package ru.matveyakulov.github.data_api.service;

import ru.matveyakulov.github.data_api.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAll();

    void updatePrice(Long id, String value);

    void updateClientId(Long id, String value);
}
