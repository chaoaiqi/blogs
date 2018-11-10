package qdu.lc.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

	/**
	 * 首页
	 * 
	 * @return
	 */
    @RequestMapping(value = {"/"})
	public String index(Model model) {
    	model.addAttribute("name","刘超");
		return "/home/index";
	}
}
