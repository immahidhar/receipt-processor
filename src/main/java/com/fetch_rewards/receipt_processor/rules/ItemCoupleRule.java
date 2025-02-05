package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 5 points for every two items on the receipt.
 */
@Slf4j
@Component
public class ItemCoupleRule implements Rule {
    @Override
    public int apply(Receipt receipt) {
        int points = 0;
        if (receipt != null && receipt.getItems() != null) {
            points = (int) (5 * Math.floor((double) (receipt.getItems().size() / 2)));
        }
        log.debug("{}", points);
        return points;
    }
}
