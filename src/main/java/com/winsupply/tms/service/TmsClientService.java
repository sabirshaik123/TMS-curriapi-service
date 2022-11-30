package com.winsupply.tms.service;

import com.winsupply.tms.contracts.BookDeliveryRequestBody;
import com.winsupply.tms.contracts.BookDeliveryResponseBody;
import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;

import java.util.List;

public interface TmsClientService {

    public List<GetQuoteResponseBody> getDeliveryQuote(GetQuoteRequestBody requestBody);

    public BookDeliveryResponseBody bookDelivery(BookDeliveryRequestBody requestBody);
}
