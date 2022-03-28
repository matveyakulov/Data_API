package ru.matveyakulov.github.data_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.matveyakulov.github.data_api.dto.ClientDTO;
import ru.matveyakulov.github.data_api.dto.OrderDTO;
import ru.matveyakulov.github.data_api.dto.UpdateTableDataDTO;
import ru.matveyakulov.github.data_api.dto.UserDTO;
import ru.matveyakulov.github.data_api.service.ClientService;
import ru.matveyakulov.github.data_api.service.OrderService;
import ru.matveyakulov.github.data_api.service.UpdateService;
import ru.matveyakulov.github.data_api.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class MainController {

    @Autowired
    private UpdateService updateService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @Autowired
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

    @PreAuthorize("hasAnyRole('USER')")
    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody UpdateTableDataDTO updateTableDataDTO){
        updateService.update(updateTableDataDTO);
        return ResponseEntity.ok().build();
    }
}
