package com.CezaryZal.repository;

import com.CezaryZal.entity.NominalTolerance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NominalToleranceRepositoryDbImpl implements RepositoryDb{

    private SessionFactory sessionFactory;

    @Autowired
    public NominalToleranceRepositoryDbImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public NominalTolerance getRecord(String inputSign, int inputValue) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<NominalTolerance> query = currentSession.createQuery("FROM NominalTolerance WHERE sign=:name " +
                "AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputValue);

        NominalTolerance tolerance = query.getSingleResult();

        return tolerance;
    }
}
