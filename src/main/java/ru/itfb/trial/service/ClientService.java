package ru.itfb.trial.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.model.Product;
import ru.itfb.trial.model.Role;
import ru.itfb.trial.repository.ClientRepository;
import ru.itfb.trial.repository.RoleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    private final ApplicationContext context;

    private final RoleRepository roleRepository;

    public Client getById(Long id) {

        return clientRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client getByName(String name) {
        return clientRepository.findByName(name).orElseThrow(IllegalAccessError::new);
    }

    public Client update(Client client) {
        if (clientRepository.existsById(client.getId())) {
            clientRepository.save(client);
        } else {
            throw new IllegalArgumentException("No such client found");
        }
        return client;
    }

    public void delete(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No such client found");
        }
    }

    public Client create(Client client) {
        if (client == null) return null;
        return create(client.getLogin(), client.getPassword(), client.getName(), client.getPasswordConfirm());
    }

    public Client create(String login, String password, String name, String isConfirmed) {
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(EntityNotFoundException::new);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        CharSequence pass = encoder.encode(password);
        Client client = null;
        if (!clientRepository.existsByLogin(login)) {
            client = new Client();
            client.setLogin(login);
            client.setName(name);
            client.setPassword(pass.toString());
            client.setRoles(roles);
            client.setPasswordConfirm(isConfirmed);
            clientRepository.save(client);
            log.info("Customer saved");
            log.info(String.format("Customer password is: %s", client.getPassword()));
        } else {
            log.info(String.format("Customer with %s login already exist", login));
        }
        return client;
    }

    public Client update (Client client, Product product){
        if (clientRepository.existsById(client.getId())) {

            clientRepository.save(client);
        } else {
            throw new IllegalArgumentException("No such client found");
        }
        return client;
    }
}
