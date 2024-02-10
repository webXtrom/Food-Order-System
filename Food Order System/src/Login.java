import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;



public class Login extends JFrame {
	private static final String ActionEvent = null;
	private static final int BOLD = 0;

	public Login() {
		
		setSize(500,300);
		setDefaultCloseOperation(3);
		setLayout(null);
		setLocationRelativeTo(null);
		
//Header Panel	
		JPanel headerpanel = new JPanel();
		headerpanel.setBackground(new Color(34,36,54));
		headerpanel.setBounds(5,5,490,60);
		add(headerpanel);
//Login form	
		JLabel headertext = new JLabel("Login Form");
		headertext.setForeground(Color.WHITE);
		headertext.setFont(new Font("ITALIC",BOLD,40));
		headerpanel.add(headertext);
//Input Panel	
		JPanel inputPanel=new JPanel();
		inputPanel.setBackground(new Color(34,36,54));
		inputPanel.setBounds(5,70,490,425);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		
		Font labelFont = new Font("Arial",Font.BOLD,16);
	
//UserName 
		JLabel nameLabel = new JLabel("Username : ");
		nameLabel.setBounds(80,25,100,25);
		nameLabel.setFont(labelFont);
		nameLabel.setForeground(Color.WHITE);
		inputPanel.add(nameLabel);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(200,25,200,25);
		nameText.setFont(labelFont);
		inputPanel.add(nameText);
//Password
		JLabel passLabel = new JLabel("Password : ");
		passLabel.setBounds(80,70,100,25);
		passLabel.setFont(labelFont);
		passLabel.setForeground(Color.WHITE);
		inputPanel.add(passLabel);
		
		JTextField passText = new JTextField();
		passText.setBounds(200,70,200,25);
		passText.setFont(labelFont);
		inputPanel.add(passText);
		
		 
		
//Login 	
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(300,120,100,30);
		loginBtn.setBackground(new Color(73,91,195));
		loginBtn.setFont(labelFont);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBorder(new LineBorder(Color.BLUE));
		inputPanel.add(loginBtn);
		
//Register	
		JButton regBtn= new JButton("Register");
		regBtn.setBounds(100,120,100,30);
		regBtn.setBackground(new Color(73,91,195));
		regBtn.setFont(labelFont);
		regBtn.setForeground(Color.WHITE);
		regBtn.setBorder(new LineBorder(Color.BLUE));
		inputPanel.add(regBtn);
		setVisible(true);
		
		regBtn.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Registration();
				
			}
			});
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				String userName = nameText.getText();
				String pass = passText.getText();
				
			
					
				
				DbConnect db = new DbConnect();
				
				String queryLogin ="SELECT userName,pass FROM `register`";
				
				db.Login(queryLogin, userName, pass);
			}
			});
				
			setVisible(true);

		}
        }

