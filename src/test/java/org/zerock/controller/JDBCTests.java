package org.zerock.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	@Test
	public void testConnect()throws Exception {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //localhost대신 ip주소가 들어갈수도
        String id = "bit03";
        String pw = "bit03";
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        long start = System.currentTimeMillis();
		log.info("----------------1");
		log.info("----------------2");
		
		for(int i = 0; i < 50; i++) {
			
			Connection con = DriverManager.getConnection(url,id,pw);
			log.info(con);
			con.close();
			
		}
		long end = System.currentTimeMillis();
		
		log.info("----------------3");
		log.info("----------------4");
		log.info("TOTAL " + (end - start));
	}

}
