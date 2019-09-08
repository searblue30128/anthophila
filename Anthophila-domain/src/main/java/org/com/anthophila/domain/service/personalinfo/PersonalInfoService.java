package org.com.anthophila.domain.service.personalinfo;

import org.com.anthophila.domain.model.PersonalInfo;

public interface PersonalInfoService {

    PersonalInfo findByNo(String accountNo);
}
