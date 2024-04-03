package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IpurchaseOrder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
	IpurchaseOrder order=ctx.getBean("purchase",IpurchaseOrder.class);
	try {
		String msg=order.purchase(new String[] {"pant","shirt"},
				new String[] {"nareshchinthakayala19@gmail.com","naresh342000@gmail.com"});
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	}

}
