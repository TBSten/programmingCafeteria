package com.hatenablog.tbsten.syuukan;

import com.hatenablog.tbsten.Games;

/*
 * No 7
 * lv 3(/5)
 * モンテカルロ法をまねて円周率を求めるプログラム。
 *
 * */
public class RandomTest_03 {

	public static void main(String[] args) {
		new RandomTest_03() ;
	}

	RandomTest_03(){
		int cnt = 0 ;
		long n = 100_000_000L;
		int r = 3 ;
		for(long i = 0 ;i < n;i++) {
			double x = Games.randomDouble(-r, r);
			double y = Games.randomDouble(-r, r);
			if(x*x+y*y <= r*r) {
				cnt++;
			}
		}
		double menseki = (double)2*r*2*r*cnt/n ;
		double pi = menseki/(r*r) ;
		System.out.println("半径:"+r);
		System.out.println("面積:"+menseki);
		System.out.println("円周率:"+pi);
	}

}
