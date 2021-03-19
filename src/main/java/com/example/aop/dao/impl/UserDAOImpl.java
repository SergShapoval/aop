package com.example.aop.dao.impl;

import com.example.aop.dao.UserDAO;
import com.example.aop.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    private Map<Integer, User> storage = Map.of(
            1, new User(1, "user1", 100),
            2, new User(2, "user2", 200),
            3, new User(3, "user3", 300),
            4, new User(4, "user4", 400),
            5, new User(5, "user5", 500)
    );


    @Override
    public User insert(User user) {
        return this.storage.put(storage.size() + 1, user);
    }

    @Override
    public User getByID(int id) {
        return this.storage.get(id);
    }

    @Override
    public User deleteByID(int id) {
        return this.storage.remove(id);
    }

    @Override
    public User updateByID(int id, User user) {
        return this.storage.replace(id, user);
    }
}
