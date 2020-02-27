package org.zerock.controller;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DSTests {

	@Autowired
	private DataSource ds;
	
	@Test
	public void testCon()throws Exception {
		
		log.info(ds);
		
		 long start = System.currentTimeMillis();
			log.info("----------------1");
			log.info("----------------2");
			
			for(int i = 0; i < 50; i++) {
				
				Connection con = ds.getConnection(); 
				log.info(con);
				con.close();
				
			}
			long end = System.currentTimeMillis();
			
			log.info("----------------3");
			log.info("----------------4");
			log.info("TOTAL " + (end - start));
		
	}
	
}
