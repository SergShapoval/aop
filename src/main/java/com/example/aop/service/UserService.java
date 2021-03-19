package com.example.aop.service;

import com.example.aop.dto.AddNewUserDTO;
import com.example.aop.dto.UpdateExistingUserDTO;
import com.example.aop.model.User;

public interface UserService {
    User add(AddNewUserDTO addNewUserDTO);

    User get(int id);

    User delete(int id);

    User update(int id, UpdateExistingUserDTO updateExistingUserDTO);
}
