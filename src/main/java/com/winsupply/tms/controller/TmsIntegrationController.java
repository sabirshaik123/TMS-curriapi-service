package com.winsupply.tms.controller;

import com.winsupply.tms.contracts.DeliveryRequest;
import com.winsupply.tms.contracts.Delivery;
import com.winsupply.tms.contracts.QuoteRequest;
import com.winsupply.tms.contracts.Quote;
import com.winsupply.tms.exceptions.InvalidClientException;
import com.winsupply.tms.service.TmsWinService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class TmsIntegrationController {

    private final TmsWinService tmsWinService;

    @PostMapping("/getDeliveryQuote")
    public List<Quote> getDeliveryQuote(
            @RequestParam String appName,
            @RequestBody QuoteRequest requestBody)
            throws InvalidClientException {
        return tmsWinService.getDeliveryQuote(appName, requestBody);
    }

    @PostMapping("/bookDelivery")
    public Delivery bookDelivery(
            @RequestParam String appName,
            @RequestBody DeliveryRequest requestBody)
            throws InvalidClientException {
        return tmsWinService.bookDelivery(appName, requestBody);
    }

    @GetMapping("/deliveries")
    public List<Delivery> deliveries(
            @RequestParam String appName)
            throws InvalidClientException {
        return tmsWinService.listDeliveries(appName);
    }
}
