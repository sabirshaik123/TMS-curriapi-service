package com.winsupply.tms.controller;

import com.winsupply.tms.utility.GraphQLClient;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TmsIntegrationController {

    @GetMapping("/tmstest")
    public ClientGraphQlResponse test(){
        System.out.println(" This is tms test controller ");
        return GraphQLClient.clientCall();
    }
}
