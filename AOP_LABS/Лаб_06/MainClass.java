//lab 6
/*У вікні додатка намалювати правильний шестикутник, розмістити три 
  кнопки «залити фігуру червоним», «залити фігуру жовтим», «скасувати»
  та реалізувати їх функції.
*/

import java.awt.*;
import java.awt.event.*;

class MainClass extends Frame implements ActionListener{
	Button fillItRed;
	Button fillItYellow;
	Button cancel;
	int state = 3;
	Polygon hexagon = new Polygon(new int[] {600, 753, 1059, 1212, 1059, 753}, new int[] {360, 95, 95, 360, 625, 625}, 6);
	
 	MainClass(String s, int w, int h){
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
		
		//Стандартний шрифт
        Font font = new Font("Times New Roman", 0, 28);
        setFont(font);
		
		//Червоний
		fillItRed = new Button("залити фігуру червоним");
		fillItRed.addActionListener(this);
		fillItRed.setBounds(110, 135, 380, 60);
		add(fillItRed);
		
		//Жовтий
		fillItYellow = new Button("залити фігуру жовтим");
		fillItYellow.addActionListener(this);
		fillItYellow.setBounds(110, 330, 380, 60);
		add(fillItYellow);
		
		//Порожній
		cancel = new Button("скасувати");
		cancel.addActionListener(this);
		cancel.setBounds(110, 525, 380, 60);
		add(cancel);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fillItRed){
			state = 1;
			repaint();
        }
        if(e.getSource() == fillItYellow){
			state = 2;
			repaint();
		}
		if(e.getSource() == cancel){
			state = 3;
			repaint();
		}
    }
    
    public void paint(Graphics g){
		switch (state){
			case 1: g.setColor(Color.RED);
					g.fillPolygon(hexagon);
					break;
			case 2: g.setColor(Color.YELLOW);
					g.fillPolygon(hexagon);
					break;
			case 3: g.drawPolygon(hexagon);
					break;
		}
	}
	
	public static void main(String[] args){
		new MainClass("Шестикутник", 1280, 720);
	}
}
