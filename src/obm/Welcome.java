package obm;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;



import java.awt.*;

public class Welcome extends JFrame implements Runnable{
	JProgressBar p;
	public Welcome() {

	    Thread t;
	    setUndecorated(true);
	    
		setBounds(300,100,800,550);
		setLayout(null);
		
		JPanel p1= new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(new ColorUIResource(0,0,255));
		p1.setLayout(null);
		add(p1);
		
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("./imags/banklogo-xl.png"));
		Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel l1= new JLabel(i3);
		l1.setBounds(300,80,200,200);
		p1.add(l1);
		
		JLabel l2= new JLabel("Welcome To Sky Bank");
		l2.setFont(new FontUIResource("Railway", Font.BOLD, 35));
		l2.setForeground(new ColorUIResource(255,255,255));
		l2.setBounds(180,300,500,40);
		p1.add(l2);
		
		JLabel l3= new JLabel("India's number one online bank");
		l3.setFont(new FontUIResource("Tahoma", Font.PLAIN, 18));
		l3.setForeground(new ColorUIResource(255,255,255));
		l3.setBounds(280,370,300,20);
		p1.add(l3);
		
		 p= new JProgressBar();
		p.setBounds(5,450,790,20);
		p.setForeground(new ColorUIResource(243, 150, 50 ));
		p1.add(p);
		
	    t=new Thread(this);
		t.start();
		
	}
	
	@Override
	public void run() {
try {
			
			for (int i = 1; i <=101; i++) {
				int m=p.getMaximum();
				int n=p.getValue();
				if (n<m) {
					p.setValue(p.getValue()+1);
				}
				else {
					i=101;
					
//					new Dashboard(username).setVisible(true);
					setVisible(false);
					
				}
				Thread.sleep(50);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
new Login().setVisible(true);
	}
	public static void main(String[] args) {
		 
			new Welcome().setVisible(true);
	
			
	}


}
