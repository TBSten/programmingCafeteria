package com.hatenablog.tbsten.syuukan;

import com.hatenablog.tbsten.Games;

/*
 * No 4
 * lv 1(/5)。
 * YとNの選択肢から入力し、Yを選んだら終了、Nを選んだらもう一度入力させる を繰り返す
 * */
public class Only1Choice {

	public static void main(String[] args) {
		new Only1Choice();
	}

	Only1Choice(){
		String in = input() ;
		while(!in.equals("Y")) {
			in = input () ;
		}

	}
	String input() {
		System.out.println("YまたはNを入力");
		return Games.inputString();
	}


}
