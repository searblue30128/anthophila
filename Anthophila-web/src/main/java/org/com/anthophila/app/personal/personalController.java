package org.com.anthophila.app.personal;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class personalController {

    private static final Logger logger = LoggerFactory.getLogger(personalController.class);

    //基本情報
    @RequestMapping(value = "/personal_01", method = { RequestMethod.GET })
    public String personal_01(Locale locale, Model model) {
        //基本情報
        return "personal/personal_01";
    }

    //交通費管理
    @RequestMapping(value = "/personal_02", method = { RequestMethod.GET })
    public String personal_02(Locale locale, Model model) {
        //交通費管理
        return "personal/personal_02";
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