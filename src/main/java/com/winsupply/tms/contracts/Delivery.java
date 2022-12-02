package com.winsupply.tms.contracts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    String id;
    Address origin;
    Address destination;
    DeliveryMeta deliveryMeta;
    String deliveryMethod;
    String distance;
    String estimatedTravelTime;
    DeliveryStatus deliveryStatus;
    DriverMeta driver;
    List<String> images;
    Integer price;
    String createdAt;
    String deliveredAt;
}
