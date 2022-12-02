package com.winsupply.tms.clients;

import com.winsupply.tms.contracts.DeliveryRequest;
import com.winsupply.tms.contracts.Delivery;
import com.winsupply.tms.contracts.QuoteRequest;
import com.winsupply.tms.contracts.Quote;

import java.util.List;

public interface ClientAdapter {

    public List<Quote> getDeliveryQuote(QuoteRequest requestBody);

    public Delivery bookDelivery(DeliveryRequest requestBody);

    public List<Delivery> listDeliveries();
}
