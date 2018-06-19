package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.happycode.domain.Customer;
import com.happycode.service.CustomerService;
import com.happycode.utils.CommonUtils;

public class tsss {
	@Test
	public void sss() {
		CustomerService ss = new CustomerService();
		Customer form = new Customer();
		form.setCname("jaj");
		form.setCellphone("123456");
		form.setGender("nan");
		form.setCid(CommonUtils.uuid());
		
		ss.add(form);
	}
	
	@Test
	public void Sss(){
		Customer form = new Customer();
		form.setCname("jaj");
		form.setCellphone("123456");
		form.setGender("nan");
		form.setCid(CommonUtils.uuid());
		
		Map<String, String> fxx = new HashMap<String, String>();
		fxx.put("cname", "sdf");
		fxx.put("cellphone", "163456");
		fxx.put("gender", "ssdf");
		fxx.put("cid", "sdfdg");
		fxx.put("method", "41654");
		
		
		System.out.println();
	}
	
	@Test
	public void findAllTest() {
	}
	
	@Test
	public void add300Cstm() {
		CustomerService ss = new CustomerService();
		for (int i=0; i<300; i++) {
			Customer x = new Customer();
			x.setCid(CommonUtils.uuid());
			x.setCname("cstm_" + i);
			x.setGender(i%2==0? "男":"女");
			x.setCellphone("11122223333");
			x.setDescription("我是" + "cstm" + i + "号客户！");
			ss.add(x);
		}
	}
	
	//代码1
	@Test
	public void testxx() throws Exception  {

		//代码2
		try{
		    throw new Exception("参数越界"); 
		}catch(Exception e) {
		}
		System.out.println("异常后");//可以执行
	}
}
