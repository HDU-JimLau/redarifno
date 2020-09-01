package com.jim.redarifno;

import com.jim.redarifno.entity.Redar;
import com.jim.redarifno.service.RedarInfoService;
import com.jim.redarifno.service.RedarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RedarifnoApplicationTests {

	@Autowired
	private RedarService redarService;
	@Test
	void contextLoads() {

		List<Redar> redars = redarService.queryAll();
		System.out.println(redars);
		/*Redar redar=new Redar();
		redar.setId("tbkj01");
		List<Redar> redars = redarService.queryByAttr(redar);

		System.out.println(redars);*/

	}

}
