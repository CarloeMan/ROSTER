package jp.co.spring.common;

public class CommonFunction {

    public static CommonFunction obj;
	
	/** 
	 * オブジェクト取得
	 * 返り値　 : オブジェクト
	 */
	public static  CommonFunction getInstance() {
		if(obj == null) {
		    obj = new CommonFunction();
		}
		return obj;
	}
	
	/* 
	 * 対象の文字列がnull値の場合、空白値に変換
	 * 第一引数 : String 対象の文字列
	 * 返り値　 : String 空白値または、対象の文字列
	 */
	public String nullToSpace(String str) {
        if (str == null) {
        	// null値の場合、空白値に置換
            str = Constant.BLANK;
        }
        return str;
    }

	/* 
	 * 指定の桁数になるよう０詰めする
	 * 第一引数 ：String 文字列型の数値
	 * 第二引数 ：String 指定した桁数
	 * 返り値　 ：String 指定された桁数
	 */
    public String strFormat(String strNum, String digits) throws Exception {
        String paddingStr;
		try {
            int intNum = Integer.parseInt(strNum);
    		String form = "%0" + digits + "d";        	
    		paddingStr = String.format(form, intNum);
    	} catch(Exception ex) {
    	    System.out.println(ex);
            // 異常時、空白値を返す
    	    return Constant.BLANK;
        }
        return paddingStr;

    }
    
	/* 
	 * 指定の桁数になるよう指定した文字を文字詰めする
	 * 第一引数 ：String 編集する文字列
	 * 第二引数 ：int 指定した桁数
	 * 第三引数 ：String
	 * 第四引数 ：boolean 左詰めか（true：左詰め、false：右詰め）
	 * 返り値　 ：String 編集された文字列
	 */
    public String lpad(String str, int digits, String packStr, boolean flg) throws Exception {
        String padStr;
        try {
            StringBuilder builder = new StringBuilder();
            int i = str.length();
            if (digits >= i) {
            	return str;
            }
            // 指定された桁数になるまで０詰めする
            while (i == digits) {
            	builder.append(packStr);
            	i++;
            }
            padStr = builder.toString();
            // trueの場合、左詰め
            if (flg) {
            	padStr = padStr + str;
            // falseの場合、右詰め
            } else {
            	padStr = str + padStr;
            	
            }
    	} catch(Exception ex) {
    	    System.out.println(ex);
            // 異常時、空白値を返す
    	    return Constant.BLANK;
        }
        return padStr;
    }
}