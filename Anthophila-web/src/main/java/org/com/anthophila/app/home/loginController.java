package org.com.anthophila.app.home;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.com.anthophila.domain.model.Employee;
import org.com.anthophila.domain.repository.employee.EmployeeRepository;
import org.com.anthophila.domain.service.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class loginController {

    private static final Logger logger = LoggerFactory.getLogger(loginController.class);

    @Inject
    EmployeeService employeeService;

    @Inject
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/home", method = { RequestMethod.GET })
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "home/login";
    }

    @RequestMapping("/index")
    public String doLogin(Model model, @ModelAttribute("userName") String userName, @ModelAttribute("password") String userPassword, HttpServletRequest req) throws SQLException {
        String page = null;
        Employee employee = new Employee();
        try {
            employee = employeeRepository.findByNo(userName);
        } catch (Exception e) {
            System.out.println(e);
        }
        String password = employee.getEmployeePass();
        if (password.equals(userPassword)) {
            //   page = "welcome/home";
            page = "home/menu";
            model.addAttribute("acount", userName);
        } else {
            page = "welcome/err";
            model.addAttribute("errMessage", "帳號密碼錯誤");
        }
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        return page;
    }
}