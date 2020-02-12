package ru.itfb.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itfb.trial.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByLogin(String login);
    Optional<Client> findByName(String name);
    List<Client> findAll();

    Boolean existsByLogin(String login);
}
