//lab 9
/*Розробити віконний додаток, в якому буде відображатися інформація з бази 
  даних. Крім відображення інформації з БД, він повинен дозволяти додавати та
  видаляти записи. Дані представити у вигляді таблиць (використовувати
  компонент JTable). 
  Складність БД - необмежена. Мінімум - вона повинна містити хоча б одну таблицю. 
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainClass extends Frame implements ActionListener{
	private Connection connection;
    private Statement statement;
    private ResultSet resultset;
    private JScrollPane panel;
    private JTable table;
    private DefaultTableModel model;
    
    Button button1;
    Button button2;
    Button button3;
	
	
	public MainClass(String s, int w, int h){
        super(s);
		setLayout(null);
		setBackground(new Color(200, 200, 200));
		setSize(w, h);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent ev){ 
				System.exit (0);
			}
		});
		
		Font font = new Font("Times New Roman", 0, 28);
		setFont(font);
		
		button1 = new Button("Оновити таблицю");
        button1.setBounds(960, 120, 300, 100);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new Button("Додати запис");
        button2.setBounds(960, 320, 300, 100);
        button2.addActionListener(this);
        add(button2);
        
        button3 = new Button("Видалити запис");
        button3.setBounds(960, 520, 300, 100);
        button3.addActionListener(this);
        add(button3);
        
        drawTable(); 
	} 
	
	public static Connection initConnection(){
		Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing?useSSL=NO", "root", "toor");
        } catch(Exception e){
			System.out.println(e);
		}
		return c;
    }
    
    public void drawTable(){
		model = new DefaultTableModel();
		
		model.addColumn("id");
		model.addColumn("Назва продукту");
		model.addColumn("Кількість");
		model.addColumn("Ціна");
		
		try{
			connection = initConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * FROM testing");
			
			while(resultset.next()){
				model.addRow(new Object[]{resultset.getInt("id"), resultset.getString("product"), resultset.getInt("amount"), resultset.getDouble("price")});
			}
			
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		table = new JTable(model);
		table.setVisible(true);
		panel = new JScrollPane(table);
		panel.setBounds(40,80,900,600); 
        panel.setBackground(Color.white);
        add(panel);  
	}
    
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1){
			drawTable();
        }
        if(e.getSource() == button2){
			new AddForm("Додати запис до БД");
		}
		if(e.getSource() == button3){
			new DeleteForm("Видалити запис");
		}
    }
	
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e){
			System.out.println("You forgot to set connector. Try \"java -cp .:mysql-connector-java-x.x.xx.jar MainClass\"");
			 System.exit(1);
		}
        new MainClass("Меню Java", 1280, 720);
    }
}

class AddForm extends Frame implements ActionListener{
	Connection connection;
	TextField productField;
	TextField amountField;
	TextField priceField;
	String product;
	int amount;
	double price;
	
	AddForm(String s){
		super(s);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		setSize(330, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent ev){
				dispose();
			}
		});
		
		
		//Стандартний шрифт
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        setFont(font);
		
		Label productText = new Label("Назва*", Label.LEFT);
        productText.setBounds(35, 50, 300, 20);
        add(productText);
        
        productField = new TextField();
        productField.setBounds(35, 100, 260, 20);
        add(productField);
        
        Label amountText = new Label("Кількість", Label.LEFT);
        amountText.setBounds(35, 150, 300, 20);
        add(amountText);
        
        amountField = new TextField();
        amountField.setBounds(35, 200, 260, 20);
        add(amountField);
        
        Label priceText = new Label("Ціна", Label.LEFT);
        priceText.setBounds(35, 250, 300, 20);
        add(priceText);
        
        priceField = new TextField();
        priceField.setBounds(35, 300, 260, 20);
        add(priceField);
         
		Button button = new Button("Додати запис");
        button.addActionListener(this);
        button.setBounds(90, 350, 150, 20);
        add(button);
    }
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		connection = MainClass.initConnection();
		product = productField.getText();
		
		if (product.isEmpty()){
			JOptionPane.showMessageDialog(null, "Назва продукту обов'язкова!");
			try{connection.close();} catch (Exception e){System.out.println(e);}
			return;
		}		
			
		try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO testing (product, amount, price) VALUES (?,?,?)");
            
            st.setString(1, product);
            
            try{
				amount = Integer.parseInt(amountField.getText());
				st.setInt(2, amount);
			} catch (NumberFormatException e) {
				st.setNull(2, Types.INTEGER);
			}
			
			try{
				price = Double.parseDouble(priceField.getText());
				st.setDouble(3, price);
			} catch (NumberFormatException e) {
				st.setNull(3, Types.DECIMAL);
			}
   
            st.executeUpdate();
            st.close();
            connection.close();
            
            //MainClass.drawTable();
            dispose();
        } catch(Exception e){
            System.out.println(e);
        }
	}
}

class DeleteForm extends Frame implements ActionListener{
	Connection connection;
	TextField textField;
	int i;
	
	DeleteForm(String s){
		super(s);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		setSize(330, 200);
		setVisible(true);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent ev){
				dispose();
			}
		}); 
		
		//Стандартний шрифт
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        setFont(font);
        
        Label text = new Label("Введіть id запису", Label.LEFT);
        text.setBounds(35, 50, 300, 20);
        add(text);
        
        textField = new TextField();
        textField.setBounds(35, 100, 260, 20);
        add(textField);
        
        Button button = new Button("Видалити");
        button.addActionListener(this);
        button.setBounds(115, 150, 100, 20);
        add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev){
		connection = MainClass.initConnection();
		try {
			i = Integer.parseInt(textField.getText());
            PreparedStatement st = connection.prepareStatement("DELETE FROM testing WHERE id =?");
            st.setInt(1, i);
            st.executeUpdate();
            st.close();
            connection.close();
            
            //MainClass.drawTable();
            dispose();
        } catch(Exception e){
            System.out.println(e);
        }
	}
}

