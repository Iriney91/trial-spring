package ru.itfb.trial.web.dto;

import lombok.Data;

@Data
public class ClientInDto {
    private String name;
    private String login;
    private String password;
    private String passwordConfirm;
}
