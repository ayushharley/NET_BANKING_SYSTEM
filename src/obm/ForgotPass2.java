package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ForgotPass2 extends JFrame implements ActionListener{
	JTextField t1,t2;
	JButton b1;
	String acct;
public ForgotPass2(String acct) {
	this.acct=acct;
	 getContentPane().setBackground(new ColorUIResource(255,255,255));
     setBounds(360,60,700,490);
     setLayout(null);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/reset-pass-icon.png"));
   		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
   		ImageIcon i3 = new ImageIcon(i2);
   		JLabel l1 = new JLabel(i3);
   		l1.setBounds(300, 10, 100, 100);
   		add(l1);
   		
   		JLabel l2 = new JLabel("Reset Your Password");
   		l2.setFont(new FontUIResource("Railway", Font.BOLD, 25));
   		l2.setForeground(new ColorUIResource(240, 138, 76));
   		l2.setBounds(220, 120, 500, 33);
   		add(l2);
 
   		JPanel p1 = new JPanel();
		p1.setBounds(30, 170, 640, 180);
		p1.setBackground(new ColorUIResource(150, 227, 214));
		p1.setLayout(null);
		add(p1);

		JLabel l3 = new JLabel("Create New Password ");
		l3.setBounds(200, 20, 200, 25);
		l3.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		p1.add(l3);

		 t1 = new JTextField();
		t1.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t1.setBounds(200, 50, 250, 25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);

		JLabel l4 = new JLabel("Re-Enter New Password ");
		l4.setBounds(200, 100, 300, 25);
		l4.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		p1.add(l4);
		
		t2 = new JTextField();
		t2.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t2.setBounds(200, 130, 250, 25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);
		
		b1 = new JButton("Save Password");
		b1.setFont(new FontUIResource("Tahoma", Font.PLAIN, 19));
		b1.setBounds(235, 370, 230, 30);
		b1.addActionListener(this);
		b1.setBackground(new Color(0, 0, 255));
		b1.setForeground(new ColorUIResource(255, 255, 255));
		add(b1);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("./imags/gold-card-chip.png"));
		Image i5 = i4.getImage().getScaledInstance(21, 21, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l11 = new JLabel(i6);
		l11.setBounds(0, 0, 21, 21);
		b1.add(l11);
		
		setResizable(false);
		this.setVisible(true);
}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			
			String create_pass=t1.getText();
			String confirm_pass=t2.getText();
			if (create_pass.equals(confirm_pass)) {
				String query= "update login set password='"+create_pass+"' where acct_no='"+acct+"' ";
				
			try {
				db.DbConnect.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Password Change Succesfully");
				this.setVisible(false);
				new ToLogin2().setVisible(true);
				
			}
			
			catch (Exception e1) {
				// TODO: handle exception
			}
			
			}
			else {
				JOptionPane.showMessageDialog(null, "Password dosen't match");
			}
	}

}
}
