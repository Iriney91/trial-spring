package ru.itfb.trial.web.mapper;

import ru.itfb.trial.model.Client;
import org.mapstruct.Mapper;
import ru.itfb.trial.web.dto.ClientAuth;
import ru.itfb.trial.web.dto.ClientInDto;
import ru.itfb.trial.web.dto.ClientOutDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client dtoToClient(ClientInDto clientDTO);

    Client dtoToClient(ClientAuth clientAuth);

    ClientOutDto clientToDto(Client client);

    List<ClientOutDto> clientToDto(List<Client> clients);
}
