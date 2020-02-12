package ru.itfb.trial.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.service.ClientService;
import ru.itfb.trial.web.dto.ClientAuth;
import ru.itfb.trial.web.dto.ClientInDto;
import ru.itfb.trial.web.dto.ClientOutDto;
import ru.itfb.trial.web.mapper.ClientMapper;

import java.util.List;

@RequestMapping("/client")
@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientMapper clientMapper;
    private final ClientService clientService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientOutDto getById(@PathVariable Long id) {
        return clientMapper.clientToDto(clientService.getById(id));
    }


/*    @ModelAttribute("clients")
    @GetMapping(value = "list", produces = MediaType.TEXT_HTML_VALUE)
    public List<ClientOutDto> getClients() {
        return clientMapper.clientToDto(clientService.findAll());
    }*/

//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    public String findAll(Model model) {
//        model.addAttribute("clients", clientMapper.clientToDto(clientService.findAll()));
//        return "client/list";
//    }

//    @ModelAttribute("")
//    @GetMapping(value = "/{name}", produces = MediaType.TEXT_HTML_VALUE)
//    ClientOutDto getByName(@PathVariable String name) {
//        return clientMapper.clientToDto(clientService.getByName(name));
//    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ClientOutDto update(@PathVariable Long id, @RequestBody ClientInDto clientInDto) {
        Client client = clientMapper.dtoToClient(clientInDto);

        return (clientMapper.clientToDto(clientService.update(client)));
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    ClientOutDto create(@RequestBody ClientInDto clientInDto) {
//        return (
//                clientMapper.clientToDto(clientService.create(clientMapper.dtoToClient(clientInDto))));
//    }

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}
