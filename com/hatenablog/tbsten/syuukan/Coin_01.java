package com.hatenablog.tbsten.syuukan;

import com.hatenablog.tbsten.Games;

/*
 * No 8
 * lv 4(/5)
 * 1～nまでで5・8円玉のみで払える金額を表示するプログラム。
 *
 * */
public class Coin_01 {

	public static void main(String[] args) {
		new Coin_01() ;
	}

	Coin_01(){
		System.out.print("nを入力:") ;

		int n = Games.inputInt();

		System.out.printf("1～%dまでの5・8円玉のみで払える金額\n",n);

		for(int i = 1;i <= n;i++) {
			int j = i ;
			while(i%5 != 0 && j >= 8) {				//アイデア:i%5 != 0 がいる理由を問いにする
				j = j - 8 ;
			}
			if(j % 5 == 0) {
				System.out.println(i);
			}
		}
	}

}
