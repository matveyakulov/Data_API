package ru.matveyakulov.github.data_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matveyakulov.github.data_api.advice.exception.ClientNotFoundException;
import ru.matveyakulov.github.data_api.advice.exception.OrderNotFoundException;
import ru.matveyakulov.github.data_api.advice.exception.UserNotFoundException;
import ru.matveyakulov.github.data_api.domain.Client;
import ru.matveyakulov.github.data_api.domain.Order;
import ru.matveyakulov.github.data_api.dto.OrderDTO;
import ru.matveyakulov.github.data_api.mapper.OrderMapper;
import ru.matveyakulov.github.data_api.repository.ClientRepository;
import ru.matveyakulov.github.data_api.repository.OrderRepository;
import ru.matveyakulov.github.data_api.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    @Override
    public List<OrderDTO> findAll() {
        return OrderMapper.ORDER.listOrderToListOrderDTO(orderRepository.findAll());
    }

    @Transactional
    @Override
    public void updatePrice(Long id, String value) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Заказ с id = " + id +" не найден"));
        order.setPrice(Long.parseLong(value));
    }

    @Transactional
    @Override
    public void updateClientId(Long id, String value) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Заказ с id = " + id +" не найден"));
        Client client = clientRepository.findById(Long.parseLong(value))
                .orElseThrow(() -> new ClientNotFoundException("Клиент с id = " + id + " не найден"));
        order.setClient_id(client);
    }
}
