package com.hatenablog.tbsten.tennis;

import com.hatenablog.tbsten.GameWindow2DArray;

public class Tennis {

	public static void main(String[] args) {
		new Tennis() ;
	}

	int[][] d ;
	GameWindow2DArray gw ;
	int flg = 0 ;
	int bx ;
	int by ;
	int mx ;
	int my ;
	int ex ;
	int ey ;
	int t = 0 ;
	int dx ;
	int dy ;
	int racket ;
	int s = 1 ;
	int mmode = 1 ;
	int emode = 1 ;
	Tennis(){
		init() ;

		gw.message("クリックしてスタート");

		d[by][bx] = 10 ;
		while(flg == 0) {
			//キーボード入力
			if(!gw.key.equals("")) {
				if(gw.key.equals("左") && 0 <= mx-1 && mx-1 <= 20 - racket) {
					mx -- ;
				}else if(gw.key.equals("右") && 0 <= mx+1 && mx+1 <= 20 - racket) {
					mx ++ ;
				}else if(gw.key.equals("スペース")) {
					mmode = (mmode)%2+1;
				}
				gw.key = "" ;
			}
			//敵の移動
			teki() ;
			//ボールの移動と当たり判定
			if(t%Math.max(20-s,1) == 0) {
				int wx = bx ;
				int wy = by ;
				d[by][bx] = 0 ;
				bx += dx ;
				by += dy ;
				//bx,byが壁
				if(bx < 0 || bx >= 20) {
					bx = wx ;
					by = wy ;
					dx = dx * -1 ;
				}
				//bx,byが■
				if(bx >= 0 && bx < 20 && by >= 0 && by < 30 && (d[by][wx] == mmode || d[by][wx] == emode) ) {
					if(d[by][wx] == mmode && mmode == 2 || d[by][wx] == emode && emode == 2) {
						s = s * 12 / 10 ;
					}
					bx = wx ;
					by = wy ;
					dy = dy * -1;
					s++;
				}
				//bx,byが範囲外
				if(by < 0 || by >= 30) {
					if(by < 0) {
						//敵のゲームオーバー
						flg = 1 ;
					}else {
						//自分がゲームオーバー
						flg = 2 ;
					}
				}
				if(bx >= 0 && bx < 20 && by >= 0 && by < 30) {
					d[by][bx] = 10 ;
				}
			}
			//敵と自分の描画
			for(int i = 0;i < 20;i++) {
				if(i >= mx && i < mx+racket) {
					d[28][i] = mmode ;
				}else {
					d[28][i] = 0 ;
				}
				if(i >= ex && i < ex+racket) {
					d[1][i] = emode ;
				}else {
					d[1][i] = 0 ;
				}

			}
			gw.sleep(1000/80);
			t++ ;
		}
		if(flg == 1) {
			gw.message("勝利！");
		}else {
			gw.message("敗北...");
		}
		gw.close();

	}
	void init() {
		d = new int[30][20] ;
		gw = new GameWindow2DArray(d) ;
		gw.setSize(530,600);
		gw.setLocationRelativeTo(null);
		gw.setPrint(0, "");
		gw.setPrint(1, "□");
		gw.setPrint(2, "■");
		gw.setPrint(10, "〇");
		gw.setPrint((o)->{
			if(o instanceof Integer) {
				int i = (int)o ;
				if(i < 10) {
					return "一"+(i%10) ;
				}else if(i <= 20) {
					return "二"+(i%10) ;
				}
			}
			return null ;
		});
		mx = 1 ;
		my = 28 ;
		ex = 1 ;
		ey = 1 ;
		bx = 20/2 ;
		by = 30/2 ;
		dx = 2 ;
		dy = 1 ;
		racket = 5 ;
	}
	void teki() {
		if(t%5 == 0) {
			int w = Math.max(0, Math.min(bx-racket/2, 20-racket)) ;
			if(dy < 0) {
				ex += (int)Math.signum(w-ex) ;
			}else {
				w = 20 - w ;
				ex += (int)Math.signum(w-ex) ;
			}
		}
		if(t%240 == 0) {
			emode = (emode-1+1)%2+1;

		}
	}

}
