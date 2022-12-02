package com.winsupply.tms.contracts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMeta {
    String poNumber;
    String orderNumber;
    String bolNumber;
    String pickupNote;
    String dropoffNote;
    CustomerData customerData;
}
