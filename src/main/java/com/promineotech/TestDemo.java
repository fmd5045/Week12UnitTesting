package com.promineotech;

import java.util.*;

public class TestDemo {
	
	public static int addPositive(int a, int b) {
		if(a > 0 && b >0) {
			return a+b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
	}
	
	public static int expontential(int a, int b){
		if (b > 0) {
			int result = a;
			for (int i = 1; i < b; i++) {
				result *= a;
			}
			return result;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number*number;
	}

}



