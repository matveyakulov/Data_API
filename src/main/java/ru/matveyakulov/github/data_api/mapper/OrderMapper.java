package ru.matveyakulov.github.data_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.matveyakulov.github.data_api.domain.Order;
import ru.matveyakulov.github.data_api.dto.OrderDTO;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper ORDER = Mappers.getMapper( OrderMapper.class );

    @Mappings({
            @Mapping(target = "client_id", source = "client_id"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "date_of_create", source = "date_of_create"),
    })
    OrderDTO orderToOrderDTO(Order order);

    List<OrderDTO> listOrderToListOrderDTO(List<Order> orders);
}
