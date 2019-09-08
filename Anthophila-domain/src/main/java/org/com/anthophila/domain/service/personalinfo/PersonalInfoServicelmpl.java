package org.com.anthophila.domain.service.personalinfo;

import java.util.Optional;

import javax.inject.Inject;

import org.com.anthophila.domain.model.PersonalInfo;
import org.com.anthophila.domain.repository.personalinfo.PersonalInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PersonalInfoServicelmpl implements PersonalInfoService {

    @Inject
    PersonalInfoRepository personalInfoRepository;

    @Override
    public Optional<PersonalInfo> findByNo(String accountNo) {
        return personalInfoRepository.findByNo(accountNo);
    }
}
