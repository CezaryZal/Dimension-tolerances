package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.EntityForm;

public interface ServiceByRepo {

    EntityForm getRecordBySignAndValue(String inputSign, int inputValue);
}
