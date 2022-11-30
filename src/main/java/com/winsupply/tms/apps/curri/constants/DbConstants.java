package com.winsupply.tms.apps.curri.constants;

public class DbConstants {

    private DbConstants(){
    }

    public static String CURRI_DELIVERY_QUOTE_QUERY = "query DeliveryQuote (" +
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
    public static String CURRI_DELIVERY_QUOTES_QUERY = "query DeliveryQuotes (" +
            "$origin: AddressInput!, " +
            "$destination: AddressInput!, " +
            "$priority: String" +
            "){ " +
            "deliveryQuotes " +
            "(destination: $destination, origin: $origin, priority: $priority) " +
            "{id fee distance duration pickupDuration deliveryMethod }" +
            "}";
    public static String CURRI_BOOK_DELIVERY_QUERY =
            "mutation BookDelivery (" +
                "$origin: AddressInput!, " +
                "$destination: AddressInput!, " +
                "$dropoffContact: DeliveryContactInput, " +
                "$pickupContact: DeliveryContactInput, " +
                "$pointOfContact: DeliveryContactInput, " +
                "$priority: String, " +
                "$scheduledAt: String, " +
                "$deliveryMethod: String, " +
                "$manifestItems: [ManifestItemInput] " +
            ") { bookDelivery( data: { " +
                "skipQuote: true, " +
                "origin: $origin, " +
                "destination: $destination, " +
                "dropoffContact: $dropoffContact, " +
                "pickupContact: $pickupContact, " +
                "pointOfContact: $pointOfContact, " +
                "priority: $priority, " +
                "scheduledAt: $scheduledAt, " +
                "deliveryMethod: $deliveryMethod, " +
                "manifestItems: $manifestItems " +
            "} ) { " +
                "id, price, createdAt, deliveryMethod, deliveredAt " +
            "} }";

}
