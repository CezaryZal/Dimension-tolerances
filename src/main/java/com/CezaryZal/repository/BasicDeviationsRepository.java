package com.CezaryZal.repository;

import com.CezaryZal.entity.BasicDeviations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasicDeviationsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public BasicDeviations getRecord(int currentNominalDimension, String currentSign){
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("SELECT value FROM dimension_tolerance.basic_deviations " +
                    "where " + currentNominalDimension + " between nominal_dimension_min and nominal_dimension_max " +
                    "and sign = " + currentSign);
        System.out.println("Punkt kontrolny");
        String tmpString = query.getQueryString();
        System.out.println(tmpString);
        BasicDeviations currentBasicDeviations = (BasicDeviations) query.getSingleResult();
        System.out.println(currentBasicDeviations.toString());

        return currentBasicDeviations;
    }

    public List<BasicDeviations> getList(){
        Session currentSession = sessionFactory.getCurrentSession();
//        Query<BasicDeviations> query = currentSession.createQuery("from BasicDeviations order by 'sign'", BasicDeviations.class);
        Query<BasicDeviations> query = currentSession.createQuery("FROM BasicDeviations B WHERE B.sign = 'c'", BasicDeviations.class);
        List<BasicDeviations> tmpList = query.getResultList();

        return tmpList;
    }

    public BasicDeviations getRecordById (int id){
        Session currentSession = sessionFactory.getCurrentSession();
        BasicDeviations deviations = currentSession.get(BasicDeviations.class, id);

        return deviations;
    }
}


