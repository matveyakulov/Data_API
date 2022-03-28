package ru.matveyakulov.github.data_api.dto;

import lombok.Data;

@Data
public class UpdateTableDataDTO {

    private String tableName;
    private Long id;
    private String field;
    private String value;
}
