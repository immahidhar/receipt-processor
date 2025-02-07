package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import org.junit.jupiter.api.Test;

public class RoundDollarTotalRuleTest {

    RoundDollarTotalRule roundDollarTotalRule = new RoundDollarTotalRule();

    @Test
    public void testNullCases() {
        assert roundDollarTotalRule.apply(null) == 0;
        Receipt receipt = new Receipt();
        assert receipt.getTotal() == null;
        assert roundDollarTotalRule.apply(receipt) == 0;
    }

    @Test
    public void testRoundCases() {
        Receipt receipt = new Receipt();
        receipt.setTotal("0.00");
        assert roundDollarTotalRule.apply(receipt) == 50;
        receipt.setTotal("12.00");
        assert roundDollarTotalRule.apply(receipt) == 50;
        receipt.setTotal("134522.00");
        assert roundDollarTotalRule.apply(receipt) == 50;
    }

    @Test
    public void testNonRoundCases() {
        Receipt receipt = new Receipt();
        receipt.setTotal("12.01");
        assert roundDollarTotalRule.apply(receipt) == 0;
        receipt.setTotal("12.20");
        assert roundDollarTotalRule.apply(receipt) == 0;
        receipt.setTotal("12.25");
        assert roundDollarTotalRule.apply(receipt) == 0;
        receipt.setTotal("12.99");
        assert roundDollarTotalRule.apply(receipt) == 0;
    }

}
