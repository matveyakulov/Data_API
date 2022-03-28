package ru.matveyakulov.github.data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.matveyakulov.github.data_api.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
