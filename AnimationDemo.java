package animation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class AnimationDemo {
       public static void main(String[] args) throws InterruptedException  {
		 new FontDemo();
	
	}
}

class FontDemo extends Frame {
	 
	int x=50,y=50;
	Boolean xbool=true,ybool=true,exit1=false;
	Checkbox cb = new Checkbox("Click to Exit");
	Label lbl = new Label("Click in the box to change the position of the ball");
	ImageIcon img = new ImageIcon("C:\\Users\\nambu\\Desktop\\Creativity\\depositphotos_11495188-stock-illustration-soccer-ball.jpg");
	Image newImage =  img.getImage().getScaledInstance(25,25, Image.SCALE_SMOOTH);
	ImageIcon wallimg = new ImageIcon("C:\\Users\\nambu\\Desktop\\Creativity\\cartoon-brick-wall-texture-seamless-260nw-1898334841.jpg");
	Image wall = wallimg.getImage().getScaledInstance(10,425, Image.SCALE_SMOOTH);
	Image wall2 = wallimg.getImage().getScaledInstance(425,10, Image.SCALE_SMOOTH);
	FontDemo() throws InterruptedException {
		super ("Colour, Font, Paint Demo");
		setLayout(null);
		setVisible(true);
		setSize(525,525);
		add(cb);
		add(lbl);
		cb.setBounds(235,30,100,20);
		lbl.setBounds(150, 485, 300, 20);
		cb.addItemListener((ItemEvent ie)->{
			exit1=cb.getState();
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int dupx=me.getX();
				int dupy=me.getY();
				if(dupx>=50 && dupx<=450 && dupy>=50 && dupy<=450) {
					x=dupx;
					y=dupy;  }
			}
		});
		
		
		while(true) {
			if(xbool) x++;
			else x--;
			
			if(ybool) y++;
			else y--;
			
			if(x==450) xbool=false;
			if(x==50) xbool=true;
			if(y==450) ybool=false;
			if(y==50)  ybool=true;
			repaint();
			Thread.sleep(5);
			if(exit1)
				System.exit(0);
		}
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(newImage, x, y, cb);
		g.drawImage(wall, 50, 50, cb);
		g.drawImage(wall2,50, 475, cb);
		g.drawImage(wall2, 50, 50, cb);
		g.drawImage(wall, 475, 50, cb);
	
	}


}
/*

//g.setColor(Color.BLUE);
	//	g.drawOval(x, y, 25, 25);
g.drawLine(50, 50,475,50);
g.drawLine(50,475,475,475);
g.drawLine(50, 50,50,475);
g.drawLine(475,50,475,475);  */