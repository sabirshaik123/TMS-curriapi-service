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
public class CurriItem {
    BigDecimal length;
    BigDecimal width;
    BigDecimal height;
    BigDecimal weight;
    Integer quantity;
    String description;
}
