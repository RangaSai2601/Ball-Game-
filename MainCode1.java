
import java.awt.*;
import java.awt.event.*;

public class MainCode1 {
       public static void main(String[] args) throws InterruptedException  {
		FontDemo fd = new FontDemo();
	
	}
}

class FontDemo extends Frame {
	 
	int x=50,y=50;
	Boolean xbool=true,ybool=true,exit1=false;
	Checkbox cb = new Checkbox("Click to Exit");
	Label lbl = new Label("Click in the box to change the position of the ball");
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
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 25, 25);
		g.drawLine(50, 50,475,50);
		g.drawLine(50,475,475,475);
		g.drawLine(50, 50,50,475);
		g.drawLine(475,50,475,475);
		
	}


}
