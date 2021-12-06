package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class ToLogin extends JFrame implements ActionListener {
	JButton b1;
public ToLogin() {
	getContentPane().setBackground(new ColorUIResource(255,255,255));
    setBounds(400,200,580,400);
    setLayout(null); 
    setUndecorated(true);
    
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/check-ok.png"));
	Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel l1 = new JLabel(i3);
	l1.setBounds(200, 30, 200, 200);
	add(l1);

	JLabel l2 = new JLabel("Account Created Succesfully");
	l2.setFont(new FontUIResource("Railway", Font.BOLD, 30));
	l2.setForeground(new ColorUIResource(0, 0, 255));
	l2.setBounds(50, 260, 500, 40);
	add(l2);
	 
	b1 = new JButton("Go To Login");
	b1.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
	b1.setBounds(220, 320, 200, 40);
	b1.addActionListener(this);
	b1.setBackground(new Color(0, 0, 255));
	b1.setForeground(new ColorUIResource(255, 255, 255));
	add(b1);
	
	ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("./imags/goback.png"));
	Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
	ImageIcon i6 = new ImageIcon(i5);
	JLabel l3 = new JLabel(i6);
	l3.setBounds(200, 320, 30, 30);
	b1.add(l3);
	setResizable(false);
	this.setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==b1) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
	}

}
