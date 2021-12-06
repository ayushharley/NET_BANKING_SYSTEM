
	package obm;

	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.security.PublicKey;
	import java.sql.ResultSet;
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
	import com.email.durgesh.*;

	public class EmailVer2 extends JFrame implements ActionListener{
		JTextField t1,t2;
		JButton b1,b2;
		String em;
		String acct;
		public int otp;
	public EmailVer2(String acct) {
		this.acct=acct;
		 getContentPane().setBackground(new ColorUIResource(255,255,255));
	     setBounds(300,100,800,470);
	     setLayout(null);
	     
	     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/verified-mail.png"));
			Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel l1 = new JLabel(i3);
			l1.setBounds(350, 10, 100, 100);
			add(l1);

			JLabel l2 = new JLabel("Email Verification");
			l2.setFont(new FontUIResource("Railway", Font.BOLD, 28));
			l2.setForeground(new ColorUIResource(0, 0, 255));
			l2.setBounds(270, 120, 500, 30);
			add(l2);
			
			JPanel p1 = new JPanel();
			p1.setBounds(10, 170, 780, 250);
			p1.setBackground(new ColorUIResource(126, 148, 238));
			p1.setLayout(null);
			add(p1);
			
			JLabel l3 = new JLabel("Email:");
			l3.setBounds(100, 30, 200, 25);
			l3.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
			p1.add(l3);

			t1 = new JTextField();
			t1.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
			t1.setBounds(100, 60, 300, 25);
			t1.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t1);
			
			b1 = new JButton("Send OTP ");
			b1.setFont(new FontUIResource("Tahoma", Font.PLAIN, 16));
			b1.setBounds(450, 60, 200, 25);
			b1.addActionListener(this);
			b1.setBackground(new Color(0, 0, 255));
			b1.setForeground(new ColorUIResource(255, 255, 255));
			p1.add(b1);

			JLabel l4 = new JLabel("OTP :");
			l4.setBounds(100, 130, 200, 25);
			l4.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
			p1.add(l4);

			t2 = new JTextField();
			t2.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
			t2.setBounds(100, 160, 300, 25);
			t2.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t2);
			
			b2 = new JButton("verify OTP ");
			b2.setFont(new FontUIResource("Tahoma", Font.PLAIN, 16));
			b2.setBounds(450, 160, 200, 25);
			b2.addActionListener(this);
			b2.setBackground(new Color(0, 0, 255));
			b2.setForeground(new ColorUIResource(255, 255, 255));
			p1.add(b2);
			setResizable(false);
			this.setVisible(true);
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==b1)
			{
			
				String email1=t1.getText();
				String query="select * from create_acc where email='"+email1+"' ";
			try {
				ResultSet rs=db.DbConnect.s.executeQuery(query);
					
				if(rs.next()) {	
					
					otp=generateOtp();
					System.out.println(otp);
					
			     	   Email email= new Email("skybanklife@gmail.com", "7219791328a");
			     	   //from
			     	   email.setFrom("skybanklife@gmail.com", " Sky Bank Authority ");
			     	   email.setSubject("Sky Bank ,Net-Banking Account creation ");
			     	   email.setContent("<h1>welcome to SKY BANK</h1> <p>"
			     	   		+  " your otp for creation of Sky Bank Net-Banking Account is </p>"+ otp, "text/html");
			     	   email.addRecipient(email1);
			     	   email.send();
					
			     	  
					JOptionPane.showMessageDialog(null, "OTP Send succesfully to "+email1);
					 }
				else {
					JOptionPane.showMessageDialog(null, "invalid Email");
				}
				}
				
			catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);

			}
			}
			
			if(e.getSource()==b2)
			{
				String emailotp=t2.getText();
				System.out.println(otp);
			 String otp1=Integer.toString(otp);
				if(emailotp.equals(otp1)) {
					JOptionPane.showMessageDialog(null, "OTP verify seccesfuly");
				
					this.setVisible(false);
					new CreateLogin(acct).setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "OTP doesn't match");
				}
				
			
			}
			
			}
		 private static int generateOtp(){
			    int otp = (int) (Math.random()*1000000); 
			    return otp;
			    }

	}
