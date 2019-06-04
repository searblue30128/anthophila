package org.com.anthophila.app.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.com.anthophila.domain.model.Employee;
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

    EmployeeService employeeService;

    @RequestMapping(value = "/home", method = { RequestMethod.GET })
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        model.addAttribute("testStr", "測試登入");
        return "home/login";
    }

    @RequestMapping("/index")
    public String doLogin(Model model, @ModelAttribute("userName") String userName, @ModelAttribute("password") String password, HttpServletRequest req) {
        System.out.println("userName = " + userName);
        System.out.println("password = " + password);

        Employee data = employeeService.findByNo(userName);
        System.out.println(data);
        // Get the web application context, all spring beans are managed in this context.
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        //        UserAccountBean userAccountBean = (UserAccountBean)context.getBean("userAccountBean");
        return "welcome/home";
    }
}
