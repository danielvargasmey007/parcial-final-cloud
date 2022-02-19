package com.cloud.users.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloud.users.domain.User;
import com.cloud.users.repositories.UserRepository;
import com.cloud.users.services.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserServiceImplTest {

    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void init() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testCreateUser() {
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new User());

        Assert.assertNotNull(this.userService.createUser(new User()));
    }

}
