package org.com.anthophila.app.home;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.com.anthophila.domain.model.Message;
import org.com.anthophila.domain.repository.message.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class messageController {

	private static final Logger logger = LoggerFactory.getLogger(messageController.class);

	@Inject
	MessageRepository messageRepository;

	/**
	 * 刪除訊息
	 *
	 * @param model
	 * @param messageNo
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/deleteMessage")
	public String deleteMessage(Model model, @ModelAttribute("messageInfo") String messageContent) throws SQLException {
		String page = "home/menu";
		List<Message> message = new ArrayList<Message>();
		String accountNo = getSessionAccountNo();
		if (StringUtils.hasText(messageContent)) {
			System.out.println(messageContent);
			messageRepository.updateMessage(accountNo, messageContent);
		}

		message = messageRepository.findByNo(accountNo);
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

		return page;
	}

	public static String getSessionAccountNo() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		return session.getAttribute("acountNo").toString();
	}
}