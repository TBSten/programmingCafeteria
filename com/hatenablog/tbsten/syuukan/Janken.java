package com.hatenablog.tbsten.syuukan;

import com.hatenablog.tbsten.Games;

/*
 * No 1
 * lv 2(/5)。
 * コンピュータとじゃんけんをするプログラム。
 * */
public class Janken {

	public static void main(String[] args) {
		String[] ken = {"グー","チョキ","パー"} ;
		for(int i = 0;i < 3;i++) {
			System.out.print(ken[i]+"は"+i+"を、");
		}
		System.out.println("入力して下さい");
		int jibun = Games.inputInt() ;
		int teki = Games.random(0,3);
		System.out.println("じゃんけん");
		Games.sleep(700);
		System.out.println("ぽん");
		System.out.println(ken[jibun]+" vs "+ken[teki]);
		if(teki == jibun) {
			System.out.println("あいこ");
		}else if(jibun == (teki+2)%3) {
			System.out.println("かち！");
		}else {
			System.out.println("まけ...");
		}
	}

}
