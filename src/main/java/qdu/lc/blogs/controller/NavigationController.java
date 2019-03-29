package qdu.lc.blogs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import qdu.lc.blogs.entity.Address;
import qdu.lc.blogs.entity.AddressObj;
import qdu.lc.blogs.entity.Response;
import qdu.lc.blogs.model.Visit;
import qdu.lc.blogs.service.UtilService;
import qdu.lc.blogs.service.VisitService;

@Controller
public class NavigationController {

	@Autowired
	private UtilService utilService;
	@Autowired
	private VisitService visitService;
	/**
	 * 首页
	 * 
	 * @return
	 */
    @RequestMapping(value = {"/"})
	public String index(HttpServletRequest request,Model model) {
		String ip = utilService.getIp(request);
		Response response = null;
		Visit iVisit = null;
		if (!"0:0:0:0:0:0:0:1".equals(ip)) {
			String params = "ip=" + ip;
			response = utilService.getIpAddress(params);
			iVisit = visitService.addVisitRecord(ip);
		}
		if(response.getMeta().isSuccess()) {
			AddressObj addressObj = (AddressObj) response.getData();
			Address address = addressObj.getData();
			String str = "来自" + address.getCountry() + address.getCity() + "的你。";
			model.addAttribute("name",str);
			model.addAttribute("ip",ip);
			model.addAttribute("date",iVisit.getLasttime());
		}else {			
			model.addAttribute("name","mic");
			model.addAttribute("ip","...我怎么知道.");
		}
		return "/home/index";
	}
}
