package com.fetch_rewards.receipt_processor.data;

import lombok.Data;

import java.util.List;

@Data
public class Receipt {
    String retailer;
    String purchaseDate;
    String purchaseTime;
    double total;
    List<Item> items;
}
