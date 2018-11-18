package qdu.lc.blogs.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * ip 地址相关工具类
 * 
 * @author liuchao
 *
 */
public class IPAdressUtils {

	/**
	 * 获取当前请求的ip 本地请求将返回0:0:0:0:0:0:0:1
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAdrress(HttpServletRequest request) throws Exception {
		String Xip = request.getHeader("X-Real-IP");
		String XFor = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = XFor.indexOf(",");
			if (index != -1) {
				return XFor.substring(0, index);
			} else {
				return XFor;
			}
		}
		XFor = Xip;
		if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
			return XFor;
		}
		if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getRemoteAddr();
		}
		return XFor;
	}

	/**
	 * 获取地址
	 * 
	 * @param urlStr   请求接口的url
	 * @param params   请求接口的参数
	 * @param encoding
	 * @return
	 */
	public static String getResult(String urlStr, String params, String encoding) throws Exception {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			connection.setConnectTimeout(60000);// 设置连接超时时间，单位毫秒
			connection.setReadTimeout(60000);// 设置读取数据超时时间，单位毫秒
			connection.setDoOutput(true);// 是否打开输出流 true|false
			connection.setDoInput(true);// 是否打开输入流true|false
			connection.setRequestMethod("GET");// 提交方法POST|GET
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
			out.writeBytes(params);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
			out.flush();// 刷新
			out.close();// 关闭输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
			//以BufferedReader流来读取
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// 关闭连接
			}
		}
		return null;
	}

}
