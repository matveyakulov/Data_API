package ru.matveyakulov.github.data_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.matveyakulov.github.data_api.advice.exception.TableDataCorrectException;
import ru.matveyakulov.github.data_api.dto.UpdateTableDataDTO;
import ru.matveyakulov.github.data_api.security.jwt.JwtTokenProvider;
import ru.matveyakulov.github.data_api.service.ClientService;
import ru.matveyakulov.github.data_api.service.OrderService;
import ru.matveyakulov.github.data_api.service.UpdateService;
import ru.matveyakulov.github.data_api.service.UserService;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void update(UpdateTableDataDTO updateTableDataDTO) {

        String tableName = updateTableDataDTO.getTableName();
        switch (tableName) {
            case "users":
                usersTableHandle(updateTableDataDTO);
                break;

            case "clients":
                clientsTableHandle(updateTableDataDTO);
                break;

            case "orders":
                ordersTableHandle(updateTableDataDTO);
                break;

            default:
                throw new TableDataCorrectException("Таблица " + tableName + " не существует");
        }
    }

    private void usersTableHandle(UpdateTableDataDTO updateTableDataDTO) {

        String field = updateTableDataDTO.getField();
        switch (field) {
            case "email":
                userService.updateEmail(updateTableDataDTO.getId(), updateTableDataDTO.getValue());
                break;
            case "password":
                userService.updatePassword(updateTableDataDTO.getId(), updateTableDataDTO.getValue());
                break;
            default:
                throw new TableDataCorrectException("Поле " + field + " в таблице " +
                        updateTableDataDTO.getTableName() + " не существует");
        }

    }

    private void clientsTableHandle(UpdateTableDataDTO updateTableDataDTO) {

        String field = updateTableDataDTO.getField();
        switch (field) {
            case "name":
                clientService.updateName(updateTableDataDTO.getId(), updateTableDataDTO.getValue());
                break;
            default:
                throw new TableDataCorrectException("Поле " + field + " в таблице " +
                        updateTableDataDTO.getTableName() + " не существует");
        }
    }

    private void ordersTableHandle(UpdateTableDataDTO updateTableDataDTO) {

        String field = updateTableDataDTO.getField();
        switch (field) {
            case "client_id":
                orderService.updateClientId(updateTableDataDTO.getId(), updateTableDataDTO.getValue());
                break;
            case "price":
                orderService.updatePrice(updateTableDataDTO.getId(), updateTableDataDTO.getValue());
                break;
            default:
                throw new TableDataCorrectException("Поле " + field + " в таблице " +
                        updateTableDataDTO.getTableName() + " не существует");
        }
    }
}
