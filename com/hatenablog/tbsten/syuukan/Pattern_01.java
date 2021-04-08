package com.hatenablog.tbsten.syuukan;

/*
 * No 9
 * lv 4(/5)。
 * 「〇/〇〇+〇/〇〇+〇/〇〇 = 1」が成り立つように〇に1～9の数字を当てはめる。
 * */
public class Pattern_01 {

	public static void main(String[] args) {
		new Pattern_01() ;
	}

	Pattern_01(){
		loop(-1,1);
	}

	int brankCnt = 9 ;
	int[] brank = new int[brankCnt] ;
	void loop(int bIdx,int i) {
		if(bIdx >= 0 && bIdx < brankCnt) {
			brank[bIdx] = i ;
		}
		if(bIdx < brankCnt) {
			if(bIdx+1 < brankCnt) {
				for(int n = 1;n <= 9;n++) {
					loop(bIdx+1,n);
				}
			}else {
				int bunbo = (brank[1]*10+brank[2]) *(brank[4]*10+brank[5]) *(brank[7]*10+brank[8])  ;
				int bunsi = 0 ;
				for(int a = 0;a < 3;a++) {
					int motoBunbo =(brank[a*3+1]*10+brank[a*3+2]) ;
					bunsi += brank[a*3]*(bunbo / motoBunbo) ;
				}
				if(bunsi == bunbo) {
					hyoji(brank);
				}
			}
		}



	}

	void hyoji(int[] arr) {
		String str = "" ;
		for(int i = 0;i < 3;i++) {
//			str += arr[i*3]+"/"+arr[i*3+1]+arr[i*3+2];
			str += String.format("%2d/%2d", arr[i*3], arr[i*3+1]*10+arr[i*3+2] );
			if(i != 2) {
				str+=" +" ;
			}
		}
		System.out.println(str);
	}

}
