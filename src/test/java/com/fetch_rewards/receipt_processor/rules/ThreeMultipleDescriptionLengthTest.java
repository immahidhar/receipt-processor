package com.fetch_rewards.receipt_processor.rules;

import com.fetch_rewards.receipt_processor.data.Item;
import com.fetch_rewards.receipt_processor.data.Receipt;
import org.junit.jupiter.api.Test;

public class ThreeMultipleDescriptionLengthTest {

    ThreeMultipleDescriptionLengthRule threeMultipleDescriptionLengthRule = new ThreeMultipleDescriptionLengthRule();

    @Test
    public void testNullCases() {
        assert threeMultipleDescriptionLengthRule.apply(null) == 0;
        Receipt receipt = new Receipt();
        assert receipt.getItems() == null;
        assert threeMultipleDescriptionLengthRule.apply(receipt) == 0;
    }

    @Test
    public void testNonNullCases() {
        Receipt receipt = new Receipt();
        receipt.setItems(new java.util.ArrayList<>());
        receipt.getItems().add(new Item("", "1.0"));
        assert threeMultipleDescriptionLengthRule.apply(receipt) == 1;
        receipt.getItems().add(new Item("Emils Cheese Pizza", "12.25"));
        assert threeMultipleDescriptionLengthRule.apply(receipt) == 4;
        receipt.getItems().add(new Item("Klarbrunn 12-PK 12 FL OZ", "12.00"));
        assert threeMultipleDescriptionLengthRule.apply(receipt) == 7;
        receipt.getItems().add(new Item("Gatorade", "2.25"));
        assert threeMultipleDescriptionLengthRule.apply(receipt) == 7;
    }

}
