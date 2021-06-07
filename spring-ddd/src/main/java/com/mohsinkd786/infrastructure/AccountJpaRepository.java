package com.mohsinkd786.infrastructure;

import com.mohsinkd786.domain.Account;
import com.mohsinkd786.domain.AccountNo;
import com.mohsinkd786.domain.imports.AccountRepository;
import com.mohsinkd786.infrastructure.imports.ImportedAccountJpaRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountJpaRepository implements AccountRepository {

    private final ImportedAccountJpaRepository impl;

    @Autowired
    public AccountJpaRepository(final ImportedAccountJpaRepository impl) {
        this.impl = impl;
    }

	@Override
	public Optional<Account> find(AccountNo acccountNo) {
		return impl.findOneById(acccountNo.toLong());
	}

    public void deleteAll(){impl.deleteAll();}

    public Account save(final Account account){
        return impl.save(account);
    }

}
