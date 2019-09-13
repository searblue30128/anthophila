package org.com.anthophila.domain.service.personalinfo;

import java.util.Optional;

import org.com.anthophila.domain.model.PersonalInfo;

public interface PersonalInfoService {

    Optional<PersonalInfo> findByNo(String accountNo);

    void update(PersonalInfo personalInfo);

    void insert(PersonalInfo personalInfo);
}
