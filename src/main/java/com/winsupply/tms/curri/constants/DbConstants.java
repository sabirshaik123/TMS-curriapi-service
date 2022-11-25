package com.winsupply.tms.curri.constants;

public class DbConstants {

    private DbConstants(){
    }

    public static String CURRI_DELIVERY_QUOTE_QUERY = "query " +
            "DeliveryQuote (" +
            "$origin: AddressInput!, " +
            "$destination: AddressInput!, " +
            "$deliveryMethod: String!, " +
            "$priority: String" +
            "){ " +
            "deliveryQuote (" +
            "destination: $destination, origin: $origin, deliveryMethod: $deliveryMethod, priority: $priority) " +
            "{id fee  distance duration pickupDuration deliveryMethod }" +
            "}";
}
