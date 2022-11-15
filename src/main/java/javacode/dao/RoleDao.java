package javacode.dao;

import javacode.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);

    boolean existsRolesByName(String name);
}