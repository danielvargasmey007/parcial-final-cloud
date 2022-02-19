package com.cloud.users.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.users.domain.User;
import com.cloud.users.dto.UserDTO;
import com.cloud.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> getUsers() throws Exception {
        List<User> response = this.userService.getUsers();

        List<UserDTO> responseDTO = response
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());

        return responseDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Long deleteUser(@Valid @PathVariable Long id) throws Exception {
        return this.userService.deleteUser(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        User user = this.userService.createUser(modelMapper.map(userDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }

}
