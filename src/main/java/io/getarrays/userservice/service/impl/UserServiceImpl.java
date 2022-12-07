package io.getarrays.userservice.service.impl;

import io.getarrays.userservice.dao.RoleRepo;
import io.getarrays.userservice.dao.UserDao;
import io.getarrays.userservice.models.entity.Roles;
import io.getarrays.userservice.models.entity.Users;
import io.getarrays.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleRepo roleRepo;

    @Override
    public Users saveUser(Users users) {
        return userDao.save(users);
    }

    @Override
    public Roles saveRole(Roles roles) {
        return roleRepo.save(roles);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        Users users = userDao.findByUserName(userName);
        Roles roles = roleRepo.findByName(roleName);
        users.getRoles().add(roles);
    }

    @Override
    public Users getUser(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public List<Users> getAll() {
        return userDao.findAll();
    }
}
