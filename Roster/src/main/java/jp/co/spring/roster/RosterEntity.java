package jp.co.spring.roster;

import java.util.List;

public class RosterEntity {

	protected String strDispYear;   // 表示年
	protected String strDispMonth;  // 表示月
	protected String strNowYear;    // 現在の年
	protected String strNowMonth;   // 現在の月
	protected int intNowYoubi;      // 現在の月
	protected List dispRosterList;      // 現在の月
	
	/** 
	 * GETTERメソッド 
	 */
	// 表示年
	protected String getDispYear() {
		return this.strDispYear;
	}
	// 表示月
	protected String getDispMonth() {
		return this.strDispMonth;
	}
	// 現在年
	protected String getNowYear() {
		return this.strNowYear;
	}
	// 現在月
	protected String getNowMonth() {
		return this.strNowMonth;
	}
	// 曜日（int型）
	protected int getIntNowYoubi() {
		return this.intNowYoubi;
	}
	// 表示する勤務表
	protected List getDispRosterList() {
		return this.dispRosterList;
	}

	/** 
	 * SETTERメソッド 
	 */
	// 表示年
	protected void setDispYear(String strDispYear) {
		this.strDispYear =  strDispYear;
	}
	// 表示月
	protected void setDispMonth(String strDispMonth) {
		this.strDispMonth =  strDispMonth;
	}
	// 現在年
	protected void setNowYear(String strNowYear) {
		this.strNowYear =  strNowYear;
	}
	// 現在月
	protected void setNowMonth(String strNowMonth) {
		this.strNowMonth =  strNowMonth;
	}
	// 曜日（int型）
	protected void setIntNowYoubi(int intNowYoubi) {
		this.intNowYoubi =  intNowYoubi;
	}
	// 表示する勤務表
	protected void setDispRosterList(List dispRosterList) {
		this.dispRosterList =  dispRosterList;
	}
}