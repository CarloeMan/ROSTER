package jp.co.spring.roster;

import jp.co.spring.common.CommonCalender;
import jp.co.spring.common.CommonFunction;
import jp.co.spring.common.Constant;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Roster {

    // インスタンス作成
	CommonFunction func = CommonFunction.getInstance();
	CommonCalender cal = CommonCalender.getInstance();

	// 表示する勤務表の作成
	protected int makeRoster(HashMap<String, Object> dataMap, RosterEntity entity) throws Exception {
		int sum = 0;
		List<HashMap> dispRosterList = new ArrayList<>();
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
		    entity.setNowYear(strNowYear);
		    entity.setNowMonth(strNowMonth);
		    int intYear;
		    int intMonth;
     	    if(!Constant.BLANK.equals(strYear) && !Constant.BLANK.equals(strMonth)) {
    		    intYear  = Integer.parseInt(strYear);
    		    intMonth = Integer.parseInt(strMonth);
	        } else {
    		    intYear  = intNowYear;
    		    strYear  = strNowYear; 
    		    intMonth = intNowMonth;
    		    strMonth = strNowMonth;     		    	        	
	        }
     	    entity.setDispYear(strYear);
     	    entity.setDispMonth(strMonth);
            //日付をLocalDate型に変換
            LocalDate localDate = LocalDate.of(intYear, intMonth, Integer.parseInt(strNowDate));
    		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            int intNumYoubi = dayOfWeek.getValue(); //曜日を取得
            entity.setIntNowYoubi(intNumYoubi);
		    String strYM = strYear + strMonth;
	        int numOfDaysInMonth = cal.getNumOfDaysInMonth(intYear, intMonth);
		    // カレンダー日付の作成
		    for (int intDay = 1; intDay <= numOfDaysInMonth; intDay++) {
		    	HashMap map = new HashMap<String, Object>();
	            String strDay = Integer.toString(intDay);  // int型からstring型に変換
	            String strYMD = strYM + strDay;
	            //日付をLocalDate型に変換
	            localDate = LocalDate.of(intYear, intMonth, intDay);
	    		dayOfWeek = localDate.getDayOfWeek();
	            int numYoubi = dayOfWeek.getValue(); //曜日を取得
	            String dispYoubi = cal.dispYoubi(numYoubi);
	            map.put("dispYoubi", dispYoubi);
	            strDay = func.lpad(strDay, 2, "0", true);  // 1桁の場合、前0詰めの2桁表示
	            map.put("strMonth", strMonth);
	            map.put("strDay", strDay);
	            map.put("strMDstart", strMonth+strDay+"start");	            
	            // 業務開始（本日付）
	            String startTime = "";
	            if (strNowYmd.equals(strYMD) && Constant.FLG_ON.equals(startFlg)) {
	            	startTime = getHMS(dateTime);
	            } else if (numYoubi == 6 || numYoubi == 7) {
	            	startTime = "―";
	            }
	            map.put("startTime", startTime);	            	            
	            map.put("strMDend", strMonth+strDay+"end");	            
	            // 業務終了（本日付）
	            String endTime = "";
	            if (strNowYmd.equals(strYMD) && Constant.FLG_ON.equals(endFlg)) {
	            	endTime = getHMS(dateTime);
	            } else if (numYoubi == 6 || numYoubi == 7) {
	            	endTime = "―";
	            } 
	            map.put("endTime", endTime);
	            dispRosterList.add(map);
	            sum++;
		    }
		    entity.setDispRosterList(dispRosterList);
		} catch(Exception ex) {
    	    System.out.println(ex);
        }
		return sum;
    }
	
	/* 
	 * カレンダークラスで取得した曜日を数値から文字列に変換
	 * 第一引数 : LocalDateTimeクラス
	 * 返り値 　: String HH時mm分ss秒
	 */
	private String getHMS(LocalDateTime dateTime) {
		String strHour    = Integer.toString(dateTime.getHour()) + "時";
		String strMinute = Integer.toString(dateTime.getMinute()) + "分";
		String strSecond  = Integer.toString(dateTime.getSecond()) + "秒";
		return strHour + strMinute + strSecond; 
	}
}
