package jp.co.spring.roster;

import jp.co.spring.common.CommonCalender;
import jp.co.spring.common.CommonFunction;
import jp.co.spring.common.Constant;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Roster {

	CommonFunction func = CommonFunction.getInstance();
	CommonCalender cal = CommonCalender.getInstance();

	// 表示する勤務表の作成
	public void makeKinmuhyoHtml(HashMap<String, Object> dataMap) throws Exception {
		try {
		    String startFlg = func.nullToSpace((String)dataMap.get("startFlg"));
		    String endFlg = func.nullToSpace((String)dataMap.get("endFlg"));
		    String strYear = func.nullToSpace((String)dataMap.get("strYear"));
		    String strMonth = func.nullToSpace((String)dataMap.get("strMonth"));
		    LocalDateTime dateTime = LocalDateTime.now();
		    int intNowYear = dateTime.getYear();
		    String strNowYear  = Integer.toString(intNowYear);
		    int intNowMonth = dateTime.getMonthValue();
		    String strNowMonth = func.lpad(Integer.toString(intNowMonth), 2, "0", true);
		    int intNowDate = dateTime.getDayOfMonth();
		    String strNowDate  = func.lpad(Integer.toString(intNowDate), 2, "0", true);
		    String strNowYmd = strNowYear + strNowMonth + strNowDate;
		    String strYM = strYear + strMonth;
		    int intYear  = Integer.parseInt(strYear);
		    int intMonth = Integer.parseInt(strMonth);
	        int numOfDaysInMonth = cal.getNumOfDaysInMonth(intYear, intMonth);
	        StringBuffer makeRosterHtml = new StringBuffer(); 
		    // カレンダー日付の作成
		    for (int intDay = 1; intDay <= numOfDaysInMonth; intDay++) {
	            String strDay = Integer.toString(intDay);  // int型からstring型に変換
	            String strYMD = strYM + strDay;
	            //日付をLocalDate型に変換
	            LocalDate localDate = LocalDate.of(intYear, intMonth, intDay);
	    		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
	            int numYoubi = dayOfWeek.getValue(); //曜日を取得
	            String dispYoubi = cal.dispYoubi(numYoubi);
	            strDay = func.lpad(strDay, 2, "0", true);  // 1桁の場合、前0詰めの2桁表示
	            makeRosterHtml.append("<tr>");
	            makeRosterHtml.append("<td class=\"dispDay\">");
	            makeRosterHtml.append(strMonth).append("月").append(strDay).append("日 (").append(dispYoubi).append(")");
	            makeRosterHtml.append("</td>");
	            makeRosterHtml.append("<td>");
	            makeRosterHtml.append("<span id=\"").append(strMonth + strDay).append("start\">");
	            // 業務開始（本日付）
	            String startTime = "";
	            if (strNowYmd.equals(strYMD) && Constant.FLG_ON.equals(startFlg)) {
	            	startTime = getHMS(dateTime);
	            } else if (numYoubi == 0 || numYoubi == 6) {
	            	startTime = "―";
	            }
	            makeRosterHtml.append(startTime);
	            makeRosterHtml.append("</span>");
	            makeRosterHtml.append("</td>");
	            makeRosterHtml.append("<td>");
	            makeRosterHtml.append("<span id=\"").append(strMonth + strDay).append("end\">");
	            // 業務終了（本日付）
	            String endTime = "";
	            if (strNowYmd.equals(strYMD) && Constant.FLG_ON.equals(endFlg)) {
	            	endTime = getHMS(dateTime);
	            } else if (numYoubi == 0 || numYoubi == 6) {
	            	endTime = "―";
	            } 
	            makeRosterHtml.append(endTime);
	            makeRosterHtml.append("</td>");
	            makeRosterHtml.append("</tr>");
		    }
		} catch(Exception ex) {
    	    System.out.println(ex);
        }
    }
	
	protected String getHMS(LocalDateTime dateTime) {
		String strHour    = Integer.toString(dateTime.getHour()) + "時";
		String strMinute = Integer.toString(dateTime.getMinute()) + "分";
		String strSecond  = Integer.toString(dateTime.getSecond()) + "秒";
		return strHour + strMinute + strSecond; 
	}
}