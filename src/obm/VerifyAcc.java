package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;import com.mysql.cj.exceptions.RSAException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
public class VerifyAcc extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JRadioButton male,female;
	JButton b1;
	public VerifyAcc() {
		 getContentPane().setBackground(new ColorUIResource(255,255,255));
	      setBounds(200,50,890,690);
	      setLayout(null);
	      
	      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("./imags/verify-profile.png"));
			Image i2= i1.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT);
			ImageIcon i3= new ImageIcon(i2);
			JLabel l1= new JLabel(i3);
			l1.setBounds(390,10,90,90);
			add(l1);
			
			JLabel l2= new JLabel("Verify Your Bank Account");
			l2.setFont(new FontUIResource("Railway", Font.BOLD, 28));
			l2.setForeground(new ColorUIResource(0,0,255));
			l2.setBounds(250,110,500,40);
			add(l2);
	      
	      //value started
	      JPanel p1= new JPanel();
	      p1.setBounds(15,150,860,480);
	      p1.setBackground(new ColorUIResource(145, 240, 233));
	      p1.setLayout(null);
	      add(p1);
	      
	  	
			JLabel l3= new  JLabel("Full Name :");
			l3.setBounds(100, 40 ,200 ,25);
			l3.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l3);
			
			t1= new JTextField();
			t1.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t1.setBounds(100,70 ,250 ,25);
			t1.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t1);
			
			JLabel l4= new  JLabel("Mobile number :");
			l4.setBounds(100, 120 ,200 ,25);
			l4.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l4);
			
			t2= new JTextField();
			t2.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t2.setBounds(100,150 ,250 ,25);
			t2.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t2);
			
			JLabel l5= new  JLabel("Account Number :");
			l5.setBounds(100, 200 ,200 ,25);
			l5.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l5);
			
			t3= new JTextField();
			t3.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t3.setBounds(100,230 ,250 ,25);
			t3.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t3);
			
			JLabel l6= new  JLabel("Debit-Card Number :");
			l6.setBounds(100, 270 ,200 ,25);
			l6.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l6);
			
			t4= new JTextField();
			t4.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t4.setBounds(100,300 ,250 ,25);
			t4.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t4);

			JLabel l7= new  JLabel("Mother Name :");
			l7.setBounds(500, 40 ,200 ,25);
			l7.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l7);
			
			t5= new JTextField();
			t5.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t5.setBounds(500,70 ,250 ,25);
			t5.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t5);
			
			JLabel l8= new  JLabel("Pan Number :");
			l8.setBounds(500, 120 ,200 ,25);
			l8.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l8);
			
			t6= new JTextField();
			t6.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t6.setBounds(500,150 ,250 ,25);
			t6.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t6);
			
			JLabel l9= new  JLabel("Aadhar Number :");
			l9.setBounds(500, 200 ,200 ,25);
			l9.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l9);
			
			t7= new JTextField();
			t7.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t7.setBounds(500,230 ,250 ,25);
			t7.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t7);
			
			JLabel l10= new  JLabel("Pin :");
			l10.setBounds(500, 270 ,200 ,25);
			l10.setFont(new FontUIResource("Tahoma",Font.BOLD,16 ));
			p1.add(l10);
			
			t8= new JTextField();
			t8.setFont(new FontUIResource("Tahoma",Font.BOLD,14 ));
			t8.setBounds(500,300 ,250 ,25);
			t8.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t8);
			
			JLabel l11= new JLabel("Gender :");
			l11.setBounds(336, 345, 200, 25);
			l11.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
			p1.add(l11);
			
			male= new JRadioButton("Male");
			male.addActionListener(this);
			male.setBounds(330, 370 ,70 ,34);
			male.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
			male.setBackground(new ColorUIResource(145, 240, 233));
			p1.add(male);
			
			
			female= new JRadioButton("Female");
			female.addActionListener(this);
			female.setBounds(440, 370 ,100 ,34);
			female.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
			female.setBackground(new ColorUIResource(145, 240, 233));
			p1.add(female);
			
			ButtonGroup bg=new ButtonGroup();
			bg.add(male);
			bg.add(female);

			b1=new JButton("Verify Details");
	   		b1.setFont(new FontUIResource("Tahoma",Font.PLAIN,20));
	   		b1.setBounds(320,420,200,35);
	   		b1.setBackground(new Color(0,0,255));
	   		b1.setForeground(new ColorUIResource(255,255,255));
	   		b1.addActionListener(this);
	   		p1.add(b1);
	   		setResizable(false);
	   		this.setVisible(true);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
		String full_name=t1.getText();
		String phone=t2.getText();
		String acct_no=t3.getText();
		String debit_no=t4.getText();
		String mother_name=t5.getText();
		String pan=t6.getText();
		String adhar=t7.getText();
		String pin=t8.getText();
		String gender;
		if(male.isSelected())
		{
			gender="Male";
		}
		else {
			gender="Female";
		}
		

		
		String query="select * from create_acc where name='"+full_name+"' AND mother_name='"+mother_name+"'AND number="
				+ "'"+phone+"' AND adhar_no='"+adhar+"'AND pan_no='"+pan+"'AND acct_no='"+acct_no+"'AND debit_no='"+debit_no+"' AND "
						+ "pin='"+pin+"' AND gender='"+gender+"'  ";
		try {
			ResultSet rs=db.DbConnect.s.executeQuery(query);
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Account Details Matched Perfectly");
				this.setVisible(false);
				new EmailVer2(acct_no).setVisible(true);
			}
			else {
				JOptionPane.showInternalMessageDialog(null, "Wrong Information");
			}
		} catch (SQLException e1) {
		
			JOptionPane.showInternalMessageDialog(null, e1);
		}
		
		
	}
	}
}
