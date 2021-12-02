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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class CreateLogin extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4;
	JLabel l7;
	JButton b1;
	String acct;
public CreateLogin(String acct) {
	this.acct=acct;
	 getContentPane().setBackground(new ColorUIResource(255,255,255));
     setBounds(200,100,575,570);
     setLayout(null);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/add profile.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(250, 10, 70, 70);
		add(l1);

		JLabel l2 = new JLabel("Signup");
		l2.setFont(new FontUIResource("Railway", Font.BOLD, 25));
		l2.setForeground(new ColorUIResource(0, 0, 255));
		l2.setBounds(230, 80, 500, 30);
		add(l2);

		// Initaial information
		JPanel p1 = new JPanel();
		p1.setBounds(15, 130, 540, 380);
		p1.setBackground(new ColorUIResource(145, 161, 233));
		p1.setLayout(null);
		add(p1);

		JLabel l3 = new JLabel("Account number :");
		l3.setBounds(150, 20, 200, 25);
		l3.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l3);

		 l7 = new JLabel(acct);
		l7.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		l7.setBounds(150, 50, 250, 25);
		l7.setBorder(BorderFactory.createEmptyBorder());
		p1.add(l7);

		JLabel l4 = new JLabel("username :");
		l4.setBounds(150, 90, 200, 25);
		l4.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l4);
		
		t2 = new JTextField();
		t2.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t2.setBounds(150, 130, 250, 25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);
		

		JLabel l5 = new JLabel("password :");
		l5.setBounds(150, 160, 200, 25);
		l5.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l5);

		t3 = new JTextField();
		t3.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t3.setBounds(150, 200, 250, 25);
		t3.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t3);

		JLabel l6 = new JLabel("Confirm Password :");
		l6.setBounds(150, 230, 200, 25);
		l6.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l6);
		
		t4 = new JTextField();
		t4.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t4.setBounds(150, 270, 250, 25);
		t4.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t4);


		b1 = new JButton(" SignUp");
		b1.setFont(new FontUIResource("Tahoma", Font.PLAIN, 18));
		b1.setBounds(200, 320, 150, 30);
		b1.addActionListener(this);
		b1.setBackground(new Color(0, 0, 255));
		b1.setForeground(new ColorUIResource(255, 255, 255));
		p1.add(b1);

}public static void main(String[] args) {
	new CreateLogin("").setVisible(true);
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			
			String acc=l7.getText();
			String username=t2.getText();
			String pass1=t3.getText();
			String pass2=t4.getText();
			if (!username.equals("")) {
				
			
			if (pass2.equals(pass1)  ) {
				
				String query= "insert into login value('"+acc+"','"+username+"','"+pass2+"',acct_balance='0' )";
				try {
					db.DbConnect.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Signup Succesfully");
					new ToLogin().setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				 
			}
			else {
				JOptionPane.showMessageDialog(null, "password doesn't match");
			}
			}
			else {
				JOptionPane.showMessageDialog(null, "username can't be empty");
			}
		}
		
	}

}
