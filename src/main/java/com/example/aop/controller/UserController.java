package com.example.aop.controller;

import com.example.aop.dto.AddNewUserDTO;
import com.example.aop.dto.UpdateExistingUserDTO;
import com.example.aop.model.User;
import com.example.aop.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}/get")
    public User getUser(@PathVariable int id) {
        return this.userService.get(id);
    }

    @PostMapping(value = "/add")
    public User addNewUser(@RequestBody AddNewUserDTO addNewUserDTO) {
        return this.userService.add(addNewUserDTO);
    }

    @PutMapping(value = "/{id}/update")
    public User updateUser(@PathVariable int id, @RequestBody UpdateExistingUserDTO updateExistingUserDTO) {
        return this.userService.update(id, updateExistingUserDTO);
    }

    @DeleteMapping(value = "/{id}/delete")
    public User deleteUser(@PathVariable int id) {
        return this.userService.delete(id);
    }
}
