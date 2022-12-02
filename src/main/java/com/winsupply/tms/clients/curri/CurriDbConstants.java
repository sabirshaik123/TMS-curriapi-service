package com.winsupply.tms.clients.curri;

public class CurriDbConstants {

    private CurriDbConstants(){
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
                "id " +
                "createdAt " +
                "distance " +
                "price " +
                "estimatedTravelTime " +
                "deliveryMethod " +
                "deliveredAt " +
                "deliveryMeta { dropoffNote pickupNote poNumber orderNumber } " +
                "deliveryStatus { name code } " +
                "origin { name addressLine1 addressLine2 city state postalCode latitude longitude } " +
                "destination { name addressLine1 addressLine2 city state postalCode latitude longitude } " +
                "driver { firstName lastName phoneNumber profileImageUrl } " +
                "images " +
            "} }";
    public static String CURRI_LIST_DELIVERY_QUERY =
            "query { deliveries { " +
                "id " +
                "createdAt " +
                "distance " +
                "price " +
                "estimatedTravelTime " +
                "deliveryMethod " +
                "deliveredAt " +
                "deliveryMeta { dropoffNote pickupNote poNumber orderNumber } " +
                "deliveryStatus { name code } " +
                "origin { name addressLine1 addressLine2 city state postalCode latitude longitude } " +
                "destination { name addressLine1 addressLine2 city state postalCode latitude longitude } " +
                "driver { firstName lastName phoneNumber profileImageUrl } " +
                "images " +
            "} }";

}
