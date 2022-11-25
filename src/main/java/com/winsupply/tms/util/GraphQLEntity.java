package com.winsupply.tms.util;

import java.util.List;

public class GraphQLEntity<T> {

    private String queryName;
    private T queryCondition;
    private List<String> outputAttrs;

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public T getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(T queryCondition) {
        this.queryCondition = queryCondition;
    }

    public List<String> getOutputAttrs() {
        return outputAttrs;
    }

    public void setOutputAttrs(List<String> outputAttrs) {
        this.outputAttrs = outputAttrs;
    }

}
