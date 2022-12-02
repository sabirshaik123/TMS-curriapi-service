package com.winsupply.tms.apps.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriDriverLocation {
    BigDecimal latitude;
    BigDecimal longitude;
}
