package org.com.anthophila.app.utility;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 處理字串共用函數
 *
 * @author admin
 *
 */
public class StringUtil {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

	/** char 空白 */
	private static char space = ' ';

	/** char 全形空白 */
	private static char fullwidth_space = '　';

	/**
	 * 去除字串str左邊的空白與全形空白
	 *
	 * @param str 字串
	 * @return String
	 */
	public static String trimLeft(String str) {
		String s = str;
		if (StringUtils.isNotEmpty(str)) {
			int beginIndex = 0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c != space && c != fullwidth_space) {
					beginIndex = i;
					break;
				}
			}
			s = str.substring(beginIndex);
		}
		return s;
	}

	/**
	 * 去除字串str右邊的空白與全形空白
	 *
	 * @param str 字串
	 * @return String
	 */
	public static String trimRight(String str) {
		String s = str;
		if (StringUtils.isNotEmpty(str)) {
			int endIndex = 0;
			for (int i = str.length() - 1; i >= 0; i--) {
				char c = str.charAt(i);
				if (c != space && c != fullwidth_space) {
					endIndex = i + 1;
					break;
				}
			}
			s = str.substring(0, endIndex);
		}
		return s;
	}

	/**
	 * 呼叫物件的toString()，如果物件o為null，回傳空字串
	 *
	 * @param o 物件
	 * @return String 字串
	 */
	public static String toString(Object o) {
		String s = "";
		if (o != null) {
			s = o.toString();
		}
		return s;
	}

	/**
	 * 將BigDecimal b取傳入的小數點位數scale並轉字串
	 *
	 * @param b 數值
	 * @param scale 小數點位數
	 * @return String 字串
	 */
	public static String toString(BigDecimal b, int scale) {
		String s = "";
		if (b != null) {
			b = b.setScale(scale);
			s = b.toString();
		}
		return s;
	}

	/**
	 * 判斷半形
	 *
	 * @param c char
	 * @return boolean true:半形<br>
	 *                 false:全形
	 */
	public static boolean isHalfWidth(char c) {
		return '\u0000' <= c && c <= '\u00FF' || '\uFF61' <= c && c <= '\uFFDC' || '\uFFE8' <= c && c <= '\uFFEE';
	}

	/**
	 * 判斷全形
	 *
	 * @param c char
	 * @return boolean true:全形<br>
	 *                 false:半形
	 */
	public static boolean isFullWidth(char c) {
		return !isHalfWidth(c);
	}

	/**
	 * 半形轉全形
	 *
	 * @param s 欲轉換的字串
	 * @return String 全形字串
	 */
	//	public static String toFullWidth(String s) {
	//		StringBuilder builder = new StringBuilder();
	//		if (StringUtils.isNotBlank(s)) {
	//			char[] chars = s.toCharArray();
	//			for (int i = 0; i < chars.length; ++i) {
	//				builder.append(ValueInputUtil.single2Double(chars[i]));
	//			}
	//		}
	//		return builder.toString();
	//	}

	/**
	 * 判斷字串列中任何一個為""、null、" "
	 *
	 * @param strs 字串
	 * @return boolean true ：任一字串為""、null、" "<br>
	 *                 false；皆不為""、null、" "
	 */
	public static boolean isAnyBlank(String... strs) {
		boolean isAnyBlank = false;
		if (strs != null) {
			for (int i = 0; i < strs.length; i++) {
				if (StringUtils.isBlank(strs[i])) {
					isAnyBlank = true;
					break;
				}
			}
		} else
			isAnyBlank = true;
		return isAnyBlank;
	}

	/**
	 * 判斷字串陣列皆為""、null、" "
	 *
	 * @param strs 字串
	 * @return boolean true ：皆為""、null、" "<br>
	 *                 false：任一字串為""、null、" "
	 */
	public static boolean isBlank(String... strs) {
		return !isAnyNotBlank(strs);
	}

	/**
	 * 判斷字串任一不為""、null、" "
	 *
	 * @param strs 字串
	 * @return boolean true ：皆不為""、null、" "<br>
	 *                 false：任一字串為""、null、" "
	 */
	public static boolean isAnyNotBlank(String... strs) {
		boolean isAnyNotBlank = false;
		if (strs != null) {
			for (int i = 0; i < strs.length; i++) {
				if (StringUtils.isNotBlank(strs[i])) {
					isAnyNotBlank = true;
					break;
				}
			}
		}
		return isAnyNotBlank;
	}

	/**
	 * 判斷字串皆不為""、null、" "。
	 *
	 * @param strs 字串
	 * @return boolean true ：字串皆不為""、null、" "<br>
	 *                 false：任一字串為""、null、" "
	 */
	public static boolean isNotBlank(String... strs) {
		return !isAnyBlank(strs);
	}

	/**
	 * 判斷字串任一為""、null。
	 *
	 * @param strs 字串
	 * @return boolean true :任一字串為""、null<br>
	 *                 false:字串皆不為""、null
	 */
	public static boolean isAnyEmpty(String... strs) {
		boolean isAnyEmpty = false;
		if (strs != null) {
			for (int i = 0; i < strs.length; i++) {
				if (StringUtils.isEmpty(strs[i])) {
					isAnyEmpty = true;
					break;
				}
			}
		} else
			isAnyEmpty = true;
		return isAnyEmpty;
	}

	/**
	 * 取得字串真實的長度<br>
	 * 每個全形字會換算成2個字或3個字(BaNCS 每個全形字算3個字)<br>
	 *
	 * 例:<br>
	 * String realLength = StringUtil.getRealLength("12三4", 3);
	 *
	 * @param str 字串
	 * @param fullWidthLen 全形字的長度
	 * @return int len 字串長度
	 */
	public static int getRealLength(String str, int fullWidthLen) {
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isHalfWidth(str.charAt(i))) //半形字，長度+1
				len++;
			else //全形字，可能 長度+3 or 長度+2
				len += fullWidthLen;
		}
		return len;
	}

	/**
	 * 判斷字串皆為""、null。
	 *
	 * @param strs 字串
	 * @return boolean true :字串皆為""、null<br>
	 *                 false:任一字串不為""、null
	 */
	public static boolean isEmpty(String... strs) {
		return !isAnyNotEmpty(strs);
	}

	/**
	 * 判斷字串任一不為""、null。
	 *
	 * @param strs 字串
	 * @return boolean true :任一字串不為""、null<br>
	 *                 false:字串皆為""、null
	 */
	public static boolean isAnyNotEmpty(String... strs) {
		boolean isAnyNotEmpty = false;
		if (strs != null) {
			for (int i = 0; i < strs.length; i++) {
				if (StringUtils.isNotEmpty(strs[i])) {
					isAnyNotEmpty = true;
					break;
				}
			}
		}
		return isAnyNotEmpty;
	}

	/**
	 * 判斷字串皆不為""、null。
	 *
	 * @param strs 字串
	 * @return boolean true :字串皆不為""、null<br>
	 *                 false:任一字串為""、null
	 */
	public static boolean isNotEmpty(String... strs) {
		return !isAnyEmpty(strs);
	}

	/**
	 * 去除字串左邊的字元<br>
	 *
	 * 例：<br>
	 * String testString = "0100";<br>
	 * String resultString = StringUtil.trimLeft(testString, '0');<br>
	 *
	 * @param s 原始字串
	 * @param c 欲去除字元
	 * @return String 去除後的字串
	 */
	public static String trimLeft(String s, char c) {
		String result = s;
		if (isNotBlank(s)) {
			int length = s.length();
			int index = 0;
			for (int i = 0; i < length; i++) {
				if (c != s.charAt(i)) {
					index = i;
					break;
				}
			}
			result = s.substring(index);
		}
		return result;
	}

	/**
	 * 去除字串右邊的字元<br>
	 *
	 * 例：<br>
	 * String testString = "0100";<br>
	 * String resultString = StringUtil.trimRight(testString, '0');<br>
	 *
	 * @param s 原始字串
	 * @param c 欲去除字元
	 * @return String 去除後的字串
	 */
	public static String trimRight(String s, char c) {
		String result = s;
		if (isNotBlank(s)) {
			int length = s.length();
			int index = 0;
			for (int i = length - 1; i >= 0; i--) {
				if (c != s.charAt(i)) {
					index = i;
					break;
				}
			}
			result = s.substring(0, index + 1);
		}
		return result;
	}

	/**
	 * 在想要切的地方切<br>
	 *
	 * 例：<br>
	 * String testString = "helloworldgigi";<br>
	 * String resultString = StringUtil.mutilate(testString, 5,10);<br>
	 *
	 * @param body 原始字串
	 * @param position 要切的位置
	 * @return String[] 去除後的字串
	 */
	public static String[] mutilate(String body, int... position) {
		StringBuilder stringBuilder = new StringBuilder(body);
		for (int i = 0; i < position.length; i++)
			if (position[i] > 0 && position[i] < body.length())
				stringBuilder.insert(position[i] + i, ",");
		return stringBuilder.toString().split(",");
	}

	/**
	 * 轉換成中文大寫數字<br>
	 *
	 * 例：<br>
	 * String paramString = "123456";<br>
	 * String resultString = 壹拾貳萬參仟肆佰伍拾陸;<br>
	 *
	 * @param body 原始數字字串
	 * @return String 中文大寫數字字串
	 */
	static final String CHINESE_DIGIT = "零壹貳參肆伍陸柒捌玖";

	public static String formatInteger(String paramString) {
		String str1 = "";
		String str2 = "";
		if (paramString.length() < 9) {
			return formatTenThousand(paramString);
		}
		if ((paramString.length() > 8) && (paramString.length() < 13)) {
			str1 = paramString.substring(0, paramString.length() - 8);
			str2 = paramString.substring(paramString.length() - 8);
			if (allZero(str2)) {
				return formatInteger(str1) + "億";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "億" + formatInteger(str2);
		}
		if ((paramString.length() > 12) && (paramString.length() < 17)) {
			str1 = paramString.substring(0, paramString.length() - 12);
			str2 = paramString.substring(paramString.length() - 12);
			if (allZero(str2)) {
				return formatInteger(str1) + "兆";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "兆" + formatInteger(str2);
		}
		if ((paramString.length() > 16) && (paramString.length() < 21)) {
			str1 = paramString.substring(0, paramString.length() - 16);
			str2 = paramString.substring(paramString.length() - 16);
			if (allZero(str2)) {
				return formatInteger(str1) + "京";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "京" + formatInteger(str2);
		}
		if ((paramString.length() > 20) && (paramString.length() < 25)) {
			str1 = paramString.substring(0, paramString.length() - 20);
			str2 = paramString.substring(paramString.length() - 20);
			if (allZero(str2)) {
				return formatInteger(str1) + "垓";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "垓" + formatInteger(str2);
		}
		if ((paramString.length() > 24) && (paramString.length() < 29)) {
			str1 = paramString.substring(0, paramString.length() - 24);
			str2 = paramString.substring(paramString.length() - 24);
			if (allZero(str2)) {
				return formatInteger(str1) + "秭";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "秭" + formatInteger(str2);
		}
		if ((paramString.length() > 28) && (paramString.length() < 33)) {
			str1 = paramString.substring(0, paramString.length() - 28);
			str2 = paramString.substring(paramString.length() - 28);
			if (allZero(str2)) {
				return formatInteger(str1) + "壤";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "壤" + formatInteger(str2);
		}
		if ((paramString.length() > 32) && (paramString.length() < 37)) {
			str1 = paramString.substring(0, paramString.length() - 32);
			str2 = paramString.substring(paramString.length() - 32);
			if (allZero(str2)) {
				return formatInteger(str1) + "溝";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "溝" + formatInteger(str2);
		}
		if ((paramString.length() > 36) && (paramString.length() < 41)) {
			str1 = paramString.substring(0, paramString.length() - 36);
			str2 = paramString.substring(paramString.length() - 36);
			if (allZero(str2)) {
				return formatInteger(str1) + "澗";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "澗" + formatInteger(str2);
		}
		if ((paramString.length() > 40) && (paramString.length() < 45)) {
			str1 = paramString.substring(0, paramString.length() - 40);
			str2 = paramString.substring(paramString.length() - 40);
			if (allZero(str2)) {
				return formatInteger(str1) + "正";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "正" + formatInteger(str2);
		}
		if ((paramString.length() > 44) && (paramString.length() < 49)) {
			str1 = paramString.substring(0, paramString.length() - 44);
			str2 = paramString.substring(paramString.length() - 44);
			if (allZero(str2)) {
				return formatInteger(str1) + "載";
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatInteger(str2);
				}
				return getChineseDigit(0) + formatInteger(str2);
			}
			return formatInteger(str1) + "載" + formatInteger(str2);
		}
		str1 = paramString.substring(0, paramString.length() - 48);
		str2 = paramString.substring(paramString.length() - 48);
		if (allZero(str2)) {
			return formatInteger(str1) + "極";
		}
		if (allZero(str1)) {
			if (str2.charAt(0) == '0') {
				return formatInteger(str2);
			}
			return getChineseDigit(0) + formatInteger(str2);
		}
		return formatInteger(str1) + "極" + formatInteger(str2);
	}

	private static boolean allZero(String paramString) {
		boolean bool = true;
		for (int i = 0; i < paramString.length(); i++) {
			int j = paramString.charAt(i);
			if (j != 48) {
				return false;
			}
		}
		return bool;
	}

	//將單個數字0-9轉換成中文漢字
	private static String getChineseDigit(int i) {
		i = i < 0 ? -1 * i : i;
		return CHINESE_DIGIT.substring((i % 10), (i % 10) + 1);
	}

	private static String getChineseMag(int paramInt) {
		switch (paramInt) {
		case 0:
			return "";
		case 1:
			return "拾";
		case 2:
			return "佰";
		case 3:
			return "仟";
		case 4:
			return "萬";
		}
		return "";
	}

	private static String formatThousand(String paramString) {
		StringBuffer localStringBuffer = new StringBuffer();
		if (allZero(paramString)) {
			return getChineseDigit(0);
		}
		int i = 0;
		for (;;) {
			if (paramString.charAt(0) == '0') {
				i = 1;
				paramString = paramString.substring(1);
			} else {
				break;
			}
		}
		if (i != 0) {
			localStringBuffer.append(getChineseDigit(0));
		}
		int j = paramString.charAt(0);
		int k = paramString.length() - 1;
		localStringBuffer.append(getChineseDigit(j - 48));
		localStringBuffer.append(getChineseMag(k));
		if (paramString.length() > 1) {
			String str = paramString.substring(1);
			if (!allZero(str)) {
				localStringBuffer.append(formatThousand(str));
			}
		}
		return localStringBuffer.toString();
	}

	private static String formatTenThousand(String paramString) {
		if (paramString.length() > 4) {
			String str1 = paramString.substring(0, paramString.length() - 4);
			String str2 = paramString.substring(paramString.length() - 4);
			if (allZero(str2)) {
				return formatTenThousand(str1) + getChineseMag(4);
			}
			if (allZero(str1)) {
				if (str2.charAt(0) == '0') {
					return formatThousand(str2);
				}
				return getChineseDigit(0) + formatThousand(str2);
			}
			return formatTenThousand(str1) + getChineseMag(4) + formatThousand(str2);
		}
		return formatThousand(paramString);
	}

	/**
	 * 將字串以MD5方法加密
	 *
	 * @param str 須加密的字串
	 * @return String 加密後的字串
	 */
	public static String md5(String str) throws Throwable {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		String md5 = new BigInteger(1, md.digest()).toString(16).toUpperCase();
		return md5;
	}

	/**
	 * 字串左靠右補空白(中文字長度以3計算)
	 *
	 * @param str 原始字串
	 * @param length 右補空白至固定長度
	 * @return String 處理後字串
	 */
	public static String formatBlank(String str, int length) {
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isHalfWidth(str.charAt(i))) {
				len++;
			} else {
				len += 3;
			}
		}
		return String.format("%1$-" + (length - len + str.length()) + "s", str);
	}

	public static String fillString(String in, int length, boolean rightAlign, char ch) {
		StringBuffer sb = new StringBuffer();
		if (in == null) {
			in = "";
		}
		int inLength = getStringWidth(in);
		if (inLength >= length) {
			return in;
		}
		int loopLength = (ch < 256) ? length - inLength
				: (length - inLength) / 2;
		for (int i = 0; i < loopLength; ++i) {
			sb.append(ch);
		}
		if (rightAlign)
			sb.append(in);
		else {
			sb.insert(0, in);
		}

		return sb.toString();
	}

	public static int getStringWidth(String s) {
		if ((s == null) || (s.equals("")))
			return 0;
		int width = 0;
		char[] ca = s.toCharArray();
		for (int i = 0; i < ca.length; ++i) {
			if (isDBCS(ca[i]))
				width += 2;
			else {
				++width;
			}
		}
		return width;
	}

	public static boolean isDBCS(char ch) {
		return (((ch >= 8192) && (ch <= 65533)) || ((ch >= 711) && (ch <= 969) && (String
				.valueOf(ch).getBytes().length == 2)));
	}

	public static String fillBlankHead(String in, int length) {
		return fillString(in, length, true, ' ');
	}

	public static String fillZeroHead(String in, int length) {
		return fillString(in, length, true, '0');
	}

	public static String fillBlankTail(String in, int length) {
		return fillString(in, length, false, ' ');
	}

	public static String fillZeroTail(String in, int length) {
		return fillString(in, length, false, '0');
	}

}
