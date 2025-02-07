package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import org.junit.jupiter.api.Test;

public class RetailerRuleTest {

    RetailerRule retailerRule = new RetailerRule();

    @Test
    public void testNullCases() {
        assert retailerRule.apply(null) == 0;
        Receipt receipt = new Receipt();
        assert receipt.getRetailer() == null;
        assert retailerRule.apply(receipt) == 0;
    }

    @Test
    public void testNonNullCases() {
        Receipt receipt = new Receipt();
        receipt.setRetailer("Target");
        assert retailerRule.apply(receipt) == 6;
        receipt.setRetailer("M&M Corner Market");
        assert retailerRule.apply(receipt) == 14;
        receipt.setRetailer("  12345-_+=&/;,. abcde  ");
        assert retailerRule.apply(receipt) == 10;
    }

}
