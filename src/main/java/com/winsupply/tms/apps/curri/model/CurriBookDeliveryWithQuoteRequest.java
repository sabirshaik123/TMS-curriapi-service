package com.winsupply.tms.apps.curri.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CurriBookDeliveryWithQuoteRequest extends CurriBookDeliveryRequest{
    String deliveryQuoteId;
}
