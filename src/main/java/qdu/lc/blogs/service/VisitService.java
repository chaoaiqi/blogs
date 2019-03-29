package qdu.lc.blogs.service;


import org.springframework.stereotype.Service;

import qdu.lc.blogs.model.Visit;

@Service
public interface VisitService {

	/**
	 * 添加访客记录
	 * @param ip
	 * @return
	 */
	Visit addVisitRecord(String ip);


}
