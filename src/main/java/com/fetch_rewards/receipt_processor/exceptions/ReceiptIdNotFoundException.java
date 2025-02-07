package com.fetch_rewards.receipt_processor.exceptions;

public class ReceiptIdNotFoundException extends RuntimeException {

    public ReceiptIdNotFoundException(String message) {
        super(message);
    }
}