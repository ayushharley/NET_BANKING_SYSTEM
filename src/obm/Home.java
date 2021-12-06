package obm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import com.email.durgesh.Email;
import com.mysql.cj.xdevapi.PreparableStatement;

import net.proteanit.sql.DbUtils;

public class Home extends JFrame implements MouseInputListener, ActionListener, KeyListener {

	JPanel p1, p2, Home, Transfer, Account, Card, Profile, Logout, ProfilePanel, HomePanel, Accountpanel, p12,
			CardPanel, p14, p15, p16, p17, TransferPanel, p18, p19;
	// home
	JLabel namemain, debitacc, debitbalance, creditcardnol, creditbalancel;
	JButton apply;

	// Account
	JLabel pan1, acct_no1, customer_name, acct_no2, debitbalance1;
	JTextArea addressl;

	// tranfer
	JTextField transfer_receiveracc, transfer_receiveramo;
	JButton transfer_receiverpay;

	// cards
	// creditcard
	JLabel cardcreditbalancel, cardcreditdatel, cardcreditcvvl, cardcreditcardno2l, cardcreditcardno1l,
			cardcreditcardnamel;
	JTextField creditoldpint;
	static JTextField creditotpt;
	JTextField credit_newpint;
	JTextField credit_repint;
	JButton creditsendob;
	static JButton creditverifyotpb;
	JButton credit_changepinb;

	// debitcard
	JLabel debitnol, cvvl, debitnamel, debitno2l, debitdatel, debitbalance2l;
	JTextField debit_old_pint, debit_otpt, debit_new_pint, debit_repint;
	JButton debit_send_otpb, debit_verify_otpb, debit_changeb;
	String debit_new_repin;

	// profile
	JLabel l1, acct_nol, panl, adhar, emaill, usernamel,nameprofile;

	// databse string
	String name, mother_name, number, adhar_no, pan_no, acct_no, debit_no, debit_pin, email, address, gender, date,
			username, creditcardno, creditbalance, balance, creditdate, creditcvv, creditname, creditpin;
    
	static String creditemail;
	static String card_name ;
	static String otp;
	String repin;

	//jtable
	JTable j1,j2;
	JScrollPane sp1,sp2;
	java.sql.Date date1;
	String receiver_acct_no,receiver_amo,cd;
	DefaultTableModel model1,model2,model3;
	String acct ;

	public Home(String acct) {
this.acct=acct;

//-----------------------------------------------------------------values from databases start--------------------------------------------------------

		try {

			String query = "select * from create_acc where acct_no='" + acct + "' ";
			ResultSet rs = db.DbConnect.s.executeQuery(query);
			while (rs.next()) {

				name = rs.getString("name");
				mother_name = rs.getString("mother_name");
				number = rs.getString("number");
				adhar_no = rs.getString("adhar_no");
				pan_no = rs.getString("pan_no");
				debit_no = rs.getString("debit_no");
				debit_pin = rs.getString("pin");
				email = rs.getString("email");
				address = rs.getString("address");
				gender = rs.getString("gender");
				date = rs.getString("date");

			}

			String query2 = "select * from login where acct_no='" + acct + "' ";
			ResultSet rs2 = db.DbConnect.s.executeQuery(query2);
			while (rs2.next()) {
				username = rs2.getString("username");

				balance = rs2.getString("acct_balance");
			}

			String query3 = "select * from credit_card where acct_no='" + acct + "' ";
			ResultSet rs3 = db.DbConnect.s.executeQuery(query3);
			while (rs3.next()) {
				creditcardno = rs3.getString("card_no");
				creditname = rs3.getString("name");
				creditcvv = rs3.getString("cvv");
				creditdate = rs3.getString("date");
				creditbalance = rs3.getString("balance");
				creditpin = rs3.getString("pin");
				creditemail = rs3.getString("email");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

//	---------------------------------------------------------values from databases end-------------------------------------------------------

		getContentPane().setBackground(new ColorUIResource(255, 255, 255));
		setBounds(100, 50, 1300, 700);
		setLayout(null);

		p1 = new JPanel();
		p1.setBounds(0, 0, 1300, 50);
		p1.setBackground(new ColorUIResource(43, 69, 253));
		p1.setLayout(null);
		add(p1);

		l1 = new JLabel("Home Section");
		l1.setFont(new FontUIResource("Railway", Font.BOLD, 22));
		l1.setForeground(new ColorUIResource(255, 255, 255));
		l1.setBounds(550, 10, 500, 30);
		p1.add(l1);

		p2 = new JPanel();
		p2.setBounds(0, 50, 90, 700);
		p2.setBackground(new ColorUIResource(43, 69, 253));
		p2.setLayout(null);
		add(p2);

//-------------------------------------------------home-------------------------------------------------------		
		Home = new JPanel();
		Home.setBounds(0, 60, 90, 70);
		Home.setBackground(new ColorUIResource(21, 50, 252));
		Home.setLayout(null);
		Home.addMouseListener(this);
		p2.add(Home);

		ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("./imags/white-home.png"));
		Image i112 = i111.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i113 = new ImageIcon(i112);
		JLabel l111 = new JLabel(i113);
		l111.setBounds(25, 15, 30, 30);
		Home.add(l111);

		JLabel l51 = new JLabel("Home ");
		l51.setFont(new FontUIResource("Railway", Font.PLAIN, 15));
		l51.setForeground(new ColorUIResource(255, 255, 255));
		l51.setBounds(19, 50, 50, 15);
		Home.add(l51);

//--------------------------------------------------Transfer---------------------------------------------------------------		

		Transfer = new JPanel();
		Transfer.setBounds(0, 150, 90, 70);
		Transfer.setBackground(new ColorUIResource(21, 50, 252));
		Transfer.setLayout(null);
		Transfer.addMouseListener(this);
		p2.add(Transfer);

		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("./imags/transfer-icon.png"));
		Image i12 = i11.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i13 = new ImageIcon(i12);
		JLabel l11 = new JLabel(i13);
		l11.setBounds(25, 15, 30, 30);
		Transfer.add(l11);

		JLabel l52 = new JLabel("Transfer ");
		l52.setFont(new FontUIResource("Railway", Font.PLAIN, 14));
		l52.setForeground(new ColorUIResource(255, 255, 255));
		l52.setBounds(15, 50, 70, 15);
		Transfer.add(l52);

//------------------------------------Account----------------------------------------------------

		Account = new JPanel();
		Account.setBounds(0, 240, 90, 70);
		Account.setBackground(new ColorUIResource(21, 50, 252));
		Account.setLayout(null);
		Account.addMouseListener(this);
		p2.add(Account);

		ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("./imags/white-moneybag.png"));
		Image i22 = i21.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i23 = new ImageIcon(i22);
		JLabel l21 = new JLabel(i23);
		l21.setBounds(25, 15, 30, 30);
		Account.add(l21);

		JLabel l53 = new JLabel("Account ");
		l53.setFont(new FontUIResource("Railway", Font.PLAIN, 14));
		l53.setForeground(new ColorUIResource(255, 255, 255));
		l53.setBounds(15, 50, 70, 15);
		Account.add(l53);

//-------------------------------------------Card-------------------------------------------------------------		

		Card = new JPanel();
		Card.setBounds(0, 330, 90, 70);
		Card.setBackground(new ColorUIResource(21, 50, 252));
		Card.setLayout(null);
		Card.addMouseListener(this);
		p2.add(Card);

		ImageIcon i31 = new ImageIcon(ClassLoader.getSystemResource("./imags/white-card.png"));
		Image i32 = i31.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i32);
		JLabel l31 = new JLabel(i33);
		l31.setBounds(27, 15, 30, 30);
		Card.add(l31);

		JLabel l54 = new JLabel("Card ");
		l54.setFont(new FontUIResource("Railway", Font.PLAIN, 15));
		l54.setForeground(new ColorUIResource(255, 255, 255));
		l54.setBounds(23, 50, 50, 15);
		Card.add(l54);

//--------------------------------------------------Profile---------------------------------------------------------------		

		Profile = new JPanel();
		Profile.setBounds(0, 420, 90, 70);
		Profile.setBackground(new ColorUIResource(21, 50, 252));
		Profile.setLayout(null);
		Profile.addMouseListener(this);
		p2.add(Profile);

		ImageIcon i41 = new ImageIcon(ClassLoader.getSystemResource("./imags/white-user-icon.png"));
		Image i42 = i41.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i43 = new ImageIcon(i42);
		JLabel l41 = new JLabel(i43);
		l41.setBounds(25, 15, 30, 30);
		Profile.add(l41);

		JLabel l55 = new JLabel("Profile ");
		l55.setFont(new FontUIResource("Railway", Font.PLAIN, 14));
		l55.setForeground(new ColorUIResource(255, 255, 255));
		l55.setBounds(20, 50, 70, 15);
		Profile.add(l55);

//------------------------------------Logout----------------------------------------------------

		Logout = new JPanel();
		Logout.setBounds(0, 510, 90, 70);
		Logout.setBackground(new ColorUIResource(21, 50, 252));
		Logout.setLayout(null);
		Logout.addMouseListener(this);
		p2.add(Logout);

		ImageIcon i51 = new ImageIcon(ClassLoader.getSystemResource("./imags/white-logout-logo.png"));
		Image i52 = i51.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i53 = new ImageIcon(i52);
		JLabel l81 = new JLabel(i53);
		l81.setBounds(25, 15, 30, 30);
		Logout.add(l81);

		JLabel l56 = new JLabel("Log-Out ");
		l56.setFont(new FontUIResource("Railway", Font.PLAIN, 14));
		l56.setForeground(new ColorUIResource(255, 255, 255));
		l56.setBounds(15, 50, 70, 15);
		Logout.add(l56);

//------------------------------------Profile panel-------------------------------------------------------------

		ProfilePanel = new JPanel();
		ProfilePanel.setBounds(50, 50, 1250, 650);
		ProfilePanel.setBackground(new ColorUIResource(255, 255, 255));
		ProfilePanel.setLayout(null);
		add(ProfilePanel);

		ImageIcon i61 = new ImageIcon(ClassLoader.getSystemResource("./imags/card-hxl.png"));
		Image i62 = i61.getImage().getScaledInstance(700, 540, Image.SCALE_DEFAULT);
		ImageIcon i63 = new ImageIcon(i62);
		JLabel l61 = new JLabel(i63);
		l61.setBounds(300, 50, 700, 555);
		ProfilePanel.add(l61);

		ImageIcon i64 = new ImageIcon(ClassLoader.getSystemResource("./imags/male-profile.png"));
		Image i65 = i64.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i66 = new ImageIcon(i65);
		JLabel l62 = new JLabel(i66);
		l62.setBounds(320, 15, 80, 80);
		l61.add(l62);

		nameprofile = new JLabel();
		nameprofile.setFont(new FontUIResource("Railway", Font.BOLD, 19));
		nameprofile.setForeground(new ColorUIResource(255, 255, 255));
		nameprofile.setBounds(250, 100, 470, 22);
		l61.add(nameprofile);

		JLabel l64 = new JLabel("_________________________________________________________________________");
		l64.setForeground(new ColorUIResource(255, 255, 255));
		l64.setBounds(180, 120, 500, 22);
		l61.add(l64);

		JLabel l65 = new JLabel("Account No      ");
		l65.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l65.setForeground(new ColorUIResource(255, 255, 255));
		l65.setBounds(186, 190, 270, 22);
		l61.add(l65);

		acct_nol = new JLabel();
		acct_nol.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		acct_nol.setForeground(new ColorUIResource(255, 255, 255));
		acct_nol.setBounds(380, 190, 270, 22);
		l61.add(acct_nol);

		JLabel l67 = new JLabel(" username         ");
		l67.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l67.setForeground(new ColorUIResource(255, 255, 255));
		l67.setBounds(180, 230, 270, 22);
		l61.add(l67);

		usernamel = new JLabel();
		usernamel.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		usernamel.setForeground(new ColorUIResource(255, 255, 255));
		usernamel.setBounds(380, 230, 270, 22);
		l61.add(usernamel);

		JLabel l69 = new JLabel(" Adhar No        ");
		l69.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l69.setForeground(new ColorUIResource(255, 255, 255));
		l69.setBounds(180, 270, 270, 22);
		l61.add(l69);

		adhar = new JLabel();
		adhar.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		adhar.setForeground(new ColorUIResource(255, 255, 255));
		adhar.setBounds(380, 270, 270, 22);
		l61.add(adhar);

		JLabel l70 = new JLabel(" Pan No          ");
		l70.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l70.setForeground(new ColorUIResource(255, 255, 255));
		l70.setBounds(180, 310, 270, 22);
		l61.add(l70);

		panl = new JLabel();
		panl.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		panl.setForeground(new ColorUIResource(255, 255, 255));
		panl.setBounds(380, 310, 270, 22);
		l61.add(panl);

		JLabel l73 = new JLabel(" Account Type   ");
		l73.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l73.setForeground(new ColorUIResource(255, 255, 255));
		l73.setBounds(180, 350, 270, 22);
		l61.add(l73);

		JLabel l74 = new JLabel("Saving ");
		l74.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l74.setForeground(new ColorUIResource(255, 255, 255));
		l74.setBounds(380, 350, 270, 22);
		l61.add(l74);

		JLabel l75 = new JLabel(" Email           ");
		l75.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l75.setForeground(new ColorUIResource(255, 255, 255));
		l75.setBounds(180, 390, 270, 22);
		l61.add(l75);

		emaill = new JLabel();
		emaill.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		emaill.setForeground(new ColorUIResource(255, 255, 255));
		emaill.setBounds(380, 390, 400, 22);
		l61.add(emaill);

		nameprofile.setText(name);
		acct_nol.setText(acct);
		adhar.setText(adhar_no);
		panl.setText(pan_no);
		emaill.setText(email);
		usernamel.setText(username);

//---------------------------------------------home panel-----------------------------------------------------		

		HomePanel = new JPanel();
		HomePanel.setBounds(50, 50, 1250, 650);
		HomePanel.setBackground(new ColorUIResource(255, 255, 255));
		HomePanel.setLayout(null);
		add(HomePanel);

		namemain = new JLabel();
		namemain.setFont(new FontUIResource("Railway", Font.BOLD, 18));
		namemain.setForeground(new ColorUIResource(30, 87, 238));
		namemain.setBounds(450, 15, 550, 25);
		HomePanel.add(namemain);

		JLabel l78 = new JLabel("Welcome to Sky Bank");
		l78.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l78.setForeground(new ColorUIResource(109, 110, 113));
		l78.setBounds(520, 40, 550, 25);
		HomePanel.add(l78);

		ImageIcon homeimg = new ImageIcon(ClassLoader.getSystemResource("./imags/pinkblue1.png"));
		Image homeimg2 = homeimg.getImage().getScaledInstance(1100, 550, Image.SCALE_DEFAULT);
		ImageIcon homeimg3 = new ImageIcon(homeimg2);
		JLabel homeimage = new JLabel(homeimg3);
		homeimage.setBounds(85, 90, 1100, 500);
		HomePanel.add(homeimage);

		ImageIcon i24 = new ImageIcon(ClassLoader.getSystemResource("./imags/card.png"));
		Image i25 = i24.getImage().getScaledInstance(360, 200, Image.SCALE_DEFAULT);
		ImageIcon i26 = new ImageIcon(i25);
		JLabel l79 = new JLabel(i26);
		l79.setBounds(85, 40, 360, 200);
		homeimage.add(l79);

		JLabel icon = new JLabel("Debit Card");
		icon.setFont(new FontUIResource("Railway", Font.BOLD, 15));
		icon.setForeground(new ColorUIResource(255, 255, 255));
		icon.setBounds(20, 30, 200, 25);
		l79.add(icon);

		debitacc = new JLabel();
		debitacc.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		debitacc.setForeground(new ColorUIResource(255, 255, 255));
		debitacc.setBounds(20, 60, 200, 25);
		l79.add(debitacc);

		JLabel rupee = new JLabel("₹");
		rupee.setFont(new FontUIResource("Railway", Font.PLAIN, 25));
		rupee.setForeground(new ColorUIResource(255, 255, 255));
		rupee.setBounds(20, 120, 20, 50);
		l79.add(rupee);

		debitbalance = new JLabel();
		debitbalance.setFont(new FontUIResource("Railway", Font.PLAIN, 25));
		debitbalance.setForeground(new ColorUIResource(255, 255, 255));
		debitbalance.setBounds(50, 120, 200, 50);
		l79.add(debitbalance);

		ImageIcon debitlogo = new ImageIcon(ClassLoader.getSystemResource("./imags/mastercard-icon.png"));
		JLabel debitlogo2 = new JLabel(debitlogo);
		debitlogo2.setBounds(300, 2, 40, 40);
		l79.add(debitlogo2);

		// value
		namemain.setText(" Hello ! "+name);
		debitacc.setText(debit_no);
		debitbalance.setText(balance);
		//

		ImageIcon i27 = new ImageIcon(ClassLoader.getSystemResource("./imags/card-sky-blue.png"));
		Image i28 = i27.getImage().getScaledInstance(360, 200, Image.SCALE_DEFAULT);
		ImageIcon i29 = new ImageIcon(i28);
		JLabel l80 = new JLabel(i29);
		l80.setBounds(85, 270, 360, 200);
		homeimage.add(l80);

		JLabel icon2 = new JLabel("Credit Card");
		icon2.setFont(new FontUIResource("Railway", Font.BOLD, 15));
		icon2.setForeground(new ColorUIResource(255, 255, 255));
		icon2.setBounds(20, 30, 200, 25);
		l80.add(icon2);

		creditcardnol = new JLabel();
		creditcardnol.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		creditcardnol.setForeground(new ColorUIResource(255, 255, 255));
		creditcardnol.setBounds(20, 60, 200, 25);
		l80.add(creditcardnol);
		creditcardnol.setVisible(false);

		JLabel rupee2 = new JLabel("₹");
		rupee2.setFont(new FontUIResource("Railway", Font.PLAIN, 25));
		rupee2.setForeground(new ColorUIResource(255, 255, 255));
		rupee2.setBounds(20, 120, 20, 50);
		l80.add(rupee2);

		creditbalancel = new JLabel("43255");
		creditbalancel.setFont(new FontUIResource("Railway", Font.PLAIN, 25));
		creditbalancel.setForeground(new ColorUIResource(255, 255, 255));
		creditbalancel.setBounds(50, 120, 200, 50);
		l80.add(creditbalancel);

		ImageIcon creditlogo = new ImageIcon(ClassLoader.getSystemResource("./imags/visa-icon.png"));
		JLabel creditlogo1 = new JLabel(creditlogo);
		creditlogo1.setBounds(300, 2, 60, 50);
		l80.add(creditlogo1);

		apply = new JButton("Apply for Cedit Card");
		apply.setBackground(new Color(0, 0, 255));
		apply.setForeground(new ColorUIResource(255, 255, 255));
		apply.setFont(new FontUIResource("Tahoma", Font.PLAIN, 17));
		apply.addMouseListener(this);
		apply.setBounds(70, 70, 230, 30);
		l80.add(apply);

		creditcardnol.setText(creditcardno);
		creditbalancel.setText(creditbalance);

		creditcardnol.setVisible(false);
		rupee2.setVisible(false);
		creditbalancel.setVisible(false);
		creditlogo1.setVisible(false);
		apply.setVisible(false);

		try {
			String query = "select * from credit_card where acct_no='" + acct + "'";
			ResultSet rs = db.DbConnect.s.executeQuery(query);

			if (rs.next()) {

				creditcardnol.setVisible(true);
				rupee2.setVisible(true);
				creditbalancel.setVisible(true);
				creditlogo1.setVisible(true);

			} else {
				apply.setVisible(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

//------------------------------------------------------home panel Account Statement------------------------------------------------------------		

		JLabel statement = new JLabel("Account Statement");
		statement.setFont(new FontUIResource("Railway", Font.BOLD, 18));
		statement.setForeground(new ColorUIResource(255, 255, 255));
		statement.setBounds(690, 10, 400, 25);
		homeimage.add(statement);

		JPanel HomePanel2 = new JPanel();
		HomePanel2.setBounds(530, 50, 472, 430);
		HomePanel2.setBackground(new ColorUIResource(211, 243, 132));
		HomePanel2.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));

		homeimage.add(HomePanel2);
		
		// Data to be displayed in the JTable

		// Initializing the JTable
		j1 = new JTable();
		j1.getTableHeader().setBounds(30, 580, 200, 300);
		j1.setBackground(new ColorUIResource(211, 243, 132));
		j1.getTableHeader().setReorderingAllowed(false);
		j1.getTableHeader().setFont(new FontUIResource("Railway", Font.BOLD, 14));
		// adding it to JScrollPane
		 model1 = new DefaultTableModel(new Object[] { "Date", "Account No", "Amount", "C/D" }, 0);
		j1.setModel(model1);
		j1.setEnabled(false);
		j1.setRowHeight(50);
		sp1 = new JScrollPane(j1);
		sp1.setBackground(new ColorUIResource(211, 243, 132));
		HomePanel2.add(sp1);
		try {
			String query = "select * from acct_statement where user_acct_no='"+acct+"' ";
			ResultSet rs = db.DbConnect.s.executeQuery(query);
			while (rs.next()) {
				Date date = rs.getDate(1);
				String acct_no = rs.getString(2);
				String amount = rs.getString(3);
				String cd = rs.getString(4);

				Object tbdata[] = { date, acct_no, amount, cd };
				model1.addRow(tbdata);
				
				
			}
		} catch (Exception e) {

		}

//-----------------------------------------------------HOme End--------------------------------------------------

//-----------------------------------------------------Account--------------------------------------------------

		Accountpanel = new JPanel();
		Accountpanel.setBounds(50, 50, 1250, 650);
		Accountpanel.setBackground(new ColorUIResource(255, 255, 255));
		Accountpanel.setLayout(null);
		add(Accountpanel);
		Accountpanel.setEnabled(true);

		p12 = new JPanel();
		p12.setBounds(170, 50, 950, 350);
		p12.setBackground(new ColorUIResource(255, 255, 255));
		p12.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p12.setLayout(null);
		Accountpanel.add(p12);

		ImageIcon i35 = new ImageIcon(ClassLoader.getSystemResource("./imags/banklogo-xl.png"));
		Image i36 = i35.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i37 = new ImageIcon(i36);
		JLabel l82 = new JLabel(i37);
		l82.setBounds(435, 10, 70, 70);
		p12.add(l82);

		JLabel l84 = new JLabel("Pass-Book");
		l84.setFont(new FontUIResource("Railway", Font.BOLD, 19));
		l84.setForeground(new ColorUIResource(48, 206, 216));
		l84.setBounds(20, 10, 200, 25);
		p12.add(l84);

		JLabel l85 = new JLabel("Sky Bank");
		l85.setFont(new FontUIResource("Railway", Font.BOLD, 19));
		l85.setForeground(new ColorUIResource(58, 88, 200));
		l85.setBounds(630, 30, 200, 25);
		p12.add(l85);

		JLabel l86 = new JLabel("Address ");
		l86.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l86.setForeground(new ColorUIResource(71, 73, 73));
		l86.setBounds(560, 120, 200, 25);
		p12.add(l86);

		JTextArea l87 = new JTextArea("Budhwar peth,\nSky Tower,Pune");
		l87.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l87.setForeground(new ColorUIResource(58, 88, 200));
		l87.setEditable(false);
		l87.setBounds(690, 123, 200, 45);
		p12.add(l87);

		JLabel l88 = new JLabel("Phone  ");
		l88.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l88.setForeground(new ColorUIResource(71, 73, 73));
		l88.setBounds(560, 175, 200, 25);
		p12.add(l88);

		JLabel l89 = new JLabel("9234567211");
		l89.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l89.setForeground(new ColorUIResource(71, 73, 73));
		l89.setBounds(690, 175, 200, 25);
		p12.add(l89);

		JLabel l90 = new JLabel("Email ");
		l90.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l90.setForeground(new ColorUIResource(71, 73, 73));
		l90.setBounds(560, 220, 200, 25);
		p12.add(l90);

		JLabel l91 = new JLabel("Skybank@gmail.com");
		l91.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l91.setForeground(new ColorUIResource(71, 73, 73));
		l91.setBounds(690, 220, 200, 25);
		p12.add(l91);

		JLabel l92 = new JLabel("IFSC  ");
		l92.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l92.setForeground(new ColorUIResource(71, 73, 73));
		l92.setBounds(560, 260, 200, 25);
		p12.add(l92);

		JLabel l93 = new JLabel("SKY0000501");
		l93.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l93.setForeground(new ColorUIResource(71, 73, 73));
		l93.setBounds(690, 260, 200, 25);
		p12.add(l93);

// ----------------------------------------------------customer details----------------------------------------------------------------

		JLabel l94 = new JLabel("Account Status  ");
		l94.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l94.setForeground(new ColorUIResource(71, 73, 73));
		l94.setBounds(50, 120, 200, 25);
		p12.add(l94);

		JLabel l95 = new JLabel("Active");
		l95.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l95.setForeground(new ColorUIResource(71, 73, 73));
		l95.setBounds(250, 120, 200, 25);
		p12.add(l95);

		JLabel l96 = new JLabel("Account Type  ");
		l96.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l96.setForeground(new ColorUIResource(71, 73, 73));
		l96.setBounds(50, 150, 200, 25);
		p12.add(l96);

		JLabel l97 = new JLabel("Saving");
		l97.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l97.setForeground(new ColorUIResource(71, 73, 73));
		l97.setBounds(250, 150, 200, 25);
		p12.add(l97);

		JLabel l98 = new JLabel("Pan- No ");
		l98.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l98.setForeground(new ColorUIResource(71, 73, 73));
		l98.setBounds(50, 180, 200, 25);
		p12.add(l98);

		pan1 = new JLabel();
		pan1.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		pan1.setForeground(new ColorUIResource(71, 73, 73));
		pan1.setBounds(250, 180, 200, 25);
		p12.add(pan1);

		JLabel l100 = new JLabel("Account Number ");
		l100.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l100.setForeground(new ColorUIResource(71, 73, 73));
		l100.setBounds(50, 210, 200, 25);
		p12.add(l100);

		acct_no1 = new JLabel();
		acct_no1.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		acct_no1.setForeground(new ColorUIResource(71, 73, 73));
		acct_no1.setBounds(250, 210, 200, 25);
		p12.add(acct_no1);

		JLabel l102 = new JLabel(" Custemer name ");
		l102.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l102.setForeground(new ColorUIResource(71, 73, 73));
		l102.setBounds(43, 235, 200, 25);
		p12.add(l102);

		customer_name = new JLabel();
		customer_name.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		customer_name.setForeground(new ColorUIResource(71, 73, 73));
		customer_name.setBounds(250, 235, 200, 25);
		p12.add(customer_name);

		JLabel l104 = new JLabel("Address");
		l104.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l104.setForeground(new ColorUIResource(71, 73, 73));
		l104.setBounds(50, 280, 200, 34);
		p12.add(l104);

		addressl = new JTextArea();
		addressl.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		addressl.setForeground(new ColorUIResource(71, 73, 73));
		addressl.setBounds(250, 280, 300, 45);
		addressl.setBackground(new ColorUIResource(255, 255, 255));
		addressl.setEditable(false);
		p12.add(addressl);

		ImageIcon i38 = new ImageIcon(ClassLoader.getSystemResource("./imags/card.png"));
		Image i39 = i38.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
		ImageIcon i40 = new ImageIcon(i39);
		JLabel l106 = new JLabel(i40);
		l106.setBounds(170, 420, 300, 180);
		Accountpanel.add(l106);

		JLabel icon3 = new JLabel("Available Balance");
		icon3.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		icon3.setForeground(new ColorUIResource(255, 255, 255));
		icon3.setBounds(20, 30, 200, 25);
		l106.add(icon3);

		acct_no2 = new JLabel();
		acct_no2.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		acct_no2.setForeground(new ColorUIResource(255, 255, 255));
		acct_no2.setBounds(20, 60, 200, 25);
		l106.add(acct_no2);

		JLabel rupee1 = new JLabel("₹");
		rupee1.setFont(new FontUIResource("Railway", Font.PLAIN, 22));
		rupee1.setForeground(new ColorUIResource(255, 255, 255));
		rupee1.setBounds(20, 120, 20, 50);
		l106.add(rupee1);

		debitbalance1 = new JLabel();
		debitbalance1.setFont(new FontUIResource("Railway", Font.PLAIN, 22));
		debitbalance1.setForeground(new ColorUIResource(255, 255, 255));
		debitbalance1.setBounds(50, 120, 200, 50);
		l106.add(debitbalance1);

		ImageIcon debitlogo1 = new ImageIcon(ClassLoader.getSystemResource("./imags/mastercard-icon.png"));
		JLabel debitlogo3 = new JLabel(debitlogo1);
		debitlogo3.setBounds(240, 2, 40, 40);
		l106.add(debitlogo3);

		pan1.setText(pan_no);
		acct_no1.setText(acct);
		customer_name.setText(name);
		addressl.setText(address);
		acct_no2.setText(acct);
		debitbalance1.setText(balance);

//-----------------------------------------------------------------------cards-----------------------------------------------------------------------
		CardPanel = new JPanel();
		CardPanel.setBounds(50, 50, 1250, 650);
		CardPanel.setBackground(new ColorUIResource(255, 255, 255));
		CardPanel.setLayout(null);
		add(CardPanel);

//----------------------------------------------------------credit card details-----------------------------------------------------------

		p14 = new JPanel();
		p14.setBounds(60, 10, 570, 570);
		p14.setBackground(new ColorUIResource(255, 255, 255));
		p14.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p14.setLayout(null);
		CardPanel.add(p14);

		JLabel l110 = new JLabel("Credit Card Details");
		l110.setFont(new FontUIResource("Railway", Font.BOLD, 18));
		l110.setForeground(new ColorUIResource(0, 0, 255));
		l110.setBounds(210, 20, 300, 25);
		p14.add(l110);

		ImageIcon i44 = new ImageIcon(ClassLoader.getSystemResource("./imags/new card.png"));
		Image i45 = i44.getImage().getScaledInstance(310, 170, Image.SCALE_DEFAULT);
		ImageIcon i46 = new ImageIcon(i45);
		JLabel l107 = new JLabel(i46);
		l107.setBounds(145, 70, 310, 170);
		p14.add(l107);

		JLabel l112 = new JLabel("Credit Card ");
		l112.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l112.setForeground(new ColorUIResource(255, 255, 255));
		l112.setBounds(10, 10, 300, 25);
		l107.add(l112);

		ImageIcon i47 = new ImageIcon(ClassLoader.getSystemResource("./imags/visa-icon.png"));
		JLabel l108 = new JLabel(i47);
		l108.setBounds(260, 2, 40, 40);
		l107.add(l108);

		ImageIcon i48 = new ImageIcon(ClassLoader.getSystemResource("./imags/silver-card-chip.png"));
		JLabel l109 = new JLabel(i48);
		l109.setBounds(30, 39, 40, 50);
		l107.add(l109);

		cardcreditcardno1l = new JLabel("Credit Numbeer ");
		cardcreditcardno1l.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		cardcreditcardno1l.setForeground(new ColorUIResource(255, 255, 255));
		cardcreditcardno1l.setBounds(10, 105, 300, 25);
		l107.add(cardcreditcardno1l);

		cardcreditcardnamel = new JLabel();
		cardcreditcardnamel.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		cardcreditcardnamel.setForeground(new ColorUIResource(255, 255, 255));
		cardcreditcardnamel.setBounds(10, 130, 300, 25);
		l107.add(cardcreditcardnamel);

		JLabel l115 = new JLabel("Credit Card Type  ");
		l115.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l115.setForeground(new ColorUIResource(69, 70, 75));
		l115.setBounds(20, 290, 300, 25);
		p14.add(l115);

		JLabel l116 = new JLabel(" Saving");
		l116.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l116.setForeground(new ColorUIResource(69, 70, 75));
		l116.setBounds(170, 290, 300, 25);
		p14.add(l116);

		JLabel l117 = new JLabel("Credit Card No  ");
		l117.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l117.setForeground(new ColorUIResource(69, 70, 75));
		l117.setBounds(20, 325, 300, 25);
		p14.add(l117);

		cardcreditcardno2l = new JLabel();
		cardcreditcardno2l.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		cardcreditcardno2l.setForeground(new ColorUIResource(69, 70, 75));
		cardcreditcardno2l.setBounds(170, 325, 300, 25);
		p14.add(cardcreditcardno2l);

		JLabel l119 = new JLabel("CVV Number  ");
		l119.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l119.setForeground(new ColorUIResource(69, 70, 75));
		l119.setBounds(20, 360, 300, 25);
		p14.add(l119);

		cardcreditcvvl = new JLabel();
		cardcreditcvvl.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		cardcreditcvvl.setForeground(new ColorUIResource(69, 70, 75));
		cardcreditcvvl.setBounds(170, 360, 300, 25);
		p14.add(cardcreditcvvl);

		JLabel l121 = new JLabel("Issu Date ");
		l121.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l121.setForeground(new ColorUIResource(69, 70, 75));
		l121.setBounds(330, 290, 200, 25);
		p14.add(l121);

		cardcreditdatel = new JLabel();
		cardcreditdatel.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		cardcreditdatel.setForeground(new ColorUIResource(69, 70, 75));
		cardcreditdatel.setBounds(440, 290, 300, 25);
		p14.add(cardcreditdatel);

		JLabel l123 = new JLabel("Expiry Date ");
		l123.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l123.setForeground(new ColorUIResource(69, 70, 75));
		l123.setBounds(330, 325, 300, 25);
		p14.add(l123);

		JLabel l124 = new JLabel(" 11-10-200");
		l124.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l124.setForeground(new ColorUIResource(69, 70, 75));
		l124.setBounds(435, 325, 300, 25);
		p14.add(l124);

		JLabel l125 = new JLabel("Balance ");
		l125.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l125.setForeground(new ColorUIResource(69, 70, 75));
		l125.setBounds(330, 360, 300, 25);
		p14.add(l125);

		cardcreditbalancel = new JLabel();
		cardcreditbalancel.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		cardcreditbalancel.setForeground(new ColorUIResource(69, 70, 75));
		cardcreditbalancel.setBounds(435, 360, 300, 25);
		p14.add(cardcreditbalancel);

		JLabel l127 = new JLabel("Interest Rate ");
		l127.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l127.setForeground(new ColorUIResource(69, 70, 75));
		l127.setBounds(190, 395, 300, 25);
		p14.add(l127);

		JLabel l128 = new JLabel("8%/year");
		l128.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l128.setForeground(new ColorUIResource(69, 70, 75));
		l128.setBounds(320, 395, 300, 25);
		p14.add(l128);

		// values
		cardcreditbalancel.setText(creditbalance);
		cardcreditcardnamel.setText(creditname);
		cardcreditcvvl.setText(creditcvv);
		cardcreditdatel.setText(creditdate);
		cardcreditcardno1l.setText(creditcardno);
		cardcreditcardno2l.setText(creditcardno);

		// values end

		p16 = new JPanel();
		p16.setBounds(20, 430, 525, 130);
		p16.setBackground(new ColorUIResource(218, 247, 166));
		p16.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p16.setLayout(null);
		p14.add(p16);

		JLabel l148 = new JLabel("0ld Pin");
		l148.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l148.setForeground(new ColorUIResource(69, 70, 75));
		l148.setBounds(20, 10, 300, 25);
		p16.add(l148);

		creditoldpint = new JTextField();
		creditoldpint.setBounds(20, 35, 100, 24);
		creditoldpint.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p16.add(creditoldpint);

		creditsendob = new JButton("Send OTP");
		creditsendob.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		creditsendob.setForeground(new ColorUIResource(255, 255, 255));
		creditsendob.setBackground(new Color(15, 51, 231));
		creditsendob.setBounds(130, 35, 115, 24);
		creditsendob.addActionListener(this);
		p16.add(creditsendob);

		JLabel l149 = new JLabel("OTP");
		l149.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l149.setForeground(new ColorUIResource(69, 70, 75));
		l149.setBounds(290, 10, 300, 25);
		p16.add(l149);

		creditotpt = new JTextField();
		creditotpt.setBounds(290, 35, 100, 24);
		creditotpt.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p16.add(creditotpt);
		creditotpt.setEnabled(false);

		creditverifyotpb = new JButton("Verify");
		creditverifyotpb.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		creditverifyotpb.setForeground(new ColorUIResource(255, 255, 255));
		creditverifyotpb.setBackground(new Color(15, 51, 231));
		creditverifyotpb.setBounds(395, 35, 95, 24);
		creditverifyotpb.addActionListener(this);
		p16.add(creditverifyotpb);
		creditverifyotpb.setEnabled(false);

		JLabel l150 = new JLabel("New-Pin");
		l150.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l150.setForeground(new ColorUIResource(69, 70, 75));
		l150.setBounds(20, 65, 300, 25);
		p16.add(l150);

		credit_newpint = new JTextField();
		credit_newpint.setBounds(20, 90, 170, 24);
		credit_newpint.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p16.add(credit_newpint);
		credit_newpint.setEnabled(false);

		JLabel l151 = new JLabel("Re-Enter New-Pin");
		l151.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l151.setForeground(new ColorUIResource(69, 70, 75));
		l151.setBounds(220, 65, 300, 25);
		p16.add(l151);

		credit_repint = new JTextField();
		credit_repint.setBounds(220, 90, 170, 24);
		credit_repint.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p16.add(credit_repint);
		credit_repint.setEnabled(false);

		credit_changepinb = new JButton("Change");
		credit_changepinb.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		credit_changepinb.setForeground(new ColorUIResource(225, 225, 225));
		credit_changepinb.setBackground(new Color(15, 51, 231));
		credit_changepinb.setBounds(400, 90, 95, 24);
		credit_changepinb.addActionListener(this);
		p16.add(credit_changepinb);
		credit_changepinb.setEnabled(false);

//-------------------------------------------------------------debit card-------------------------------------------------------------------------------------

		p15 = new JPanel();
		p15.setBounds(655, 10, 570, 570);
		p15.setBackground(new ColorUIResource(255, 255, 255));
		p15.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p15.setLayout(null);
		CardPanel.add(p15);

		JLabel l129 = new JLabel("Debit Card Details");
		l129.setFont(new FontUIResource("Railway", Font.BOLD, 18));
		l129.setForeground(new ColorUIResource(0, 0, 255));
		l129.setBounds(210, 20, 300, 25);
		p15.add(l129);

		ImageIcon i50 = new ImageIcon(ClassLoader.getSystemResource("./imags/card.png"));
		Image i54 = i50.getImage().getScaledInstance(310, 170, Image.SCALE_DEFAULT);
		ImageIcon i55 = new ImageIcon(i54);
		JLabel l130 = new JLabel(i55);
		l130.setBounds(145, 70, 310, 170);
		p15.add(l130);

		JLabel l131 = new JLabel("Debit Card ");
		l131.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l131.setForeground(new ColorUIResource(255, 255, 255));
		l131.setBounds(10, 10, 300, 25);
		l130.add(l131);

		ImageIcon i56 = new ImageIcon(ClassLoader.getSystemResource("./imags/mastercard-icon.png"));
		JLabel l332 = new JLabel(i56);
		l332.setBounds(260, 2, 40, 40);
		l130.add(l332);

		ImageIcon i57 = new ImageIcon(ClassLoader.getSystemResource("./imags/gold-card-chip.png"));
		JLabel l133 = new JLabel(i57);
		l133.setBounds(30, 39, 40, 50);
		l130.add(l133);

		debitnol = new JLabel();
		debitnol.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		debitnol.setForeground(new ColorUIResource(255, 255, 255));
		debitnol.setBounds(10, 105, 300, 25);
		l130.add(debitnol);

		debitnamel = new JLabel("Debit Nmae ");
		debitnamel.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		debitnamel.setForeground(new ColorUIResource(255, 255, 255));
		debitnamel.setBounds(10, 130, 300, 25);
		l130.add(debitnamel);

		JLabel l136 = new JLabel("Debit Card Type  ");
		l136.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l136.setForeground(new ColorUIResource(69, 70, 75));
		l136.setBounds(20, 290, 300, 25);
		p15.add(l136);

		JLabel l137 = new JLabel("Saving");
		l137.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l137.setForeground(new ColorUIResource(69, 70, 75));
		l137.setBounds(170, 290, 300, 25);
		p15.add(l137);

		JLabel l138 = new JLabel("Debit Card No ");
		l138.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l138.setForeground(new ColorUIResource(69, 70, 75));
		l138.setBounds(20, 325, 300, 25);
		p15.add(l138);

		debitno2l = new JLabel();
		debitno2l.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		debitno2l.setForeground(new ColorUIResource(69, 70, 75));
		debitno2l.setBounds(170, 325, 300, 25);
		p15.add(debitno2l);

		JLabel l140 = new JLabel("CVV Number  ");
		l140.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l140.setForeground(new ColorUIResource(69, 70, 75));
		l140.setBounds(20, 360, 300, 25);
		p15.add(l140);

		cvvl = new JLabel();
		cvvl.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		cvvl.setForeground(new ColorUIResource(69, 70, 75));
		cvvl.setBounds(170, 360, 300, 25);
		p15.add(cvvl);

		JLabel l142 = new JLabel("Issu Date ");
		l142.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l142.setForeground(new ColorUIResource(69, 70, 75));
		l142.setBounds(330, 290, 200, 25);
		p15.add(l142);

		debitdatel = new JLabel();
		debitdatel.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		debitdatel.setForeground(new ColorUIResource(69, 70, 75));
		debitdatel.setBounds(435, 290, 295, 25);
		p15.add(debitdatel);

		JLabel l144 = new JLabel("Expiry Date ");
		l144.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l144.setForeground(new ColorUIResource(69, 70, 75));
		l144.setBounds(330, 325, 300, 25);
		p15.add(l144);

		JLabel l145 = new JLabel("11/12/2030");
		l145.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		l145.setForeground(new ColorUIResource(69, 70, 75));
		l145.setBounds(435, 325, 300, 25);
		p15.add(l145);

		JLabel l146 = new JLabel("Balance ");
		l146.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l146.setForeground(new ColorUIResource(69, 70, 75));
		l146.setBounds(330, 360, 300, 25);
		p15.add(l146);

		debitbalance2l = new JLabel();
		debitbalance2l.setFont(new FontUIResource("Railway", Font.BOLD, 17));
		debitbalance2l.setForeground(new ColorUIResource(69, 70, 75));
		debitbalance2l.setBounds(435, 360, 300, 25);
		p15.add(debitbalance2l);

		// value

		debitnamel.setText(name);
		cvvl.setText("7219");
		debitno2l.setText(debit_no);
		debitnol.setText(debit_no);
		debitbalance2l.setText(balance);
		debitdatel.setText(date);

		// values

		p17 = new JPanel();
		p17.setBounds(20, 430, 525, 130);
		p17.setBackground(new ColorUIResource(236, 234, 123));
		p17.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p17.setLayout(null);
		p15.add(p17);

		JLabel l152 = new JLabel("0ld Pin");
		l152.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l152.setForeground(new ColorUIResource(69, 70, 75));
		l152.setBounds(20, 10, 300, 25);
		p17.add(l152);

		debit_old_pint = new JTextField();
		debit_old_pint.setBounds(20, 35, 100, 24);
		debit_old_pint.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p17.add(debit_old_pint);

		debit_send_otpb = new JButton("Send OTP");
		debit_send_otpb.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		debit_send_otpb.setForeground(new ColorUIResource(255, 255, 255));
		debit_send_otpb.setBackground(new Color(15, 51, 231));
		debit_send_otpb.setBounds(130, 35, 115, 24);
		debit_send_otpb.addActionListener(this);
		p17.add(debit_send_otpb);

		JLabel l153 = new JLabel("OTP");
		l153.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l153.setForeground(new ColorUIResource(69, 70, 75));
		l153.setBounds(290, 10, 300, 25);
		p17.add(l153);

		debit_otpt = new JTextField();
		debit_otpt.setBounds(290, 35, 100, 24);
		debit_otpt.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p17.add(debit_otpt);
		debit_otpt.setEnabled(false);

		debit_verify_otpb = new JButton("Verify");
		debit_verify_otpb.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		debit_verify_otpb.setForeground(new ColorUIResource(255, 255, 255));
		debit_verify_otpb.setBackground(new Color(15, 51, 231));
		debit_verify_otpb.setBounds(395, 35, 95, 24);
		debit_verify_otpb.addActionListener(this);
		p17.add(debit_verify_otpb);
		debit_verify_otpb.setEnabled(false);

		JLabel l154 = new JLabel("New-Pin");
		l154.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l154.setForeground(new ColorUIResource(69, 70, 75));
		l154.setBounds(20, 65, 300, 25);
		p17.add(l154);

		debit_new_pint = new JTextField();
		debit_new_pint.setBounds(20, 90, 170, 24);
//		debit_new_pint.setDocument(new JTextFieldLimit(10));
		debit_new_pint.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p17.add(debit_new_pint);
		debit_new_pint.setEnabled(false);

		JLabel l155 = new JLabel("Re-Enter New-Pin");
		l155.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l155.setForeground(new ColorUIResource(69, 70, 75));
		l155.setBounds(220, 65, 300, 25);
		p17.add(l155);

		debit_repint = new JTextField();
		debit_repint.setBounds(220, 90, 170, 24);
		debit_repint.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		p17.add(debit_repint);
		debit_repint.setEnabled(false);

		debit_changeb = new JButton("Change");
		debit_changeb.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		debit_changeb.setForeground(new ColorUIResource(225, 225, 225));
		debit_changeb.setBackground(new Color(15, 51, 231));
		debit_changeb.setBounds(400, 90, 95, 24);
		debit_changeb.addActionListener(this);
		p17.add(debit_changeb);
		debit_changeb.setEnabled(false);

//-------------------------------------------------transfer---------------------------------------------------------

		TransferPanel = new JPanel();
		TransferPanel.setBounds(50, 50, 1250, 650);
		TransferPanel.setBackground(new ColorUIResource(255, 255, 255));
		TransferPanel.setLayout(null);
		add(TransferPanel);

		p18 = new JPanel();
		p18.setBounds(60, 10, 570, 570);
		p18.setBackground(new ColorUIResource(216, 232, 211));
		p18.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p18.setLayout(null);
		TransferPanel.add(p18);

		ImageIcon i58 = new ImageIcon(ClassLoader.getSystemResource("./imags/card-xl.png"));
		Image i59 = i58.getImage().getScaledInstance(470, 350, Image.SCALE_DEFAULT);
		ImageIcon i60 = new ImageIcon(i59);
		JLabel l156 = new JLabel(i60);
		l156.setBounds(55, 70, 470, 350);
		p18.add(l156);

		JLabel l157 = new JLabel("Sky Bank");
		l157.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l157.setForeground(new ColorUIResource(255, 255, 255));
		l157.setBounds(20, 10, 300, 25);
		l156.add(l157);

		ImageIcon i157 = new ImageIcon(ClassLoader.getSystemResource("./imags/white-shield.png"));
		JLabel l158 = new JLabel(i157);
		l158.setBounds(215, 30, 50, 50);
		l156.add(l158);

		JLabel l159 = new JLabel("Secure Payment");
		l159.setFont(new FontUIResource("Railway", Font.BOLD, 16));
		l159.setForeground(new ColorUIResource(255, 255, 255));
		l159.setBounds(170, 90, 300, 25);
		l156.add(l159);

		JLabel l160 = new JLabel("Receiver Account No :");
		l160.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l160.setForeground(new ColorUIResource(255, 255, 255));
		l160.setBounds(110, 150, 300, 25);
		l156.add(l160);

		transfer_receiveracc = new JTextField();
		transfer_receiveracc.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		transfer_receiveracc.setForeground(new ColorUIResource(0, 0, 0));
		transfer_receiveracc.setBounds(110, 175, 250, 25);
		transfer_receiveracc.addKeyListener(this);
		l156.add(transfer_receiveracc);

		JLabel l161 = new JLabel("Enter Amount:");
		l161.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		l161.setForeground(new ColorUIResource(255, 255, 255));
		l161.setBounds(110, 220, 300, 25);
		l156.add(l161);

		transfer_receiveramo = new JTextField();
		transfer_receiveramo.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		transfer_receiveramo.setForeground(new ColorUIResource(0, 0, 0));
		transfer_receiveramo.setBounds(110, 245, 250, 25);
		transfer_receiveramo.addKeyListener(this);
		l156.add(transfer_receiveramo);

		transfer_receiverpay = new JButton("Pay");
		transfer_receiverpay.setFont(new FontUIResource("Railway", Font.BOLD, 14));
		transfer_receiverpay.setForeground(new ColorUIResource(255, 255, 255));
		transfer_receiverpay.setBackground(new Color(0, 0, 255));
		transfer_receiverpay.setBounds(160, 295, 150, 25);
		transfer_receiverpay.addActionListener(this);
		l156.add(transfer_receiverpay);

		p19 = new JPanel();
		p19.setBounds(655, 10, 570, 570);
		p19.setBackground(new ColorUIResource(211, 243, 132));
		p19.setBorder(BorderFactory.createLineBorder(new ColorUIResource(0, 0, 0)));
		p19.setLayout(null);
		TransferPanel.add(p19);

		JLabel l162 = new JLabel("Account Statement");
		l162.setFont(new FontUIResource("Railway", Font.BOLD, 18));
		l162.setForeground(new ColorUIResource(0, 0, 0));
		l162.setBounds(190, 30, 400, 25);
		p19.add(l162);

		JPanel p19b = new JPanel();
		p19b.setBounds(60, 90, 468, 430);
		p19b.setBackground(new ColorUIResource(211, 243, 132));

		p19.add(p19b);

		
		// Data to be displayed in the JTable
		// Initializing the JTable
		j2 = new JTable();
		j2.setBackground(new ColorUIResource(211, 243, 132));
		j2.getTableHeader().setReorderingAllowed(false);

		j2.getTableHeader().setFont(new FontUIResource("Railway", Font.BOLD, 14));
		// adding it to JScrollPane
		model2 = new DefaultTableModel(new Object[] { "Date", "Account No", "Amount", "C/D" }, 0);
		j2.setModel(model2);
		j2.setEnabled(false);
		j2.setRowHeight(50);
		 sp2 = new JScrollPane(j2);
		sp2.setBackground(new ColorUIResource(211, 243, 132));
		p19b.add(sp2);
	
		
		try {
			String query = "select * from acct_statement where user_acct_no='"+acct+"'";
			ResultSet rs = db.DbConnect.s.executeQuery(query);
			while (rs.next()) {
				Date date = rs.getDate(1);
				String acct_no = rs.getString(2);
				String amount = rs.getString(3);
				String cd = rs.getString(4);

				Object tbdata[] = { date, acct_no, amount, cd };
				model2.addRow(tbdata);
				
				
			}
		} catch (Exception e) {

		}
		// Frame Size
		Accountpanel.setVisible(false);
		CardPanel.setVisible(false);
		ProfilePanel.setVisible(false);
		TransferPanel.setVisible(false);
		HomePanel.setVisible(true);
		this.setVisible(true);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == Home) {
			HomePanel.setVisible(true);
			l1.setText("Home Section");
			Accountpanel.setVisible(false);
			CardPanel.setVisible(false);
			ProfilePanel.setVisible(false);
			TransferPanel.setVisible(false);
		}

		if (e.getSource() == Account) {
			HomePanel.setVisible(false);
			Accountpanel.setVisible(true);
			l1.setText("Account Section");
			CardPanel.setVisible(false);
			ProfilePanel.setVisible(false);
			TransferPanel.setVisible(false);
		}
		if (e.getSource() == Card) {
			HomePanel.setVisible(false);
			Accountpanel.setVisible(false);
			CardPanel.setVisible(true);
			l1.setText("Card Section");
			ProfilePanel.setVisible(false);
			TransferPanel.setVisible(false);
		}
		if (e.getSource() == Transfer) {
			HomePanel.setVisible(false);
			Accountpanel.setVisible(false);
			CardPanel.setVisible(false);
			ProfilePanel.setVisible(false);
			TransferPanel.setVisible(true);
			l1.setText("Transfer Section");

		}
		if (e.getSource() == Profile) {
			HomePanel.setVisible(false);
			Accountpanel.setVisible(false);
			CardPanel.setVisible(false);
			ProfilePanel.setVisible(true);
			l1.setText("Profile Section");
			TransferPanel.setVisible(false);
		}
		if (e.getSource() == Logout) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Do you Really want to Logout?", "Choose",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				new Login().setVisible(true);
			}
		}
		if (e.getSource() == apply) {
			this.setVisible(false);
			new CreditCard(acct).setVisible(true);
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

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void emailsend() {

		try {

			otp = run();
			System.out.println(otp);

			Email email = new Email("skybanklife@gmail.com", "7219791328a");
			email.setFrom("skybanklife@gmail.com", " Sky Bank Authority ");
			email.setSubject("Sky Bank Autority ");
			email.setContent("<h1>welcome to SKY BANK</h1> <p>" + " your otp for "+ card_name +"card pin change is</p>" + otp,
					"text/html");
			email.addRecipient(creditemail);
			email.send();

			JOptionPane.showMessageDialog(null, "otp send succesfully. check your email for otp");

		} catch (Exception e2) {
			// TODO: handle exception
		}

 	}

	public static String run() {

		Random random = new Random();
		int r1 = random.nextInt(10000);
		String ra = Integer.toString(r1);
		return ra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
if (e.getSource() == creditsendob) {
			
	card_name="Credit";
			String olpin=creditoldpint.getText();
		
			if (olpin.equals(creditpin)) {
	
				emailsend();
				creditotpt.setEnabled(true);
				creditverifyotpb.setEnabled(true);
			}
			else {
				   JOptionPane.showMessageDialog(null, "pin dosen't match ");
			}
			
		}
		
		if (e.getSource() == creditverifyotpb) {
			
			String creditotp=creditotpt.getText();
			if(creditotp.equals(otp)) {
				  JOptionPane.showMessageDialog(null, "otp matched succesfully now you can change your pin ");
				  
				  creditotpt.setText("");
				  creditoldpint.setText("");
				  creditotpt.setEnabled(false);
				  creditoldpint.setEnabled(false);
				  
				  creditverifyotpb.setEnabled(false);
				  creditsendob.setEnabled(false);
				  
				  credit_newpint.setEnabled(true);
				  credit_repint.setEnabled(true);
				  credit_changepinb.setEnabled(true);
				  
			}
			else {
				   JOptionPane.showMessageDialog(null, "otp dosen't match ");
			}
			
		}
		
		if (e.getSource() == credit_changepinb) {
			
			String newpin=credit_newpint.getText();
			 repin=credit_repint.getText();
			if (newpin.equals(repin)) {
				  		
			try {
				String query="update credit_card set pin='"+repin+"' where acct_no='"+acct+"' ";
				
				db.DbConnect.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "your credit card pin change succesfully");
				
				credit_newpint.setText("");
				credit_repint.setText("");
				  credit_newpint.setEnabled(false);
				  credit_repint.setEnabled(false);
				  credit_changepinb.setEnabled(false);
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
				
			}
			else {
				JOptionPane.showMessageDialog(null, "your enter pin doesn,t match ");
			}
		}
		
//debit pin chnge		
		
		if (e.getSource() == debit_send_otpb) {
			
			card_name="Debit";
			String debit_ol_pin=debit_old_pint.getText();
		
			if (debit_ol_pin.equals(debit_pin)) {
	
				emailsend();
				debit_otpt.setEnabled(true);
				debit_verify_otpb.setEnabled(true);
			}
			else {
				   JOptionPane.showMessageDialog(null, "pin dosen't match ");
			}
			
		}
		
		if (e.getSource() == debit_verify_otpb) {
			
			String debit_verify_otp=debit_otpt.getText();
			if(debit_verify_otp.equals(otp)) {
				  JOptionPane.showMessageDialog(null, "otp matched succesfully now you can change your pin ");
				  
				  debit_old_pint.setText("");
				  debit_otpt.setText("");
				  debit_old_pint.setEnabled(false);
				  
				  debit_otpt.setEnabled(false);
				  debit_verify_otpb.setEnabled(false);
				  debit_send_otpb.setEnabled(false);
				  
				  debit_new_pint.setEnabled(true);
				  debit_repint.setEnabled(true);
				  debit_changeb.setEnabled(true);
				  
				  
				
			}
			else {
				   JOptionPane.showMessageDialog(null, "otp dosen't match ");
			}
			
		}
		
		if (e.getSource() == debit_changeb) {
			
			String debit_new_pin=debit_new_pint.getText();
			debit_new_repin=debit_repint.getText();
			if (debit_new_pin.equals(debit_new_repin)) {
				  		
			try {
				String query="update create_acc set pin='"+debit_new_repin+"' where acct_no='"+acct+"' ";
				
				db.DbConnect.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "your debit card pin change succesfully");
				
				
				  debit_new_pint.setText("");
				  debit_repint.setText("");
				  debit_new_pint.setEnabled(false);
				  debit_repint.setEnabled(false);
				  debit_changeb.setEnabled(false);
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
			}
			else {
				JOptionPane.showMessageDialog(null, "your enter pin doesn,t match ");
			}
		}
		
		
   if (e.getSource() == transfer_receiverpay) {
//	transfer_receiveracc
	String receiver_acc=transfer_receiveracc.getText();
	
	 if(receiver_acc.length()==10) {
		 
		 
		 if(transfer_receiveramo.getText().length()<=4
				 && !"".equals(transfer_receiveramo.getText()) 
				 && !"0".equals(transfer_receiveramo.getText()))
		{
				try {
					int balance1=Integer.parseInt(balance);
					 String amount=transfer_receiveramo.getText();
					 int amount1=Integer.parseInt(amount);
					 
					 System.out.println(balance1);
					 System.out.println(amount1);
					 

				if (amount1<=balance1) {
					
			    	balance1=balance1-amount1;
			    	String balance1s=Integer.toString(balance1);
			    System.out.println(balance1s);
			    	
			    
			   
			    	String query="update login set acct_balance='"+balance1s+"' where acct_no='"+acct+"' ";
			    	db.DbConnect.s.executeUpdate(query);
			    	
			    java.util.Date currDate = new java.util.Date();
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String strCurrDate = dateFormat.format(currDate);
					String cd="creditd";
						
					 java.sql.Date sqlDate = new java.sql.Date(currDate.getTime());
			    	System.out.println(sqlDate);
			    	
                   String query2="insert into acct_statement value('"+sqlDate+"','"+receiver_acc+"','"+amount+"','credited','"+acct+"')";
	    	        db.DbConnect.s.executeUpdate(query2);

	    	        JOptionPane.showMessageDialog(null, "Amount sent succesfully");
	    	        
	    	        transfer_receiveracc.setText("");
	    	        transfer_receiveramo.setText("");
              
					Object tbdata[] = { sqlDate, receiver_acc, amount,cd};
					model1.addRow(tbdata);
					model2.addRow(tbdata);
					
	
					String query3="select * from login where acct_no='"+acct+"' ";
					ResultSet rs=db.DbConnect.s.executeQuery(query3);
					while(rs.next()) {
						debitbalance.setText(rs.getString("acct_balance"));
						debitbalance2l.setText(rs.getString("acct_balance"));
						debitbalance1.setText(rs.getString("acct_balance"));
						
					}
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Insufficient amount");
				}
					 
				
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		}	 
		else {
			JOptionPane.showMessageDialog(null, "invalid amount to trnasfer");
		}
	 }else {
		 JOptionPane.showMessageDialog(null, "invalid Receiver Account Number ");
	 }
		}
			 
	
}
	

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == transfer_receiveracc) {
			char ch = e.getKeyChar();
			if (!Character.isDigit(ch)) {
				// cosume means wo cahr ko dikhayenga hi nhi
				e.consume();
			}
		}
		if (e.getSource() == transfer_receiveramo) {
			char ch = e.getKeyChar();
			if (!Character.isDigit(ch)) {
				// cosume means wo cahr ko dikhayenga hi nhi
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
