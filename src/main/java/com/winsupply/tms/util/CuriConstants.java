package com.winsupply.tms.util;

import com.winsupply.tms.curri.model.CurriGetQuoteRequest;

public class CuriConstants {

    public static final String CURI_URL = "https://api.curri.com/graphql";
    public static final String CURI_USERNAME = "user_M6DJ3AUJYN";
    public static final String CURI_PASSWORD =  "d5df96e3-e484-4f66-9b3f-01b3bb09b284";

    public static final String QUERY_DELIEVERY_QUOTE = "query {\n" +
            "  deliveryQuotes(\n" +
            "    origin: {\n" +
            "      name: $nameOrigin\n" +
            "      addressLine1: $addressOrigin\n" +
            "      city: $cityOrigin\n" +
            "      state: $stateOrigin\n" +
            "      postalCode: $postalCodeOrigin\n" +
            "    }\n" +
            "    destination: {\n" +
            "      name: $nameDestination\n" +
            "      addressLine1: $addressDestination\n" +
            "      city: $cityDestination\n" +
            "      state: $stateDestination\n" +
            "      postalCode: $postalCodeDestination\n" +
            "    }\n" +
            "    priority: $priority\n" +
            "  ) {\n" +
            "    id\n" +
            "    fee\n" +
            "    distance\n" +
            "    duration\n" +
            "    pickupDuration\n" +
            "    deliveryMethod\n" +
            "  }\n" +
            "}";
    public static String getCuriDelieveryQuery(CurriGetQuoteRequest data){
        String qry = QUERY_DELIEVERY_QUOTE;
        qry = qry.replace("$nameOrigin", "\"" + data.getOrigin().getName() + "\"")
        .replace("$addressOrigin", "\"" + data.getOrigin().getAddressLine1() + "\"")
        .replace("$cityOrigin", "\"" + data.getOrigin().getCity() + "\"")
        .replace("$stateOrigin", "\"" + data.getOrigin().getState() + "\"")
        .replace("$postalCodeOrigin", data.getOrigin().getPostalCode())
        .replace("$nameDestination", "\"" + data.getDestination().getName() + "\"")
        .replace("$addressDestination","\"" +  data.getDestination().getAddressLine1()+ "\"")
        .replace("$cityDestination","\"" +  data.getDestination().getCity()+ "\"")
        .replace("$stateDestination", "\"" + data.getDestination().getState() + "\"")
        .replace("$postalCodeDestination", data.getDestination().getPostalCode())
        .replace("$priority", "\"" + data.getPriority()+ "\"");

        return qry;
    }
}
