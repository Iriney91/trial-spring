package ru.itfb.trial.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.web.dto.ClientAuth;

@Controller
@RequiredArgsConstructor
public class ClientAuthController {

    @GetMapping("/auth")
    public String authentication(Model model) {
        model.addAttribute("ClientAuth", new ClientAuth());

        return "client/authentication";
    }
}
