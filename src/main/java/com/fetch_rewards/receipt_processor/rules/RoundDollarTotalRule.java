package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 50 points if the total is a round dollar amount with no cents.
 */
@Slf4j
@Component
public class RoundDollarTotalRule implements Rule {
    @Override
    public int apply(Receipt receipt) {
        int points = 0;
        if (receipt != null && receipt.getTotal() != null && Double.parseDouble(receipt.getTotal()) % 1 == 0) {
            points = 50;
        }
        log.debug("{}", points);
        return points;
    }
}
