package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * One point for every alphanumeric character in the retailer name.
 */
@Slf4j
@Component
public class RetailerRule implements Rule {
    @Override
    public int apply(Receipt receipt) {
        int points = 0;
        if (receipt != null && receipt.getRetailer() != null) {
            for (char c : receipt.getRetailer().toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    points++;
                }
            }
        }
        log.debug("{}", points);
        return points;
    }
}
