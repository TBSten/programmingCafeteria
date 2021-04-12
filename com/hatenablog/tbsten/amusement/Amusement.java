package com.hatenablog.tbsten.amusement;

public class Amusement {

	public static void main(String[] args) {
		new Amusement();
	}



	/*
	 * placeCntこのアトラクションの中からcntこ選んで最大のhappinessになる組み合わせを探す。
	 */
	String[] name = {"A","B","C","D"} ;
	int[] happiness = {30,10,10,12} ;
	int cnt = 3 ;
	int placeCnt = name.length ;
	int[] maxArr = {-1,-1,-1} ;
	int[] workArr = new int[cnt] ;
	Amusement(){
		init() ;

		loop(-1,-1) ;

		for(int i = 0;i < cnt;i++) {
			workArr[i] = happiness[ maxArr[i] ] ;
		}

		hyoji(workArr);
	}
	void init(){
		//
	}
	void loop(int a,int b) {
		if(a < cnt) {
			if(a >= 0){
				//現在位置を保存
				workArr[a] = b ;
			}
			if(a+1 < cnt) {
				//次の地点が範囲内
				for(int i = b+1;i < placeCnt;i++) {
					loop(a+1,i);
				}
			}else {
				//次の地点が範囲外
				int maxHappiness = 0 ;
				int workHappiness = 0 ;
				for(int i = 0;i < cnt;i++) {
					if(maxArr[i] >= 0) {
						maxHappiness += happiness[maxArr[i]] ;
					}
					workHappiness += happiness[workArr[i]] ;
				}
				if(maxHappiness <= workHappiness) {
					for(int i = 0;i < cnt;i++) {
						maxArr[i] = workArr[i] ;
					}
				}

			}
		}else {
			//現在位置が範囲外（たぶんないけど）
		}
	}
	void hyoji(int[] arr) {
		System.out.println("幸福度が最大の組み合わせ:");
		for(int i = 0;i < arr.length;i++) {
			System.out.printf("%3d ",arr[i]);
		}
		System.out.println();
	}
}

