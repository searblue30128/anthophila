package org.com.anthophila.domain.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonalInfo implements Serializable {

    private String accountNo;

    private String jobTitle;

    private Date birthday;

    private String gendor;

    private String name;

    private String phoneNo;

    private String email;

    private String mate;

    private String liveAlone;

    private String nearStation;

    private String address;

    private String residenceCardNo;

    private Date residenceDateStart;

    private Date residenceDateEnd;

    private String bankAccountName;

    private String bankAccountBranch;

    private String bankAccountNo;

    private String passportNo;

    private String hiredInsuranceInsuredNo;

    private String dependentRelativeName1;

    private String dependentRelativeRelation1;

    private Date dependentRelativeBirthday1;

    private String dependentRelativeAddress1;

    private String dependentRelativeName2;

    private String dependentRelativeRelation2;

    private Date dependentRelativeBirthday2;

    private String dependentRelativeAddress2;

    private String dependentRelativeName3;

    private String dependentRelativeRelation3;

    private Date dependentRelativeBirthday3;

    private String dependentRelativeAddress3;

    public PersonalInfo(String accountNo) {
        this.accountNo = accountNo;
    }
}
