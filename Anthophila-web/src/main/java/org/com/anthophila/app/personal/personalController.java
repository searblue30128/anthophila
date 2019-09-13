package org.com.anthophila.app.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.com.anthophila.app.home.loginController;
import org.com.anthophila.domain.model.PersonalInfo;
import org.com.anthophila.domain.repository.personalinfo.PersonalInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

/**
 * Handles requests for the application home page.
 */
@Controller
public class personalController {

    private static final Logger logger = LoggerFactory.getLogger(personalController.class);

    @Inject
    PersonalInfoRepository personalInfoRepository;

    //基本情報
    @RequestMapping(value = "/personal_01", method = { RequestMethod.GET })
    public String personal_01(Locale locale, Model model) {
        String accountNo = loginController.getSessionAccountNo();
        PersonalInfo person = personalInfoRepository.findByNo(accountNo).orElse(new PersonalInfo(accountNo));
        model.addAttribute("personalInfo", person);
        return "personal/personal_01";
    }

    //基本情報 ajax 儲存
    @RequestMapping(value = "/personal_01_ajax", method = { RequestMethod.POST })
    public String personal_01_ajax(Locale locale, Model model, HttpServletRequest request) {
        String accountNo = loginController.getSessionAccountNo();
        // Map<String, String[]> modelMap = request.getParameterMap();
        BufferedReader reader;
        try {
            reader = new BufferedReader(request.getReader());
            String jsonString = reader.readLine();
            PersonalInfo person = JSON.parseObject(jsonString, PersonalInfo.class);
            if (personalInfoRepository.findByNo(accountNo).isPresent()) {
                personalInfoRepository.update(person);
            } else {
                personalInfoRepository.insert(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "personal/personal_01";
    }

    //交通費管理
    @RequestMapping(value = "/personal_02", method = { RequestMethod.GET })
    public String personal_02(Locale locale, Model model) {
        //交通費管理
        return "personal/personal_02";
    }

    //新增交通費
    @RequestMapping(value = "personal/newtransportcost", method = { RequestMethod.GET })
    public String personal_newtransportcost(Locale locale, Model model) {
        //新增交通費
        return "personal/personal_02_1";
    }

    //勤務管理
    @RequestMapping(value = "/personal_03", method = { RequestMethod.GET })
    public String personal_03(Locale locale, Model model) {
        //勤務管理
        return "personal/personal_03";
    }

    //請假管理
    @RequestMapping(value = "/personal_04", method = { RequestMethod.GET })
    public String personal_04(Locale locale, Model model) {
        //請假管理
        return "personal/personal_04";
    }

    //履歴管理
    @RequestMapping(value = "/personal_05", method = { RequestMethod.GET })
    public String personal_05(Locale locale, Model model) {
        //履歴管理
        return "personal/personal_05";
    }
}