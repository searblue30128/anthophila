package org.com.anthophila.domain.repository.personalinfo;

import java.util.Optional;

import org.com.anthophila.domain.model.PersonalInfo;

public interface PersonalInfoRepository {

    Optional<PersonalInfo> findByNo(String accountNo);

    PersonalInfo find();
}
