package org.com.anthophila.app.utility;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 處理數字共用函數
 *
 * @author admin
 *
 */
public class NumberUtil {

	private static final Logger logger = LoggerFactory.getLogger(NumberUtil.class);

	private static final List<DecimalFormat> dcimalFormatList = new ArrayList<>();
	static {
		dcimalFormatList.add(new DecimalFormat("#,###.#"));
		dcimalFormatList.add(new DecimalFormat("$#,###.#"));
	}

	/**
	 * 將String、Double、Long、Integer轉換成BigDecimal，轉換失敗回傳BigDecimal.ZERO
	 *
	 * @param o 欲轉換的物件
	 * @return BigDecimal
	 */
	public static BigDecimal toBigDecimal(Object o) {
		BigDecimal b = null;
		try {
			if (o instanceof String) {
				String s = (String) o;
				b = toBigDecimal(s);
			} else if (o instanceof Double) {
				b = new BigDecimal((Double) o);
			} else if (o instanceof Long) {
				b = new BigDecimal((Long) o);
			} else if (o instanceof Integer) {
				b = new BigDecimal((Integer) o);
			} else if (o instanceof BigDecimal) {
				b = (BigDecimal) o;
			}
		} catch (Throwable t) {
			logger.error(t.toString(), t);
		}
		return b == null ? BigDecimal.ZERO : b;
	}

	/**
	 * 將String、Double、Long、Integer轉換成BigDecimal，轉換失敗回傳BigDecimal.ZERO
	 *
	 * @param o 欲轉換的物件
	 * @param scale 小數點位數
	 * @return BigDecimal
	 */
	public static BigDecimal toBigDecimal(Object o, int scale) {
		BigDecimal b = toBigDecimal(o);
		return b.setScale(scale);
	}

	/**
	 * 將String轉換成BigDecimal，轉換失敗回傳BigDecimal.ZERO<br>
	 * 如負號在最後一碼，將負號改放在第一碼。<br>
	 * 如有逗號分隔或有$號，將其Format為一般數字格式。
	 *
	 * @param str 欲轉換的字串
	 * @return BigDecimal
	 */
	public static BigDecimal toBigDecimal(String str) {
		BigDecimal b = null;
		try {
			if (StringUtils.isNotBlank(str)) {
				str = StringUtil.trimLeft(str);
				str = StringUtil.trimRight(str);
				if (str.contains("-")) {
					str = str.replace("-", "");
					str = "-" + str;
				}
				Number n = null;
				for (DecimalFormat df : dcimalFormatList) {
					try {
						n = df.parse(str);
					} catch (Exception e) {
					}
				}
				if (n != null)
					b = new BigDecimal(n.toString());
			}
		} catch (Throwable t) {
			logger.error(t.toString(), t);
		}
		return b == null ? BigDecimal.ZERO : b;
	}

	/**
	 * 處理BigDecimal累加
	 *
	 * @param nums 欲相加的數字
	 * @return BigDecimal
	 */
	public static BigDecimal add(BigDecimal... nums) {
		BigDecimal result = BigDecimal.ZERO;
		if (nums != null)
			for (BigDecimal num : nums)
				if (num != null)
					result = result.add(num);
		return result;
	}

	/**
	 * 處理BigDecimal累加<br>
	 * 例:BigDecimal total = NumberUtil.add(c.get("COM-AMT"));
	 *
	 * @param nums 欲相加的數字
	 * @return BigDecimal
	 */
	@SuppressWarnings("rawtypes")
	public static BigDecimal add(List nums) {
		BigDecimal result = BigDecimal.ZERO;
		if (nums != null)
			for (Object num : nums)
				if (num != null)
					result = result.add(toBigDecimal(num));
		return result;
	}

	/**
	 * BigDecimal b減去BigDecimal nums
	 *
	 * @param b 被減數
	 * @param nums 減數
	 * @return BigDecimal
	 */
	public static BigDecimal subtract(BigDecimal b, BigDecimal... nums) {
		b = toBigDecimal(b);
		if (nums != null)
			for (BigDecimal num : nums)
				if (num != null)
					b = b.subtract(num);
		return b;
	}

	/**
	 * BigDecimal b減去BigDecimal nums<br>
	 * 例:BigDecimal total = NumberUtil.subtract(new BigDecimal("10000"), c.get("COM-AMT"));
	 *
	 * @param b 被減數
	 * @param nums 減數
	 * @return BigDecimal
	 */
	@SuppressWarnings("rawtypes")
	public static BigDecimal subtract(BigDecimal b, List nums) {
		b = toBigDecimal(b);
		if (nums != null)
			for (Object num : nums)
				if (num != null)
					b = b.subtract(toBigDecimal(num));
		return b;
	}

	/**
	 * 處理BigDecimal累乘
	 *
	 * @param nums 欲相乘的數字
	 * @return BigDecimal
	 */
	public static BigDecimal multiply(BigDecimal... nums) {
		BigDecimal result = new BigDecimal("1");
		if (nums != null) {
			for (BigDecimal num : nums)
				if (num != null)
					result = result.multiply(num);
		} else {
			result = BigDecimal.ZERO;
		}
		return result;
	}

	/**
	 * 處理BigDecimal累乘<br>
	 * 例:BigDecimal total = NumberUtil.multiply(c.get("COM-AMT"));
	 *
	 * @param b 被乘數
	 * @param nums 乘數
	 * @return BigDecimal
	 */
	@SuppressWarnings("rawtypes")
	public static BigDecimal multiply(BigDecimal b, List nums) {
		BigDecimal result = new BigDecimal("1");
		if (nums != null) {
			for (Object num : nums)
				if (num != null)
					result = result.multiply(toBigDecimal(num));
		} else {
			result = BigDecimal.ZERO;
		}
		return result;
	}
}
