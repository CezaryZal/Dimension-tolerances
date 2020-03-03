package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.repository.RepositoryDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceRepoImp implements ServiceRepo{

    private final RepositoryDb  additionalDataRepository;
    private final RepositoryDb  basicDeviationsRepository;
    private final RepositoryDb  nominalToleranceRepository;

    @Autowired
    public ServiceRepoImp(@Qualifier("additionalDataToBasicDeviationRepoDbImp") RepositoryDb  additionalDataRepository,
                          @Qualifier("basicDeviationRepoDbImp") RepositoryDb  basicDeviationsRepository,
                          @Qualifier("nominalToleranceRepoDbImp") RepositoryDb  nominalToleranceRepository) {
        this.additionalDataRepository = additionalDataRepository;
        this.basicDeviationsRepository = basicDeviationsRepository;
        this.nominalToleranceRepository = nominalToleranceRepository;
    }

    @Transactional
    @Override
    public Double getValueOfAdditionalDataBySignAndValue(String inputSign, int inputValue) {
        return additionalDataRepository.getValueOfRecord(inputSign, inputValue);
    }

    @Transactional
    @Override
    public Double getValueOfBasicDeviationBySignAndValue(String inputSign, int inputValue) {
        return basicDeviationsRepository.getValueOfRecord(inputSign, inputValue);
    }

    @Transactional
    @Override
    public Double getValueOfNominalToleranceBySignAndValue(String inputSign, int inputValue) {
        return nominalToleranceRepository.getValueOfRecord(inputSign, inputValue);
    }
}
