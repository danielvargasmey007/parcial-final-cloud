package com.cloud.users.services;

import java.util.List;

import com.cloud.users.domain.User;

public interface UserService {

    List<User> getUsers();

    User createUser(User user);

    Long deleteUser(Long id) throws Exception;

}
