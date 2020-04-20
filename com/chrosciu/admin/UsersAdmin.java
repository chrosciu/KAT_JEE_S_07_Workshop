package com.chrosciu.admin;

import com.chrosciu.dao.UserDao;
import com.chrosciu.model.User;

public class UsersAdmin {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User newUser = new User(1, "chrosciu2", "chrosciu2@chrosciu.com", "test2");
        User savedUser = userDao.create(newUser);
        int userId = savedUser.getId();
        User fetchedUser = userDao.read(userId);
        System.out.println(fetchedUser);
    }
}
