package com.CezaryZal.entity;

import javax.persistence.*;

@Entity
@Table(name = "basic_deviations")
public class BasicDeviations implements EntityToDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nominal_dimension_min")
    private int dimensionMin;

    @Column(name = "nominal_dimension_max")
    private int dimensionMax;

    @Column(name = "sign")
    private String sign;

    @Column(name = "value")
    private int value;

    public BasicDeviations() {
    }

    public BasicDeviations(int dimensionMin, int dimensionMax, String sign, int value) {
        this.dimensionMin = dimensionMin;
        this.dimensionMax = dimensionMax;
        this.sign = sign;
        this.value = value;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getDimensionMin() {
        return dimensionMin;
    }

    @Override
    public int getDimensionMax() {
        return dimensionMax;
    }

    @Override
    public String getSign() {
        return sign;
    }

    @Override
    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "BasicDeviations{" +
                "id=" + id +
                ", dimensionMin=" + dimensionMin +
                ", dimensionMax=" + dimensionMax +
                ", sign='" + sign + '\'' +
                ", value=" + value +
                '}';
    }
}
