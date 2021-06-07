package com.mohsinkd786.infrastructure.imports;

import com.mohsinkd786.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ImportedClientJpaRepository extends JpaRepository<Client, Long> {

    /**Deletes all Clients. Useful for test scenarios in order to start with an empty client set*/
    void deleteAll();

    Client save(Client client);

    void delete(Client client);

    Optional<Client> findOneById(Long id);

    Optional<Client> findOneByUsername(String username);

    Optional<Client> findOneByUsernameAndBirthDate(String name, LocalDate birthDate);

    List<Client> findAllByOrderByIdDesc();

    List<Client> findAllByBirthDateGreaterThanEqualOrderByBirthDateDescIdDesc(LocalDate minDate);

    Optional<Client> findFirstByOrderByIdAsc();
}
