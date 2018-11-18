package qdu.lc.blogs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import qdu.lc.blogs.entity.Response;

@Service
public interface UtilService {

	/**
	 * 获取ip
	 * @param request
	 * @return
	 */
	String getIp(HttpServletRequest request);

	/**
	 * 获取ip所在地址
	 * @param params
	 * @return
	 */
	Response getIpAddress(String params);

}
