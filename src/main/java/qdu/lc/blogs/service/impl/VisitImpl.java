package qdu.lc.blogs.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import qdu.lc.blogs.dao.VisitMapper;
import qdu.lc.blogs.model.Visit;
import qdu.lc.blogs.service.VisitService;
import qdu.lc.blogs.utils.DateUtils;

@Component
public class VisitImpl implements VisitService {

	@Autowired
	private VisitMapper visitDao;

	@Override
	public Visit addVisitRecord(String ip) {
		Long sysTime = DateUtils.getServerTime();
		Date date = new Date(sysTime);
		Visit visit = new Visit(date, ip);
		visitDao.insertSelective(visit);
		return visit;
	}

}
