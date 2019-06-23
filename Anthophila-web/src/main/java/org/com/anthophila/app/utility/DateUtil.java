package org.com.anthophila.app.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 處理日期共用函數
 *
 * @author admin
 *
 */
public class DateUtil {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/** 一天 的 milliseconds */
	private static long day_to_ms = 24 * 60 * 60 * 1000;

	/**
	 * 轉成日期類別
	 *
	 * @param dateStr 日期字串
	 * @param format 日期格式
	 * @return Date
	 * @throws ParseException ParseException
	 */
	public static Date toDate(String dateStr, String format) throws ParseException {
		Date date = null;
		if (StringUtils.isNotBlank(dateStr) && StringUtils.isNotBlank(format)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateStr);
		}
		return date;
	}

	/**
	 * 轉成日期字串
	 *
	 * @param date 日期類別
	 * @param format 日期格式
	 * @return String 日期字串
	 */
	public static String toDateString(Date date, String format) {
		String dateStr = null;
		if (date != null && StringUtils.isNotBlank(format)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date);
			if (Long.MAX_VALUE == date.getTime()) {
				String tempStr = "";
				while (tempStr.length() < format.length()) {
					tempStr += "9";
				}
				dateStr = tempStr;
			} else if (Long.MIN_VALUE == date.getTime()) {
				String tempStr = "";
				while (tempStr.length() < format.length()) {
					tempStr += "0";
				}
				dateStr = tempStr;
			}
		}
		return dateStr;
	}

	/**
	 * 把日期date加上n個日期單位。若n為負數則為減掉n日期單位
	 *
	 * @param date 日期類別
	 * @param unit 日期單位
	 * @param n 數量
	 * @return Date
	 */
	private static Date add(Date date, int unit, int n) {
		Date d = null;
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(unit, n);
			d = cal.getTime();
		}
		return d;
	}

	/**
	 * 把日期date加上minute個分。若minute為負數則為減掉minute分
	 *
	 * @param date 日期類別
	 * @param minute 分
	 * @return Date
	 */
	public static Date addMin(Date date, int minute) {
		return add(date, Calendar.MINUTE, minute);
	}

	/**
	 * 把日期date加上hour個小時。若hour為負數則為減掉hour小時
	 *
	 * @param date 日期類別
	 * @param hour 小時
	 * @return Date
	 */
	public static Date addHour(Date date, int hour) {
		return add(date, Calendar.HOUR, hour);
	}

	/**
	 * 把日期date加上day個天。若day為負數則為減掉day天
	 *
	 * @param date 日期類別
	 * @param day 天
	 * @return Date
	 */
	public static Date addDay(Date date, int day) {
		return add(date, Calendar.DAY_OF_YEAR, day);
	}

	/**
	 * 把日期date加上month個月。若month為負數則為減掉month月
	 *
	 * @param date 日期類別
	 * @param month 月
	 * @return Date
	 */
	public static Date addMonth(Date date, int month) {
		return add(date, Calendar.MONTH, month);
	}

	/**
	 * 把日期date加上year個年。若year為負數則為減掉year年
	 *
	 * @param date 日期類別
	 * @param year 年
	 * @return Date
	 */
	public static Date addYear(Date date, int year) {
		return add(date, Calendar.YEAR, year);
	}

	/**
	 * 取得日期date的日期單位unit數值
	 *
	 * @param date 日期類別
	 * @param unit 日期單位
	 * @return int 數量
	 */
	public static int get(Date date, int unit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(unit);
	}

	/**
	 * 取得日期date的分
	 *
	 * @param date 日期類別
	 * @return int 分
	 */
	public static int getMin(Date date) {
		return get(date, Calendar.MINUTE);
	}

	/**
	 * 取得日期date的小時
	 *
	 * @param date 日期類別
	 * @return int 小時
	 */
	public static int getHour(Date date) {
		return get(date, Calendar.HOUR);
	}

	/**
	 * 取得日期date的日
	 *
	 * @param date 日期類別
	 * @return int 日
	 */
	public static int getDay(Date date) {
		return get(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得日期date的月
	 *
	 * @param date 日期類別
	 * @return int 月
	 */
	public static int getMonth(Date date) {
		return get(date, Calendar.MONTH) + 1;
	}

	/**
	 * 取得日期date的年
	 *
	 * @param date 日期類別
	 * @return int 年
	 */
	public static int getYear(Date date) {
		return get(date, Calendar.YEAR);
	}

	/**
	 * 取得該月最大日期
	 *
	 * @param date 日期類別
	 * @return int 日
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得該月最大日期
	 *
	 * @param year 年
	 * @param month 月
	 * @return int 日
	 */
	public static int getDaysOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 比較date1是否大於date2
	 *
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return int<br>
	 *         0:date1等於date2<br>
	 *         1:date1大於date2<br>
	 *         -1:date1小於date2
	 */
	public static int compare(Date date1, Date date2) {
		int result = 0;
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		if (d1 > d2)
			result = 1;
		else if (d1 < d2)
			result = -1;
		return result;
	}

	/**
	 * 將民國日期字串dateStr轉成日期類別<br>
	 * 例:dateStr="01060920", format="yyyyMMdd"
	 *
	 * @param dateStr 民國日期字串
	 * @param format 日期格式
	 * @return Date
	 * @throws ParseException ParseException
	 */
	public static Date formatADDate(String dateStr, String format) throws ParseException {
		Date date = null;
		if (StringUtils.isNotBlank(dateStr) && StringUtils.isNotBlank(format)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateStr);
			date = addYear(date, 1911);
		}
		return date;
	}

	/**
	 * 將日期date轉成民國日期字串
	 *
	 * @param date 日期類別
	 * @param format 民國日期字串格式
	 * @return String
	 * @throws ParseException ParseException
	 */
	public static String formatROCDate(Date date, String format) throws ParseException {
		String dateStr = null;
		if (date != null && StringUtils.isNotBlank(format)) {
			date = addYear(date, -1911);
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date);
		}
		return dateStr;
	}

	/**
	 * 計算 兩個時間裡相差之天數 (有正負數)<br>
	 * date1 - date2
	 *
	 * @param date1 開始計算之日期
	 * @param date2 結束計算之日期
	 * @return int 相差之天數
	 *
	 */
	public static int diffDays(Date date1, Date date2) {
		long a = date1.getTime();
		long b = date2.getTime();
		return (int) ((a - b) / day_to_ms);
	}

	/**
	 * 計算 兩個時間裡相差之月數 (有正負數)<br>
	 * date1 - date2
	 *
	 * @param date1 開始計算之日期
	 * @param date2 結束計算之日期
	 * @return int 相差之月數
	 *
	 */
	public static int diffMonths(Date date1, Date date2) {
		int d1y = getYear(date1);
		int d2y = getYear(date2);
		int d1m = getMonth(date1);
		int d2m = getMonth(date2);
		return (d1y - d2y) * 12 + (d1m - d2m);
	}

	/**
	 * 判斷這一天是否是月底
	 *
	 * @param date 日期類別
	 * @return boolean true:日期為月底<br>
	 *                 false:日期不為月底
	 */
	public static boolean isEndOfMonth(Date date) {
		boolean isEndOfMonth = false;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		if (dayOfMonth == cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			isEndOfMonth = true;
		}
		return isEndOfMonth;
	}

	/**
	 * 判斷該日期是否為本周第一天
	 *
	 * @param date 日期類別
	 * @return boolean true:該日期為本周第一天<br>
	 *                 false:該日期不為本周第一天
	 */
	public static boolean isStartOfWeek(Date date) {
		boolean isStartOfWeek = false;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == cal.getActualMinimum(Calendar.DAY_OF_WEEK)) {
			isStartOfWeek = true;
		}
		return isStartOfWeek;
	}

	/**
	 * 將日期變回本月第一天
	 *
	 * @param date 日期類別
	 * @return Date 回覆本月第一天
	 *
	 *
	 */
	public static Date getFirstMonth(Date date) {
		int DayOfMonth = getDay(date);
		int diffDay = DayOfMonth - 1;
		Date FirstOfDay = addDay(date, -diffDay);
		return FirstOfDay;
	}

	/**
	 * 以本月第一天回推六個月算半年日期
	 *
	 * @param date 日期類別
	 * @return Date 回覆半年日期
	 *
	 */
	public static Date getHelfYear(Date date) {
		Date FirstOfDay = getFirstMonth(date);
		Date HelfYear = addMonth(FirstOfDay, -6);
		return HelfYear;
	}

	/**
	 * 取得時間即日期的Date物件
	 *
	 * @param c 交易內容
	 * @param yyyyMMdd 字串西元年月日
	 * @param time 只取Date型態的時間
	 * @return
	 */
	public static Date getDateTime(String yyyyMMdd, Date time) {
		Date result = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		String dateYear = yyyyMMdd.substring(0, 4);
		String dateMonth = yyyyMMdd.substring(4, 6);
		String dateDay = yyyyMMdd.substring(6, 8);
		cal.set(Calendar.YEAR, Integer.valueOf(dateYear));
		cal.set(Calendar.MONTH, Integer.valueOf(dateMonth) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dateDay));
		result = cal.getTime();
		return result;
	}

	/**
	 * 用電文的時間與用電文的日期組成Date物件
	 *
	 * @param c 交易內容
	 * @param HHmmSS 字串時間
	 * @param date 只取Date型態的日期
	 * @return
	 */
	public static Date getDateTimes(String HHmmSS, Date date) {
		Date result = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String hour = HHmmSS.substring(0, 2);
		String min = HHmmSS.substring(2, 4);
		String sec = HHmmSS.substring(4, 6);
		cal.set(Calendar.HOUR, Integer.valueOf(hour));
		cal.set(Calendar.MINUTE, Integer.valueOf(min));
		cal.set(Calendar.SECOND, Integer.valueOf(sec));
		result = cal.getTime();
		return result;
	}

	/**
	 * 判斷日期成立
	 *
	 * @param c 交易內容
	 * @param date 只取Date型態的日期
	 * @return
	 */
	public static boolean getDateTure(String date, String format) {
		boolean result = true;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		try {
			sdf.parse(date);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
