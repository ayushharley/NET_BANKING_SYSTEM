package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.mail.MessagingException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import com.email.durgesh.*;

public class CreditCardInfo extends JFrame implements ActionListener {
	static String rn1, rn2, rn3;
	JLabel name, cardno, cardno1, cvvn, date;
	JButton sendo;
	String email1,pin;
	String acct;

	public CreditCardInfo(String acct) {
		this.acct=acct;
		getContentPane().setBackground(new ColorUIResource(255, 255, 255));
		setBounds(200, 10, 690, 600);
		setLayout(null);

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("./imags/gold-card-chip.png"));
		Image i5 = i4.getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l7 = new JLabel(i6);
		l7.setBounds(275, 0, 190, 80);
		add(l7);

		JLabel l1 = new JLabel("Credit Card Details");
		l1.setFont(new FontUIResource("Railway", Font.BOLD, 18));
		l1.setForeground(new ColorUIResource(0, 0, 255));
		l1.setBounds(280, 70, 300, 25);
		add(l1);

		JPanel p1 = new JPanel();
		p1.setBounds(60, 100, 570, 410);
		p1.setBackground(new ColorUIResource(218, 247, 166));
		p1.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p1.setLayout(null);
		add(p1);

		ImageIcon i44 = new ImageIcon(ClassLoader.getSystemResource("./imags/new card.png"));
		Image i45 = i44.getImage().getScaledInstance(310, 170, Image.SCALE_DEFAULT);
		ImageIcon i46 = new ImageIcon(i45);
		JLabel l107 = new JLabel(i46);
		l107.setBounds(145, 20, 310, 170);
		p1.add(l107);

		JLabel l112 = new JLabel("Credit Card ");
		l112.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l112.setForeground(new ColorUIResource(255, 255, 255));
		l112.setBounds(10, 10, 300, 25);
		l107.add(l112);

		ImageIcon i47 = new ImageIcon(ClassLoader.getSystemResource("./imags/visa-icon.png"));
		JLabel l108 = new JLabel(i47);
		l108.setBounds(260, 2, 40, 40);
		l107.add(l108);

		ImageIcon i48 = new ImageIcon(ClassLoader.getSystemResource("./imags/silver-card-chip.png"));
		JLabel l109 = new JLabel(i48);
		l109.setBounds(30, 39, 40, 50);
		l107.add(l109);

		cardno = new JLabel();
		cardno.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		cardno.setForeground(new ColorUIResource(255, 255, 255));
		cardno.setBounds(10, 105, 300, 25);
		l107.add(cardno);

		name = new JLabel();
		name.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		name.setForeground(new ColorUIResource(255, 255, 255));
		name.setBounds(10, 130, 300, 25);
		l107.add(name);

		JLabel l115 = new JLabel("Credit Card Type  ");
		l115.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l115.setForeground(new ColorUIResource(69, 70, 75));
		l115.setBounds(20, 220, 300, 25);
		p1.add(l115);

		JLabel l116 = new JLabel(" Saving");
		l116.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l116.setForeground(new ColorUIResource(69, 70, 75));
		l116.setBounds(170, 220, 300, 25);
		p1.add(l116);

		JLabel l117 = new JLabel("Credit Card No  ");
		l117.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l117.setForeground(new ColorUIResource(69, 70, 75));
		l117.setBounds(20, 255, 300, 25);
		p1.add(l117);

		cardno1 = new JLabel();
		cardno1.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		cardno1.setForeground(new ColorUIResource(69, 70, 75));
		cardno1.setBounds(170, 255, 300, 25);
		p1.add(cardno1);

		JLabel l119 = new JLabel("CVV Number  ");
		l119.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l119.setForeground(new ColorUIResource(69, 70, 75));
		l119.setBounds(20, 290, 300, 25);
		p1.add(l119);

		cvvn = new JLabel();
		cvvn.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		cvvn.setForeground(new ColorUIResource(69, 70, 75));
		cvvn.setBounds(170, 290, 300, 25);
		p1.add(cvvn);

		JLabel l121 = new JLabel("Issu Date ");
		l121.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l121.setForeground(new ColorUIResource(69, 70, 75));
		l121.setBounds(330, 220, 200, 25);
		p1.add(l121);

		date = new JLabel();
		date.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		date.setForeground(new ColorUIResource(69, 70, 75));
		date.setBounds(430, 220, 300, 25);
		p1.add(date);

		JLabel l123 = new JLabel("Expiry Date ");
		l123.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l123.setForeground(new ColorUIResource(69, 70, 75));
		l123.setBounds(330, 255, 300, 25);
		p1.add(l123);

		JLabel l124 = new JLabel("1/1/2030");
		l124.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l124.setForeground(new ColorUIResource(69, 70, 75));
		l124.setBounds(435, 255, 300, 25);
		p1.add(l124);

		JLabel l125 = new JLabel("Balance ");
		l125.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l125.setForeground(new ColorUIResource(69, 70, 75));
		l125.setBounds(330, 290, 300, 25);
		p1.add(l125);

		JLabel l126 = new JLabel("50000");
		l126.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l126.setForeground(new ColorUIResource(69, 70, 75));
		l126.setBounds(435, 290, 300, 25);
		p1.add(l126);

		JLabel l127 = new JLabel("Interest Rate ");
		l127.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l127.setForeground(new ColorUIResource(69, 70, 75));
		l127.setBounds(190, 325, 300, 25);
		p1.add(l127);

		JLabel l128 = new JLabel("10%/Year");
		l128.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l128.setForeground(new ColorUIResource(69, 70, 75));
		l128.setBounds(320, 325, 300, 25);
		p1.add(l128);

		 sendo = new JButton("Send Pin to Email");
		sendo.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		sendo.setForeground(new ColorUIResource(255, 255, 255));
		sendo.setBackground(new Color(15, 51, 231));
		sendo.addActionListener(this);
		sendo.setBounds(170, 365, 250, 24);
		p1.add(sendo);

		String creditno = ran();

		String cvv = ran2();
         pin = ran2();
        

		cardno.setText(creditno);
		cardno1.setText(creditno);
		cvvn.setText(cvv);
		
		Date currDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strCurrDate = dateFormat.format(currDate);
		System.out.println(strCurrDate);
		
		date.setText(strCurrDate);
		
		 java.sql.Date sqlDate = new java.sql.Date(currDate.getTime());
		
		
		try {

			String query = "select * from credit_card where acct_no='"+acct+"' ";
			
			ResultSet rs=db.DbConnect.s.executeQuery(query);
			while(rs.next()) {
				name.setText(rs.getString("name"));
				email1=rs.getString("email");
				
				String query2="update credit_card set card_no='"+creditno+"',cvv='"+cvv+"',date='"+sqlDate+"',balance='50000',pin='"+pin+"' where acct_no='"+acct+"' ";
				db.DbConnect.s.executeUpdate(query2);
				
			}

		} catch (Exception e) {

		}

	}
	public static void main(String[] args) {
		new CreditCardInfo("").setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sendo) {
			
		
	     	   //from
	     	   try {
	     		   
	     		   
	     			Email email= new Email("harleyayush@gmail.com", "7219791328a");
				email.setFrom("harleyayush@gmail.com", "Ayush harle");
				 email.setSubject("Sky Bank Autority");
		     	   email.setContent("<h1>welcome to SKY BANK</h1> <p>"
		     	   		+ " your Credit card pin is</p>"+pin , "text/html");
		     	   email.addRecipient(email1);
		     	   email.send();
		     	   
		     	   JOptionPane.showMessageDialog(null, "Pin send succesfully. check your email for pin");
		     	   JOptionPane.showMessageDialog(null, "Credit-card generated succedfully \nclick ok to go to home page");
		     	   new Home(acct).setVisible(true);
				
			} catch (UnsupportedEncodingException | MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
			}
	     	  
		}


	}

	public static String ran2() {

		Random random = new Random();
		int cvv1 = random.nextInt(10000);
		String cvv = Integer.toString(cvv1);
		return cvv;
	}

	public static String ran() {

		Random random = new Random();
		int r1 = random.nextInt(1000000000);
		String ra = Integer.toString(r1);
		return ra;
	}
}
