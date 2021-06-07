package com.mohsinkd786.rest_interface;

import com.mohsinkd786.domain.Account;
import com.mohsinkd786.domain.AccountAccess;

/**
 * Data about an Account of a bank, and the access a Client of the bank has to
 * it. Usable as Data Transfer Object.
 */
public class AccountAccessResource {

	public String clientUsername;
	public boolean isOwner;
	public Long accountNo;
	public String accountName;
	public String accountBalance;

	/**
	 * Constructs a data transfer object from the given domain entity.
	 *
	 * @param entity
	 *            the entity to be converted
	 */
	public AccountAccessResource(final AccountAccess entity) {
		final Account account = entity.getAccount();
		this.clientUsername = entity.getClient().getUsername();
		this.isOwner = entity.isOwner();
		this.accountNo = account.accountNo().toLong();
		this.accountName = account.getName();
		this.accountBalance = Double.toString(account.getBalance().toDouble());
	}

}
