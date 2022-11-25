package com.winsupply.tms.curri.service;

import com.winsupply.tms.curri.constants.DbConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class CurriClientService {
    @Value("${curri.baseUrl}")
    private String curriBaseUrl;
    @Value("${curri.userId}")
    private String curriUserId;
    @Value("${curri.apiKey}")
    private String curriApikey;
    private HttpGraphQlClient curriGraphQlClient = null;

    public void loadCurriGraphQlClient(){
        WebClient webClient = WebClient.builder()
                .baseUrl(curriBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        curriGraphQlClient = HttpGraphQlClient.builder(webClient)
                .headers(headers -> headers.setBasicAuth(curriUserId, curriApikey))
                .build();
    }

    public HttpGraphQlClient getCurriGraphQlClient() {
        if(curriGraphQlClient == null) {
            loadCurriGraphQlClient();
        }
        return curriGraphQlClient;
    }


    public ClientGraphQlResponse getCurriDeliveryQuotes(Map<String, Object> data) {
        return getCurriGraphQlClient()
                .document(DbConstants.CURRI_DELIVERY_QUOTE_QUERY)
                .variables(data)
                .execute().block();
    }
}
