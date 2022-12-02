package com.winsupply.tms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.client.RestTemplate;

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
        HttpGraphQlClient httpGraphQlClient =  HttpGraphQlClient
                .builder().url(curriBaseUrl)
                .headers(headers -> headers.setBasicAuth(curriUserId, curriApikey))
                .build();
        return httpGraphQlClient;
    }
}
