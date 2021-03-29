package com.hatenablog.tbsten;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	ArrayList<Draw> draws = new ArrayList<>();

	public void addDraw(Draw d) {
		draws.add(d);
		setOpaque(false);
	}

	@Override public void paint(Graphics g) {
		super.paint(g);
		for(Draw d:draws) {
			d.draw(this, g);
		}
	}

	static interface Draw {
		public void draw(Component com,Graphics g) ;
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Canvas can = new Canvas();
		f.add(can);
		can.addDraw((c,g)->{
			g.setColor(Color.RED);
			g.drawRect(20, 20, 80, 80);
		});
		f.setVisible(true);
	}
}
