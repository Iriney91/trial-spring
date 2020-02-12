package ru.itfb.trial.web.controller;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itfb.trial.model.Client;
import ru.itfb.trial.repository.ClientRepository;
import ru.itfb.trial.web.dto.ClientAuth;
import ru.itfb.trial.web.mapper.ClientMapper;

public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/auth").setViewName("auth");
    }
}
