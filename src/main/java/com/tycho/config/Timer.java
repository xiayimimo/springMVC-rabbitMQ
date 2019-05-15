package com.tycho.config;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Timer {

	@Scheduled(cron="0/5 * * * * ?")
	public void timer() {
		System.out.println(new Date());
		System.out.println(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
	}
}
