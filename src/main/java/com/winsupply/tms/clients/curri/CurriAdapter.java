package com.winsupply.tms.clients.curri;

import com.winsupply.tms.clients.ClientAdapter;
import com.winsupply.tms.contracts.Delivery;
import com.winsupply.tms.contracts.DeliveryRequest;
import com.winsupply.tms.contracts.Quote;
import com.winsupply.tms.contracts.QuoteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CurriAdapter implements ClientAdapter {

    //if Request/Response is has same pojo structure b/w win and curri. Mapper would be created

    private final CurriClientService curriClientService;

    @Override
    public List<Quote> getDeliveryQuote(QuoteRequest requestBody) {
        List<Quote> responseBody = null;
        if(requestBody.getDeliveryMethod() != null) {
            responseBody = new ArrayList<Quote>();
            responseBody.add(curriClientService.getDeliveryQuote(requestBody));
        }else{
            responseBody = curriClientService.getDeliveryQuotes(requestBody);
        }
        return responseBody;
    }

    @Override
    public Delivery bookDelivery(DeliveryRequest requestBody) {
        return curriClientService.bookDelivery(requestBody);
    }

    @Override
    public List<Delivery> listDeliveries() {
        return curriClientService.listDeliveries();
    }
}
