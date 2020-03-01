package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.model.entity.EntityToDb;

public interface ServiceRepo {

    EntityToDb getRecordBySignAndValue(String inputSign, int inputValue);
}
