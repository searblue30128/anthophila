package org.com.anthophila.domain.repository.personalinfo;

import org.com.anthophila.domain.model.PersonalInfo;

public interface PersonalInfoRepository {

    PersonalInfo findByNo(String accountNo);

    PersonalInfo find();
}
