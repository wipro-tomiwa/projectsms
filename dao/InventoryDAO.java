package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;
import bean.Inventory;

public class InventoryDAO {

	public boolean insertInventory(Inventory e) {
		try {
			// Statement st=con.createStatement();
			Connection con = null;
			con = DBUtil.getConnection();
			String sql = "insert into Inventory values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, e.getItemID());
			pst.setString(2, e.getItemName());
			pst.setDouble(3, e.getPrice());
			pst.setInt(4, e.getQuantity());

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

	public static boolean createInventory() {
		try {
			Connection con = null;
			con = DBUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "CREATE TABLE INVENTORY889 (ITEMID NUMBER (6) PRIMARY KEY, ITEMNAME VARCHAR(15), PRICE NUMBER(5,2), STOCKLEVEL NUMBER(3))";

			int count = st.executeUpdate(sql);

			if (count == 0) {
				System.out.println("Inventory Table is created");
				return true;
			} else {
				System.out.println("Inventory Table is not created");
				return false;
			}
		} catch (SQLSyntaxErrorException f) {
			System.out.println("SQL Syntax Error!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteInventory() {
		// Create a Statement Object
		try {
			Connection con = null;
			con = DBUtil.getConnection();
		
			Statement st = con.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter ItemID to be deleted");
			int itemid = scan.nextInt();
			String sql = "DELETE FROM INVENTORY WHERE ITEMid=" + itemid;
			System.out.println(sql);
			int count = st.executeUpdate(sql);

			if (count == 1) {
				System.out.println("Record deleted");
				return true;
			} else {
				System.out.println("Record not deleted");
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean readInventory(){
		try {
			Connection con = null;
			con = DBUtil.getConnection();
			Statement st = con.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter itemid: ");
			int itemid=scan.nextInt();
			
			String sql = "SELECT * FROM INVENTORY WHERE ITEMid ="+itemid;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			boolean flag = false;
			while (rs.next())
			{
				flag = true;
				System.out.println("ItemID="+rs.getInt("itemid"));
				System.out.println("Item name="+rs.getString("itemname"));
				System.out.println("Price="+rs.getDouble("price"));
				System.out.println("Stock level="+rs.getInt("stocklevel"));
			}
			
			if (!flag)
			System.out.println("Record not found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static boolean updateInventory() {
		try {
			Connection con = null;
			con = DBUtil.getConnection();
			Statement st=con.createStatement();
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter Item ID to be updated");
			int id=scan.nextInt();
			
			System.out.println("Enter stocklevel to be updated");
			int stocklevel=scan.nextInt();
			
			//EXACT UPDATE COMMAND FROM SQL FOR ENTIRE TABLE
			String sql="UPDATE INVENTORY  SET STOCKLEVEL='"+stocklevel+"' WHERE ITEMID = '"+id+"'";
			System.out.println(sql);
			
			int count=st.executeUpdate(sql);
			
			if (count==1){
				System.out.println("Item updated");
				return true;
			}
			else{
				System.out.println("Item not updated");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}