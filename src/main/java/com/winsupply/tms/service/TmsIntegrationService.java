package com.winsupply.tms.service;

import com.winsupply.tms.curri.model.CurriGetQuoteRequest;
import com.winsupply.tms.util.GraphQLEntity;
import com.winsupply.tms.util.GraphQLServiceCall;
import graphql.ExecutionResult;
import graphql.scalar.GraphqlStringCoercing;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLOutputType;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLInvocationInputFactory;
import graphql.servlet.GraphQLQueryInvoker;
import graphql.servlet.GraphQLSingleInvocationInput;
import graphql.servlet.internal.GraphQLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static graphql.Scalars.GraphQLFloat;
import static graphql.Scalars.GraphQLString;

@Service
public class TmsIntegrationService {

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    private GraphQLInvocationInputFactory invocationInputFactory;
//
//    @Autowired
//    private GraphQLQueryInvoker queryInvoker;

    String query = "query {\n" +
            "  deliveryQuote(\n" +
            "    origin{\n" +
            "      name\n" +
            "      addressLine1\n" +
            "      city\n" +
            "      state\n" +
            "      postalCode\n" +
            "    }\n" +
            "    destination {\n" +
            "      name\n" +
            "      addressLine1\n" +
            "      city\n" +
            "      state\n" +
            "      postalCode\n" +
            "    }\n" +
            "    priority\n" +
            "  ) {\n" +
            "    id\n" +
            "    fee\n" +
            "    distance\n" +
            "    duration\n" +
            "    pickupDuration\n" +
            "    deliveryMethod\n" +
            "  }\n" +
            "}";

   public void getDeliveryOptions(CurriGetQuoteRequest data){
//       GraphQLEntity<CurriGetQuoteRequest> ql = new GraphQLEntity<>();
//       ql.setQueryName("deliveryQuotes");
//       ql.setQueryCondition(data);
//       ql.setOutputAttrs(List.of("id",
//               "fee",
//               "distance",
//               "duration",
//               "pickupDuration",
//               "deliveryMethod"));

       Map<String, Object> variables = new HashMap<>();
       variables.put("origin",data.getOrigin());
       variables.put("destination",data.getDestination());
       variables.put("priority",data.getPriority());

/*
       GraphQLRequest graphQLRequest = new GraphQLRequest("deliveryQuotes",variables,"deliveryQuotes");
       GraphQLSchema schema = GraphQLSchema.newSchema().build();
       GraphQLContext context = new GraphQLContext();

       GraphQLSingleInvocationInput graphQLSingleInvocationInput = new GraphQLSingleInvocationInput(graphQLRequest, schema, context, null);
       GraphQLQueryInvoker qlQueryInvoker = GraphQLQueryInvoker.newBuilder().build();
       ExecutionResult result = qlQueryInvoker.query(graphQLSingleInvocationInput);
       result.toString();
       System.out.println(" result.toString() ::::::::::::::::: "+result.toString());
*/
       GraphQLObjectType testPojo = GraphQLObjectType.newObject().name("deliveryQuote")
               .description("deliveryQuote")
               .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(GraphQLString))
               .field(GraphQLFieldDefinition.newFieldDefinition().name("fee").type(GraphQLFloat))
               .field(GraphQLFieldDefinition.newFieldDefinition().name("distance").type(GraphQLFloat))
               .field(GraphQLFieldDefinition.newFieldDefinition().name("duration").type(GraphQLFloat))
               .field(GraphQLFieldDefinition.newFieldDefinition().name("pickupDuration").type(GraphQLFloat))
               .field(GraphQLFieldDefinition.newFieldDefinition().name("deliveryMethod").type(GraphQLString))
       .build();

//       GraphQLObjectType testPojo = new Object().name("TestPojo")
//               .description("This is a test POJO")
//               .field(newFieldDefinition().name("id").type(GraphQLString).build())
//               .field(newFieldDefinition().name("name").type(GraphQLString).build())
//               .build();

       GraphQLSchema schema = GraphQLSchema.newSchema().query(testPojo).build();
       GraphQLInvocationInputFactory invocationInputFactory = GraphQLInvocationInputFactory.newBuilder(schema).build();
       GraphQLQueryInvoker queryInvoker = GraphQLQueryInvoker.newBuilder().build();

       GraphQLRequest request = new GraphQLRequest(query, variables, null);
       GraphQLSingleInvocationInput invocationInput = invocationInputFactory.create(request);
       ExecutionResult result = queryInvoker.query(invocationInput);




   }
}
