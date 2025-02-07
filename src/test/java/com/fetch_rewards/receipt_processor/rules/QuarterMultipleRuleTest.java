package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import org.junit.jupiter.api.Test;

public class QuarterMultipleRuleTest {

    QuarterMultipleRule quarterMultipleRule = new QuarterMultipleRule();

    @Test
    public void testNullCases() {
        assert quarterMultipleRule.apply(null) == 0;
        Receipt receipt = new Receipt();
        assert receipt.getTotal() == null;
        assert quarterMultipleRule.apply(receipt) == 0;
    }

    @Test
    public void testQuarterCases() {
        Receipt receipt = new Receipt();
        receipt.setTotal("0.00");
        assert quarterMultipleRule.apply(receipt) == 25;
        receipt.setTotal("0.25");
        assert quarterMultipleRule.apply(receipt) == 25;
        receipt.setTotal("12.75");
        assert quarterMultipleRule.apply(receipt) == 25;
        receipt.setTotal("21.00");
        assert quarterMultipleRule.apply(receipt) == 25;
        receipt.setTotal("232340.50");
        assert quarterMultipleRule.apply(receipt) == 25;
        receipt.setTotal("025.25");
        assert quarterMultipleRule.apply(receipt) == 25;
    }

    @Test
    public void testNonQuarterCases() {
        Receipt receipt = new Receipt();
        receipt.setTotal("0.23");
        assert quarterMultipleRule.apply(receipt) == 0;
        receipt.setTotal("0.37");
        assert quarterMultipleRule.apply(receipt) == 0;
        receipt.setTotal("0.20");
        assert quarterMultipleRule.apply(receipt) == 0;
        receipt.setTotal("0.90");
        assert quarterMultipleRule.apply(receipt) == 0;
    }

}
