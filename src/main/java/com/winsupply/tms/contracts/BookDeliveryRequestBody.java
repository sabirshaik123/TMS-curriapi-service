package com.winsupply.tms.contracts;

import com.winsupply.tms.apps.curri.model.CurriAddress;
import com.winsupply.tms.apps.curri.model.CurriContact;
import com.winsupply.tms.apps.curri.model.CurriItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDeliveryRequestBody {
    CurriAddress origin;
    CurriAddress destination;
    CurriContact dropoffContact;
    CurriContact pickupContact;
    CurriContact pointOfContact;
    String priority;
    String scheduledAt;
    String deliveryMethod;
    List<CurriItem> manifestItems;
}
