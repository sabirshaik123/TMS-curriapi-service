package com.winsupply.tms.util;

import com.google.gson.Gson;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

public class GraphQLServiceCall<T> {

    public ClientGraphQlResponse clientCall(String query){
        HttpClient httpClient = HttpClient.create()
                .resolver(spec -> spec.queryTimeout(Duration.ofSeconds(60)));

        WebClient webClient = WebClient.builder()
                .baseUrl(CuriConstants.CURI_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder(webClient)
                .headers(headers -> headers.setBasicAuth(CuriConstants.CURI_USERNAME, CuriConstants.CURI_PASSWORD))
                .build();

        return graphQlClient.document(query).execute().block();
    }


    private String parseToGraphQL(GraphQLEntity<T> graphQLEntity){
        Gson gson = new Gson();
        StringBuffer sb = new StringBuffer();
        sb.append("query {")
                .append("deliveryQuotes(")
                .append(gson.toJson(graphQLEntity.getQueryCondition()))
                .append(")")
                .append(gson.toJson(graphQLEntity.getOutputAttrs()).replace("[","{").replace("]","}"))
                .append("}");
        System.out.println(sb.toString());
        return sb.toString();
    }

}
