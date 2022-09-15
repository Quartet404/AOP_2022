//lab 7
/*Створити проект, який буде мати дві форми. З використанням 
  компонентів TextField i Button створити першу форму, в яку потрібно
  буде ввести довжини трьох сторін трикутника. У другій формі
  відобразити значення площі та периметра  трикутника.
*/

import java.awt.*;
import java.awt.event.*;

class MainClass extends Frame implements ActionListener{
	TextField aField;
	TextField bField;
	TextField cField;
	
	double a,b,c;
        
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
		
		//Стандартний шрифт
		Font font = new Font("Times New Roman", 0, 28);
		setFont(font);
		
		aField = new TextField();
        aField.setBounds(35, 150, 265, 40);
        add(aField);
        
        bField = new TextField();
        bField.setBounds(35, 340, 265, 40);
        add(bField);
        
        cField = new TextField();
        cField.setBounds(35, 530, 265, 40);
        add(cField);
        
        Label text1 = new Label("Введіть довжину першої сторони", Label.LEFT);
        text1.setBounds(35, 110, 600, 40);
        add(text1);
        
        Label text2 = new Label("Введіть довжину другої сторони", Label.LEFT);
        text2.setBounds(35, 300, 500, 40);
        add(text2);
        
        Label text3 = new Label("Введіть довжину третьої сторони", Label.LEFT);
        text3.setBounds(35, 490, 600, 40);
        add(text3);
        
        Button button = new Button("Розрахувати");
        button.setBounds(550, 335, 250, 50);
        button.addActionListener(this);
        add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		a = Double.parseDouble(aField.getText());
		b = Double.parseDouble(bField.getText());
		c = Double.parseDouble(cField.getText());
		new Answer("Результат", a, b, c);
    }
	
	
	public static void main(String args[]){
		new MainClass("Калькулятор трикутників", 850, 700);
	}
}

class Answer extends Frame {
	public Answer(String s, double a, double b, double c){
		super(s);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		setSize(600, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent ev){ 
				dispose();
			}
		}); 
		
		//Стандартний шрифт
        Font font = new Font("Times New Roman", 0, 28);
        setFont(font);
        
        Label text1 = new Label("Периметр трикутника: " + perimetr(a, b, c), Label.LEFT);
        text1.setBounds(35, 100, 500, 40);
        
        Label text2 = new Label("Площа трикутника: " + area(a, b, c), Label.LEFT);
        text2.setBounds(35, 200, 500, 40);
        
        if (area(a,b,c) > 0){
			add(text1);
			add(text2);
		}
		else {
			text1.setText("Такого трикутника не існує");
			add(text1);
		}
        
	}
	
	private double perimetr(double a, double b, double c){
		return a + b + c;
	}
	
	private double area(double a, double b, double c){
		double p = (a + b + c)/2;
		return Math.sqrt(p*(p - a)*(p - b)*(p - c));
	}
}
