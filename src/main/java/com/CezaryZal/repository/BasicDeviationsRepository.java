package com.CezaryZal.repository;

import com.CezaryZal.entity.BasicDeviations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BasicDeviationsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public BasicDeviations getRecord(String inputSign, int inputValue){
        Session currentSession = sessionFactory.getCurrentSession();

        Query<BasicDeviations> query = currentSession.createQuery("FROM BasicDeviations WHERE sign=:name " +
                "AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputValue);

        BasicDeviations deviations = query.getSingleResult();

        return deviations;
    }

    public List<BasicDeviations> getList(String inputSign, int inputValue){

        Session currentSession = sessionFactory.getCurrentSession();

//        Query<BasicDeviations> query = currentSession.createQuery("FROM BasicDeviations WHERE sign=:name");
//        query.setParameter("name", inputSign);
//        List<BasicDeviations> tmpList = query.getResultList();

//        Query<BasicDeviations> query = currentSession.createQuery("FROM BasicDeviations WHERE sign=:name " +
//                "AND nominal_dimension_max=:value");
        Query<BasicDeviations> query = currentSession.createQuery("FROM BasicDeviations WHERE sign=:name " +
                "AND :value BETWEEN nominal_dimension_min and nominal_dimension_max");
        query.setParameter("name", inputSign);
        query.setParameter("value", inputValue);

        List<BasicDeviations> tmpList = query.getResultList();

        System.out.println("inputSign: " + inputSign);
        System.out.println("długość: " + tmpList.size());
        System.out.println("Lista: " + Arrays.toString(tmpList.toArray()));

        return tmpList;
    }

    public BasicDeviations getRecordById (int id){
        Session currentSession = sessionFactory.getCurrentSession();
        BasicDeviations deviations = currentSession.get(BasicDeviations.class, id);

        return deviations;
    }
}


