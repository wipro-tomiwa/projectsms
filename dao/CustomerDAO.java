package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import util.DBUtil;
import bean.Customer;

public class CustomerDAO {
	public boolean insertCustomer(Customer e) {
		try {
			// Statement st=con.createStatement();
			Connection con=null;
			con = DBUtil.getConnection();
			String sql = "insert into Sainsburycustomers values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, e.getId());
			pst.setString(2, e.getName());
			pst.setString(3, e.getAddress());
			pst.setInt(4, e.getContact());
			pst.setString(5, e.getEmail());

			int count = pst.executeUpdate();
				

			if (count == 1)
				return true;
			else
				return false;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	public static boolean deleteCustomer() {
		//Create a Statement Object
		try {
			Connection con=null;
			con = DBUtil.getConnection();
			Statement gt=con.createStatement();
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter customer_id to be deleted");
			int customer_id=scan.nextInt();
			String sql="delete from Sainsburycustomers where custid=" + customer_id;
			System.out.println(sql);
			scan.close();

			int count=gt.executeUpdate(sql);
			System.out.println("count ="+ count);
			//while(true);
		
			if (count == 1){
				System.out.println("Record deleted");
				return true;
			}
			else{
				System.out.println("Record not deleted, please enter valid value");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}
	
	public boolean updateCustomerSalary(int eid, float salary) {
		return false;
	}

	public Customer readCustomer(int eid) {
		return null;
	}
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			// Statement st=con.createStatement();
			Connection con = DBUtil.getConnection();
			String sql = "select * from Sainsburycustomers";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Customer bean = new Customer(0, sql, sql, 0, sql);
				bean.setId(rs.getInt("custid"));
				bean.setName(rs.getString("custname"));
				bean.setAddress(rs.getString("address"));
				bean.setContact(rs.getInt("contact"));
				bean.setEmail(rs.getString("email"));
				list.add(bean);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		return list;
	}
}