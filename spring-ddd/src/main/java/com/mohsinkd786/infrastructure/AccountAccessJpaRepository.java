package com.mohsinkd786.infrastructure;

import com.mohsinkd786.domain.Account;
import com.mohsinkd786.domain.AccountAccess;
import com.mohsinkd786.domain.Amount;
import com.mohsinkd786.domain.Client;
import com.mohsinkd786.domain.imports.AccountAccessRepository;
import com.mohsinkd786.infrastructure.imports.ImportedAccountAccessJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountAccessJpaRepository implements AccountAccessRepository {

    private final ImportedAccountAccessJpaRepository impl;

    @Autowired
    public AccountAccessJpaRepository(final ImportedAccountAccessJpaRepository impl) {
        this.impl = impl;
    }

    public void deleteAll(){impl.deleteAll();}

    public AccountAccess save(final AccountAccess accountAccess){
        return impl.save(accountAccess);
    }

    @Override
    public void delete(AccountAccess accountAccess) {
        impl.delete(accountAccess);
    }

    @Override
    public List<AccountAccess> findManagedAccountsOf(Client client, boolean asOwner) {
        return impl.findAllByClientAndIsOwnerGreaterThanEqualOrderByIdDesc(client, asOwner);
    }

    @Override
    public List<AccountAccess> findFullAccounts(final Amount minBalance) {
        return impl.findAllByAccountBalanceCentsGreaterThanEqualOrderByAccountBalanceCentsDescClientIdDesc(minBalance.getCents());
    }

    @Override
    public Optional<AccountAccess> find(final Client client, final Account account) {
        return impl.findOneByClientAndAccount(client, account);
    }

}
