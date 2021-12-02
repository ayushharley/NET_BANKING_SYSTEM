package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

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

import com.email.durgesh.Email;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class ForgotPass extends JFrame implements ActionListener{
	JTextField t1,t2,t3;
	JButton b1,b2;
	JLabel l12;
	public int otp;
	String acct;
public ForgotPass() {
	// TODO Auto-generated constructor stub
	  getContentPane().setBackground(new ColorUIResource(255,255,255));
      setBounds(300,60,700,630);
      setLayout(null);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/verify-profile.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(300, 10, 100, 100);
		add(l1);
		
		JLabel l2 = new JLabel("First Check it's You");
		l2.setFont(new FontUIResource("Railway", Font.BOLD, 27));
		l2.setForeground(new ColorUIResource(236, 175, 138));
		l2.setBounds(220, 130, 500, 33);
		add(l2);

		// Initaial information
		JPanel p1 = new JPanel();
		p1.setBounds(30, 170, 640, 180);
		p1.setBackground(new ColorUIResource(145, 161, 233));
		p1.setLayout(null);
		add(p1);

		JLabel l3 = new JLabel("Account number :");
		l3.setBounds(200, 20, 200, 25);
		l3.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l3);

		 t1 = new JTextField();
		t1.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t1.setBounds(200, 50, 250, 25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);

		JLabel l4 = new JLabel("username :");
		l4.setBounds(200, 95, 200, 25);
		l4.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l4);
		
		t2 = new JTextField();
		t2.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t2.setBounds(200, 130, 250, 25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);
		
		b1 = new JButton("  Verify Details");
		b1.setFont(new FontUIResource("Tahoma", Font.PLAIN, 19));
		b1.setBounds(255, 370, 200, 30);
		b1.addActionListener(this);
		b1.setBackground(new Color(0, 0, 255));
		b1.setForeground(new ColorUIResource(255, 255, 255));
		add(b1);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("./imags/white-search-person.png"));
		Image i5 = i4.getImage().getScaledInstance(21, 21, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l11 = new JLabel(i6);
		l11.setBounds(0, 0, 21, 21);
		b1.add(l11);

		
		JPanel p2 = new JPanel();
		p2.setBounds(30, 420, 640, 80);
		p2.setBackground(new ColorUIResource(145, 161, 233));
		p2.setLayout(null);
		add(p2);
		
		JLabel l5 = new JLabel("Enter OTP :");
		l5.setBounds(200, 10, 200, 25);
		l5.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p2.add(l5);

		t3 = new JTextField();
		t3.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t3.setBounds(200, 40, 250, 25);
		t3.setBorder(BorderFactory.createEmptyBorder());
		t3.setEnabled(false);
		p2.add(t3);

		b2 = new JButton("Verify OTP");
		b2.setFont(new FontUIResource("Tahoma", Font.PLAIN, 18));
		b2.setBounds(250, 520, 200, 30);
		b2.addActionListener(this);
		b2.setBackground(new Color(0, 0, 255));
		b2.setForeground(new ColorUIResource(255, 255, 255));
		b2.setEnabled(false);
		add(b2);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("./imags/check-sm.png"));
		Image i8 = i7.getImage().getScaledInstance(21, 21, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		 l12 = new JLabel(i9);
		l12.setBounds(10, 0, 21, 21);
		l12.setEnabled(false);
		b2.add(l12);
		
		 acct=t1.getText();
		 System.out.println(acct);
}
public static void main(String[] args) {
	
	new ForgotPass().setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			try {
				acct=t1.getText();
				
				String username=t2.getText();
				System.out.println(username);
				System.out.println(acct);
				String query1="select * from login where acct_no='"+acct+"' AND username='"+username+"' ";
				ResultSet rs1=db.DbConnect.s.executeQuery(query1);
				if(rs1.next()) {
					 
					String query2="select * from create_acc where acct_no='"+acct+"' ";
					ResultSet rs2=db.DbConnect.s.executeQuery(query2);
					
					while(rs2.next()) {
						String email1=rs2.getString("email");
						
						otp=generateOtp();
					
				     	   Email email= new Email("harleyayush@gmail.com", "7219791328a");
				     	   //from
				     	   email.setFrom("harleyayush@gmail.com", "Ayush harle");
				     	   email.setSubject("this is testing email");
				     	   email.setContent("<h1>welcome to SKY BANK</h1> <p>"
				     	   		+ " your otp is</p>"+otp , "text/html");
				     	   email.addRecipient(email1);
				     	   email.send();
				     	  JOptionPane.showMessageDialog(null, "OTP Send succesfully to "+email1); 
				     	   t3.setEnabled(true);
				     	   b2.setEnabled(true);
				     	   l12.setEnabled(true);
				     	   
//				     	  960871895
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Details dosen't match ");
					t1.setText("");
					t2.setText("");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if (e.getSource()==b2) {
			
			String emailotp=t3.getText();
			
		 String otp1=Integer.toString(otp);
			if(emailotp.equals(otp1)) {
				JOptionPane.showMessageDialog(null, "OTP verify seccesfuly");
				
				new ForgotPass2(acct).setVisible(true);
				
				
				
		}
			else {
				JOptionPane.showMessageDialog(null, "Invalid OTP");
			}
		}
		
	}
	 private static int generateOtp(){
		    int otp = (int) (Math.random()*1000000); 
		    return otp;
		    }

}
