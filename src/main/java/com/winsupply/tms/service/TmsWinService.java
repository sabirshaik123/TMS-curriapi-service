package com.winsupply.tms.service;

import com.winsupply.tms.contracts.BookDeliveryRequestBody;
import com.winsupply.tms.contracts.BookDeliveryResponseBody;
import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;
import com.winsupply.tms.apps.curri.service.CurriClientService;
import com.winsupply.tms.exceptions.InvalidClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmsWinService {

    @Autowired
    private CurriClientService curriClientService;

    private TmsClientService getClientSevice(String appName) throws InvalidClientException {
        TmsClientService tmsClientService = null;
        switch (appName){
            case "curri":
                tmsClientService = this.curriClientService;
                break;
            case "uber":
                break;
            case "fedEx":
                break;
            default:
                break;
        }
        if(tmsClientService == null) {
            throw new InvalidClientException();
        }
        return tmsClientService;
    }

    public List<GetQuoteResponseBody> getDeliveryQuote(String appName, GetQuoteRequestBody requestBody)
            throws InvalidClientException {
        return getClientSevice(appName).getDeliveryQuote(requestBody);
    }

    public BookDeliveryResponseBody bookDelivery(String appName, BookDeliveryRequestBody requestBody)
            throws InvalidClientException{
        return getClientSevice(appName).bookDelivery(requestBody);
    }

    public List<BookDeliveryResponseBody> listDeliveries(String appName)
            throws InvalidClientException{
        return getClientSevice(appName).listDeliveries();
    }

}
