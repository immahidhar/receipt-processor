package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Item;
import com.fetch_rewards.receipt_processor.data.Receipt;
import org.junit.jupiter.api.Test;


public class ItemCoupleRuleTest {

    ItemCoupleRule itemCoupleRule = new ItemCoupleRule();

    @Test
    public void testNullCases() {
        assert itemCoupleRule.apply(null) == 0;
        Receipt receipt = new Receipt();
        assert receipt.getItems() == null;
        assert itemCoupleRule.apply(receipt) == 0;
    }

    @Test
    public void testNonNullCases() {
        Receipt receipt = new Receipt();
        receipt.setItems(new java.util.ArrayList<>());
        receipt.getItems().add(new Item()); // 1 item
        assert itemCoupleRule.apply(receipt) == 0;
        receipt.getItems().add(new Item()); // 2 items
        assert itemCoupleRule.apply(receipt) == 5;
        receipt.getItems().add(new Item()); // 3 items
        assert itemCoupleRule.apply(receipt) == 5;
        receipt.getItems().add(new Item()); // 4 items
        assert itemCoupleRule.apply(receipt) == 10;
        receipt.getItems().add(new Item()); // 5 items
        assert itemCoupleRule.apply(receipt) == 10;
        receipt.getItems().add(new Item()); // 6 items
        assert itemCoupleRule.apply(receipt) == 15;
    }
}
