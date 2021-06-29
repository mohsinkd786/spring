package com.mohsinkd786.service;

import com.mohsinkd786.command.CreateAccountCommand;
import com.mohsinkd786.command.CreditMoneyCommand;
import com.mohsinkd786.command.DebitMoneyCommand;
import com.mohsinkd786.entity.BankAccount;
import com.mohsinkd786.rest.dto.AccountCreationDTO;
import com.mohsinkd786.rest.dto.MoneyAmountDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static com.mohsinkd786.service.ServiceUtils.formatUuid;

@Service
@AllArgsConstructor
public class AccountCommandService {
    private final CommandGateway  commandGateway;

    public CompletableFuture<BankAccount> createAccount(AccountCreationDTO creationDTO) {
        return this.commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID(),
                creationDTO.getInitialBalance(),
                creationDTO.getOwner()
        ));
    }

    public CompletableFuture<String> creditMoneyToAccount(String accountId,
                                                          MoneyAmountDTO moneyCreditDTO) {
        return this.commandGateway.send(new CreditMoneyCommand(
                formatUuid(accountId),
                moneyCreditDTO.getAmount()
        ));
    }

    public CompletableFuture<String> debitMoneyFromAccount(String accountId,
                                                           MoneyAmountDTO moneyDebitDTO) {
        return this.commandGateway.send(new DebitMoneyCommand(
                formatUuid(accountId),
                moneyDebitDTO.getAmount()
        ));
    }
}
