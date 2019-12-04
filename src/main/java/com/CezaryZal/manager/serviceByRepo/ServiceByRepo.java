package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.EntityToDb;

public interface ServiceByRepo {

    EntityToDb getRecordBySignAndValue(String inputSign, int inputValue);
}
