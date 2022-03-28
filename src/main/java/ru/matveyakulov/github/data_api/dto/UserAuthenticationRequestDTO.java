package ru.matveyakulov.github.data_api.dto;

import lombok.Data;

@Data
public class UserAuthenticationRequestDTO {

    private String email;
    private String password;
}
