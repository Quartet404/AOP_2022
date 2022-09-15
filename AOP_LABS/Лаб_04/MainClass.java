//lab 4

/* У вікні додатка розмістити три фігури: еліпс червоного кольору,
   прямокутний трикутник жовтого кольору, рівнобічну трапецію синього
   кольору. Створити напис біля кожної фігури, який містить інформацію 
   про її назву та колір. Напис повинен мати наступні характеристики:
   розмір 16пт, колір темно-сірий, курсив.
*/

import java.awt.*;
import java.awt.event.*; 

class MainClass extends Frame{
	MainClass(String s, int w, int h){
		super (s);
		setSize(w, h);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent ev){ 
				System.exit (0);
			}
		}); 
	}
	
	public void paint(Graphics g){
		setBackground(new Color(240, 240, 240));
		Font font = new Font("Ubuntu", Font.ITALIC, 16);
		g.setFont(font);
		
		int[] xTriangle = {150, 150, 250};
		int[] yTriangle = {418, 318, 418};
		Polygon triangle = new Polygon(xTriangle, yTriangle, 3);
		
		int[] xTrapezoid = {125, 160, 240, 275};
		int[] yTrapezoid = {602, 502, 502, 602};
		Polygon trapezoid = new Polygon(xTrapezoid, yTrapezoid, 4);
		
		g.setColor(Color.darkGray);
		g.drawString("Еліпс червоного кольору", 400, 184);
		g.drawString("Прямокутний трикутник жовтого кольору", 400, 368);
		g.drawString("Рівнобічна трапеція синього кольору", 400, 552);
		
		g.setColor(Color.red);
		g.fillOval(125, 134, 150, 100);
		
		g.setColor(Color.yellow);
		g.fillPolygon(triangle);
		
		g.setColor(Color.blue);
		g.fillPolygon(trapezoid);
		
	}
	
	public static void main(String[] args){ 
		new MainClass("Три фігури", 1280, 720);
	}
} 
