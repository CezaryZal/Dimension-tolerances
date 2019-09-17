package com.CezaryZal.repository;

import com.CezaryZal.entity.RecordToDb;

public interface RepositoryDb {

    RecordToDb getRecord(String inputSign, int inputValue);
}
