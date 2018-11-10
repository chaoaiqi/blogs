package qdu.lc.blogs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 时间转换工具类
 * 
 * @author liuchao
 *
 */
public class DateUtils {
	
	/**
	 * 时间戳转指定格式的时间类型
	 * 
	 * @param time   时间戳
	 * @param format 格式 传参为null，则默认为"yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static String stampToDate(Long dateTime, String format) {
		if (null == dateTime)
			return null;
		if (!StringUtils.isNotEmpty(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		Date date = new Date(dateTime);
		String resStr = new SimpleDateFormat(format).format(date);
		return resStr;
	}

	/**
	 * 时间转时间戳
	 * 
	 * @param dateTimeStr 时间类型的字符串 例如2018-11-10 13:06:46
	 * @return
	 */
	public static Long dateToStamp(String dateTimeStr) {
		if (!StringUtils.isNotEmpty(dateTimeStr)) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		long time;
		try {
			date = simpleDateFormat.parse(dateTimeStr);
			time = date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return time;
	}

	/**
	 * 获取当时系统时间戳
	 * @return
	 */
	public static Long getServerTime() {
		Long time = System.currentTimeMillis();
		return time;
	}
}
