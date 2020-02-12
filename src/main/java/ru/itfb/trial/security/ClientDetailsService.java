package ru.itfb.trial.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.repository.ClientRepository;
import ru.itfb.trial.web.dto.ClientAuth;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class ClientDetailsService implements UserDetailsService {
    @Autowired
    private final ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Client client = repository.findByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("No such user found"));
        return new ClientDetails(client);
    }
}
