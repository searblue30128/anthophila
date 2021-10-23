package org.com.anthophila.app.home;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.com.anthophila.app.utility.CommonUtil;
import org.com.anthophila.domain.model.Account;
import org.com.anthophila.domain.model.Message;
import org.com.anthophila.domain.repository.account.AccountRepository;
import org.com.anthophila.domain.repository.message.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class loginController {

	private static final Logger logger = LoggerFactory.getLogger(loginController.class);

	@Inject
	AccountRepository accountRepository;

	@Inject
	MessageRepository messageRepository;

	/**
	 * 畫面初期化 導向
	 *
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home/login";
	}

	/**
	 * 登入邏輯 作成中
	 *
	 * @param model
	 * @param userName
	 * @param userPassword
	 * @param req
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/accountLogin")
	public String doLogin(Model model, @ModelAttribute("userName") String userName,
			@ModelAttribute("password") String userPassword, HttpServletRequest req) throws SQLException {
		String page = "home/login";
		Account account = new Account();
		List<Message> message = new ArrayList<Message>();
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

					//取得訊息資訊處理------------------------------------------START
					message = messageRepository.findByNo(userName);
					//公司訊息
					List<String> companyMessageList = new ArrayList();
					//月次訊息
					List<String> monthlyMessageList = new ArrayList();
					//重要訊息
					List<String> warningMessageList = new ArrayList();

					message.forEach((temp) -> {
						if (temp.getMessageLevel().equals("0")) {
							companyMessageList.add(temp.getMessageContent());
						} else if (temp.getMessageLevel().equals("1")) {
							monthlyMessageList.add(temp.getMessageContent());
						} else if (temp.getMessageLevel().equals("2")) {
							warningMessageList.add(temp.getMessageContent());
						}
					});

					model.addAttribute("companyMessage", companyMessageList);
					model.addAttribute("monthlyMessage", monthlyMessageList);
					model.addAttribute("warningMessage", warningMessageList);
					//取得訊息資訊處理------------------------------------------END
				} else {
					model.addAttribute("errMessage", "密碼錯誤");
				}
			} else {
				model.addAttribute("errMessage", "帳號不存在");
			}
			setSessionAccountNo(req, userName);
		}
		return page;
	}

	private static void setSessionAccountNo(HttpServletRequest request, String userName) {
		request.getSession().setAttribute("acountNo", userName);
	}

	public static String getSessionAccountNo() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		return session.getAttribute("acountNo").toString();
	}
}