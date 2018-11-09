package qdu.lc.blogs.utils;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

/**
 * 加密算法
 * 
 * @author liuchao
 *
 */
public class MD5Utils {

	/**
	 * 加入一个salt值用于混淆
	 */
	private final static String salt = "4cea0dfe-a230-4c3b-89d7-cdc19d2c3668";

	public static String getMd5(String str) {
		if (StringUtils.isNotEmpty(str)) {
			String base = str + "/" + salt;
			String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
			return md5;
		}
		return null;
	}

	/**
	 * 随机生成一个全球唯一的ID
	 * 
	 * @return
	 */
	public static String getUuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
