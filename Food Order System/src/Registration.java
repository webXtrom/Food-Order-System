import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Registration extends JFrame{
public Registration(){
		
		setSize(500,460);
		setDefaultCloseOperation(3);
		setLayout(null);
		setLocationRelativeTo(null);
		
		
//Header Panel
		JPanel headerpanel = new JPanel();
		headerpanel.setBackground(new Color(34,36,54));
		headerpanel.setBounds(5,5,490,60);
		add(headerpanel);
		
		JLabel headertext = new JLabel("Registration Form");
		headertext.setForeground(Color.WHITE);
		headertext.setFont(new Font("Arial",Font.BOLD,30));
		headerpanel.add(headertext);
		
//Input Panel	

		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(34,36,54));
		inputPanel.setBounds(5,70,490,425);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		Font labelFont = new Font("Arial",Font.BOLD,16);
		
//Name Field
		JLabel name = new JLabel("Name : ");
		name.setForeground(Color.WHITE);
		name.setBounds(130,5,100,25);
		name.setFont(labelFont);
		inputPanel.add(name);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(200,5,200,25);
	
		nameText.setFont(labelFont);
		inputPanel.add(nameText);
//Email Field	
		JLabel email = new JLabel("Email : ");
		email.setForeground(Color.WHITE);
		email.setBounds(130,50,100,25);
		email.setFont(labelFont);
		inputPanel.add(email);
		
		JTextField emailText = new JTextField();
		emailText.setBounds(200,50,200,25);
		emailText.setFont(labelFont);
		inputPanel.add(emailText);
		
// Password Field	
		JLabel pass = new JLabel("Password : ");
		pass.setForeground(Color.WHITE);
		pass.setBounds(100,100,100,25);
		pass.setFont(labelFont);
		inputPanel.add(pass);
		
		JTextField passText = new JTextField();
		passText.setBounds(200,100,200,25);
		passText.setFont(labelFont);
		inputPanel.add(passText);
		
//Confirm Filed	

		JLabel conPass = new JLabel("Confirm Password : ");
		conPass.setForeground(Color.WHITE);
		conPass.setBounds(35,150,170,25);
		conPass.setFont(labelFont);
		inputPanel.add(conPass);
		
		JTextField conPassText = new JTextField();
		conPassText.setBounds(200,150,200,25);
		conPassText.setFont(labelFont);
		inputPanel.add(conPassText);
		
//Mobile Field	
		JLabel mob = new JLabel("Mobile : ");
		mob.setForeground(Color.WHITE);
		mob.setBounds(130,200,100,25);
		mob.setFont(labelFont);
		inputPanel.add(mob);
		
		JTextField mobText = new JTextField();
		mobText.setBounds(200,200,200,25);
		mobText.setFont(labelFont);
		inputPanel.add(mobText);
		
	
//Address Field
		JLabel address = new JLabel("Address : ");
		address.setForeground(Color.WHITE);
		address.setBounds(115,250,100,25);
		address.setFont(labelFont);
		inputPanel.add(address);
		
		JTextField addText = new JTextField();
		addText.setBounds(200,250,200,25);
		addText.setFont(labelFont);
		addText.setBorder(new LineBorder(Color.BLUE));
		inputPanel.add(addText);
//Register Field
		JButton regBtn = new JButton("Register");
		regBtn.setBounds(300,300,100,30);
		regBtn.setBackground(new Color(73,91,195));
		regBtn.setFont(labelFont);
		regBtn.setForeground(Color.WHITE);
		regBtn.setBorder(new LineBorder(Color.BLUE));
		inputPanel.add(regBtn);
//Login Filed	
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(100,300,100,30);
		loginBtn.setBackground(new Color(73,91,195));
		loginBtn.setFont(labelFont);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBorder(new LineBorder(Color.BLUE));
		inputPanel.add(loginBtn);
		
		
			
		
		loginBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
					
					
		dispose();
		new Login();
					
		}

		
				  
				  			  
	 });
		
		regBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			String userName = nameText.getText();
			String email = emailText.getText();
			String pass = passText.getText();
			String conPass = conPassText.getText();
			String mobile = mobText.getText();
			String address = addText.getText();
			
			//Validation 
			String mobileRegex = "(\\+88)?01[3-9]\\d{8}";
			String userNameRegex = "^[a-zA-Z .]+$";
			String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
			String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
			
			if(!Pattern.matches(userNameRegex,userName)) {
			       JOptionPane.showMessageDialog(null,"In-valid Username");
			}else if (!Pattern.matches(emailRegex, email)) {
				 JOptionPane.showMessageDialog(null,"In-valid Email");
				
			}
			else if(!pass.equals(conPass)){
				
				JOptionPane.showMessageDialog(null,"Password and Confrim Password is not match");
			}
			else if (!Pattern.matches(mobileRegex, mobile)) {
				 JOptionPane.showMessageDialog(null,"In-valid Mobile Number");
			}
			
			else {
				DbConnect db = new DbConnect();
				
				String queryInsert = "INSERT INTO `register`(`username`, `email`, `pass`, `mobile`, `address`) VALUES ('"+userName+"','"+email+"','"+pass+"','"+mobile+"','"+address+"')";
				//System.out.println(" "+queryInsert);
				db.RegisterInsert(queryInsert);
				}
			}
			
			
			  
		 
		  });
		  
		
		setVisible(true);
		
		
		

	}
}

