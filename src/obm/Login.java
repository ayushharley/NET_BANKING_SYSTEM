package obm;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.Color;
import java.awt.Event;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.email.durgesh.Email;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class Login extends JFrame implements MouseInputListener{
	JPanel p2,p3,p4,p6;
	JTextField t1;
	JPasswordField t2 ;
	JButton b1;
	
	public Login() {
		
           getContentPane().setBackground(new ColorUIResource(255,255,255));
           setBounds(200,100,880,600);
           setLayout(null);
           
           JPanel p1= new JPanel();
   		p1.setBounds(0,0,350,600);
   		p1.setBackground(new ColorUIResource(0,0,255));
   		p1.setLayout(null);
   		add(p1);
           
   		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("./imags/banklogo-xl.png"));
		Image i2= i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel l1= new JLabel(i3);
		l1.setBounds(85,30,170,170);
		p1.add(l1);
          
		JLabel l2= new JLabel("Sky Bank");
		l2.setFont(new FontUIResource("Railway", Font.BOLD, 33));
		l2.setForeground(new ColorUIResource(255,255,255));
		l2.setBounds(80,200,500,38);
		p1.add(l2);
		
		JLabel l3= new JLabel("India's number one online bank");
		l3.setFont(new FontUIResource("Tahoma", Font.PLAIN, 14));
		l3.setForeground(new ColorUIResource(255,255,255));
		l3.setBounds(55,255,300,18);
		p1.add(l3);
		
		//create account
		  p2= new JPanel();
	   		p2.setBounds(0,315,350,40);
	   		p2.setBackground(new ColorUIResource(0,0,255));
	   		p2.setLayout(null);
	   		p2.addMouseListener(this);
	   		p1.add(p2);
	   		
	   		
	   		JLabel l4= new JLabel("Create Bank Account");
	   		l4.setFont(new FontUIResource("Railway", Font.BOLD, 18));
			l4.setForeground(new ColorUIResource(255,255,255));
			l4.setBounds(50,12,300,20);
			p2.add(l4);
			
			ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("./imags/white-addAccount.png"));
			JLabel l5= new JLabel(i4);
			l5.setBounds(10,8,30,25);
			p2.add(l5); 
			
			//forgot password
			 p3= new JPanel();
	   		p3.setBounds(0,375,350,40);
	   		p3.setBackground(new ColorUIResource(0,0,255));
	   		p3.setLayout(null);
	   		p3.addMouseListener(this);
	   		p1.add(p3);
			
			JLabel l6= new JLabel("Create Net-Banking Account");
	   		l6.setFont(new FontUIResource("Railway", Font.BOLD, 18));
			l6.setForeground(new ColorUIResource(255,255,255));
			l6.setBounds(50,12,350,20);
			p3.add(l6);
			
			ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("./imags/white-forgetpass.png"));
			JLabel l7= new JLabel(i5);
			l7.setBounds(10,8,30,25);
			p3.add(l7); 
			
			//logout
			 p4= new JPanel();
	   		p4.setBounds(0,430,350,40);
	   		p4.setBackground(new ColorUIResource(0,0,255));
	   		p4.setLayout(null);
	   		p4.addMouseListener(this);
	   		p1.add(p4);
	   		
			JLabel l8= new JLabel("Forgot Password");
	   		l8.setFont(new FontUIResource("Railway", Font.BOLD, 18));
			l8.setForeground(new ColorUIResource(255,255,255));
			l8.setBounds(50,12,300,20);
			p4.add(l8);
			
			ImageIcon i6= new ImageIcon(ClassLoader.getSystemResource("./imags/white-user-icon.png"));
			JLabel l9= new JLabel(i6);
			l9.setBounds(10,8,30,25);
			p4.add(l9); 
			
			
			
			
			JPanel p5 = new JPanel();
			p5.setBounds(300,0,580,600);
	   		p5.setBackground(new ColorUIResource(255,255,255));
	   		p5.setLayout(null);
	   		add(p5);
	   		
	   		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("./imags/login-profile.png"));
	   		JLabel l10 = new JLabel(i7);
	   		l10.setBounds(200,0,200,200);
	   		p5.add(l10);
	   		
	   		JLabel l11 = new JLabel("Welcome");
	   		l11.setFont(new FontUIResource("Tahoma",Font.BOLD,30));
	   		l11.setForeground(new ColorUIResource(0,0,255));
	   		l11.setBounds(220,195,300,35);
	   		p5.add(l11);
	   		
	   		
	   		//username
	   		JLabel l12 = new JLabel("username");
	   		l12.setFont(new FontUIResource("Tahoma",Font.PLAIN,20));
	   		l12.setForeground(new ColorUIResource(0,0,0));
	   		l12.setBounds(160,260,200,25);
	   		p5.add(l12);
	   		
	   		t1=new JTextField();
	   		t1.setFont(new FontUIResource("Tahoma",Font.PLAIN,17));
	   		t1.setForeground(new ColorUIResource(0,0,0));
	   		t1.setBounds(160,290,300,30);
	   		p5.add(t1);
	   		
	   		
	   		//password
	   		JLabel l13 = new JLabel("password");
	   		l13.setFont(new FontUIResource("Tahoma",Font.PLAIN,20));
	   		l13.setForeground(new ColorUIResource(0,0,0));
	   		l13.setBounds(160,350,200,25);
	   		p5.add(l13);
	   		
	   		t2=new JPasswordField();
	   		t2.setFont(new FontUIResource("Tahoma",Font.PLAIN,17));
	   		t2.setForeground(new ColorUIResource(0,0,0));
	   		t2.setBounds(160,380,300,30);
	   		p5.add(t2);
	   		
	   		b1=new JButton("Login");
	   		b1.setFont(new FontUIResource("Tahoma",Font.PLAIN,20));
	   		b1.setBounds(240,450,140,35);
	   		b1.addMouseListener(this);
	   		b1.setBackground(new Color(0,0,255));
	   		b1.setForeground(new ColorUIResource(255,255,255));
	   		p5.add(b1);
	   		
	   		
	   	//exit
			p6= new JPanel();
	   		p6.setBounds(0,485,350,40);
	   		p6.setBackground(new ColorUIResource(0,0,255));
	   		p6.setLayout(null);
	   		p6.addMouseListener(this);
	   		p1.add(p6);
	   		
			JLabel l14= new JLabel("Exit");
	   		l14.setFont(new FontUIResource("Railway", Font.BOLD, 18));
			l14.setForeground(new ColorUIResource(255,255,255));
			l14.setBounds(50,12,300,20);
			p6.add(l14);
			
			ImageIcon i8= new ImageIcon(ClassLoader.getSystemResource("./imags/white-close-icon.png"));
			JLabel l15= new JLabel(i8);
			l15.setBounds(9,8,30,25);
			p6.add(l15); 
			
	   		setUndecorated(true);
	   		
	   	
	}

public static void main(String[] args) {
	new Login().setVisible(true);
	
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==b1) {
			String username=t1.getText();
			String pass=t2.getText();
			if(!username.equals("") && !pass.equals(""))
			{
      String query="select * from login where username='"+username+"' AND password='"+pass+"' ";
      try {
		
    	  ResultSet rs=db.DbConnect.s.executeQuery(query);
    	  if(rs.next()) {
    		  
//    		  JOptionPane.showMessageDialog(null,"succsfully login");
    		  String acc=rs.getString("acct_no");
    		  System.out.println(acc);
    		  String balance1=rs.getString("acct_balance");
    		  int balance2=Integer.parseInt(balance1);
    		  System.out.println(balance2);
    		  String acct=rs.getString("acct_no");
//    		  System.out.println(balance);
    		  if (balance2<=2) {
				new AddBalance(acct).setVisible(true);
			}
    		  else {
    			  new Home(acct).setVisible(true);
			}
    		  
    		
    		  
    	  }
    	  else {
    		  JOptionPane.showMessageDialog(null,"invlid Crednitail");
		}
	} catch (Exception e2) {
		// TODO: handle exception
	}
			}
			else {
				JOptionPane.showMessageDialog(null,"Please input Values");
			}
		
		}
		if(e.getSource()==p2)
		{
		new CreateAcc().setVisible(true);
		}
	
		if(e.getSource()==p3)
		{
			new VerifyAcc().setVisible(true);
		}
		if(e.getSource()==p4)
		{
			new ForgotPass().setVisible(true);
		}
		if(e.getSource()==p6)
		{
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==p2) {
			p2.setBackground(new ColorUIResource(27, 51, 161   ));
		}
		if (e.getSource()==p3) {
			p3.setBackground(new ColorUIResource(27, 51, 161   ));
		}
		if (e.getSource()==p4) {
			p4.setBackground(new ColorUIResource(27, 51, 161   ));
		}
		if (e.getSource()==p6) {
			p6.setBackground(new ColorUIResource(27, 51, 161   ));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		p2.setBackground(new ColorUIResource(0,0,255 ));
		p3.setBackground(new ColorUIResource(0,0,255 ));
		p4.setBackground(new ColorUIResource(0,0,255 ));
		p6.setBackground(new ColorUIResource(0,0,255 ));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
