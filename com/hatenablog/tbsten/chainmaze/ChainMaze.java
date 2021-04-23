package com.hatenablog.tbsten.chainmaze;

import java.awt.Color;

import com.hatenablog.tbsten.GameWindow2DArray;
import com.hatenablog.tbsten.Games;

public class ChainMaze {

	public static void main(String[] args) {
		new ChainMaze();
	}

	int WIDTH = 15 ;
	int HEIGHT = 10 ;
	int mx = 0 ;
	int my = HEIGHT -1 ;
	int ex = WIDTH -1 ;
	int ey = 0 ;
	int[][] map ;
	int flg = 0 ;
	int time = 0 ;
	GameWindow2DArray gw ;
	ChainMaze(){
		init();

		int wy = my ;
		//mapなどの初期化処理
		for(int x = 0;x < WIDTH;x++) {
			for(int y = 0;y < HEIGHT;y++) {
				map[y][x] = Games.random(1, 6)*5 ;
			}
			map[wy][x] = Games.random(0, 2)*2+1;
			int d = Games.random(0, 2)*2-1 ;
			if(wy + d < HEIGHT) {
				wy = wy + d ;
			}else {
				wy = wy - d ;
			}
			map[wy][x] = Games.random(0, 2)*2+1;
		}
		map[my][mx] = Games.random(1, 3)*5 ;
		map[ey][ex] = Games.random(1, 5)*(WIDTH*HEIGHT);

		gw.message("ゲームスタート");
		//ゲームループ
		while(flg == 0) {
			if(gw.mouseX != -1) {
				if( onSide(gw.mouseX ,gw.mouseY) == 1 && map[my][mx] > map[gw.mouseY][gw.mouseX] ) {
					map[gw.mouseY][gw.mouseX] += map[my][mx] ;
					map[my][mx] = 0 ;
					mx = gw.mouseX ;
					my = gw.mouseY ;
				}
				gw.mouseX = -1 ;
			}
			if(mx == ex && my == ey) {
				flg = 1 ;
			}
			if(time%3000 == 0) {
				for(int yy = -1;yy <= 1;yy++) {
					for(int xx = -1;xx <= 1;xx++) {
						if(onSide(mx+xx,my+yy)==1 && mx+xx >= 0 && mx+xx < WIDTH && my+yy >=0 && my+yy < HEIGHT) {
							map[my+yy][mx+xx] /= 2 ;
						}
					}
				}
			}
			Games.sleep(1);
			time += 1 ;
		}
		int score = Math.max(60-time/1000, 0)*map[my][mx] ;
		gw.message(time/1000+"秒かかって"+map[my][mx]+"ポイント==>>"+score);
		gw.close();

	}

	public void init() {
		map = new int[HEIGHT][WIDTH] ;
		gw = new GameWindow2DArray(map) ;
		gw.setLabelOption((x,y,label)->{
			if(onSide(x,y) == 1 && map[my][mx] > map[y][x] ) {
				label.setBackground(new Color(70,70,190));	//120
			}else if(x == mx && y == my) {
				label.setBackground(new Color(255,70,70));	//185
			}else if(x == ex && y == ey){
				label.setBackground(new Color(20,90,20));	//70

			}else{
				label.setBackground(Color.BLACK);
			}
		});
	}




	public int onSide(int x,int y) {
		if((x == mx -1 && y == my) || (x == mx +1 && y == my) || (x == mx && y == my -1) || (x == mx && y == my +1) ) {
			return 1 ;
		}else {
			return 0 ;
		}
	}

}
