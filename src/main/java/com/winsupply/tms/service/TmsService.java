package com.winsupply.tms.service;

import com.winsupply.tms.curri.model.CurriGetQuoteRequest;
import com.winsupply.tms.util.CuriConstants;
import com.winsupply.tms.util.GraphQLEntity;
import com.winsupply.tms.util.GraphQLServiceCall;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.stereotype.Service;

@Service
public class TmsService {


  public String getDeliveryOptions(CurriGetQuoteRequest data){
      GraphQLServiceCall<CurriGetQuoteRequest> graphQLServiceCall = new GraphQLServiceCall<>();
      ClientGraphQlResponse graphQlResponse =  graphQLServiceCall.clientCall(CuriConstants.getCuriDelieveryQuery(data));
      return graphQlResponse.toString();
  }

}
