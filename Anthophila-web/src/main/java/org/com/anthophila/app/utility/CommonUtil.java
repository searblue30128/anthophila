package org.com.anthophila.app.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 通用函數
 *
 * @author admin
 *
 */
public class CommonUtil {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	/**
	 * 檢查是否同物件，若不相同比較兩物件toString()是否相等
	 *
	 * @param a 欲檢查的物件
	 * @param b 欲檢查的物件
	 * @return boolean true :兩物件相同或toString()相等<br>
	 *                 false:兩物件不同且toString()不相等
	 */
	public static boolean isEquals(Object a, Object b) {
		boolean result = false;
		if (a != null && b != null) {
			if (a.equals(b)) {
				result = true;
			}
			if (result == false) {
				if (a.toString().equals(b.toString())) {
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * 檢查是否不同物件，若不相同比較兩物件toString()是否相等
	 *
	 * @param a 欲檢查的物件
	 * @param b 欲檢查的物件
	 * @return boolean true :兩物件toString()不相等<br>
	 *                 false:兩物件相同或toString()相等
	 */
	public static boolean isNotEquals(Object a, Object b) {
		return !isEquals(a, b);
	}

	/**
	 * 判斷物件是否為null
	 *
	 * @param o 欲判斷之物件
	 * @return boolean 若true則物件不為null，反之回傳false
	 */
	public static boolean isNotNull(Object o) {
		return !isNull(o);
	}

	/**
	 * 判斷物件是否為null
	 *
	 * @param o 欲判斷之物件
	 * @return boolean 若true則物件為null，反之回傳false
	 */
	public static boolean isNull(Object o) {
		boolean isNull = false;
		if (o == null) {
			isNull = true;
		}
		return isNull;
	}
}
