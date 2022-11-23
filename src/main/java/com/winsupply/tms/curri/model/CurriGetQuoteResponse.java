package com.winsupply.tms.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriGetQuoteResponse {
    String id;
    BigDecimal fee;
    BigDecimal distance;
    long duration;
    long pickupDuration;
    String deliveryMethod;
}
