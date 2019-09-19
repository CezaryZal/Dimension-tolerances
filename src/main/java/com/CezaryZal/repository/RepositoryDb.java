package com.CezaryZal.repository;

import com.CezaryZal.entity.EntityToDb;

public interface RepositoryDb {

    EntityToDb getRecord(String inputSign, int inputValue);
}
