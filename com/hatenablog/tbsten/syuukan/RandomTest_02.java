package com.hatenablog.tbsten.syuukan;

import com.hatenablog.tbsten.Games;

/*
 * No 5
 * lv 2(/5)
 * ランダムなひらがな2-3文字の組み合わせである猫の名前」を100件表示するプログラム。
 *
 * */
public class RandomTest_02 {

	public static void main(String[] args) {
		new RandomTest_02();
	}

	String[] hiragana = {
			"あ","い","う","え","お",
			"か","き","く","け","こ",
			"さ","し","す","せ","そ",
			"た","ち","つ","て","と",
			"な","に","ぬ","ね","の",
			"は","ひ","ふ","へ","ほ",
			"ま","み","む","め","も",
			"や","ゆ","よ",
			"ら","り","る","れ","ろ",
			"わ","を","ん",
			"が","ぎ","ぐ","げ","ご",
			"ざ","じ","ず","ぜ","ぞ",
			"た","ぢ","づ","で","ど",
			"ば","び","ぶ","べ","ぼ",
			"ぱ","ぴ","ぷ","ぺ","ぽ"} ;
	int hiraganaLen = hiragana.length ;
	RandomTest_02(){
		for(int i = 1;i <= 100;i++) {
			String name = calc("",0);
			output(i,name);
		}
	}

	String calc(String str,int i) {
		String ans = str ;
		if(i < 2 || (i < 3 && Games.random(0, 2) < 1)) {
			ans = calc(ans + hiragana[Games.random(0, hiraganaLen)],i+1) ;
		}
		return ans ;
	}

	void output(int i,String name) {
		System.out.println(String.format("%3d件目:%s",i,name));
	}
}
