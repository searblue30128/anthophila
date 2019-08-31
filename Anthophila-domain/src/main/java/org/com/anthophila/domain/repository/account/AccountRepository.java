package org.com.anthophila.domain.repository.account;

import org.com.anthophila.domain.model.Account;

public interface AccountRepository {

	Account findByNo(String accountNo);

	Account find();

}
