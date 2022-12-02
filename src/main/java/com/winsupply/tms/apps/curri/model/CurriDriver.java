package com.winsupply.tms.apps.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriDriver {
    String firstName;
    String lastName;
    String phoneNumber;
    String profileImageUrl;
    CurriDriverLocation lastKnownLocation;
}
