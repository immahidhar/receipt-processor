package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Item;
import com.fetch_rewards.receipt_processor.data.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * If the trimmed length of the item description is a multiple of 3,
 * multiply the price by 0.2 and round up to the nearest integer.
 * The result is the number of points earned.
 */
@Slf4j
@Component
public class ThreeMultipleDescriptionLengthRule implements Rule {
    @Override
    public int apply(Receipt receipt) {
        int points = 0;
        if (receipt != null && receipt.getItems() != null) {
            for (Item item : receipt.getItems()) {
                if (item.getShortDescription() != null && item.getShortDescription().strip().length() % 3 == 0) {
                    points += (int) Math.ceil(Double.parseDouble(item.getPrice()) * 0.2);
                }
            }
        }
        log.debug("{}", points);
        return points;
    }
}
