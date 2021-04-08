package com.hatenablog.tbsten;

import static java.awt.Color.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
/**
 * 2021/4/8現在では非推奨のゲームウィンドウ。
 *
 * @author TBSten
 *
 */

public class GameWindowPixel extends GameWindow2DArray {

	public static void main(String[] args) {
		int[][] map = new int[100][100] ;
		map[5][5] = 1 ;
		GameWindowPixel gw = new GameWindowPixel(map) ;

	}



	int size = 2 ;
	Canvas cp ;

	ObjectToColor o2c = (ob)->{
		if(ob instanceof Integer && ((int)ob) == 0 )  {
			return BLACK ;
		}else if(ob instanceof Integer && ((int)ob) == 1 )  {
			return RED ;
		}else if(ob instanceof Integer && ((int)ob) == 2 )  {
			return BLUE ;
		}
		return BLACK;
	};

	public GameWindowPixel(Object map) {
		super(map);
		this.cp = new Canvas();
		this.setContentPane(this.cp);

		JFrame sizeSetter = new JFrame("サイズ");
		JLabel title = new JLabel("サイズ変更");
		sizeSetter.add(title,BorderLayout.NORTH);
		JSlider sl = new JSlider(1,30);
		sl.setValue(this.size);
		sl.setMajorTickSpacing(10);
		sl.setMinorTickSpacing(1);
		sl.setPaintTicks(true);
		sl.setSnapToTicks(true);
		sl.addChangeListener((e)->{
			int v = sl.getValue() ;
			this.size = v ;
			this.repaint();
		});
		sizeSetter.add(sl);
		sizeSetter.setSize(200,100);
		sizeSetter.setVisible(true);
	}

	@Override public int getFps() {
		System.out.println(this.map);
		if(this.map != null ) {
			Object[][] map = obTo2DArr(this.map);
			return 1*map.length * map[0].length/90 ;
		}else {
			return 200 ;
		}
	}

	@Override public void reload(Container con) {
		if(this.map != null && cp != null) {
			Object[][] map = obTo2DArr(this.map);
			for(int y = 0;y < map.length ;y++) {
				for(int x = 0;x < map[y].length ;x++) {
					final int Y = y ;
					final int X = x ;
					//(x*size,y*size,size,size)で描画
					cp.addDraw((c,g)->{
						g.setColor(o2c.obToColor(map[Y][X]));
						g.fillRect(X*size,Y*size,size,size);
					});
				}
			}
		}
	}

	static interface ObjectToColor{
		public Color obToColor(Object ob) ;
	}

}
