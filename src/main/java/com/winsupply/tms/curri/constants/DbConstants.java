package com.winsupply.tms.curri.constants;

public class DbConstants {

    private DbConstants(){
    }

    public static String CURRI_DELIVERY_QUOTE_QUERY = "query " +
            "DeliveryQuote (" +
            "$origin: AddressInput!, " +
            "$destination: AddressInput!, " +
            "$deliveryMethod: String!, " +
            "$priority: String, " +
            "$manifestItems: [ManifestItemInput]" +
            "){ " +
            "deliveryQuote " +
            "(destination: $destination, origin: $origin, deliveryMethod: $deliveryMethod, priority: $priority, manifestItems: $manifestItems) " +
            "{id fee distance duration pickupDuration deliveryMethod }" +
            "}";
    public static String CURRI_DELIVERY_QUOTES_QUERY = "query " +
            "DeliveryQuotes (" +
            "$origin: AddressInput!, " +
            "$destination: AddressInput!, " +
            "$priority: String" +
            "){ " +
            "deliveryQuotes " +
            "(destination: $destination, origin: $origin, priority: $priority) " +
            "{id fee distance duration pickupDuration deliveryMethod }" +
            "}";
}
