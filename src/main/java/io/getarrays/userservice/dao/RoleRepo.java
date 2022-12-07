package io.getarrays.userservice.dao;

import io.getarrays.userservice.models.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Long> {
        Roles findByName(String name);
}
