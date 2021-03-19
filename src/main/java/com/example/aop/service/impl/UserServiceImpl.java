package com.example.aop.service.impl;

import com.example.aop.dao.UserDAO;
import com.example.aop.dto.AddNewUserDTO;
import com.example.aop.dto.UpdateExistingUserDTO;
import com.example.aop.model.User;
import com.example.aop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User add(AddNewUserDTO addNewUserDTO) {
        if (Objects.isNull(addNewUserDTO)) {
            return null;
        }
        return this.userDAO.insert(new User(addNewUserDTO.getName(), addNewUserDTO.getSalary()));
    }

    @Override
    public User get(int id) {
        if (id <= 0) {
            return null;
        }
        return this.userDAO.getByID(id);
    }

    @Override
    public User delete(int id) {
        if (id <= 0) {
            return null;
        }
        return this.userDAO.deleteByID(id);
    }

    @Override
    public User update(int id, UpdateExistingUserDTO updateExistingUserDTO) {
        if (id <= 0 || Objects.isNull(updateExistingUserDTO)) {
            return null;
        }
        return this.userDAO.updateByID(id, new User(updateExistingUserDTO.getName(),
                updateExistingUserDTO.getSalary()));
    }
}
