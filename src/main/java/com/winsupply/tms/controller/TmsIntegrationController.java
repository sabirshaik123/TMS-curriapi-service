package com.winsupply.tms.controller;

import com.winsupply.tms.contracts.BookDeliveryRequestBody;
import com.winsupply.tms.contracts.BookDeliveryResponseBody;
import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;
import com.winsupply.tms.exceptions.InvalidClientException;
import com.winsupply.tms.service.TmsWinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TmsIntegrationController {

    @Autowired
    TmsWinService tmsWinService;

    @PostMapping("/getDeliveryQuote")
    public List<GetQuoteResponseBody> getDeliveryQuote(
            @RequestParam String appName,
            @RequestBody GetQuoteRequestBody requestBody)
            throws InvalidClientException {
        return tmsWinService.getDeliveryQuote(appName, requestBody);
    }

    @PostMapping("/bookDelivery")
    public BookDeliveryResponseBody bookDelivery(
            @RequestParam String appName,
            @RequestBody BookDeliveryRequestBody requestBody)
            throws InvalidClientException {
        return tmsWinService.bookDelivery(appName, requestBody);
    }

    @PostMapping("/deliveries")
    public List<BookDeliveryResponseBody> deliveries(
            @RequestParam String appName)
            throws InvalidClientException {
        return tmsWinService.listDeliveries(appName);
    };
}
