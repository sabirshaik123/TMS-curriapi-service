package com.winsupply.tms.apps.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriAddress {
    String id;
    String name;
    String city;
    String state;
    String addressLine1;
    String addressLine2;
    String postalCode;
    String latitude;
    String longitude;
}
