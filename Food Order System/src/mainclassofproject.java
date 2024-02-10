import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class mainclassofproject extends JFrame{
	
	JButton btn1,insertBtn,update,delete;
	JFileChooser fc;
	String Imagepath;
	
	public mainclassofproject() {
		setSize(820,600);
		setDefaultCloseOperation(3);
		setLayout(null);
		//Header Panel 
		JPanel headerpanel = new JPanel();
		headerpanel.setBackground(new Color(34,36,54));
		headerpanel.setBounds(5,15,780,50);
		add(headerpanel);
		
		JLabel headertext = new JLabel("Welcome To Our Restaurent");
		headertext.setForeground(Color.WHITE);
		headertext.setFont(new Font("Arial",Font.BOLD,30));
		headerpanel.add(headertext);
		
	//Add Panel	
		
		JPanel addpanel=new JPanel();
		addpanel.setBounds(0,90,415,520);
		add(addpanel);
		addpanel.setBackground(new Color(82, 138, 174));
		addpanel.setLayout(null);
	//Show Panel
		JPanel showPanel = new JPanel();
		showPanel.setBackground(new Color(115, 165, 198));
		showPanel.setBounds(410,90,510,520);
		showPanel.setLayout(null);
		add(showPanel);
		
		String data[][]={ {   "  Sreyoshi","Sreyo","670"},    
                {"    102","Jai","7800"}};    
		String column[]={"NAME","PRICE","QUANTITY"};   
		DefaultTableModel tableModel = new DefaultTableModel(data, column);
	    JTable jT = new JTable(tableModel);
		showPanel.add(new JScrollPane(jT));
		
		
		Font font = new Font("Arial",Font.BOLD,16);
	//Product Name
		JLabel productname=new JLabel("Product Name:");
		productname.setBounds(10,10,150,25);
		
		addpanel.add(productname);
		productname.setForeground(Color.WHITE);
		productname.setFont(font);
		JTextField nametext=new JTextField();
		nametext.setBounds(170,10,200,25);
		addpanel.add(nametext);
		
	//Product Price		
		JLabel productprice=new JLabel("Product Price:");
		 productprice.setBounds(10,50,150,25);
		addpanel.add( productprice);
		productprice.setForeground(Color.WHITE);
		productprice.setFont(font);
		JTextField productext=new JTextField();
		productext.setBounds(170,50,200,25);
		addpanel.add(productext);
		
	//Product quantity	
		
		JLabel productquantity=new JLabel("Product Quantity:");
		productquantity.setBounds(10,90,150,25);
		addpanel.add( productquantity);
		productquantity.setForeground(Color.WHITE);
		productquantity.setFont(font);
		JTextField quantitytext=new JTextField();
		quantitytext.setBounds(170,90,200,25);
		addpanel.add(quantitytext);
	//Add Image		

		JLabel addimage=new JLabel("Add Image:");
		 addimage.setBounds(10,130,150,25);
		addpanel.add(addimage);
		addimage.setForeground(Color.WHITE);
		 addimage.setFont(font);
		 btn1 =new JButton("add image");
		btn1.setBounds(170,130,100,25);
		btn1.setBorder(new LineBorder(Color.BLACK));
		addpanel.add(btn1);
		
		JLabel Imagedisplaylabel=new JLabel("");
		Imagedisplaylabel.setBounds(180,170,200,150);
		Imagedisplaylabel.setBorder(new LineBorder(Color.black));
		addpanel.add(Imagedisplaylabel);
		

	//InsertBtn    
		insertBtn =new JButton("Insert");
		insertBtn.setBounds(50,330,100,30);
		insertBtn.setForeground(Color.WHITE);
		insertBtn.setBackground(new Color(73,91,195));
		insertBtn.setBorder(new LineBorder(Color.BLACK));
		addpanel.add(insertBtn);
	//Update		
		update =new JButton("Update");
		update.setBounds(175,330,100,30);
		update.setForeground(Color.WHITE);
		update.setBackground(new Color(73,91,195));
		update.setBorder(new LineBorder(Color.BLACK));
		addpanel.add(update);
	//Delete		
		delete =new JButton("Delete");
		delete.setBounds(310,330,100,30);
		delete.setBackground(new Color(73,91,195));
		delete.setForeground(Color.WHITE);
		delete.setBorder(new LineBorder(Color.BLACK));
		addpanel.add(delete);

	btn1.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			fc = new JFileChooser();
			fc.showDialog(null,"Choose");//Here showdialog is used for opne filechooder
			File file= fc.getSelectedFile();
			Imagepath=file.getAbsolutePath();

			ImageIcon image =new ImageIcon(new ImageIcon(Imagepath).getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT));
		    Imagedisplaylabel.setIcon(image);
			
		}catch(Exception e2) {
			
		}
	}
	});
	setVisible(true);
	}
	}


