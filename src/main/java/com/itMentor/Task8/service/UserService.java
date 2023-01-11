package com.itMentor.Task8.service;

import com.itMentor.Task8.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User findById(Long id);
    void addUser(User user);

    List<User> listUsers();

    void update(User user);

    @Transactional
    void deleteUserById(Long id);
}
