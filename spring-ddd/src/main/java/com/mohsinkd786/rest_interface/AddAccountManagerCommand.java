package com.mohsinkd786.rest_interface;

/**Command to add the Client with the given username as a manager to the Account with the given accountNo.*/
public class AddAccountManagerCommand {

	public Long accountNo;
	public String username;

    @Override
    public String toString() {
        return String.format(
                "AddAccountManagerCommand{accountNo=%d, username=%s}",
                accountNo, username);
    }

}
