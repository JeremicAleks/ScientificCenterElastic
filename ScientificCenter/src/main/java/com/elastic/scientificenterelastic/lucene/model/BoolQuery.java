package com.elastic.scientificenterelastic.lucene.model;

import java.util.ArrayList;
import java.util.List;

public class BoolQuery {
    private List<BoolQueryField> fieldsAndValue;
    private String operation;

    public BoolQuery() {
        this.fieldsAndValue = new ArrayList<>();
    }

    public List<BoolQueryField> getFieldsAndValue() {
        return fieldsAndValue;
    }

    public void setFieldsAndValue(List<BoolQueryField> fieldsAndValue) {
        this.fieldsAndValue = fieldsAndValue;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
