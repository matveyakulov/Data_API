package ru.matveyakulov.github.data_api.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matveyakulov.github.data_api.dto.ClientDTO;
import ru.matveyakulov.github.data_api.dto.OrderDTO;
import ru.matveyakulov.github.data_api.dto.UserDTO;
import ru.matveyakulov.github.data_api.service.ClientService;
import ru.matveyakulov.github.data_api.service.OrderService;
import ru.matveyakulov.github.data_api.service.UserService;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/app")
public class DataController {

    private OrderService orderService;
    private ClientService clientService;
    private UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/data/users")
    public List<UserDTO> getUserData(){

        return userService.findAll();
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/data/orders")
    public List<OrderDTO> getOrderData(){

        return orderService.findAll();
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/data/clients")
    public List<ClientDTO> getClientData(){

        return clientService.findAll();
    }
}
