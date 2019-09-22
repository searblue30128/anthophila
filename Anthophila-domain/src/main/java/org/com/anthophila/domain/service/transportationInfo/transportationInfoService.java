package org.com.anthophila.domain.service.personalinfo;

import java.util.Optional;

import org.com.anthophila.domain.model.PersonalInfo;

public interface transportationInfoService {

    Optional<PersonalInfo> findByNo(String accountNo);

    void update(PersonalInfo personalInfo);

    void insert(PersonalInfo personalInfo);
}
