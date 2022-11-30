package com.winsupply.tms.service;

import com.winsupply.tms.contracts.BookDeliveryRequestBody;
import com.winsupply.tms.contracts.BookDeliveryResponseBody;
import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;
import com.winsupply.tms.apps.curri.service.CurriClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmsWinService {

    @Autowired
    private CurriClientService curriClientService;


    private TmsClientService getClientSevice(String appName){
        TmsClientService tmsClientService = null;
        switch (appName){
            case "curri":
                tmsClientService = this.curriClientService;
                break;
            case "uber":
                break;
        }
        return tmsClientService;
    }

    public List<GetQuoteResponseBody> getDeliveryQuote(String appName, GetQuoteRequestBody requestBody) {
        TmsClientService tmsClientService = getClientSevice(appName);
        if(tmsClientService == null){
            // TODO Exception
            return null;
        }else{
            return tmsClientService.getDeliveryQuote(requestBody);
        }
    }

    public BookDeliveryResponseBody bookDelivery(String appName, BookDeliveryRequestBody requestBody) {
        TmsClientService tmsClientService = getClientSevice(appName);
        if(tmsClientService == null){
            // TODO Exception
            return null;
        }else{
            return tmsClientService.bookDelivery(requestBody);
        }
    }
}
