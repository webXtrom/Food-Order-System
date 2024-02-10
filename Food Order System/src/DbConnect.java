import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private int flag=0;
public  DbConnect() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food order system","root","");
		st=con.createStatement();
		
		}
		catch (Exception e) {
			System.out.println("Error:"+e);
			
		}
		
		}

	public void RegisterInsert(String queryInsert) {
		try {
		st.executeUpdate(queryInsert);
		JOptionPane.showMessageDialog(null,"Registration Completed,You can login now");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Registration not Completed"+e);
			
		}
		
		}

	public void Login(String queryLogin,String userName,String pass) {
		// TODO Auto-generated method stub
		try {
			rs=st.executeQuery(queryLogin);
			while(rs.next()) {
				String tableUserName=rs.getString(2);
				String tablePass=rs.getString(4);
				
				if(userName.equals(tableUserName) && pass.equals(tablePass)) {
					JOptionPane.showMessageDialog(null, "Welcome, You are a Valid User!!");
					flag=1;
					new mainclassofproject();
					break;
					
				}
				if(flag==0) {
				
					JOptionPane.showMessageDialog(null, "UserName and Password is not matching!!");

				}
			}
		}catch(Exception e) {
		
		
	}
	}
	}


