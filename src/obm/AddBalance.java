package obm;

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

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBalance extends JFrame implements ActionListener{
	JTextField t1;
	JButton b1;
	String acct;
	
public AddBalance(String acct) {
this.acct=acct;
	getContentPane().setBackground(new ColorUIResource(255,255,255));
      setBounds(200,100,700,500);
      setLayout(null);
//      male-profile.png
      
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/male-profile.png"));
 		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
 		ImageIcon i3 = new ImageIcon(i2);
 		JLabel l1 = new JLabel(i3);
 		l1.setBounds(300, 10, 100, 100);
 		add(l1);
 		
 		JLabel l2= new JLabel("Add Amoount");
		l2.setFont(new FontUIResource("Railway", Font.BOLD, 28));
		l2.setForeground(new ColorUIResource(0,0,255));
		l2.setBounds(250,110,500,30);
		add(l2);
		
		 JPanel p1= new JPanel();
	      p1.setBounds(10,150,680,270);
	      p1.setBackground(new ColorUIResource(249, 231, 121));
	      p1.setLayout(null);
	      add(p1);
	      
	      JLabel l3= new  JLabel("Enter Amount ");
			l3.setBounds(210, 40 ,200 ,30);
			l3.setFont(new FontUIResource("Tahoma",Font.BOLD,17 ));
			p1.add(l3);
			
			t1= new JTextField();
			t1.setFont(new FontUIResource("Tahoma",Font.BOLD,15 ));
			t1.setBounds(210,80 ,250 ,30);
			t1.setBorder(BorderFactory.createEmptyBorder());
			p1.add(t1);
			
			b1=new JButton("ADD");
	   		b1.setFont(new FontUIResource("Tahoma",Font.PLAIN,20));
	   		b1.setBounds(270,140,120,30);
	   		b1.setBackground(new Color(0,0,255));
	   		b1.setForeground(new ColorUIResource(255,255,255));
	   		b1.addActionListener(this);
	   		p1.add(b1);

	   		
}public static void main(String[] args) {
	
	new AddBalance("").setVisible(true);
}


	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	{
		
		
		String amount1=t1.getText();
		if(!amount1.equals("")) {
		int amount=Integer.parseInt(amount1);
	
		if( amount<=10000 ) {
		String query="update login set acct_balance='"+amount+"' where acct_no='"+acct+"'";
		
		try {
			
			db.DbConnect.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Balance added succesfully");
			new Home(acct).setVisible(true);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Balance can't be zero");
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Can't addd balance greater than 1000");
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Balance should be greater than 0");
		}
	
	}
		
	}

}
