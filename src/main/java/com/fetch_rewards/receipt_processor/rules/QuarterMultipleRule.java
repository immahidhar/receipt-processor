package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 25 points if the total is a multiple of 0.25.
 */
@Slf4j
@Component
public class QuarterMultipleRule implements Rule {
    @Override
    public int apply(Receipt receipt) {
        int points = 0;
        if (receipt != null && receipt.getTotal() != null && Double.parseDouble(receipt.getTotal()) % 0.25 == 0) {
            points = 25;
        }
        log.debug("{}", points);
        return points;
    }
}
