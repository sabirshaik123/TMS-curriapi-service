package com.winsupply.tms.contracts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetQuoteResponseBody {
    String id;
    Integer fee;
    Integer distance;
    Integer duration;
    Integer pickupDuration;
    String deliveryMethod;
}
