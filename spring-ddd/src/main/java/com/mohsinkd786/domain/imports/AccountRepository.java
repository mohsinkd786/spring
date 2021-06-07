package com.mohsinkd786.domain.imports;

import java.util.Optional;

import com.mohsinkd786.domain.Account;
import com.mohsinkd786.domain.AccountNo;

public interface AccountRepository {

	/**
	 * Searches the {@link Account} object with the given account number.
	 *
	 * @param acccountNo
	 *            unique account number of the searched account
	 * @return the {@link Account} object with the given account number, if existing.
	 * @throws IllegalArgumentException
	 *             acccountNo is null or empty
	 */
	Optional<Account> find(AccountNo acccountNo);

	/**
	 * Deletes all Accounts. Useful for test scenarios in order to start with an
	 * empty account set.
	 */
	void deleteAll();

	/**
	 * Saves the account giving it a unique, higher account number (accountNo).
	 *
	 * @param account
	 *            the {@link Account} to be saved
	 * @return the modified instance
	 */
	Account save(Account account);

}
