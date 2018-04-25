import org.example.mongodb.model.Application;
import org.example.mongodb.model.User;
import org.example.mongodb.model.UserMongoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMongoRepositoryTest {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Before
    public void setUp() {
        User user1 =  new User("Joe", 26);
        User user2 = new User("Chandler", 25);
        assertNull(user1.getId());
        assertNull(user2.getId());
        userMongoRepository.save(user1);
        userMongoRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }

    @Test
    public void testFetchData() {
        User user = userMongoRepository.findByName("Joe");
        assertNotNull(user);
        assertEquals(26, user.getAge());
        // fetch all data and see if there are only two documents
        Iterable<User> users = userMongoRepository.findAll();
        int count = 0;
        for (User u : users) {
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    public void testUpdateData() {
        User user1 = userMongoRepository.findByName("Chandler");
        user1.setAge(27);
        userMongoRepository.save(user1);
        User user2 = userMongoRepository.findByName("Chandler");
        assertNotNull(user2);
        assertEquals(27,user2.getAge());
    }


    @After
    public void tearDown() {
        userMongoRepository.deleteAll();
    }

}
