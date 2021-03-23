package com.hatenablog.tbsten;

import java.awt.Container;
import java.lang.reflect.Array;

public class GameWindow1DArray extends GameWindow2DArray {
	Object arr ;
	Object xArr ;
	Object yArr ;
	int gameWidth ;
	int gameHeight ;
	public GameWindow1DArray(Object arr,Object xArr,Object yArr,int gameWidth ,int gameHeight){
		super(new Object[gameHeight][gameWidth]);
		this.arr = arr ;
		this.xArr = xArr ;
		this.yArr = yArr ;
		this.gameWidth = gameWidth ;
		this.gameHeight = gameHeight ;
	}
	@Override public void reload(Container con) {
		if(this.arr != null && this.xArr != null && this.xArr != null ) {
			//arrをもとにmapを書き換え
			Object[] arr = obTo1DArr(this.arr) ;
			Object[] xArr = obTo1DArr(this.xArr) ;
			Object[] yArr = obTo1DArr(this.yArr) ;
//			Object[][] rmap = obTo2DArr(new Object[gameHeight][gameWidth]) ;

		//	System.out.println();
			for(int y = 0;y < gameHeight;y++) {
				for(int x = 0;x < gameWidth;x++) {
					((Object[][])(this.map))[y][x] = "" ;
					for(int i = 0;i < arr.length;i++) {
						boolean w = new Integer(x).equals(xArr[i]) && new Integer(y).equals(yArr[i]) ;
						if( w && this.map != null) {
							((Object[][])(this.map))[y][x] = arr[i] ;
//							System.out.printf("(%d,%d)に%s\n",x,y,arr[i]);
						}

					}
//					System.out.printf("%5s",String.valueOf(map[y][x]));
				}
//				System.out.println();
			}
		}
		super.reload(con);

	}
	//obを1次元配列にして返す
	private static Object[] obTo1DArr(Object ob){
		int length = Array.getLength(ob);
		Object[] ans = new Object[length];
		for(int i = 0;i < length;i++) {
			ans[i] = Array.get(ob, i);
		}
		return ans ;
	}

	/*
	public static void main(String[] args){
		int[] arr = {0,1,1,1,1,1} ;
		int[] xArr = {0,1,2,3,4,5} ;
		int[] yArr = {0,1,1,1,2,2} ;
		int cnt = 6 ;
		int d = 0 ;
		GameWindow1DArray gw = new GameWindow1DArray(arr,xArr,yArr,10,10) ;
		gw.setPrint(-1,"×");
		gw.setPrint(-2,"");
		while(true) {

			if(gw.mouseX != -1) {
				for(int i = 0;i < cnt;i++) {
					if(xArr[i] == gw.mouseX && yArr[i] == gw.mouseY ) {
						arr[i] = -1 ;
					}
				}
				gw.mouseX = -1 ;
				gw.mouseY = -1 ;
			}

			//移動タイミングなら
			if(d%120 == 0) {

			}
			sleep(1);
		}
	}
	*/
}
