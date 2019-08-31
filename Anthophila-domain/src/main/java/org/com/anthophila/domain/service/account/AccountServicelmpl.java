package org.com.anthophila.domain.service.account;

import javax.inject.Inject;

import org.com.anthophila.domain.model.Account;
import org.com.anthophila.domain.repository.account.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountServicelmpl implements AccountService {

	@Inject
	AccountRepository accountRepository;

	@Override
	public Account findByNo(String accountNo) {
		return accountRepository.findByNo(accountNo);
	}

}
