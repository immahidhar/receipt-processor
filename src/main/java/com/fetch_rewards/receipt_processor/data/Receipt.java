package com.fetch_rewards.receipt_processor.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Receipt {
    @NotNull
    String retailer;
    @NotBlank
    String purchaseDate;
    @NotBlank
    String purchaseTime;
    @NotBlank
    String total;
    @NotNull
    @Size(min = 1)
    List<Item> items;
}
