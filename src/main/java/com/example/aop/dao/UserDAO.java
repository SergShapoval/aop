package com.example.aop.dao;

import com.example.aop.model.User;

public interface UserDAO {
    User insert(User user);

    User getByID(int id);

    User deleteByID(int id);

    User updateByID(int id, User user);
}
