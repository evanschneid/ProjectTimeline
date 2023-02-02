package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {
        void insertUser(User user);
        User getUserById(int id);
        List<User> getAllUsers();
        void updateUser(User user);
        void deleteUser(int id);
        User findByUsername(String username);

        boolean createUser();
}
