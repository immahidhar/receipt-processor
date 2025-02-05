package com.fetch_rewards.receipt_processor.api;

import com.fetch_rewards.receipt_processor.data.Points;
import com.fetch_rewards.receipt_processor.data.Receipt;
import com.fetch_rewards.receipt_processor.data.ReceiptId;
import com.fetch_rewards.receipt_processor.service.ReceiptProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;


@Slf4j
@RestController
public class ReceiptAPI {

    @Autowired
    private ReceiptProcessor receiptProcessor;

    @RequestMapping("/")
    public String home() {
        log.info("home - Receipt Processor server up and running!");
        return "Receipt Processor server up and running!";
    }

    @PostMapping("/receipts/process")
    public @ResponseBody ReceiptId processReceipt(@RequestBody Receipt receipt) {
        log.info("process receipt - {}", receipt);
        String id = receiptProcessor.processReceipt(receipt);
        log.info("id - {}", id);
        return new ReceiptId(id);
    }

    @GetMapping("/receipts/{id}/points")
    public @ResponseBody Points getPoints(@PathVariable("id") String receiptId) {
        log.info("get points - {}", receiptId);
        int points = receiptProcessor.getPoints(receiptId);
        log.info("points - {}", points);
        return new Points(points);
    }

}
