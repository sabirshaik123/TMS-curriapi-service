package com.winsupply.tms.apps.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriDeliveryMeta {
    String poNumber;
    String orderNumber;
    String bolNumber;
    String pickupNote;
    String dropoffNote;
    CurriCustomerData customerData;
}
