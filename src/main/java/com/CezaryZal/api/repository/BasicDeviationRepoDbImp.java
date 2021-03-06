package com.CezaryZal.api.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("basicDeviation")
public class BasicDeviationRepoDbImp implements RepositoryDb {

    private final SessionFactory sessionFactory;

    @Autowired
    public BasicDeviationRepoDbImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Double getValueOfRecord(String inputSign, int inputDimension) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Double> query = currentSession.createQuery(
                "SELECT value FROM BasicDeviationTabularDataImp WHERE sign=:name " +
                "AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputDimension);

        return query.getSingleResult();
    }

}


