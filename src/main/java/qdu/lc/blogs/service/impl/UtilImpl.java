package qdu.lc.blogs.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import qdu.lc.blogs.entity.AddressObj;
import qdu.lc.blogs.entity.Response;
import qdu.lc.blogs.service.UtilService;
import qdu.lc.blogs.utils.Contants;
import qdu.lc.blogs.utils.IPAdressUtils;

@Component
public class UtilImpl implements UtilService {

	@Override
	public String getIp(HttpServletRequest request) {
		String ip = "";
		try {
			ip = IPAdressUtils.getIpAdrress(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ip;
	}

	@Override
	public Response getIpAddress(String params) {
		Response response = new Response();
		try {
			String addresStr = IPAdressUtils.getResult(Contants.TBURL, params, "UTF-8");
			AddressObj addressObj = JSON.parseObject(addresStr, AddressObj.class);
			response.success(addressObj);
		} catch (Exception e) {
			response.failure(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

}
