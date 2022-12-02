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
public class DeliveryRequest {
    Address origin;
    Address destination;
    Contact dropoffContact;
    Contact pickupContact;
    Contact pointOfContact;
    String priority;
    String scheduledAt;
    String deliveryMethod;
    List<ItemMeta> manifestItems;
}
