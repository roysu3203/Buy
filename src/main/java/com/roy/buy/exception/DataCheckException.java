package com.roy.buy.exception;

/**
 * 例外：驗證資料正確性
 */
public class DataCheckException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/** 錯誤代碼 */
	private int id;
	
	/** 錯誤訊息 */
	private String message;
	
	/** 建構子, 建立 class 時必須傳入錯誤代碼 */
	public DataCheckException(int id) {
		this.id = id;
	}

	/** 取得例外訊息 */
	public String getMessage() {
		switch(id) {
			case 1:
				message = "這帳號被別人註冊囉，請您更換一個帳號。";
				break;
			case 2:
				message = "這Email被別人註冊囉，請您更換一個Email。";
				break;
			default:
				message = "資料驗證錯誤。";
				break;
		}
		return message;
	}

}
