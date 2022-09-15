
//lab 10
/*Створити програму для малювання точок на екрані. Координати точок
  програма зчитує із INPUT.txt  файлу. Малює ці точки на екрані.
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class MainClass extends Frame implements ActionListener{
	Scanner sc;
	int x;
	int y;
	
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
		
		
		Button button = new Button("Намалювати Точку");
        button.setBounds(960, 320, 300, 100);
        button.addActionListener(this);
        add(button);
        
        
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillOval(x, y, 10, 10);
	}
	 
    @Override
	public void actionPerformed(ActionEvent ev){
		File file = null;
		
		try{
			file = new File("INPUT.txt");
			sc = new Scanner(file);
			int state = 0;
			
			while (sc.hasNextInt()){
				if (state==0){
					x = sc.nextInt();
				} else{
					y = sc.nextInt();
					paint(this.getGraphics());
				}
				state = state==0?1:0;
			}
			
		} catch (Exception e){
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args){
		new MainClass("Java IO", 1280, 720);
	}
}
