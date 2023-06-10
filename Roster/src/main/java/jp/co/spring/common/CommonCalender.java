package jp.co.spring.common;

import java.util.Calendar;

public class CommonCalender {

    public static CommonCalender obj;
	
	/** 
	 * オブジェクト取得
	 * 返り値　 : オブジェクト
	 */
	public static  CommonCalender getInstance() {
		if(obj == null) {
		    obj = new CommonCalender();
		}
		return obj;
	}

	/* 
	 * カレンダークラスで取得した曜日を数値から文字列に変換
	 * 第一引数 : int 曜日（数字）
	 * 返り値 　: String 曜日名
	 */
	public String dispYoubi(int intNum) {
	    String youbi = "";
        switch (intNum) {
		    case 1: 
		    	youbi = "月";
			    break;
            case 2: 
            	youbi = "火";
                break;  
            case 3: 
            	youbi = "水";
                break;  
            case 4: 
            	youbi = "木";
                break;  
            case 5: 
            	youbi = "金";
                 break;  
            case 6: 
            	youbi = "土";
                break;
		    case 7: 
			    youbi = "日";
			    break;
	    }
        return youbi;
	}
	
	/* 
	 * 指定した年月の日数を取得
	 * 第一引数 : int 年
	 * 第二引数 : int 月
	 * 返り値 　: int 指定した年月の日数
	 */
	public int getNumOfDaysInMonth (int year, int month) {
	    Calendar calender = Calendar.getInstance();
	    calender.clear();
	    calender.set(year, month, 1);
	    int numOfDaysInMonth = calender.getActualMaximum(Calendar.DATE) - calender.get(Calendar.DATE);
	    return numOfDaysInMonth;
	}

}
