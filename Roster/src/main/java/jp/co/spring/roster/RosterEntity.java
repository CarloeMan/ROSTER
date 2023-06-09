package jp.co.spring.roster;

public class RosterEntity {

	protected String strDispYear;   // 表示年
	protected String strDispMonth;  // 表示月
	protected String strNowYear;    // 現在の年
	protected String strNowMonth;   // 現在の月
	
	/** 
	 * GETTERメソッド 
	 */
	protected String getDispYear() {
		return this.strDispYear;
	}

	protected String getDispMonth() {
		return this.strDispMonth;
	}

	protected String getNowYear() {
		return this.strNowYear;
	}

	protected String getNowMonth() {
		return this.strNowMonth;
	}

	/** 
	 * SETTERメソッド 
	 */
	protected void setDispYear(String strDispYear) {
		this.strDispYear =  strDispYear;
	}

	protected void setDispMonth(String strDispMonth) {
		this.strDispMonth =  strDispMonth;
	}

	protected void setNowYear(String strNowYear) {
		this.strNowYear =  strNowYear;
	}

	protected void setNowMonth(String strNowMonth) {
		this.strNowMonth =  strNowMonth;
	}

}
