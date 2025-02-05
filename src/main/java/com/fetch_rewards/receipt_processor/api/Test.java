package com.fetch_rewards.receipt_processor.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Test {
    @RequestMapping("/")
    public String home() {
        log.info("home - Receipt Processor server up and running!");
        return "Receipt Processor server up and running!";
    }
}
