package com.cloud.users.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.users.domain.User;
import com.cloud.users.repositories.UserRepository;
import com.cloud.users.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Long deleteUser(Long id) throws Exception {
        if(this.userRepository.hasBooking(id) > 0) {
            throw new Exception("User has Booking");
        }
        this.userRepository.delete(new User(id));
        return id;
    }

}
