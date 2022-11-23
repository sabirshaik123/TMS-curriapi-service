package com.winsupply.tms.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class curriBookDeliveryRequestData {
    String deliveryQuoteId;
    CurriContact dropoffContact;
    CurriContact pickupContact;
    CurriContact pointOfContact;
    CurriDeliveryMeta deliveryMeta;
    List<CurriItem> manifestItems;

}
