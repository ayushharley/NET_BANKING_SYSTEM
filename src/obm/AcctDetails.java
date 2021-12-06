package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class AcctDetails extends JFrame implements ActionListener{ 
	JLabel l21,l22,l23,l24,l25,l26,l27,l28,l29;
	JButton b1;
	String acct;
public AcctDetails(String acct) {
	this.acct=acct;
	getContentPane().setBackground(new ColorUIResource(255, 255, 255));
	setBounds(270, 0, 900, 720);
	setLayout(null);

	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/male-profile.png"));
	Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel l1 = new JLabel(i3);
	l1.setBounds(410, 10, 90, 90);
	add(l1);

	JLabel l2 = new JLabel("Bank Account Details");
	l2.setFont(new FontUIResource("Railway", Font.BOLD, 28));
	l2.setForeground(new ColorUIResource(0, 0, 255));
	l2.setBounds(290, 110, 500, 30);
	add(l2);

	// Initaial information
	JPanel p1 = new JPanel();
	p1.setBounds(10, 150, 880, 510);
	p1.setBackground(new ColorUIResource(240, 181, 145));
	p1.setLayout(null);
	add(p1);
	
	String name="ayush ashokrao Harle";
	
	JLabel l15 = new JLabel("Welcome "+name+"  ");
	l15.setBounds(300, 10, 400, 20);
	l15.setForeground(new ColorUIResource(199, 9, 9));
	l15.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
	p1.add(l15); 
	
	JLabel l16 = new JLabel("This is your Sky Bank Account details plese always remeber it  ");
	l16.setBounds(180, 34, 600, 20);
	l16.setForeground(new ColorUIResource(199, 9, 9));
	l16.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
	p1.add(l16); 
	

	JLabel l3 = new JLabel("Full Name :");
	l3.setBounds(100, 90, 200, 25);
	l3.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l3);

	l21 = new JLabel();
	l21.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
	l21.setBounds(100, 120, 250, 25);
	l21.setBorder(BorderFactory.createEmptyBorder());
	p1.add(l21);

	JLabel l4 = new JLabel("Mother Name :");
	l4.setBounds(100, 165, 200, 25);
	l4.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l4);

	l22 = new JLabel();
	l22.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
	l22.setBounds(100, 190, 250, 25);
	l22.setBorder(BorderFactory.createEmptyBorder());
	p1.add(l22);

	JLabel l5 = new JLabel("Mobile Number :");
	l5.setBounds(100, 240, 200, 25);
	l5.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l5);

	l23 = new JLabel();
	l23.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
	l23.setBounds(100, 270, 250, 25);
	l23.setBorder(BorderFactory.createEmptyBorder());
	p1.add(l23);

	JLabel l6 = new JLabel("Aadhar Number :");
	l6.setBounds(100, 315, 200, 25);
	l6.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l6);

	l24 = new JLabel();
	l24.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
	l24.setBounds(100, 345, 250, 25);
	l24.setBorder(BorderFactory.createEmptyBorder());
	p1.add(l24);

	JLabel l7 = new JLabel("Pan Number :");
	l7.setBounds(550, 90, 200, 25);
	l7.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l7);

	l25 = new JLabel();
	l25.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
	l25.setBounds(550, 120, 250, 25);
	l25.setBorder(BorderFactory.createEmptyBorder());
	p1.add(l25);
	
	JLabel l8 = new JLabel("Email:");
	l8.setBounds(550, 165, 200, 25);
	l8.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l8);

	l26 = new JLabel();
	l26.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
	l26.setBounds(550, 190, 250, 25);
	l26.setBorder(BorderFactory.createEmptyBorder());
	p1.add(l26);

	 l8 = new JLabel("Account Number :");
	l8.setBounds(550, 240, 300, 25);
	l8.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l8);

	 l27 = new JLabel();
	 l27.setBounds(550, 270, 200, 25);
	 l27.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l27);
	
	JLabel l10= new JLabel("Debit-card Number :");
	l10.setBounds(550, 315, 200, 25);
	l10.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l10);

	 l28 = new JLabel();
	 l28.setBounds(550, 345, 200, 25);
	 l28.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l28);
	
	JLabel l12= new JLabel("Pin :");
	l12.setBounds(400, 380, 200, 25);
	l12.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l12);

	 l29 = new JLabel();
	 l29.setBounds(400, 410, 200, 25);
	 l29.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	p1.add(l29);

	b1 = new JButton("Go To Login");
	b1.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	b1.setBounds(300, 450, 200, 35);
	b1.addActionListener(this);
	b1.setBackground(new Color(0, 0, 255));
	b1.setForeground(new ColorUIResource(255, 255, 255));
	p1.add(b1);
	
	ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("./imags/goback.png"));
	Image i5 = i4.getImage().getScaledInstance(26, 26, Image.SCALE_DEFAULT);
	ImageIcon i6 = new ImageIcon(i5);
	JLabel l17 = new JLabel(i6);
	l17.setBounds(200, 320, 30, 30);
	b1.add(l17);
	
	
	try {
		String query= "select * from create_acc where acct_no='"+acct+"'";
		ResultSet rs=db.DbConnect.s.executeQuery(query);
		while(rs.next()) {

			l21.setText(rs.getString("name"));
			l22.setText(rs.getString("mother_name"));
			l23.setText(rs.getString("number"));
			l24.setText(rs.getString("adhar_no"));
			l25.setText(rs.getString("pan_no"));
			l26.setText(rs.getString("email"));
			l27.setText(rs.getString("acct_no"));
			l28.setText(rs.getString("debit_no"));
			l29.setText(rs.getString("pin"));
			
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	setResizable(false);
	this.setVisible(true);
}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
		
	}

}
