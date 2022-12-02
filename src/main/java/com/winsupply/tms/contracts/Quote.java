package com.winsupply.tms.contracts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    String id;
    Integer fee;
    Integer distance;
    Integer duration;
    Integer pickupDuration;
    String deliveryMethod;
}
