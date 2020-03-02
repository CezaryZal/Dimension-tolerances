package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.model.entity.TabularData;

public interface ServiceRepo {

    TabularData getRecordBySignAndValue(String inputSign, int inputValue);
}
