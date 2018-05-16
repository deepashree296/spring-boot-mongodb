import com.example.people.Application;
import com.example.people.user.models.User;
import com.example.people.user.repositories.UserMongoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    }

    @Test
    public void testFetchData() {

    }

    @Test
    public void testUpdateData() {

    }


    @After
    public void tearDown() {
    }

}
