package assessment.code;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class Assessment {

	Driver d = null;
	Connection conn = null;
	
	public void Connect() {
		
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
	public void InsertPatient(int id,String name,String email) {
		String query = "insert into tbl_patients values (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
			
			int r = stmt.executeUpdate();
			System.out.println(r + " row inserted in patients");
		} catch (SQLException e) {
			System.out.println("Error in insertind data in patients!");
			e.printStackTrace();
		}
	}
	public void InsertPrescription(int id, int patient_id,String med_name) {
		String query = "insert into tbl_prescription values (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, id);
			stmt.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.setInt(3, patient_id);
			stmt.setString(4, med_name);
			
			int r = stmt.executeUpdate();
			System.out.println(r + " row inserted in prescription table");
		} catch (SQLException e) {
			System.out.println("Error in insertind data in prescription!");
			e.printStackTrace();
		}
	}
	public void Display() {
		String query1 = "select * from tbl_patients";
		String query2 = "select * from tbl_prescription";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query1);
			PreparedStatement stmt1 = conn.prepareStatement(query2);
			
			ResultSet rs = stmt.executeQuery();
			ResultSet rs1 = stmt1.executeQuery();
			while(rs.next()) {
				System.out.print("ID := "+rs.getInt("id"));
				System.out.println("  Name := "+ rs.getString("name")+" Email := "+rs.getString("email")+" Registered Date := "+rs.getDate("reg_date"));
				
			}
			System.out.println("\n\n");
			while(rs1.next()) {
				System.out.print("ID := "+rs1.getInt("id"));
				System.out.println("  Prescribed_Date := "+ rs1.getDate("prescribed_date")+" Patient_id := "+rs1.getInt("patient_id")+" Medicine Name := "+rs1.getString("medicine_name"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Update(int id, String meds) {
		String query = "update tbl_prescription set medicine_name = (?) where id = (?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, meds);
			stmt.setInt(2, id);
			
			int r = stmt.executeUpdate();
			System.out.println(r + " row updated!");
		} 
		catch (SQLException e) {
			System.out.println("Error in updating!!!");
			e.printStackTrace();
		}
		
	}
	public void Delete(int id) {
		String query = "delete from tbl_prescription where id = (?)";
		
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
		
		Scanner sc = new Scanner(System.in);
		
		Assessment a = new Assessment();
		a.Connect();
		
		while (true) {
			
			System.out.println("1. Add Patients,2.Add Prescription, 3.Display, 4.Update Medicines, 5.Delete Prescription ,6.Exit");
			System.out.println("Enter ur choice: ");
			int n = sc.nextInt();
			
			switch (n) {
			case 1:
				
				System.out.println("Enter name of Patient ");
				String nm = sc.next();

				System.out.println("Enter email of Patient: ");
				String em = sc.next();
				
				Patients p = new Patients(nm, em);
				System.out.println(p);
				
				a.InsertPatient(p.getId(), p.getName(), p.getEmail());
				

				break;
			case 2:
				//m.display();
				
				System.out.println("Enter Patient ID ");
				int p_id = sc.nextInt();

				System.out.println("Enter medicine name : ");
				String med = sc.next();
				
				Prescriptions pres = new Prescriptions(p_id, med);
				//System.out.println(p);
				
				a.InsertPrescription(pres.getId(), pres.getPatientId(), pres.getMedicineName());
				
				break;
			case 3:
				a.Display();
				break;
			case 4:
				System.out.println("Enter Prescription id whose medicines has to be updated: ");
				int id1 = sc.nextInt();
				System.out.println("enter medicine names to be updated: ");
				String med_up = sc.next();
				
				a.Update(id1, med_up);
				
				break;
			case 5:
				System.out.println("Enter the Prescription id to be deleted:");
				int id2 = sc.nextInt();
				
				a.Delete(id2);
				break;
			case 6:
				sc.close();
				System.exit(0);

			default:
				break;
			}
		}

	}

}
