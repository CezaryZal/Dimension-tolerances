package com.CezaryZal.repository;

import com.CezaryZal.entity.EntityForm;

public interface RepositoryDb {

    EntityForm getRecord(String inputSign, int inputValue);
}
