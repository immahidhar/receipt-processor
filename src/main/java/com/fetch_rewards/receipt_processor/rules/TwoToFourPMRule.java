package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 10 points if the time of purchase is after 2:00pm and before 4:00pm.
 */
@Slf4j
@Component
public class TwoToFourPMRule implements Rule {
    @Override
    public int apply(Receipt receipt) {
        int points = 0;
        if (receipt != null && receipt.getPurchaseTime() != null) {
            int hr = Integer.parseInt(receipt.getPurchaseTime().substring(0,2));
            if (hr >= 14 && hr < 16) {
                points = 10;
            }
        }
        log.debug("{}", points);
        return points;
    }
}
