package io.getarrays.userservice.dao;

import io.getarrays.userservice.models.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);
}
