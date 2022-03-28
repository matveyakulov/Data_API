package ru.matveyakulov.github.data_api.dto;

import lombok.Data;
import ru.matveyakulov.github.data_api.domain.Client;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderDTO {

    private Client client_id;
    private Long price;
    private Date date_of_create;
}
