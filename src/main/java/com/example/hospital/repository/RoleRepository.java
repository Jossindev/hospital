package com.example.hospital.repository;

import com.example.hospital.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findRoleByName(String s);
}
