package ru.matveyakulov.github.data_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.matveyakulov.github.data_api.domain.User;
import ru.matveyakulov.github.data_api.dto.UserAuthenticationRequestDTO;
import ru.matveyakulov.github.data_api.dto.UserDTO;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper USER = Mappers.getMapper( UserMapper.class );

    @Mappings({
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "date_of_create", source = "date_of_create"),
    })
    UserDTO userToUserDTO(User user);

    List<UserDTO> listUserToListUserDTO(List<User> users);
}
