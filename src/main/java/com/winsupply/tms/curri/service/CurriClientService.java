package com.winsupply.tms.curri.service;

import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;
import com.winsupply.tms.curri.constants.DbConstants;
import com.winsupply.tms.curri.model.CurriGetQuoteResponse;
import com.winsupply.tms.service.TmsClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CurriClientService implements TmsClientService {

    @Autowired
    private HttpGraphQlClient curriGraphQlClient = null;

   public ClientGraphQlResponse getCurriDeliveryQuotes(Map<String, Object> data) {
        return curriGraphQlClient
                .document(DbConstants.CURRI_DELIVERY_QUOTE_QUERY)
                .variables(data)
                .execute()
                .block();
    }

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

        String query = "";
        if(requestBody.getDeliveryMethod() != null) {
            variables.put("deliveryMethod", requestBody.getDeliveryMethod());
            if(requestBody.getManifestItems() != null)
                variables.put("manifestItems",requestBody.getManifestItems());
            query = DbConstants.CURRI_DELIVERY_QUOTE_QUERY;
        }else{
            query = DbConstants.CURRI_DELIVERY_QUOTES_QUERY;
        }

        ClientGraphQlResponse graphQlResponse = curriGraphQlClient
                .document(query)
                .variables(variables)
                .execute()
                .block();
        return mapToGetQuoteResponseBody(graphQlResponse);
    }

    public List<GetQuoteResponseBody> mapToGetQuoteResponseBody(ClientGraphQlResponse graphQlResponse) {
        List<GetQuoteResponseBody> responseBody = new ArrayList<GetQuoteResponseBody>();
        if(graphQlResponse.isValid() && graphQlResponse.getData() != null ){

            LinkedHashMap response = (LinkedHashMap)graphQlResponse.getData();
            if(response.get("deliveryQuotes") != null){
                ((ArrayList) response.get("deliveryQuotes")).stream().forEach(obj -> {
                    if(obj instanceof LinkedHashMap) {
                        responseBody.add(mapToGetQuoteResponseBody((LinkedHashMap) obj));
                    }
                });
            }else if(response.get("deliveryQuote") != null){
                responseBody.add(mapToGetQuoteResponseBody((LinkedHashMap)response.get("deliveryQuote")));
            }

        }
        return responseBody;
    }

    public GetQuoteResponseBody mapToGetQuoteResponseBody(LinkedHashMap response) {
        GetQuoteResponseBody responseBody = GetQuoteResponseBody
                .builder()
                .id((String)response.get("id"))
                .fee((Integer)response.get("fee"))
                .deliveryMethod((String)response.get("deliveryMethod"))
                .distance((Integer)response.get("distance"))
                .pickupDuration((Integer)response.get("pickupDuration"))
                .duration((Integer)response.get("duration"))
                .build();
        return responseBody;
    }
}
