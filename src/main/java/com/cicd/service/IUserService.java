package com.cicd.service;

import com.cicd.entity.Role;
import com.cicd.entity.User;

public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addToUser(String userName, String roleName);
}
