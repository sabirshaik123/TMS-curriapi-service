package com.winsupply.tms.service;

import com.winsupply.tms.clients.ClientAdapter;
import com.winsupply.tms.clients.curri.CurriAdapter;
import com.winsupply.tms.contracts.DeliveryRequest;
import com.winsupply.tms.contracts.Delivery;
import com.winsupply.tms.contracts.QuoteRequest;
import com.winsupply.tms.contracts.Quote;
import com.winsupply.tms.exceptions.InvalidClientException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TmsWinService {

    private final CurriAdapter curriAdapter;

    private ClientAdapter getClientAdapter(String appName) throws InvalidClientException {
        ClientAdapter clientAdapter = null;
        switch (appName){
            case "curri":
                clientAdapter = curriAdapter;
                break;
            case "uber":
                break;
            case "fedEx":
                break;
            default:
                break;
        }
        if(clientAdapter == null) {
            throw new InvalidClientException();
        }
        return clientAdapter;
    }

    public List<Quote> getDeliveryQuote(String appName, QuoteRequest requestBody)
            throws InvalidClientException {
        return getClientAdapter(appName).getDeliveryQuote(requestBody);
    }

    public Delivery bookDelivery(String appName, DeliveryRequest requestBody)
            throws InvalidClientException{
        return getClientAdapter(appName).bookDelivery(requestBody);
    }

    public List<Delivery> listDeliveries(String appName)
            throws InvalidClientException{
        return getClientAdapter(appName).listDeliveries();
    }

}
