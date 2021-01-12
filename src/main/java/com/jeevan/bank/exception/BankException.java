package com.jeevan.bank.exception;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
public class BankException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BankException(@NonNull final String message) {
        super(message);
    }

    public BankException(BankException bankException) {
        super(bankException);
    }
}

