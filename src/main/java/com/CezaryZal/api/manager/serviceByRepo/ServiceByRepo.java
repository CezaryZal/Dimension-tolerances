package com.CezaryZal.api.manager.serviceByRepo;

import com.CezaryZal.api.model.entity.EntityToDb;

public interface ServiceByRepo {

    EntityToDb getRecordBySignAndValue(String inputSign, int inputValue);
}
