package ru.matveyakulov.github.data_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matveyakulov.github.data_api.advice.exception.ClientNotFoundException;
import ru.matveyakulov.github.data_api.domain.Client;
import ru.matveyakulov.github.data_api.dto.ClientDTO;
import ru.matveyakulov.github.data_api.mapper.ClientMapper;
import ru.matveyakulov.github.data_api.repository.ClientRepository;
import ru.matveyakulov.github.data_api.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    @Override
    public void updateName(Long id, String value) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Клиент с id = " + id + " не найден"));
        client.setName(value);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientDTO> findAll() {

        return ClientMapper.CLIENT.listClientToListClientDTO(clientRepository.findAll());
    }
}
