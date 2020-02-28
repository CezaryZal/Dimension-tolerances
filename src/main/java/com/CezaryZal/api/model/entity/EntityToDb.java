package com.CezaryZal.api.model.entity;

public interface EntityToDb {

    int getId();

    int getDimensionMin();

    int getDimensionMax();

    String getSign();

    double getValue();
}
