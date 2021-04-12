package com.hatenablog.tbsten.mankara;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.hatenablog.tbsten.GameWindow2DArray;

public class MankaraWindow extends GameWindow2DArray {

	int[] arr ;
	JLabel[] labels = new JLabel[14] ;
	public MankaraWindow(int[] arr) {
		super(null);
		this.arr = arr ;
		for(int i = 0;i < labels.length ;i++) {
			labels[i] = new JLabel(""+arr[i]) ;
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			labels[i].setBackground(Color.BLACK);labels[i].setOpaque(true);
			labels[i].setForeground(Color.WHITE);
			labels[i].setBorder(new LineBorder(Color.WHITE,3,false));
			class MyLis extends MouseAdapter{
				int num ;
				MyLis(int i ){
					this.num = i ;
				}
				@Override public void mouseClicked(MouseEvent e) {
					MankaraWindow.this.mouse = this.num+"" ;
				}
			}
			labels[i].addMouseListener(new MyLis(i));
			this.add(labels[i]);
		}
		Container cp = this.getContentPane() ;
		Dimension sz = new Dimension(cp.getWidth(),cp.getWidth()/8*2) ;
		cp.setMinimumSize(sz);
		cp.setMaximumSize(sz);
		cp.setPreferredSize(sz);
		pack();
	}

	@Override
	public void reload(Container con) {
		int width = getContentPane().getWidth() ;
		int height = width *2/8 ;
		int aw = width / 8 ;
		int ah = height / 2 ;
		//arrをもとに配置
		if(arr != null && arr.length == 14 && labels[13] != null) {
			for(int i = 0;i < labels.length ;i++) {
				//位置調整
				if(i == 0) {
					labels[i].setBounds(0,0,aw,height);
				}else if(i < 7) {
					labels[i].setBounds(i*aw,0,aw,ah);
				}else if(i == 7) {
					labels[i].setBounds(i*aw,0,aw,height);
				}else {
					labels[i].setBounds((14-i)*aw,ah,aw,ah);
				}
				labels[i].setText(arr[i]+"");
//				labels[i].setFont();
			}
		}

	}

	public void setColor(int i,Color c,int time) {
		if(labels[i] != null) {
			Border before = labels[i].getBorder();
			labels[i].setBorder(new LineBorder(c,3,false));
			Timer t = new Timer(time,(e)->{
				labels[i].setBorder(before);
			}) ;
			t.setRepeats(false);
			t.start();
		}
	}

}
