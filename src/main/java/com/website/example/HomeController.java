/*
 * 	주제(Subject): Spring JDBC - XML Context 설정으로 Autowired 방식 - DataSource 구현
 *  파일명(Filename): HomeController.java
 *  작성자(Author): Dodo (rabbit.white at daum dot net)
 *  작성일자(Create Date): 2020-10-10
 *  설명(Description)
 *  
 * 
 */

package com.website.example;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		if ( dataSource != null ) {
			System.out.println("야2");
		}
		
		try(Connection con = dataSource.getConnection()){
			System.out.println("참");
			
		}catch(Exception e)
		{
			//fail(e.getMessage());
			System.out.println("거짓");
			
		}
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
