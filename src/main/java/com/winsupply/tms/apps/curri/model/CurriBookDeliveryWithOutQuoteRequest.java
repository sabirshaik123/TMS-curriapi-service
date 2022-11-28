package com.winsupply.tms.apps.curri.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CurriBookDeliveryWithOutQuoteRequest extends CurriBookDeliveryRequest{

    boolean skipQuote;
    CurriAddress origin;
    CurriAddress destination;
    String priority;
    String deliveryMethod;

}
