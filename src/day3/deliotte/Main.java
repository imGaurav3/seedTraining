package day3.deliotte;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class Main {
	
	Driver d = null;
	Connection conn = null;
	public void connect() {
		
		try {
			d = new OracleDriver();
			DriverManager.registerDriver(d);
			
			String uername = "hr";
			String password = "hr";
			String url = "jdbc:oracle:thin:@192.168.1.30:1521:xe";
			
			conn = DriverManager.getConnection(url, uername, password);
			//conn.setAutoCommit(false);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Connection to oracle database opens....");
	}
	public void insert(int id, String name, String email) {
		String query = "insert into students values (?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			
			int r = stmt.executeUpdate();
			System.out.println(r + " row inserted in students");
		} catch (SQLException e) {
			System.out.println("Error in insertind data in student!");
			e.printStackTrace();
		}
	}
	 
	public static void main(String[] args) {
		
		Main m = new Main();
		m.connect();
		//Students []studs;
		int c = 0;
		DataManager mn = new DataManager();
		Scanner sc = new Scanner(System.in);
		
		
		
		while (true) {
			
			System.out.println("1. Add, 2.Compare, 3.Exit");
			System.out.println("Enter ur choice: ");
			int n = sc.nextInt();
			
			switch (n) {
			case 1:
				//sc.next();
				
				System.out.println("Enter name of Student: ");
				String nm = sc.next();

				System.out.println("Enter email of Student: ");
				String em = sc.next();
				
				Students stud = new Students(nm, em);
				
				//mn.add(new Students(nm, em));
				System.out.println(stud);
				//mn.print();
				
				m.insert(stud.getId(), stud.getName(), stud.getEmail());
				

				break;
			case 2:

				System.out.println("1.Default Sort, 2.Name Sort, 3.Email Sort: ");
				System.out.println("Ente rur choice: ");
				int n1 = sc.nextInt();
				if (n1 == 1) {
					mn.defaultSort();
					mn.print();
				} else if (n1 == 2) {
					mn.namesort();
					mn.print();
				} else{
					mn.emailSort();
					mn.print();
				}
				break;
			case 3:
				sc.close();
				System.exit(0);

				break;

			default:
				break;
			}
		}
		
	}

}
