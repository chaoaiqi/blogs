package qdu.lc.blogs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import qdu.lc.blogs.model.AddressObj;
import qdu.lc.blogs.utils.IPAdressUtils;

@Api("我的工具")
@Controller
public class UtilController {

	/**
	 * 获取当前请求的ip地址
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation("用户地址")
	@ResponseBody
	@RequestMapping(value = "/getAddress", produces = "application/json;charset=UTF-8")
	public AddressObj getAddress(HttpServletRequest request, String ip) {
		try {
			if (!StringUtils.isNotEmpty(ip)) {
				ip = IPAdressUtils.getIpAdrress(request);
			}
			if (!"0:0:0:0:0:0:0:1".equals(ip)) {
				String url = "http://ip.taobao.com/service/getIpInfo.php";// 采用淘宝IP地址库
				String params = "ip=" + ip;
				String encoding = "UTF-8";
				String addresStr = IPAdressUtils.getResult(url, params, encoding);
				AddressObj addressObj = JSON.parseObject(addresStr, AddressObj.class);
				return addressObj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
