package com.winsupply.tms.apps.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriGetQuoteRequest {
    CurriAddress origin;
    CurriAddress destination;
    String priority;
    String deliveryMethod;
    List<CurriItem> manifestItems;
}
