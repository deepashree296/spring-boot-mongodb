package com.example.people.service;

import com.example.people.user.domains.User;
import com.example.people.user.repositories.UserMongoRepository;
import com.example.people.user.services.UserService;
import com.example.people.user.services.UserServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }


    @Autowired
    private UserService userService;

    @MockBean
    private UserMongoRepository userMongoRepositoryMock;


    @Before
    public void setUp() {

        userMongoRepositoryMock = mock(UserMongoRepository.class);

    }

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        Assert.assertNotNull("Failure expected not noll", users);
        Assert.assertEquals("Failure expected size", 5, users.size());
    }

    @Test
    public void testGetUserByNumber() {
        String phone_number = "123";
        User user = userService.getUserByNumber(phone_number);
        Assert.assertNotNull("failure, expected not null", user);
        Assert.assertEquals("expected phone number attribute match", phone_number, user.getPhoneNumber());
    }

    @Test
    public void testGetUserByNumberNotFound() {

        Exception exception = null;
        String phone_number = "127";
        try {

            User user = userService.getUserByNumber(phone_number);

        } catch (EmptyResultDataAccessException e) {
            exception = e;
        }

        Assert.assertNotNull("failure - expected exception", exception);
        Assert.assertTrue("failure - expected EmptyResultDataAccessException", exception instanceof  EmptyResultDataAccessException);

    }


    @Test
    public void testCreateUser() {
        User createdUser;

        createdUser = new User();
        createdUser.setUserName("test0");
        createdUser.setPhoneNumber("1211");
        createdUser.setUserId("123");

        Mockito.when(userMongoRepositoryMock.save(createdUser)).thenReturn(createdUser);

        userService.createUser(createdUser);




        Assert.assertNotNull("failure - expected not null", createdUser);
        Assert.assertNotNull("failure - expected id attibute not null", createdUser.getUserId());


        //Collection<User> userList = userService.getAllUsers();
        //Assert.assertEquals("failure - expected size", 1, userList.size());

    }

    @After
    public void tearDown() {
    }

}
