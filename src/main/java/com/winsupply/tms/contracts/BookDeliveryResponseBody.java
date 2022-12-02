package com.winsupply.tms.contracts;

import com.winsupply.tms.apps.curri.model.CurriAddress;
import com.winsupply.tms.apps.curri.model.CurriDeliveryMeta;
import com.winsupply.tms.apps.curri.model.CurriDeliveryStatus;
import com.winsupply.tms.apps.curri.model.CurriDriver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDeliveryResponseBody {
    String id;
    CurriAddress origin;
    CurriAddress destination;
    CurriDeliveryMeta deliveryMeta;
    String deliveryMethod;
    String distance;
    String estimatedTravelTime;
    CurriDeliveryStatus deliveryStatus;
    CurriDriver driver;
    List<String> images;
    Integer price;
    String createdAt;
    String deliveredAt;
}
