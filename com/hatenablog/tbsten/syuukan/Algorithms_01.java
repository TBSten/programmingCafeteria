package com.hatenablog.tbsten.syuukan;

/*
 * No 6
 * lv 2(/5)。
 * 配列を降順に並べ替えるプログラム。
 * */
public class Algorithms_01 {

	public static void main(String[] args) {
		new Algorithms_01() ;
	}

	Algorithms_01(){
		int[] data = {0,30,50,20,10,60} ;

		//並べ替え前を表示
		System.out.println("並べ替え前");
		hyouji(data);

		for(int i = 0;i < data.length;i++) {
			for(int j = i+1;j < data.length;j++) {
				if(data[i] < data[j]) {
					int w = data[i] ;
					data[i] = data[j] ;
					data[j] = w ;
				}
			}
		}

		//並べ替え後を表示
		System.out.println("並べ替え後");
		hyouji(data);

	}

	void hyouji(int[] data) {
		for(int i = 0;i < data.length;i++) {
			System.out.print(" "+data[i]);
		}
		System.out.println();
	}

}
