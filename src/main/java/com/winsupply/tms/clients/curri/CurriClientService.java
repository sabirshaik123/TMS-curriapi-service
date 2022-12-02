package com.winsupply.tms.clients.curri;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winsupply.tms.contracts.DeliveryRequest;
import com.winsupply.tms.contracts.Delivery;
import com.winsupply.tms.contracts.QuoteRequest;
import com.winsupply.tms.contracts.Quote;

import java.util.HashMap;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurriClientService {

    private final HttpGraphQlClient curriGraphQlClient;

    public Quote getDeliveryQuote(QuoteRequest requestBody) {
        return curriGraphQlClient
                .document(CurriDbConstants.CURRI_DELIVERY_QUOTE_QUERY)
                .variables(new ObjectMapper().convertValue(requestBody, HashMap.class))
                .retrieve("deliveryQuote")
                .toEntity(Quote.class)
                .block();
    }

    public List<Quote> getDeliveryQuotes(QuoteRequest requestBody) {
        return curriGraphQlClient
                .document(CurriDbConstants.CURRI_DELIVERY_QUOTES_QUERY)
                .variables(new ObjectMapper().convertValue(requestBody, HashMap.class))
                .retrieve("deliveryQuotes")
                .toEntityList(Quote.class)
                .block();
    }

    public Delivery bookDelivery(DeliveryRequest requestBody) {
        return curriGraphQlClient
                .document(CurriDbConstants.CURRI_BOOK_DELIVERY_QUERY)
                .variables(new ObjectMapper().convertValue(requestBody, HashMap.class))
                .retrieve("bookDelivery")
                .toEntity(Delivery.class)
                .block();
    }

    public List<Delivery> listDeliveries() {
        return curriGraphQlClient
                .document(CurriDbConstants.CURRI_LIST_DELIVERY_QUERY)
                .retrieve("deliveries")
                .toEntityList(Delivery.class)
                .block();
    }

}
