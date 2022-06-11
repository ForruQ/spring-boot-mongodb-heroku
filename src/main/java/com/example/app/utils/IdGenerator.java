package com.example.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class IdGenerator {

	private static String name = "MyDB";

	public String getGeneratedId() {
		SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMDDMMSS");
		Date date = new Date();
		Random rand = new Random();
		int value = rand.nextInt(999999);
		String today = formatter.format(date);
		String ids = name + '-' + today + '-' + value;
		return ids;
	}

	public String getGeneratedImageName() {
		SimpleDateFormat formatter = new SimpleDateFormat("YYMMDDMMSS");
		Date date = new Date();
		Random rand = new Random();
		int value = rand.nextInt(999999);
		String today = formatter.format(date);
		String ids = today + value;
		return ids;
	}

}
