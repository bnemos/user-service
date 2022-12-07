package io.getarrays.userservice.service;

import io.getarrays.userservice.models.entity.Roles;
import io.getarrays.userservice.models.entity.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users users);
    Roles saveRole(Roles roles);
    void addRoleToUser(String userName, String roleName);

    Users getUser(String userName);
    List<Users> getAll();


}
