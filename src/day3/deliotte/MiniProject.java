package day3.deliotte;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class MiniProject {
	
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
	
	public void update(int id,String str) {
		String query = "update students set email = (?) where id = (?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, str);
			stmt.setInt(2, id);
			
			int r = stmt.executeUpdate();
			System.out.println(r + " row updated!");
		} 
		catch (SQLException e) {
			System.out.println("Error in updating!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void display() {
		String query = "select * from students";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.print("ID := "+rs.getInt("id"));
				System.out.println("  Name := "+ rs.getString("name")+" "+rs.getString("email"));
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		String query = "delete from students where id = (?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, id);
			
			int r = stmt.executeUpdate();
			System.out.println(r+" row deleted!");
		} 
		catch (SQLException e) {
			System.out.println("Error in deleting!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		MiniProject m = new MiniProject();
		m.connect();
		
		Scanner sc = new Scanner(System.in);
		
		
		
		while (true) {
			
			System.out.println("1. Add, 2.Display, 3.Update Email, 4.Delete ,5.Exit");
			System.out.println("Enter ur choice: ");
			int n = sc.nextInt();
			
			switch (n) {
			case 1:
				
				System.out.println("Enter name of Student: ");
				String nm = sc.next();

				System.out.println("Enter email of Student: ");
				String em = sc.next();
				
				Students stud = new Students(nm, em);
				System.out.println(stud);
				
				m.insert(stud.getId(), stud.getName(), stud.getEmail());
				

				break;
			case 2:
				m.display();
				
				break;
			case 3:
				System.out.println("enter id whose name is to be updated: ");
				int id1 = sc.nextInt();
				System.out.println("enter email to be updated: ");
				String nm_up = sc.next();
				
				m.update(id1, nm_up);
				
				break;
			case 4:
				System.out.println("Enter the id to be deleted:");
				int id2 = sc.nextInt();
				
				m.delete(id2);
				break;
			case 5:
				sc.close();
				System.exit(0);

			default:
				break;
			}
		}

	}

}
