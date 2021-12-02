package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCard extends JFrame implements ActionListener {
	JLabel name, mothern, phone, aadhar, pan, email, gender, acctn;
	JTextArea te1;
	JComboBox qualification;
	JRadioButton yes, no;
	JTextField salary;
	JButton apply;
//	static String rn1, rn2, rn3;
	String acct;

	public CreditCard(String acct) {
		this.acct = acct;
		setBounds(200, 0, 890, 750);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./imags/add profile.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(410, 10, 70, 70);
		add(l1);

		JLabel l2 = new JLabel("Application Form For Credit-Card");
		l2.setFont(new FontUIResource("Railway", Font.BOLD, 24));
		l2.setForeground(new ColorUIResource(0, 0, 255));
		l2.setBounds(210, 90, 700, 30);
		add(l2);

		JPanel p1 = new JPanel();
		p1.setBounds(15, 150, 860, 530);
		p1.setBackground(new ColorUIResource(155, 231, 68));
		p1.setLayout(null);
		add(p1);

		JLabel l3 = new JLabel("Full Name :");
		l3.setBounds(100, 30, 200, 25);
		l3.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l3);

		name = new JLabel();
		name.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
		name.setBounds(100, 60, 250, 25);
		name.setBorder(BorderFactory.createEmptyBorder());
		p1.add(name);

		JLabel l4 = new JLabel("Mother Name :");
		l4.setBounds(100, 100, 200, 25);
		l4.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l4);

		mothern = new JLabel();
		mothern.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
		mothern.setBounds(100, 130, 250, 25);
		mothern.setBorder(BorderFactory.createEmptyBorder());
		p1.add(mothern);

		JLabel l5 = new JLabel("Mobile Number :");
		l5.setBounds(100, 170, 200, 25);
		l5.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l5);

		phone = new JLabel();
		phone.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
		phone.setBounds(100, 200, 250, 25);
		phone.setBorder(BorderFactory.createEmptyBorder());
		p1.add(phone);

		JLabel l6 = new JLabel("Aadhar Number :");
		l6.setBounds(100, 240, 200, 25);
		l6.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l6);

		aadhar = new JLabel();
		aadhar.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
		aadhar.setBounds(100, 270, 250, 25);
		aadhar.setBorder(BorderFactory.createEmptyBorder());
		p1.add(aadhar);

		JLabel l7 = new JLabel("Pan Number :");
		l7.setBounds(100, 310, 200, 25);
		l7.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l7);

		pan = new JLabel();
		pan.setFont(new FontUIResource("FemaleTahoma", Font.BOLD, 17));
		pan.setBounds(100, 350, 250, 25);
		pan.setBorder(BorderFactory.createEmptyBorder());
		p1.add(pan);

		JLabel l14 = new JLabel("Email:");
		l14.setBounds(100, 380, 200, 25);
		l14.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l14);

		email = new JLabel();
		email.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		email.setBounds(100, 410, 300, 25);
		email.setBorder(BorderFactory.createEmptyBorder());
		p1.add(email);

		JLabel l15 = new JLabel("Gender :");
		l15.setBounds(100, 450, 200, 25);
		l15.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l15);

		gender = new JLabel();
		gender.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
		gender.setBounds(100, 480, 250, 25);
		gender.setBorder(BorderFactory.createEmptyBorder());
		p1.add(gender);

		JLabel l16 = new JLabel("Address :");
		l16.setBounds(500, 30, 300, 25);
		l16.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(l16);

		te1 = new JTextArea();
		te1.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		te1.setBounds(500, 60, 250, 50);
		te1.setEditable(false);
		te1.setBorder(BorderFactory.createEmptyBorder());
		te1.setBackground(new ColorUIResource(155, 231, 68));
		p1.add(te1);

		JLabel l8 = new JLabel("Account Number :");
		l8.setBounds(500, 165, 300, 25);
		l8.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l8);

		acctn = new JLabel();
		acctn.setBounds(500, 195, 200, 25);
		acctn.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
		p1.add(acctn);

		JLabel l10 = new JLabel("Education Qualification:");
		l10.setBounds(500, 230, 200, 25);
		l10.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l10);

		String education[] = { "Under-Graduate", "Graduate", "Post-Graduate", "Docterate" };

		qualification = new JComboBox(education);
		qualification.setBounds(500, 265, 200, 20);
		qualification.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		p1.add(qualification);

		JLabel l17 = new JLabel("Are You Employed Or Not ? :");
		l17.setBounds(500, 305, 300, 25);
		l17.setFont(new FontUIResource("Tahoma", Font.BOLD, 14));
		p1.add(l17);

		yes = new JRadioButton("Yes");
		yes.addActionListener(this);
		yes.setBounds(500, 335, 70, 34);
		yes.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		yes.setBackground(new ColorUIResource(155, 231, 68));
		p1.add(yes);

		no = new JRadioButton("No");
		no.addActionListener(this);
		no.setBounds(650, 335, 100, 34);
		no.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		no.setBackground(new ColorUIResource(155, 231, 68));
		p1.add(no);

		ButtonGroup bg = new ButtonGroup();
		bg.add(yes);
		bg.add(no);

		JLabel l18 = new JLabel("Monthly Salary :");
		l18.setBounds(500, 375, 200, 25);
		l18.setFont(new FontUIResource("Tahoma", Font.BOLD, 15));
		p1.add(l18);

		salary = new JTextField();
		salary.setBounds(500, 410, 200, 25);
		salary.setFont(new FontUIResource("Tahoma", Font.BOLD, 16));
		p1.add(salary);

		apply = new JButton("Apply");
		apply.setBounds(520, 460, 150, 25);
		apply.setFont(new FontUIResource("Tahoma", Font.BOLD, 17));
		apply.setBackground(new Color(0, 0, 255));
		apply.setForeground(new ColorUIResource(255, 255, 255));
		apply.addActionListener(this);
		p1.add(apply);

		System.out.println("credit frame  " + acct);
		String query = "select * from create_acc where acct_no='" + acct + "' ";
		try {
			ResultSet rs1 = db.DbConnect.s.executeQuery(query);
			while (rs1.next()) {

				name.setText(rs1.getString("name"));
				mothern.setText(rs1.getString("mother_name"));
				phone.setText(rs1.getString("number"));
				aadhar.setText(rs1.getString("adhar_no"));
				pan.setText(rs1.getString("pan_no"));
				email.setText(rs1.getString("email"));
				gender.setText(rs1.getString("gender"));
				te1.setText(rs1.getString("address"));
				acctn.setText(rs1.getString("acct_no"));

			}
		    rs1.close ();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block

		}
	}

public static void main(String[] args) {
	new CreditCard("").setVisible(true);
	
}
	@Override
	public void actionPerformed(ActionEvent e)  {
		if (e.getSource() == apply) {

			String education = (String) qualification.getSelectedItem();
			String employed;

			if (yes.isSelected()) {
				employed = "yes";

			} else {
				employed = "no";
			}

			if (yes.isSelected()) {
                     String name1= name.getText();
                     String mothern1=mothern.getText();
                     String phone1=  phone.getText();
                     String adhar1= aadhar.getText() ;
                     String pan1=pan.getText();
                     String email1= email.getText() ;
                     String gender1= gender.getText();
                     String address1=  te1.getText()  ;
                     String acctn1= acctn.getText();
                     String salary1=  salary.getText() ;
				
				
				try {

					String query2 = "insert into credit_card value('" +name1 + "' ,'" +mothern1
							+ "','" + phone1+ "' ," + "'" + adhar1 + "','" +pan1 + "','"
							+ email1 + "','" + gender1 + "','" + address1+ "'," + "'"
							+ acctn1 + "','" + education + "','" + employed + "','" + salary1 + "',"
							+ "'1','1','2001/1/1','1','1' )";
					db.DbConnect.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null,
							"Hurray ! \nYou'r Eligible for credit card press ok to get one ");

					new CreditCardInfo(acct).setVisible(true);
				} catch (Exception e2) {
             System.out.println(e2);
				}
			} else {
				JOptionPane.showMessageDialog(null, "can't apply for Credit Card because you are not Employed");
			}
		}
	}
}
