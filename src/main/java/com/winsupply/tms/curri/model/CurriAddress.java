package com.winsupply.tms.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriAddress {
    String name;
    String city;
    String state;
    String postalCode;// max length 6
    
}
