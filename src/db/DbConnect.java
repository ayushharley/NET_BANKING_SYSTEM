package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DbConnect {

			public static Connection c;
			public static Statement s;
			static {
				try {
					c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","7219791328aA@");
					s= c.createStatement();	
				}catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, ex);
				}
			}

	

}
