package org.com.anthophila.app.home;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.com.anthophila.app.utility.CommonUtil;
import org.com.anthophila.domain.model.Account;
import org.com.anthophila.domain.repository.account.AccountRepository;
import org.com.anthophila.domain.service.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class loginController {

	private static final Logger logger = LoggerFactory.getLogger(loginController.class);

	@Inject
	AccountService accountService;
	//	EmployeeService employeeService;

	@Inject
	AccountRepository accountRepository;
	//    EmployeeRepository employeeRepository;

	@RequestMapping("/accountLogin")
	public String doLogin(Model model, @ModelAttribute("userName") String userName,
			@ModelAttribute("password") String userPassword, HttpServletRequest req) throws SQLException {
		String page = "home/login";
		Account account = new Account();
		if (!userName.isEmpty()) {
			try {
				account = accountRepository.findByNo(userName);
			} catch (Exception e) {
				System.out.println(e);
			}
			if (CommonUtil.isNotNull(account)) {
				String password = account.getAccountPass();

				if (password.equals(userPassword)) {
					page = "home/menu";
					model.addAttribute("acount", userName);
				} else {
					model.addAttribute("errMessage", "密碼錯誤");
				}
			} else {
				model.addAttribute("errMessage", "帳號不存在");
			}

		}
		return page;
	}
}