package com.CezaryZal.repository;

import com.CezaryZal.entity.BasicDeviations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasicDeviationsRepositoryDbImpl implements RepositoryDb {

    private SessionFactory sessionFactory;

    @Autowired
    public BasicDeviationsRepositoryDbImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public BasicDeviations getRecord(String inputSign, int inputValue){

        Session currentSession = sessionFactory.getCurrentSession();

        Query<BasicDeviations> query = currentSession.createQuery("FROM BasicDeviations WHERE sign=:name " +
                "AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputValue);

        BasicDeviations deviations = query.getSingleResult();

        return deviations;
    }

}


