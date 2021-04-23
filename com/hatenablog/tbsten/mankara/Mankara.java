package com.hatenablog.tbsten.mankara;

import java.awt.Color;

import com.hatenablog.tbsten.Games;

public class Mankara {

	public static void main(String[] args) {
		new Mankara() ;
	}

	MankaraWindow window ;
	int[] board ;
	int turn = 0 ;
	int flg = -1 ;
	Mankara(){
		init() ;

		while(flg == -1) {
			int nyu ;
			if(turn%2 == 0) {
				window.message("プレイヤーのターン");
				nyu = inputUser();
			}else {
				window.message("コンピュータのターン");
				nyu = inputEnemy() ;
			}

			//nyuの位置を選択
			move(nyu);

			//flgの操作
			int startIdx = (1-(turn%2))*7+1 ;
			int cnt = 0 ;
			for(int i = 0;i < 6;i++) {
				if(board[startIdx+i] > 0) {
					cnt ++;
				}
			}
			if(cnt == 0) {
				flg = turn%2 ;
			}
			turn ++ ;
			Games.sleep(1000);
		}
		if(flg == 0) {
			window.message("勝利");
		}else {
			window.message("敗北");
		}
		window.close();

	}
	public void move(int idx) {

		//idxから動かす
		int n = board[idx];
		board[idx] = 0 ;

		//500ミリ秒待機
		Games.sleep(500);

		for(int i = 1;i <= n;i++) {
			board[(idx+i)%14]++;

			//300ミリ秒待機
			Games.sleep(300);

		}
	}






	public void init() {
		board = new int[] {
				4,4,4,4,4,4,4,4,4,4,4,4,4,4
		} ;
		window = new MankaraWindow(board);
	}
	public int inputUser() {
		window.mouse = "" ;
		int intMouse = -1 ;
		while("".equals(window.mouse) || 8 > intMouse || 13 < intMouse || (intMouse >= 0 && board[intMouse] == 0) ) {	//キー入力がないか無効
			Games.sleep(1000/60);
			try {
				intMouse = Integer.parseInt(window.mouse);
			}catch(NumberFormatException e) {
				intMouse = -1 ;
			}
		}
		int ans =  Integer.parseInt( window.mouse );
		window.setColor(ans, Color.RED, 1000);

		window.mouse = "" ;
		return ans ;
	}
	private int enemy = 0 ;
	public int inputEnemy() {
		Games.sleep(1000);

		int ans ;
		do {
			ans = (enemy%6)+1 ;
			enemy ++ ;
		}while(board[ans] == 0 || ans >= 7 || ans <= 0);

		window.setColor(ans, Color.RED, 1000);
		return ans ;
	}

}
