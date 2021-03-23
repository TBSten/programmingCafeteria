package com.hatenablog.tbsten.moguratataki;

import com.hatenablog.tbsten.GameWindow1DArray;

public class Moguratataki {

	public static void main(String[] args) {
		new Moguratataki() ;
	}

	GameWindow1DArray gw ;
	int size ;
	int[] mogura ;
	int[] x ;
	int[] y ;
	int cnt ;
	int gameFlg ;
	int time ;
	int hitCnt ;
	int s ;
	void init() {
		size = 8 ;
		cnt = 12 ;
		mogura = new int[cnt] ;
		x = new int[cnt] ;
		y = new int[cnt] ;
		for(int i = 0;i < cnt;i++) {
			mogura[i] = 1 ;
			x[i] = -1 ;
			y[i] = -1 ;
		}
		gw = new GameWindow1DArray(mogura,x,y,size,size) ;
		gw.setPrint(1,"モ");
		gw.setPrint(0,"×");
		gameFlg = 0 ;
		time = 0 ;
		s = size * 12 ;

		gw.message("クリックしてスタート");
	}
	Moguratataki(){
		init() ;
		while(gameFlg == 0) {
			if(gw.mouseX != -1) {
				//mouse入力時
				for(int i = 0;i < cnt;i++) {
					if(mogura[i] > 0 && gw.mouseX == x[i] && gw.mouseY == y[i]) {
						mogura[i] = 0 ;
						hitCnt ++ ;
						s -= size/12 ;
					}
				}
				gw.mouseX = -1 ;
			}

			//移動タイミング
			if(time % (60 * s/100) == 0) {
				for(int i = 0;i < cnt;i++) {
					if(mogura[i] > 0) {
						x[i] = gw.random(0, size);
						y[i] = gw.random(0, size);
					}
				}
			}
			gw.sleep(1000/60);
			time++;
			if(hitCnt == cnt) {
				gameFlg = 1 ;
			}
		}
		gw.sleep(100);
		gw.message("クリア");
		gw.close();
	}

}
