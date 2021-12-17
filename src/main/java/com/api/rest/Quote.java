package com.api.rest;
/*Consuming REST:The domain class that contains the data that I need to consume*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private  String type;
    private Value value;

    public Quote(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String toString(){
        return "Quote{" + "type ='"+ '\'' +",value=" + value + '}';
    }
}
