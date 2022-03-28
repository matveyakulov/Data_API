package ru.matveyakulov.github.data_api.dto;

import lombok.Data;
import ru.matveyakulov.github.data_api.domain.Order;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class ClientDTO {

    private Set<Order> orders = new HashSet<>();
    private String name;
    private Date date_of_create;
}
