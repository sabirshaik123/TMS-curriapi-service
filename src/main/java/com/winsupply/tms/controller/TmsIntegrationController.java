package com.winsupply.tms.controller;

import com.winsupply.tms.curri.model.CurriGetQuoteRequest;
import com.winsupply.tms.curri.service.CurriClientService;
import com.winsupply.tms.service.TmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TmsIntegrationController {

    @Autowired
    TmsService tmsService;

    @Autowired
    CurriClientService curriClientService;

    @PostMapping("/getCurriDeliveryQuotes")
    public ClientGraphQlResponse getCurriDeliveryQuotes(@RequestBody Map<String, Object> data){
        return curriClientService.getCurriDeliveryQuotes(data);
    }

    @PostMapping("/getDeliveryQuotes")
    public String getDeliveryQuotes(@RequestBody CurriGetQuoteRequest data){
        return tmsService.getDeliveryOptions(data);
    }
}
