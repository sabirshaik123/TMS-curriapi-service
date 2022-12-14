package com.winsupply.tms.contracts;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {
    String trackingNumber;
    String myFavoriteNumber;
}
