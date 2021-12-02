package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class CreateAcc extends JFrame implements ActionListener{
	JTextField t1, t2, t3, t4, t5,t6;
	JButton b1,b2;
	JLabel l9,l11,l13;
	JTextArea te1;
	JRadioButton male,female;
    static String rn1 ,rn2,rn3;
	public CreateAcc() {
		// TODO Auto-generated constructor stub
		getContentPane().setBackground(new ColorUIResource(255, 255, 255));
		setBounds(200, 0, 890, 700);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/add profile.png"));
		Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(390, 10, 90, 90);
		add(l1);

		JLabel l2 = new JLabel("Create Bank Account");
		l2.setFont(new FontUIResource("Railway", Font.BOLD, 28));
		l2.setForeground(new ColorUIResource(0, 0, 255));
		l2.setBounds(270, 110, 500, 30);
		add(l2);

		// Initaial information
		JPanel p1 = new JPanel();
		p1.setBounds(15, 150, 440, 480);
		p1.setBackground(new ColorUIResource(240, 181, 145));
		p1.setLayout(null);
		add(p1);

		JLabel l3 = new JLabel("Full Name :");
		l3.setBounds(100, 30, 200, 25);
		l3.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l3);

		t1 = new JTextField();
		t1.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t1.setBounds(100, 60, 250, 25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);

		JLabel l4 = new JLabel("Mother Name :");
		l4.setBounds(100, 110, 200, 25);
		l4.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l4);

		t2 = new JTextField();
		t2.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t2.setBounds(100, 140, 250, 25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);

		JLabel l5 = new JLabel("Mobile Number :");
		l5.setBounds(100, 190, 200, 25);
		l5.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l5);

		t3 = new JTextField();
		t3.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t3.setBounds(100, 220, 250, 25);
		t3.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t3);

		JLabel l6 = new JLabel("Aadhar Number :");
		l6.setBounds(100, 260, 200, 25);
		l6.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l6);

		t4 = new JTextField();
		t4.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t4.setBounds(100, 290, 250, 25);
		t4.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t4);

		JLabel l7 = new JLabel("Pan Number :");
		l7.setBounds(100, 330, 200, 25);
		l7.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l7);

		t5 = new JTextField();
		t5.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t5.setBounds(100, 360, 250, 25);
		t5.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t5);
		
		JLabel l14 = new JLabel("Email:");
		l14.setBounds(100, 400, 200, 25);
		l14.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l14);

		t6 = new JTextField();
		t6.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		t6.setBounds(100, 430, 250, 25);
		t6.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t6);


		// Generation Task
		
		JPanel p2 = new JPanel();
		p2.setBounds(470, 150, 400, 480);
		p2.setBackground(new ColorUIResource(240, 181, 145));
		p2.setLayout(null);
		add(p2);
		
		JLabel l16 = new JLabel("Address :");
		l16.setBounds(90, 90, 300, 25);
		l16.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p2.add(l16);
		
		te1 = new JTextArea();
		te1.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		te1.setBounds(90, 116, 250, 50);
		te1.setBorder(BorderFactory.createEmptyBorder());
		p2.add(te1);
		
		JLabel l15 = new JLabel(" Please dont forgot this Account Details");
		l15.setBounds(25, 180, 400, 20);
		l15.setForeground(new ColorUIResource(199, 9, 9));
		l15.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p2.add(l15); 

		JLabel l8 = new JLabel("Account Number :");
		l8.setBounds(90, 200, 300, 25);
		l8.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p2.add(l8);

		 l9 = new JLabel();
		l9.setBounds(90, 230, 200, 25);
		l9.setFont(new FontUIResource("Tahoma", Font.BOLD, 18));
		p2.add(l9);
		
		JLabel l10= new JLabel("Debit-card Number :");
		l10.setBounds(90, 270, 200, 25);
		l10.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p2.add(l10);

		 l11 = new JLabel();
		l11.setBounds(90, 300, 200, 20);
		l11.setFont(new FontUIResource("Tahoma", Font.BOLD, 18));
		p2.add(l11);
		
		JLabel l12= new JLabel("Pin :");
		l12.setBounds(90, 340, 200, 25);
		l12.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p2.add(l12);

		 l13 = new JLabel();
		l13.setBounds(90, 370, 200, 20);
		l13.setFont(new FontUIResource("Tahoma", Font.BOLD, 18));
		p2.add(l13);
		
		JLabel l17= new JLabel("Gender :");
		l17.setBounds(90, 30, 200, 25);
		l17.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p2.add(l17);
		
		male= new JRadioButton("Male");
		male.addActionListener(this);
		male.setBounds(85, 55 ,70 ,34);
		male.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		male.setBackground(new ColorUIResource(240, 181, 145));
		p2.add(male);
		
		
		female= new JRadioButton("Female");
		female.addActionListener(this);
		female.setBounds(180, 55 ,100 ,34);
		female.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		female.setBackground(new ColorUIResource(240, 181, 145));
		p2.add(female);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);

		b2=new JButton("Generate");
   		b2.setFont(new FontUIResource("Tahoma",Font.PLAIN,17));
   		b2.setBounds(120,405,200,25);
   		b2.addActionListener(this);
   		b2.setBackground(new Color(0,0,255));
   		b2.setForeground(new ColorUIResource(255,255,255));
   		p2.add(b2);
   		
		

		b1 = new JButton("Save ");
		b1.setFont(new FontUIResource("Tahoma", Font.PLAIN, 17));
		b1.setBounds(180, 440, 100, 25);
		b1.addActionListener(this);
		b1.setBackground(new Color(0, 0, 255));
		b1.setForeground(new ColorUIResource(255, 255, 255));
		p2.add(b1);
		
		
		}
		public static void main(String[] args) {
			new CreateAcc().setVisible(true);
			
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b2) {
			{ 
				rn1=CreateAcc.ran();
				l9.setText(rn1);
				
				rn2=CreateAcc.ran();
				l11.setText(rn2);
				
				Random random= new Random();
				int rn3=random.nextInt(10000);
				String rn4=Integer.toString(rn3);
				l13.setText(rn4);
				
				b2.setEnabled(true);
			       b2.setEnabled(false);
			       
			       
			}
			
		}
		
		if (e.getSource()==b1) 
		{
			String full_name=t1.getText();
			String mother_name=t2.getText();
			String phone=t3.getText();
			String adhar=t4.getText();
			String pan=t5.getText();
			
			String acct_no=l9.getText();
			String debit_no=l11.getText();
			String pin=l13.getText();
			String email=t6.getText();
			String addres=te1.getText();
			String gender;
			if (male.isSelected()) {
				gender="Male";
			}else {
				gender="Female";
			}
	

			Date currDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strCurrDate = dateFormat.format(currDate);
			System.out.println(strCurrDate);
			
			 java.sql.Date sqlDate = new java.sql.Date(currDate.getTime());
			
			
			String query="insert into create_acc value('"+full_name+"' ,'"+mother_name+"' ,'"+phone+"' ,"
					+ " '"+adhar+"' ,'"+pan+"' ,'"+acct_no+"','"+debit_no+"','"+pin+"','"+email+"','"+addres+"',"
							+ "'"+gender+"','"+sqlDate+"' )";
			
			if (!full_name.equals("") && !mother_name.equals("") && !phone.equals("") && !adhar.equals("") && 
					!pan.equals("") && !acct_no.equals("") && !debit_no.equals("") && !pin.equals("") && !email.equals("")
					&& !addres.equals("")) {
			
			try {
				
				db.DbConnect.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Account create succesfully");
				new EmailVer(acct_no).setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			
			}
			else {
				JOptionPane.showMessageDialog(null, "Please insert values");
			}
		}
		
	}
	
   
	public static  String ran() {
		
		Random random= new Random();
		int r1 =random.nextInt(1000000000);
		String ra=Integer.toString(r1);
		return ra;
	}
}
