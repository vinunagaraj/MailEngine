package com.geekyants.mailengine.util;

import java.util.Random;

public class Validation {
	
	public static int generatePin()  {
		Random generator = new Random();
		generator.setSeed(System.currentTimeMillis());
		  
		int num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
		num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
			return 0;
		}
		}
		return num;
					
	}

}
