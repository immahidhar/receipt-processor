package com.fetch_rewards.receipt_processor.api.exceptions;

public class ReceiptIdNotFoundException extends RuntimeException {

    public ReceiptIdNotFoundException(String message) {
        super(message);
    }
}