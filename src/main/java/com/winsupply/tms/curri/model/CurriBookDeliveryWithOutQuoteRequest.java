package com.winsupply.tms.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriBookDeliveryWithOutQuoteRequest extends CurriBookDeliveryRequest{

    boolean skipQuote = true;
    CurriAddress origin;
    CurriAddress destination;
    String priority;
    String deliveryMethod;

}
