package com.winsupply.tms.contracts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteRequest {
    Address origin;
    Address destination;
    String priority;
    String deliveryMethod;
    List<ItemMeta> manifestItems;
}
