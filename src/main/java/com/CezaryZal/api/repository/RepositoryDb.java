package com.CezaryZal.api.repository;

import com.CezaryZal.api.model.entity.EntityToDb;

public interface RepositoryDb {

    EntityToDb getRecord(String inputSign, int inputValue);
}
