package jp.co.spring.roster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RosterController {
	  // 「/loginForm」へアクセスがあった場合
	  @RequestMapping("/roster")
	  public ModelAndView loginForm(ModelAndView mav) {
	    // 画面に出力するViewを指定
	    mav.setViewName("roster/roster");
	    // ModelとView情報を返す
	    return mav;
	  }
}