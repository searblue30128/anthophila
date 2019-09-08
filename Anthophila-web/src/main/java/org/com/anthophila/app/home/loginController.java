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
import org.com.anthophila.domain.service.account.AccountService;
import org.com.anthophila.domain.service.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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

    /**
    * 畫面初期化 導向
    */
    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        return "home/login";
    }

    @RequestMapping("/accountLogin")
    public String doLogin(Model model, @ModelAttribute("userName") String userName, @ModelAttribute("password") String userPassword, HttpServletRequest req) throws SQLException {
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
                    model.addAttribute("messageContent", createMessage(message));
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
    //
    //	@RequestMapping("/accountLogin")
    //	public String doLogin(Model model, @ModelAttribute("userName") String userName,
    //			@ModelAttribute("password") String userPassword, HttpServletRequest req) throws SQLException {
    //
    //
    //	}

    private static String createMessage(List<Message> messageList) {
        StringBuffer level_0 = new StringBuffer();
        messageList.forEach((temp) -> {
            level_0.append(messageStr(temp.getMessageLevel(), temp.getMessageContent()));
        });
        return level_0.toString();
    }

    private static String messageStr(String num, String content) {
        String message = null;
        if (num.equals("0")) {
            message = "<div class=\"alert alert-info\">\r\n" + " 	<button type=\"button\" class=\"close\" " + "data-dismiss=\"alert\" aria-hidden=\"true\">×</button>" + content + "</div>";
        } else if (num.equals("1")) {
            message = "<div class=\"alert alert-success alert-dismissable\">\r\n" + " 	<button type=\"button\" class=\"close\" data-dismiss=\"alert\"" + " aria-hidden=\"true\">×</button>" + content + "</div>";
        } else if (num.equals("2")) {
            message = "<div class=\"alert alert-danger alert-dismissable\">\r\n" + " 	<button type=\"button\" class=\"close\" data-dismiss=\"alert\" " + "aria-hidden=\"true\">×</button>" + content + "</div>";
        }
        return message;
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