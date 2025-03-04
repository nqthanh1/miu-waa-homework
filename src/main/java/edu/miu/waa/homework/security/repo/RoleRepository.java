package edu.miu.waa.homework.security.repo;

import edu.miu.waa.homework.security.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Optional<Role> findByRole(String role);
}
