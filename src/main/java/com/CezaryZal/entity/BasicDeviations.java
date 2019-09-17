package com.CezaryZal.entity;

import javax.persistence.*;

@Entity
@Table(name = "basic_deviations")
public class BasicDeviations {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDimensionMin() {
        return dimensionMin;
    }

    public void setDimensionMin(int dimensionMin) {
        this.dimensionMin = dimensionMin;
    }

    public int getDimensionMax() {
        return dimensionMax;
    }

    public void setDimensionMax(int dimensionMax) {
        this.dimensionMax = dimensionMax;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
