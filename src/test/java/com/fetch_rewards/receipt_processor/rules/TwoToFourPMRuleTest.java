package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Receipt;
import org.junit.jupiter.api.Test;

public class TwoToFourPMRuleTest {

    TwoToFourPMRule twoToFourPMRule = new TwoToFourPMRule();

    @Test
    public void testNullCases() {
        assert twoToFourPMRule.apply(null) == 0;
        Receipt receipt = new Receipt();
        assert receipt.getPurchaseTime() == null;
        assert twoToFourPMRule.apply(receipt) == 0;
    }

    @Test
    public void testTwoToFourPMCases() {
        Receipt receipt = new Receipt();
        receipt.setPurchaseTime("14:00");
        assert twoToFourPMRule.apply(receipt) == 10;
        receipt.setPurchaseTime("14:12");
        assert twoToFourPMRule.apply(receipt) == 10;
        receipt.setPurchaseTime("15:00");
        assert twoToFourPMRule.apply(receipt) == 10;
        receipt.setPurchaseTime("15:09");
        assert twoToFourPMRule.apply(receipt) == 10;
        receipt.setPurchaseTime("15:59");
        assert twoToFourPMRule.apply(receipt) == 10;
    }

    @Test
    public void testOtherCases() {
        Receipt receipt = new Receipt();
        receipt.setPurchaseTime("00:00");
        assert twoToFourPMRule.apply(receipt) == 0;
        receipt.setPurchaseTime("07:00");
        assert twoToFourPMRule.apply(receipt) == 0;
        receipt.setPurchaseTime("12:00");
        assert twoToFourPMRule.apply(receipt) == 0;
        receipt.setPurchaseTime("16:00");
        assert twoToFourPMRule.apply(receipt) == 0;
        receipt.setPurchaseTime("17:00");
        assert twoToFourPMRule.apply(receipt) == 0;
        receipt.setPurchaseTime("23:00");
        assert twoToFourPMRule.apply(receipt) == 0;
    }

}
