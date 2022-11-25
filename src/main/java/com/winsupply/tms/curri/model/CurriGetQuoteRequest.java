package com.winsupply.tms.curri.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class CurriGetQuoteRequest {
    CurriAddress origin;
    CurriAddress destination;
    String priority;

    public CurriAddress getOrigin() {
        return origin;
    }

    public void setOrigin(CurriAddress origin) {
        this.origin = origin;
    }

    public CurriAddress getDestination() {
        return destination;
    }

    public void setDestination(CurriAddress destination) {
        this.destination = destination;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
