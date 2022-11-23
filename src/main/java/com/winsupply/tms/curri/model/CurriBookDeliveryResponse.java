package com.winsupply.tms.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriBookDeliveryResponse {
    String id;
    Integer price;
    String createdAt; //formatted in simplified extended ISO format (ISO 8601)
    String deliveryMethod;
    String deliveredAt; //formatted in simplified extended ISO format (ISO 8601)
}
