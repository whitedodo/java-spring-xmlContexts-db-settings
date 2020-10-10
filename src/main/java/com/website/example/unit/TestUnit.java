/*
 * 	주제(Subject): Spring JDBC - XML Context 설정으로 Autowired 방식 - DataSource 구현
 *  파일명(Filename): TestUnit.java
 *  작성자(Author): Dodo (rabbit.white at daum dot net)
 *  작성일자(Create Date): 2020-10-10
 *  설명(Description)
 *  
 * 
 * 
 */

package com.website.example.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class TestUnit {
	
	private DataSource dataSource;
	private ApplicationContext ctx;
	
	// 태스트 환경에서 Autowired 버리기(JUnit 5 to Spring Framework 4.24 일 떄)
	
	@Test
	void test() {
		
		// 방법 1. (ApplicationContext로 Bean 불러오기)
		ctx = new GenericXmlApplicationContext("applicationContext.xml");
		this.dataSource = (DataSource) ctx.getBean("dataSource");
		
		if ( this.ctx != null ) {
			System.out.println("야1");
		}
		
		if ( this.dataSource != null ) {
			System.out.println("야2");
		}
		
		try(Connection con = dataSource.getConnection()){
			System.out.println("참");
			
		}catch(Exception e)
		{
			//fail(e.getMessage());
			System.out.println("거짓");
			
		}
		
	}

}
