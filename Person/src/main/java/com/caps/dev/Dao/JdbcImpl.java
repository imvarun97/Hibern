package com.caps.dev.Dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.caps.dev.beans.Person;
import com.mysql.jdbc.Driver;
public class JdbcImpl implements PersonInterface{

public void create(Person p) {
	System.out.println("Enter person Details");
    System.out.println("-------------------");
    
    Scanner in = new Scanner(System.in);
    
    System.out.println("Enter person id: ");
    p.setPersonId(Integer.parseInt(in.nextLine()));
    
    System.out.println("Enter person name: ");
    p.setPersonName(in.nextLine());
    
    System.out.println("Enter Age: ");
    p.setAge(Integer.parseInt(in.nextLine()));
    
    System.out.println("Enter email id: ");
    p.setEmail(in.nextLine());
    
    System.out.println("Enter Adress: ");
    p.setAddress(in.nextLine());
    Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		/*
		 * 1. Load the Driver
		 */
		Class.forName("com.mysql.jdbc.Driver");

		/*
		 * 2. Get the DB Connection via Driver
		 */
		
		String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

		//3rd version of getConnnecton()
		con = DriverManager.getConnection(dbUrl,"root","1387"); //1st version of getConnection

		

		
		String sql = "insert into person values(?,?,?,?,?)";
		

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, p.getPersonId());
		pstmt.setString(2,p.getPersonName());
		pstmt.setInt(3, p.getAge());
		pstmt.setString(4, p.getEmail());
		pstmt.setString(5, p.getAddress());
	
		
		int count = pstmt.executeUpdate();
		
		
		
		/*
		 * 4. Process the results
		 */

		if(count > 0) {
			System.out.println("Data Inserted");
		}else {
			System.out.println("Failed");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}

public void update(Person p) {
	
	System.out.println("Update person Details");
    System.out.println("-------------------");
    
    Scanner in = new Scanner(System.in);
    
    System.out.println("Enter person id: ");
    p.setPersonId(Integer.parseInt(in.nextLine()));
    
    System.out.println("Enter email id to be updated: ");
    p.setEmail(in.nextLine());
    
    Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		/*
		 * 1. Load the Driver
		 */
		Class.forName("com.mysql.jdbc.Driver");

		/*
		 * 2. Get the DB Connection via Driver
		 */
		
		String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

		//3rd version of getConnnecton()
		con = DriverManager.getConnection(dbUrl,"root","1387"); //1st version of getConnection

		
		
		String sql = "update person set email=? where P_id=?";
		System.out.println(sql);

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, p.getEmail());
		pstmt.setInt(2, p.getPersonId());
		
		
		int count = pstmt.executeUpdate();
		
		
		
		/*
		 * 4. Process the results
		 */

		if(count > 0) {
			System.out.println("Email id updated");
		}else {
			System.out.println("Failed");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
    
}

public void search(Person p) {
	System.out.println("Search a Person");
    System.out.println("-------------------");
    
    Scanner in = new Scanner(System.in);
    
    System.out.println("Enter person id: ");
    p.setPersonId(Integer.parseInt(in.nextLine()));
    
    Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;
	try {
		/*
		 * 1. Load the Driver
		 */
		java.sql.Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		
		/*
		 * 2. Get the DB Connection via Driver
		 */
					String dbUrl="jdbc:mysql://localhost:3306/capsv4_db"
							+ "?user=root&password=1387";
		con = DriverManager.getConnection(dbUrl); //1st version of getConnection

	
		String sql = "select * from person where p_id=?";

		cstmt = con.prepareCall(sql);
		cstmt.setInt(1,p.getPersonId());
		boolean state=cstmt.execute();
		int count=0;
	

		/*
		 * 4. Process the results
		 */
		if(state) {
			rs = cstmt.getResultSet();
		if(rs.next()){
			int id1 = rs.getInt("p_id");
			String name = rs.getString("p_name");
			int age=rs.getInt("age");
			String email = rs.getString("email");
			String address = rs.getString("address");
			

			System.out.println(id1);
			System.out.println(name);
			System.out.println(age);
			System.out.println(email);
			System.out.println(address);
			System.out.println("*********************");
		}
		else{
			System.out.println("fialed to search");
		}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(cstmt != null) {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
}

public void delete(Person p) {

	System.out.println("Delete person Details");
    System.out.println("-------------------");
    
    Scanner in = new Scanner(System.in);
    
    System.out.println("Enter person id to be deleted: ");
    p.setPersonId(Integer.parseInt(in.nextLine()));
    
    Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		/*
		 * 1. Load the Driver
		 */
		Class.forName("com.mysql.jdbc.Driver");

		/*
		 * 2. Get the DB Connection via Driver
		 */
		
		String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

		//3rd version of getConnnecton()
		con = DriverManager.getConnection(dbUrl,"root","1387"); //1st version of getConnection

		

		/*
		 * 3. Issue the SQL query via connection
		 */
		
		
		String sql = "delete from person where p_id=?";
		System.out.println(sql);

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, p.getPersonId());
		
		
		
		int count = pstmt.executeUpdate();
		
		
		
		/*
		 * 4. Process the results
		 */

		if(count > 0) {
			System.out.println("Data deleted");
		}else {
			System.out.println("Failed");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
}