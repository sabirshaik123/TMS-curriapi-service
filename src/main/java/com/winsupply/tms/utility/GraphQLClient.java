package com.winsupply.tms.utility;

import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class GraphQLClient {

    public static String query = "query {\n" +
            "  deliveryQuote(\n" +
            "    origin: {\n" +
            "      name: \"305 South Kalorama Street\"\n" +
            "      addressLine1: \"305 S Kalorama St\"\n" +
            "      city: \"Ventura\"\n" +
            "      state: \"CA\"\n" +
            "      postalCode: 93001\n" +
            "    }\n" +
            "    destination: {\n" +
            "      name: \"Y Combinator\"\n" +
            "      addressLine1: \"335 Pioneer Way\"\n" +
            "      city: \"Mountain View\"\n" +
            "      state: \"CA\"\n" +
            "      postalCode: 94041\n" +
            "    }\n" +
            "    priority: \"rush\"\n" +
            "    deliveryMethod: \"recommend\"\n" +
            "    manifestItems: [\n" +
            "      {\n" +
            "        description: \"40 Gallon Water Heater\"\n" +
            "        length: 50\n" +
            "        width: 50\n" +
            "        height: 150\n" +
            "        weight: 64\n" +
            "        quantity: 2\n" +
            "      }\n" +
            "    ]\n" +
            "  ) {\n" +
            "    id\n" +
            "    fee\n" +
            "    distance\n" +
            "    duration\n" +
            "    pickupDuration\n" +
            "    deliveryMethod\n" +
            "  }\n" +
            "}";

    public static ClientGraphQlResponse clientCall(){
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.curri.com/graphql")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder(webClient)
                .headers(headers -> headers.setBasicAuth("user_M6DJ3AUJYN", "d5df96e3-e484-4f66-9b3f-01b3bb09b284"))
                .build();

        return graphQlClient.document(query).execute().block();

    }
}
