package jp.co.spring.roster;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.spring.common.CommonFunction;

@Controller
public class RosterController {

	Roster roster = new Roster();
    // インスタンス作成
	CommonFunction func = CommonFunction.getInstance();

	@RequestMapping("/roster")
    public ModelAndView roster(ModelAndView mav) throws Exception{
    	RosterEntity entity = new RosterEntity();
    	roster.makeRoster(new HashMap<String, Object>(), entity);
    	String dispYear  = entity.getDispYear();
    	String dispMonth = entity.getDispMonth();
    	String nowYear  = entity.getNowYear();
    	String nowMonth = entity.getNowMonth();
        mav.addObject("dispYear",  dispYear);
        mav.addObject("dispMonth", dispMonth);
        mav.addObject("dispYM",    dispYear + dispMonth);
        mav.addObject("nowYM",     nowYear + nowMonth);
        mav.addObject("intNowYoubi", entity.getIntNowYoubi());
        mav.addObject("dispRosterList", entity.getDispRosterList());
        mav.setViewName("roster/roster");
        return mav;
    }
}