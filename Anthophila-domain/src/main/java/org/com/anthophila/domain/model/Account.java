package org.com.anthophila.domain.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account implements Serializable {

	private String accountNo;

	private String accountPass;

	private Date accountLoginTime;

	private String accountTryNo;

	private String accountPur;

	public Account(String accountNo) {
		this.accountNo = accountNo;
	}
}
