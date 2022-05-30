package com.crowdmarketing.repository;

import com.crowdmarketing.model.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRole(String role);
}