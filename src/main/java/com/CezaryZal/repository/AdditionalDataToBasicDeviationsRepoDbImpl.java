package com.CezaryZal.repository;

import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class AdditionalDataToBasicDeviationsRepoDbImpl implements RepositoryDb {

    private final SessionFactory sessionFactory;

    @Autowired
    public AdditionalDataToBasicDeviationsRepoDbImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public AdditionalDataToBasicDeviations getRecord(String inputSign, int inputValue) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<AdditionalDataToBasicDeviations> query = currentSession.createQuery("FROM AdditionalDataToBasicDeviations " +
                "WHERE sign=:name AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputValue);

        return query.getSingleResult();
    }
}
