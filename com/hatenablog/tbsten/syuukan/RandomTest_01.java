package com.hatenablog.tbsten.syuukan;

import com.hatenablog.tbsten.Games;

/*
 * lv 1(/5)。
 * 0から100未満の乱数を10000回発生させてその平均を表示するプログラム。
 * */
public class RandomTest_01 {

	public static void main(String[] args) {
		int sum = 0 ;
		int cnt = 0 ;
		for(long i = 0;i < 10000;i++) {
			int r = Games.random(0,100);
			System.out.printf("今回:%4d 平均:%10f\n",r,(double)sum/cnt);
			sum += r ;
			cnt ++;
		}
		System.out.print("合計は"+((double)sum/cnt));
	}

}
