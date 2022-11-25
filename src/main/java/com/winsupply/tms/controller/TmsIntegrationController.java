package com.winsupply.tms.controller;

import com.winsupply.tms.curri.model.CurriGetQuoteRequest;
import com.winsupply.tms.service.TmsService;
import com.winsupply.tms.utility.GraphQLClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TmsIntegrationController {

    @Autowired
    TmsService tmsService;

    @GetMapping("/tmstest")
    public ClientGraphQlResponse test(){
        System.out.println(" This is tms test controller ");
        return GraphQLClient.clientCall();
    }


    @PostMapping("/getDeliveryQuotes")
    public String getDeliveryQuotes(@RequestBody CurriGetQuoteRequest data){
        return tmsService.getDeliveryOptions(data);
    }
}
