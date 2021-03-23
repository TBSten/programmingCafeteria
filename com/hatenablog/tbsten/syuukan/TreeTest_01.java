package com.hatenablog.tbsten.syuukan;


/*
 * No 3
 * lv 2(/5)
 * 節の数がsizeの二分木を前順（先行順・前置順・行きがけ順とも）で10,20,...と数字をつけていくプログラム。
 * treeValueはつけられた数字を表す。よって、全順で1番目のtreeValueには10が入る。
 * treeValueの添え字は1から始まり（0は用いない）、treeValue[n]の左の子はtreeValue[n*2],右の子はtreeValue[n*2+1],
 */
public class TreeTest_01 {

	public static void main(String[] args) {

		new TreeTest_01() ;


	}
	int size = 10 ;
	int[] treeValue = new int[size+1] ;
	int i = 10 ;
	TreeTest_01(){
		calc(1);

		output();
	}

	void output() {
		for(int i = 1;i < treeValue.length;i++) {
			System.out.println(i+":"+treeValue[i]);
		}
	}

	void calc(int idx) {
		if(idx <= size) {
			//おやの値書き換え
			treeValue[idx] = i ;
			i += 10 ;
			calc(idx*2);
			calc(idx*2+1);
		}
	}

}
