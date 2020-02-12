package ru.itfb.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itfb.trial.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role>findByName(String name);
}
