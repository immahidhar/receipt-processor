package com.fetch_rewards.receipt_processor.service;

import com.fetch_rewards.receipt_processor.api.exceptions.ReceiptIdNotFoundException;
import com.fetch_rewards.receipt_processor.data.Receipt;
import com.fetch_rewards.receipt_processor.rules.Rule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class ReceiptProcessor {

    /**
     * All the rules that are supposed to be applied to calculate points
     * NOTE: By default all the Classes that implement Rule interface are applied
     * No customization yet implemented for which rules to apply or skip based on a condition as that is out of scope
     */
    @Autowired
    private List<Rule> rules;

    /**
     * In Memory Database for points associated with a receipt id. (id: points)
     */
    private final Map<String, Integer> receipt_points = new ConcurrentHashMap<String, Integer>();

    /**
     * Get points for a given receipt id.
     * @param id receipt id
     * @return points if receipt id present, -1 if not
     */
    public int getPoints(String id) {
        if (receipt_points.containsKey(id)) {
            return receipt_points.get(id);
        } else {
            throw new ReceiptIdNotFoundException("No receipt found for that ID.");
        }
    }

    /**
     * Process receipt:
     * 1. Generate a new unique id
     * 2. Calculate points for this receipt
     * @param receipt receipt
     * @return new unique id
     */
    public String processReceipt(Receipt receipt) {
        String id = generateId();
        int points = applyRules(receipt);
        receipt_points.put(id, points);
        log.debug("points = {}", points);
        return id;
    }

    /**
     * Generate a new unique id with UUID
     * Validate with already generated ids
     * @return new unique id
     */
    private String generateId() {
        String id = UUID.randomUUID().toString();
        while (receipt_points.containsKey(id)) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    /**
     * Apply each rule and calculate overall points
     * @param receipt receipt
     * @return points
     */
    private int applyRules(Receipt receipt) {
        int points = 0;
        for (Rule rule : rules) {
            points += rule.apply(receipt);
        }
        return points;
    }
}
