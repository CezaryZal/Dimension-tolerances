package com.CezaryZal.api.repository;

import com.CezaryZal.api.model.entity.NominalTolerance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class NominalToleranceRepoDbImpl implements RepositoryDb{

    private final SessionFactory sessionFactory;

    @Autowired
    public NominalToleranceRepoDbImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public NominalTolerance getRecord(String inputSign, int inputValue) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<NominalTolerance> query = currentSession.createQuery("FROM NominalTolerance WHERE sign=:name " +
                "AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputValue);

        return query.getSingleResult();
    }
}
