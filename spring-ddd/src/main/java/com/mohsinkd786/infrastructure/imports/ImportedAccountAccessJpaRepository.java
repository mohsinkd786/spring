package com.mohsinkd786.infrastructure.imports;

import com.mohsinkd786.domain.Account;
import com.mohsinkd786.domain.AccountAccess;
import com.mohsinkd786.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImportedAccountAccessJpaRepository extends JpaRepository<AccountAccess, Long> {

	void deleteAll();

	AccountAccess save(AccountAccess account);

	void delete(AccountAccess account);

	List<AccountAccess> findAllByClientAndIsOwnerGreaterThanEqualOrderByIdDesc(Client client, boolean asOwner);

	Optional<AccountAccess> findOneByClientAndAccount(Client client, Account account);

	//Optional<AccountAccess> findOneByClientAndAccount(Client client, Long accountId);

	List<AccountAccess> findAllByAccountBalanceCentsGreaterThanEqualOrderByAccountBalanceCentsDescClientIdDesc(
			long minCents);

}
