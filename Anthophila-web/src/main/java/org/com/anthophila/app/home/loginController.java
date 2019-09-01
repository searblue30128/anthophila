package org.com.anthophila.app.home;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.com.anthophila.app.utility.CommonUtil;
import org.com.anthophila.domain.model.Account;
import org.com.anthophila.domain.model.Message;
import org.com.anthophila.domain.repository.account.AccountRepository;
import org.com.anthophila.domain.repository.message.MessageRepository;
import org.com.anthophila.domain.service.account.AccountService;
import org.com.anthophila.domain.service.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class loginController {

	private static final Logger logger = LoggerFactory.getLogger(loginController.class);

	@Inject
	AccountService accountService;
	@Inject
	MessageService messageService;
	//	EmployeeService employeeService;

	@Inject
	AccountRepository accountRepository;
	@Inject
	MessageRepository messageRepository;
	//    EmployeeRepository employeeRepository;

	@RequestMapping("/accountLogin")
	public String doLogin(Model model, @ModelAttribute("userName") String userName,
			@ModelAttribute("password") String userPassword, HttpServletRequest req) throws SQLException {
		String page = "home/login";
		Account account = new Account();
		Message message = new Message();
		if (!userName.isEmpty()) {
			try {
				account = accountRepository.findByNo(userName);
			} catch (Exception e) {
				System.out.println(e);
			}
			if (CommonUtil.isNotNull(account)) {
				String password = account.getAccountPass();
				if (password.equals(userPassword)) {
					message = messageRepository.findByNo(userName);

					page = "home/menu";
					model.addAttribute("acount", userName);
					model.addAttribute("messageContent", message.getMessageContent());

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