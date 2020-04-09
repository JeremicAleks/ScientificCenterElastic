package com.elastic.scientificenterelastic.lucene.model;

public class BoolQueryField {
    String field;
    String value;

    public BoolQueryField() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
