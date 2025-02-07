package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import org.junit.jupiter.api.Test;

public class OddDateRuleTest {

    OddDateRule oddDateRule = new OddDateRule();

    @Test
    public void testNullCases() {
        assert oddDateRule.apply(null) == 0;
        Receipt receipt = new Receipt();
        assert receipt.getPurchaseDate() == null;
        assert oddDateRule.apply(receipt) == 0;
    }

    @Test
    public void testEvenDateCases() {
        Receipt receipt = new Receipt();
        receipt.setPurchaseDate("2025-02-06");
        assert oddDateRule.apply(receipt) == 0;
    }

    @Test
    public void testOddDateCases() {
        Receipt receipt = new Receipt();
        receipt.setPurchaseDate("2025-02-05");
        assert oddDateRule.apply(receipt) == 6;
    }
}
