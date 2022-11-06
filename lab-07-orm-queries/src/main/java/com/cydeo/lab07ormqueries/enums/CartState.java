package com.cydeo.lab07ormqueries.enums;

public enum CartState {
    CREATED ("created"), SOLD ("sold");

    CartState(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public String toString() {
        return "CartState{" +
                "value='" + value + '\'' +
                '}';
    }
}
