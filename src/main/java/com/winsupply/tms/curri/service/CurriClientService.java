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

//    @Value("${curri.baseUrl}")
//    private String curriBaseUrl;
//    @Value("${curri.userId}")
//    private String curriUserId;
//    @Value("${curri.apiKey}")
//    private String curriApikey;

    private String curriBaseUrl = "https://api.curri.com/graphql";
    private String curriUserId = "user_M6DJ3AUJYN";
    private String curriApikey =  "d5df96e3-e484-4f66-9b3f-01b3bb09b284";

    private HttpGraphQlClient curriGraphQlClient = null;

    private void loadCurriGraphQlClient(){
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

        ClientGraphQlResponse graphQlResponse = getCurriGraphQlClient()
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
