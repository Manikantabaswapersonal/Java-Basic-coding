package com.datetime.exmple;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DataTime {

	public static void main(String[] args) {

		
		
		
		
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd::hh:mm:ss");
		String formattedTime = ldt.format(dtf);
		System.out.println(formattedTime);
 
		
		ZoneId zid=ZoneId.of("America/New_York");
		ZonedDateTime zdt=ldt.atZone(zid);
		System.out.println(zdt);
	}
}