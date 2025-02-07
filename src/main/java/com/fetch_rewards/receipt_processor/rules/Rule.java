package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;

public interface Rule {
    int apply(Receipt receipt);
}
