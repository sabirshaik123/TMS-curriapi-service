package com.winsupply.tms.apps.curri.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winsupply.tms.apps.curri.model.CurriAddress;
import com.winsupply.tms.apps.curri.model.CurriContact;
import com.winsupply.tms.apps.curri.model.CurriGetQuoteResponse;
import com.winsupply.tms.apps.curri.model.CurriItem;
import com.winsupply.tms.contracts.BookDeliveryRequestBody;
import com.winsupply.tms.contracts.BookDeliveryResponseBody;
import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;
import com.winsupply.tms.apps.curri.constants.DbConstants;
import com.winsupply.tms.service.TmsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurriClientService implements TmsClientService {

    @Autowired
    private HttpGraphQlClient curriGraphQlClient;

    @Override
    public List<GetQuoteResponseBody> getDeliveryQuote(GetQuoteRequestBody requestBody) {
        if(requestBody.getOrigin() == null || requestBody.getDestination() ==null){
            //TODO Exception
            return null;
        }
        Map<String, Object> variables = new HashMap<>();
        variables.put("origin",requestBody.getOrigin());
        variables.put("destination",requestBody.getDestination());
        if(requestBody.getPriority() != null)
            variables.put("priority",requestBody.getPriority());
        List<GetQuoteResponseBody> responseBody = new ArrayList<GetQuoteResponseBody>();
        if(requestBody.getDeliveryMethod() != null) {
            variables.put("deliveryMethod", requestBody.getDeliveryMethod());
            if(requestBody.getManifestItems() != null)
                variables.put("manifestItems",requestBody.getManifestItems());
            GetQuoteResponseBody graphQlResponse = curriGraphQlClient
                    .document(DbConstants.CURRI_DELIVERY_QUOTE_QUERY)
                    .variables(variables)
                    .retrieve("deliveryQuote")
                    .toEntity(GetQuoteResponseBody.class)
                    .block();
            responseBody.add(graphQlResponse);
        }else{
            ArrayList graphQlResponse = curriGraphQlClient
                    .document(DbConstants.CURRI_DELIVERY_QUOTES_QUERY)
                    .variables(variables)
                    .retrieve("deliveryQuotes")
                    .toEntity(ArrayList.class)
                    .block();
            if(graphQlResponse !=  null  && !graphQlResponse.isEmpty()){
                responseBody.addAll(graphQlResponse);
            }
        }
        return responseBody;
    }

    @Override
    public BookDeliveryResponseBody bookDelivery(BookDeliveryRequestBody requestBody) {
//        try {
//            Map<String, Object> mapping = new ObjectMapper().readValue(requestBody.toString(), HashMap.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        Map<String, Object> variables = new HashMap<>();
        variables.put("origin",requestBody.getOrigin());
        variables.put("destination",requestBody.getDestination());
        variables.put("dropoffContact",requestBody.getDropoffContact());
        variables.put("pickupContact",requestBody.getPickupContact());
        variables.put("pointOfContact",requestBody.getPointOfContact());
        variables.put("priority",requestBody.getPriority());
        variables.put("scheduledAt",requestBody.getScheduledAt());
        variables.put("deliveryMethod", requestBody.getDeliveryMethod());
        variables.put("manifestItems",requestBody.getManifestItems());
        BookDeliveryResponseBody graphQlResponse = curriGraphQlClient
                .document(DbConstants.CURRI_BOOK_DELIVERY_QUERY)
                .variables(variables)
                .retrieve("bookDelivery")
                .toEntity(BookDeliveryResponseBody.class)
                .block();
        return graphQlResponse;
    }

}
