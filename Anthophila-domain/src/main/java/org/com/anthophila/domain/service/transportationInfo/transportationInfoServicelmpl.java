package org.com.anthophila.domain.service.personalinfo;

import java.util.Optional;

import javax.inject.Inject;

import org.com.anthophila.domain.model.PersonalInfo;
import org.com.anthophila.domain.repository.personalinfo.PersonalInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class transportationInfoServicelmpl implements PersonalInfoService {

    @Inject
    TransportationInfoRepository transportationInfoRepository;

    @Override
    public Optional<TransportationInfo> findByNo(String accountNo) {
        return transportationInfoRepository.findByNo(accountNo);
    }

    @Override
    public void update(TransportationInfo transportationInfo) {
    	transportationInfoRepository.update(transportationInfo);
    }

    @Override
    public void insert(TransportationInfo transportationInfo) {
    	transportationInfoRepository.insert(transportationInfo);
    }
}
