package ru.matveyakulov.github.data_api.service;

import ru.matveyakulov.github.data_api.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    void updateName(Long id, String value);

    List<ClientDTO> findAll();
}
