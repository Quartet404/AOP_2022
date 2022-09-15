//lab 8
/*Cтворити меню програми з «гарячими» клавішами, в ньому додати три
  пункти: «намалювати багатокутник», «намалювати квадрат», 
  «намалювати коло» та реалізувати їх функції.
*/

import java.awt.*;
import java.awt.event.*;

class MainClass extends Frame implements ActionListener{
    MenuItem polygon;
    MenuItem square;
    MenuItem oval;
    MenuItem clear;
    
    int state;
    
    public MainClass(String s, int w, int h){
        super(s);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		setSize(w, h);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent ev){ 
				System.exit (0);
			}
		}); 
        
        MenuBar bar = new MenuBar();
        setMenuBar(bar);
        
        Menu menu = new Menu("Намалювати");
        bar.add(menu);
        
        polygon = new MenuItem("Намалювати багатокутник", new MenuShortcut(KeyEvent.VK_1));
        polygon.addActionListener(this);
        menu.add(polygon);
        
        square = new MenuItem("Намалювати квадрат", new MenuShortcut(KeyEvent.VK_2));
        square.addActionListener(this);
        menu.add(square);
         
        oval = new MenuItem("Намалювати коло", new MenuShortcut(KeyEvent.VK_3));
        oval.addActionListener(this);
        menu.add(oval);
        
        menu.addSeparator();
        
        clear = new MenuItem("Очистити", new MenuShortcut(KeyEvent.VK_4));
        clear.addActionListener(this);
        menu.add(clear);
        
    }

    @Override
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == polygon){
			state = 1;
        }
        if(e.getSource() == square){
			state = 2;
		}
		if(e.getSource() == oval){
			state = 3;
		}
		if(e.getSource() == clear){
			state = 4;
		}
		repaint();
    }
	
	public void paint(Graphics g){
		switch (state){
			case 1: g.drawPolygon(new int[] {100, 250, 300, 350, 500, 350, 300, 250}, new int[] {300, 250, 100, 250, 300, 350, 500, 350}, 8);
					break;
			case 2: g.drawRect(100, 100, 400, 400);
					break;
			case 3: g.drawOval(100, 100, 400, 400);
					break;
		}
	}
	
    public static void main(String[] args){
        new MainClass("Меню Java", 600, 600);
    }
}
