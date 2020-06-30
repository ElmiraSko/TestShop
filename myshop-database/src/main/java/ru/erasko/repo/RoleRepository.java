package ru.erasko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.erasko.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
