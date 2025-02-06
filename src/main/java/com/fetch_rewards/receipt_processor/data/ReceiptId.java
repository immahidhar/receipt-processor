package com.fetch_rewards.receipt_processor.data;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptId {
    @NotBlank
    String id;
}
