package com.mohsinkd786.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditMoneyCommand {

    @TargetAggregateIdentifier
    private UUID accountId;
    private BigDecimal creditAmount;
}
