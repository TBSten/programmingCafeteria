package com.hatenablog.tbsten;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 * 2次元配列を受け取り、その内容を表示するウィンドウ。
 * マウス入力・キーボード入力も受け付け、入力された内容をそれぞれmouseとkeyに保持する。
 * 2次元配列の配列順はY座標,X座標の順で指定する。
 *
 * @author TBSten
 *
 */
public class GameWindow2DArray extends JFrame implements LayoutManager2{

	protected Object map ;
	public String mouse = "";
	public int mouseX = -1 ;
	public int mouseY = -1 ;
	public String key = "";
	protected JPanel cp ;
	protected JLabel[][] label = null ;
	private Map<Object,String> outputStr = new HashMap<>();
	private ObjectToString outputOts = null ;

	public GameWindow2DArray(Object map){
		super("ゲーム");
		this.map = map ;

		this.cp = (JPanel)getContentPane() ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		cp.setLayout(this);
		setLocationRelativeTo(null);
		addKeyListener(new KeyAdapter() {
			@Override public void keyPressed(KeyEvent e) {
				key = KeyEvent.getKeyText(e.getKeyCode());

				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
				}
			}
		});


		ActionListener tp = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			//	System.out.println("repaint");
				revalidate();
			    repaint();
			  }
		} ;
		System.out.println(getFps());
		new Timer(getFps(),tp).start();

		setVisible(true);
	}

	//配列の中身がobjectのとき、strを表示します
	public void setPrint(Object object, String str) {
		outputStr.put(object, str) ;
	}
	public void setPrint(ObjectToString ots) {
		outputOts = ots ;
	}

	public void message(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public void close() {
		dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
	}

	public int getFps() {
		return 200 ;
	}


	//obを2次元配列にして返す
	protected static Object[][] obTo2DArr(Object ob){
		int length = Array.getLength(ob);
		Object[][] ans = new Object[length][];
		for(int i = 0;i < length;i++) {
			int l2 = Array.getLength(Array.get(ob, i));
			ans[i] = new Object[l2] ;
			for(int j = 0;j < l2;j++) {
				ans[i][j] = Array.get(Array.get(ob, i), j);
			}
		}
		return ans ;
	}

	public static void sleep(long millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//a以上b以上の乱数
	public static int random(int a,int b) {
		return (int)(Math.random() * (b-a) +a) ;
	}

	@Override
	public void repaint() {
		super.repaint();
	}
	@Override
	public void paint(Graphics g) {
	//	System.out.println("paint");
		reload(cp);
		super.paint(g);
	}


	@Override
	public void addLayoutComponent(String name, Component comp) {}
	@Override
	public void removeLayoutComponent(Component comp) {}
	@Override
	public Dimension preferredLayoutSize(Container parent) {return parent.getSize();}
	@Override
	public Dimension minimumLayoutSize(Container parent) {return parent.getSize();}
	@Override
	public void addLayoutComponent(Component comp, Object constraints) {}
	@Override
	public Dimension maximumLayoutSize(Container target) {return target.getSize();}
	@Override
	public float getLayoutAlignmentX(Container target) {return 1f;}
	@Override
	public float getLayoutAlignmentY(Container target) {return 1f;}
	@Override
	public void invalidateLayout(Container target) {
	//	System.out.println("invalidate");
		layoutContainer(target);
	}
	@Override
	public void layoutContainer(Container parent) {
	//	System.out.println("layout");
		reload(parent);
	}
	public void reload(Container parent) {

		if(this.map != null) {
			Object[][] map = obTo2DArr(this.map);
			int onesize = Math.min(parent.getWidth() / map.length, parent.getHeight() / map[0].length) ;
			if(label == null ) {
				class MyLis extends MouseAdapter{
					int mx ;
					int my ;
					MyLis(int x,int y){
						this.mx = x ;
						this.my = y ;
					}
					@Override public void mousePressed(MouseEvent e) {
						JLabel sou = ((JLabel)e.getSource()) ;
						sou.setBackground(Color.WHITE);
						sou.setForeground(Color.BLACK);
					}
					@Override public void mouseReleased(MouseEvent e) {
						JLabel sou = ((JLabel)e.getSource()) ;
						sou.setBackground(Color.BLACK);
						sou.setForeground(Color.WHITE);
					}
					@Override public void mouseClicked(MouseEvent e) {
						mouseX = this.mx;
						mouseY = this.my;

						switch(e.getButton()) {
						case MouseEvent.BUTTON1:
							mouse = "左" ;
							break ;
						case MouseEvent.BUTTON2:
							mouse = "ホイール" ;
							break ;
						case MouseEvent.BUTTON3:
							mouse = "右" ;
							break ;
						default :
							mouse = "それ以外" ;
						}
					}
				}
				label = new JLabel[map.length][];
				for(int y = 0;y < map.length;y++) {
					label[y] = new JLabel[map[y].length] ;
					for(int x = 0;x < map[y].length;x++) {
						label[y][x] = new JLabel("") ;
						label[y][x].setHorizontalAlignment(JLabel.CENTER);
						label[y][x].setVerticalAlignment(JLabel.CENTER);
						label[y][x].addMouseListener(new MyLis(x,y));
						parent.add(label[y][x]);

						label[y][x].setForeground(Color.WHITE);
						label[y][x].setBackground(Color.BLACK);

					}
				}
			}
			for(int y = 0;y < map.length;y++) {
				for(int x = 0;x < map[y].length;x++) {
				//	System.out.println(":::"+label[y][x]);
					label[y][x].setBounds(x*onesize,y*onesize,onesize,onesize);
					try {
						if(map[y][x] != null){
							if(outputStr.containsKey(map[y][x])) {
								label[y][x].setText(outputStr.get(map[y][x]));
							}else if(outputOts != null && outputOts.o2s(map[y][x]) != null){
								label[y][x].setText(outputOts.o2s(map[y][x]));
							}else {
								label[y][x].setText(map[y][x].toString());
							}
						}else {
						//	System.out.println("("+x+","+y+")にnullがはいってた");
							label[y][x].setText("");
						}
					}catch(Throwable t) {
						t.printStackTrace();
					}
					label[y][x].setBorder(new LineBorder(Color.WHITE,Math.max(1, onesize*3/50),false));
					label[y][x].setOpaque(true);


				}
			}
		}

	}




}
