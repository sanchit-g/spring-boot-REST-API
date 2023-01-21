package com.springrest.springRest.entities;

public class Req {
    public String filter;
    public String value;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getName() {
        return value;
    }

    public void setName(String value) {
        this.value = value;
    }

    public Req(String filter, String value) {
        this.filter = filter;
        this.value = value;
    }
}