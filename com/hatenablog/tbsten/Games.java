package com.hatenablog.tbsten;

import java.util.Scanner;
/*
�Q�[���֗̕��֐����`
*/
public class Games {
	public static void sleep(long millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//a以上b以上の乱数
		public static int random(int a,int b) {
			return (int)(Math.random() * (b-a) +a) ;
		}
	//a以上b以上の小数点付き乱数
	public static double randomDouble(double a,double b) {
		return (Math.random() * (b-a) +a) ;
	}


	public static String inputString() {
		return new Scanner(System.in).next() ;
	}

	public static int inputInt() {
		return new Scanner(System.in).nextInt() ;
	}

}
