package qdu.lc.blogs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

import qdu.lc.blogs.entity.Address;
import qdu.lc.blogs.entity.AddressObj;
import qdu.lc.blogs.entity.Response;
import qdu.lc.blogs.model.Visit;
import qdu.lc.blogs.service.UtilService;
import qdu.lc.blogs.service.VisitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogsApplicationTests {

	@Autowired
   private UtilService utilService;
	@Autowired
	private VisitService visitService;
    @Test
    public void Test() {
    	try {
    		String ip = "123.59.170.194";
    		String params = "ip=" + ip;
    		Response response = utilService.getIpAddress(params);
    		Visit iVisit = visitService.addVisitRecord(ip);
    		System.out.println(JSONObject.toJSONString(iVisit));
    		if(response.getMeta().isSuccess()) {
    			AddressObj addressObj = (AddressObj) response.getData();
    			Address address = addressObj.getData();
    			System.out.println(JSONObject.toJSONString(address));
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}
