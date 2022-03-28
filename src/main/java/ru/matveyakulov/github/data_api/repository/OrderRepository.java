package ru.matveyakulov.github.data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.matveyakulov.github.data_api.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
