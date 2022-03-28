package ru.matveyakulov.github.data_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.matveyakulov.github.data_api.domain.Client;
import ru.matveyakulov.github.data_api.domain.User;
import ru.matveyakulov.github.data_api.dto.ClientDTO;
import ru.matveyakulov.github.data_api.dto.UserDTO;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper CLIENT = Mappers.getMapper( ClientMapper.class );

    @Mappings({
            @Mapping(target = "orders", source = "orders"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "date_of_create", source = "date_of_create"),
    })
    ClientDTO clientToClientDTO(Client client);

    List<ClientDTO> listClientToListClientDTO(List<Client> clients);
}
