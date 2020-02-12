package ru.itfb.trial.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.repository.ClientRepository;
import ru.itfb.trial.service.ClientService;
import ru.itfb.trial.web.dto.ClientInDto;
import ru.itfb.trial.web.mapper.ClientMapper;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientService clientService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("ClientInDto", new ClientInDto());

        return "client/registration";
    }

    @PostMapping(value = "/registration")
    public String addClient(@ModelAttribute("ClientInDto") ClientInDto clientInDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!clientInDto.getPassword().equals(clientInDto.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
//        if (clientRepository.existsByLogin(clientInDto.getLogin())){
//            model.addAttribute("loginError", "Пользователь с таким логином уже существует");
//            return "registration";
//        }

        clientMapper.clientToDto(clientService.create(clientMapper.dtoToClient(clientInDto)));
        return "redirect:/product";
    }
}
