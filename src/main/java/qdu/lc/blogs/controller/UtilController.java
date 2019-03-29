package qdu.lc.blogs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import qdu.lc.blogs.entity.Response;
import qdu.lc.blogs.service.UtilService;

@Api("我的工具")
@Controller
public class UtilController {

	@Autowired
	private UtilService utilService;

	/**
	 * 获取当前请求的ip地址
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation("用户地址")
	@ResponseBody
	@RequestMapping(value = "/getAddress", produces = "application/json;charset=UTF-8")
	public Response getAddress(HttpServletRequest request, String ip) {

		if (!StringUtils.isNotEmpty(ip)) {
			ip = utilService.getIp(request);
		}
		if (!"0:0:0:0:0:0:0:1".equals(ip)) {
			String params = "ip=" + ip;
			Response response = utilService.getIpAddress(params);
			if (response.getMeta().isSuccess()) {
				return response;
			} else {
				return null;
			}
		}
		return null;
	}
}
