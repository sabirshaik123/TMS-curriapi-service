package com.winsupply.tms.apps.curri.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CurriBookDeliveryRequest {

    CurriContact dropoffContact;
    CurriContact pickupContact;
    CurriContact pointOfContact;
    CurriDeliveryMeta deliveryMeta;
    List<CurriItem> manifestItems;
    String scheduledAt; // optional
}
