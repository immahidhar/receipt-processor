package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 6 points if the day in the purchase date is odd.
 */
@Slf4j
@Component
public class OddDateRule implements Rule {
    @Override
    public int apply(Receipt receipt) {
        int points = 0;
        if (receipt != null && receipt.getPurchaseDate() != null && Integer.parseInt(receipt.getPurchaseDate()
                .substring(receipt.getPurchaseDate().length() - 2)) % 2 == 1) {
            points = 6;
        }
        log.debug("{}", points);
        return points;
    }
}
