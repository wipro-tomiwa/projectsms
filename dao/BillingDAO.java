package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;
import bean.Billing;

public class BillingDAO {

	public boolean insertBilling(Billing e) {
		try {
			// Statement st=con.createStatement();
			Connection con=null;
			con = DBUtil.getConnection();
			String sql = "insert into OrderBilling values(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, e.getOrderId());
			pst.setString(2, e.getItemDesc());
			pst.setString(3, e.getCustName());
			pst.setString(4, e.getCardNumber());
			pst.setDouble(5, e.getPrice());
			pst.setDouble(6, e.getDiscount());
			pst.setString(7, e.getAddress());

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

	static public boolean updateOrder() {
		// Create a Statement Object
		try {
			Connection con=null;
			con = DBUtil.getConnection();
			Statement st = con.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter id to update");
			String ordId = scan.next();
			System.out.println("Enter card number to be updated");
			String ccNum = scan.next();
			String sql = "update OrderBilling set cardnumber='" + ccNum
					+ "' where orderid='" + ordId+"'";
			System.out.println(sql);
			int count = st.executeUpdate(sql);

			if (count > 0) {
				System.out.println("Record Updated");
				return true;
			} else {
				System.out.println("Record not Updated");
				return false;
			}

		} catch (SQLException i) {
			// TODO Auto-generated catch block
			i.printStackTrace();
		}
		return false;
	}
}
