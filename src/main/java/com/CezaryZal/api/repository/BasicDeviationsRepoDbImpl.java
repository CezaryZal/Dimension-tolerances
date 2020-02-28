package com.CezaryZal.api.repository;

import com.CezaryZal.api.model.entity.BasicDeviations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository

public class BasicDeviationsRepoDbImpl implements RepositoryDb {

    private final SessionFactory sessionFactory;

    @Autowired
    public BasicDeviationsRepoDbImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public BasicDeviations getRecord(String inputSign, int inputValue){

        Session currentSession = sessionFactory.getCurrentSession();

        Query<BasicDeviations> query = currentSession.createQuery("FROM BasicDeviations WHERE sign=:name " +
                "AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputValue);

        return query.getSingleResult();
    }

}


