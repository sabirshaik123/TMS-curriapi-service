package com.winsupply.tms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Value("${curri.baseUrl}")
    private String curriBaseUrl;

    @Value("${curri.userId}")
    private String curriUserId;

    @Value("${curri.apiKey}")
    private String curriApikey;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpGraphQlClient getCurriGraphQlClient(){
        WebClient webClient = WebClient.builder()
                .baseUrl(curriBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        HttpGraphQlClient httpGraphQlClient =  HttpGraphQlClient.builder(webClient)
                .headers(headers -> headers.setBasicAuth(curriUserId, curriApikey))
                .build();
        System.out.println(" HttpGraphQlClient :::"+httpGraphQlClient);
        return httpGraphQlClient;
    }
}
