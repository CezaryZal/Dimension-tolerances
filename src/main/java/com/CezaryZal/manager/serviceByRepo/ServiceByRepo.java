package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.EntityForm;
import org.springframework.stereotype.Service;

@Service
public interface ServiceByRepo {

    EntityForm getRecordBySignAndValue(String inputSign, int inputValue);
}
