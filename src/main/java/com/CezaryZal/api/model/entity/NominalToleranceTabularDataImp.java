package com.CezaryZal.api.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "nominal_tolerance")
public class NominalToleranceTabularDataImp {

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
    private double value;


    public int getId() {
        return id;
    }

    public int getDimensionMin() {
        return dimensionMin;
    }

    public int getDimensionMax() {
        return dimensionMax;
    }

    public String getSign() {
        return sign;
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        return "NominalToleranceTabularDataImp{" +
                "id=" + id +
                ", dimensionMin=" + dimensionMin +
                ", dimensionMax=" + dimensionMax +
                ", sign='" + sign + '\'' +
                ", value=" + value +
                '}';
    }
}
