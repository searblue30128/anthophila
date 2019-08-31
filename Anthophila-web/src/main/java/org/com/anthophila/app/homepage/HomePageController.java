package org.com.anthophila.app.homepage;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

	/**
	 * 畫面初期化 導向
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home/login";
	}

}
