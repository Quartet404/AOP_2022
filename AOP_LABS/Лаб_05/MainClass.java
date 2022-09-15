//lab 5

/* 
	Розробити програму, що реалізовує
	графічний інтерфейс користувача.
	Виконати завдання, номер якого співпадає
	з Вашим номером у списку.
 */

import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainClass extends Frame implements ActionListener{
	JButton url;
	
	MainClass(String s, int w, int h){
		super(s);
		setLayout(null);
		setBackground(new Color(253, 221, 194));
		setSize(w, h);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent ev){ 
				System.exit (0);
			}
		}); 
		
		//----------Заговолок----------
		Label title = new Label("Конвертація документів", Label.LEFT);
        title.setBounds(20, 40, 600, 40);
        title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
        title.setForeground(new Color(148, 54, 52));
        add(title);
        
        //Стандартний шрифт
        Font font = new Font("Times New Roman", 0, 28);
        setFont(font);
        
        //----------"Оберіть завдання"-----------
        Label text1 = new Label("Оберіть завдання:", Label.LEFT);
        text1.setBounds(40, 110, 600, 40);
        add(text1);
        
        //----------PDF Image---------
        Image pdf_img = new ImageIcon("pdf.png").getImage();
        getGraphics().drawImage(pdf_img, 235, 160, null);
        
        //----------PDF Text---------
        Label text2 = new Label("Конвертувати в PDF", Label.LEFT);
        text2.setBounds(350, 196, 600, 40);
        add(text2);
        
        //----------MS Word Image---------
        Image msw_img = new ImageIcon("MSWord.png").getImage();
        getGraphics().drawImage(msw_img, 235, 300, null);
        
        //----------MS Word Text---------
        Label text3 = new Label("Конвертувати в Microsoft Word", Label.LEFT);
        text3.setBounds(350, 336, 600, 40);
        add(text3);
        
        //----------MS Excel Image----------
        Image mse_img = new ImageIcon("MSExcel.png").getImage();
        getGraphics().drawImage(mse_img, 235, 440, null);
        
        //----------MS Excel Text----------
        Label text4 = new Label("Конвертувати в Microsoft Excel", Label.LEFT);
        text4.setBounds(350, 476, 600, 40);
        add(text4);
        
        //----------"Ім'я файлу"----------
        Label text5 = new Label("Ім'я файлу", Label.LEFT);
        text5.setBounds(100, 560, 170, 40);
        text5.setFont(new Font("Times New Roman", Font.ITALIC, 28));
        add(text5);
        
        //----------Text_Field----------
        TextField field = new TextField();
        field.setBounds(300, 560, 600, 40);
        add(field);
        
        //----------Button----------
        Button button = new Button("Далі");
        button.setBounds(950, 580, 150, 50);
        button.setForeground(new Color(255,255,255));
        button.setBackground(new Color(167, 74, 68));
        //button.setFont();
        add(button);
        
        //----------CheckBox----------
        JCheckBox checkbox = new JCheckBox("Я погоджуюсь з", true);
        checkbox.setBackground(new Color(253, 221, 194));
        checkbox.setFont(font);
        checkbox.setBounds(35, 660, 265, 40);
        add(checkbox);
        
        //----------URL----------
        url = new JButton("Умовами");
        url.addActionListener(this);
        url.setFont(new Font("Times New Roman", 0, 28));
        url.setBackground(new Color(253, 221, 194));
        url.setForeground(Color.BLUE.darker());
        url.setBorderPainted(false);
        url.setOpaque(false);
        url.setBounds(290, 660, 164, 40);
        add(url);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == url){
			try {
				Desktop.getDesktop().browse(new URI("https://www.gnu.org/licenses/gpl-3.0.en.html"));
			} catch (Exception ex){
				ex.printStackTrace();
			}
        }
    }
	
	public static void main(String[] args){
		new MainClass("Форма Java", 1280, 720);
	}
}
