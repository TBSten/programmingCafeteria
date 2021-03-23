package com.hatenablog.tbsten.snakeblock;

import com.hatenablog.tbsten.GameWindow2DArray;

public class SnakeBlock {

	public static void main(String[] args) {
		new SnakeBlock() ;
	}

	GameWindow2DArray gw ;

	int[][] map = new int[10][10] ;
	int flg = 0 ;
	int[][] arr = {
			{0,0,0,0,2,0,2,0,0,0},
			{2,0,0,0,0,0,0,0,2,0},
			{0,0,2,2,2,0,0,0,0,0},
			{0,0,0,0,0,0,2,2,2,2},
			{0,0,0,0,0,2,2,2,2,2},
			{0,2,0,2,0,2,0,2,0,2},
	} ;
	int mx = 0 ;
	int my = 9 ;
	int d = 1 ;
	SnakeBlock(){
		init();
		map[my][mx] = 1 ;

		gw.message("ゲーム開始") ;

		while(flg == 0) {
			//キー入力を受け付ける
			if(!gw.key.equals("") ) {
				int bx = mx ;
				int nx = mx ;
				if(gw.key.equals("左")) {
					nx-- ;
				}else if(gw.key.equals("右")) {
					nx++ ;
				}
				if(nx >= 0 && nx < 10 && map[my][nx] == 0) {
					map[my][bx] = 0 ;
					mx = nx ;
					map[my][mx] = 1 ;
				}
				gw.key = "" ;
			}
			//壁を作成・ずらす処理
			if(d%10 == 0) {
				for(int y = 8;y >= 0;y--) {
					for(int x = 0;x < 10;x++) {
						//x,yをx,y+1に動かす処理
						if(map[y][x] == 2 ) {
							if(map[y+1][x] == 1) {
								//衝突
								flg = 1 ;
							}
						}
						if(map[y+1][x] != 1) {
							map[y+1][x] = map[y][x] ;
						}
					}
				}

				createTop();


			}


			d++ ;
			gw.sleep(1000/60);


		}
		gw.message("ゲームオーバー");
		gw.close();

	}
	//初期化
	void init() {
		gw = new GameWindow2DArray(map);
		gw.setPrint(0, "");
		gw.setPrint(1, "☆");
		gw.setPrint(2, "■");

	}

	void createTop() {
		if(d%20 == 0) {
			//次の壁を作る
			int type = gw.random(0, arr.length);
			for(int i = 0;i < 10;i++) {
				map[0][i] = arr[type][i];
			}
		}else if(d%2 == 0){
			for(int i = 0;i < 10;i++) {
				map[0][i] = 0 ;
			}
		}
	}


}
