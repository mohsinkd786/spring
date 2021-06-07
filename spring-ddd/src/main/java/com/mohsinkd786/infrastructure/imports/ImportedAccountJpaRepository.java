package com.mohsinkd786.infrastructure.imports;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohsinkd786.domain.Account;


public interface ImportedAccountJpaRepository extends JpaRepository<Account, Long> {

    void deleteAll();

    Optional<Account> findOneById(Long id);

    Account save(Account account);

    List<Account> findAllByOrderByIdAsc();

    /*
    Iterable<Client> findAllBornFrom(LocalDate minDate);

    Optional<Client> findFirstByOrderByIdAsc();
    */
}
