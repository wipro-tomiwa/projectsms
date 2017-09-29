package dao;

import java.util.Scanner;

import bean.Billing;
import bean.Customer;
import bean.Inventory;
import dao.CustomerDAO;

public class Services {
	static Scanner sc = new Scanner(System.in);

	static Billing billbean = null;
	static Customer custbean;
	static Inventory stockbean;

	public static void main(String[] args) {

		int custid = (int) (Math.random() * 100);
		String name = "Rob";
		String custaddress = "Tower street bridge";
		int contact = 8300083;
		String email = "djdjjd@htomail.com";

		// billing
		String orderId = "ord" + Integer.toString(custid);
		String itemDesc = "Sweets";
		String custName = "Robert Sherperd";
		String cardNumber = "383828482483";
		double price = 5.0;
		int discount = 6;
		String address = " John street";

		int itemID = 001;
		String itemName = "Cookies";
		double itemPrice = 20.50;
		int quantity = 450;

		// create beans
		custbean = new Customer(custid, name, custaddress, contact, email);
		billbean = new Billing(orderId, itemDesc, custName, cardNumber, price,
				discount, address);
		stockbean = new Inventory(itemID, itemName, itemPrice, quantity);

		custbean.setName(name);
		custbean.setId(custid);
		custbean.setAddress(custaddress);
		custbean.setContact(contact);
		custbean.setEmail(email);
		
		billbean.setOrderId(orderId);
		billbean.setItemDesc(itemDesc);
		billbean.setCustName(custName);
		billbean.setCardNumber(cardNumber);
		billbean.setPrice(itemPrice);
		billbean.setDiscount(discount);
		billbean.setAddress(address);

		// invoke the DAO method
		String q = "yes";
		while (q.toLowerCase().contains("y")) {
			System.out.println("Welcome to the menu. Select an option."
					+ "\n1. Insert Customer \n2. Insert Billing "
					+ "\n3. Insert Inventory Item \n4. Delete Customer"
					+ "\n5. Update Order/Billing"
					+ "\n6. Create Inventory Table"
					+ "\n7. Delete Inventory Item"
					+ "\n8. Update Inventory Item"
					+ "\n9. Read Inventory Item");
			int menu = sc.nextInt();
			switch (menu) {
			// Calls corresponding methods
			case 1:
				runCustomerInsertion();
				break;
			case 2:
				runBillingInsertion();
				break;
			case 3:
				runInventoryInsertion();
				break;
			case 4:
				deleteCustomer();
				break;
			case 5:
				updateOrder();
				break;
			case 6:
				createInventoryTable();
				break;
			case 7:
				deleteInventoryItem();
				break;
			case 8:
				updateInventoryItem();
				break;
			case 9:
				readFromInventory();
			default:
				System.out.println("You entered a wrong selection!");
				break;
			}
			System.out.print("would you like to continue?. Enter yes or No: ");
			q = sc.next();
			System.out.println(q);
		}
		System.out.println("GoodBYE!");
	}

	private static void readFromInventory() {
		// TODO Auto-generated method stub
		InventoryDAO.readInventory();
	}

	private static void updateInventoryItem() {
		// TODO Auto-generated method stub
		InventoryDAO.updateInventory();
	}

	private static void deleteInventoryItem() {
		// TODO Auto-generated method stub
		InventoryDAO.deleteInventory();
	}

	public static void runCustomerInsertion() {
		CustomerDAO dao = new CustomerDAO();
		if (dao.insertCustomer(custbean))
			System.out.println("Customer Record Inserted");
		else
			System.out.println("Customer Record not Inserted");
	}

	public static void runBillingInsertion() {
		BillingDAO dao = new BillingDAO();
		if (dao.insertBilling(billbean))
			System.out.println("Billing Record Inserted");
		else
			System.out.println("Billing Record not Inserted");
	}

	public static void runInventoryInsertion() {
		InventoryDAO dao = new InventoryDAO();
		if (dao.insertInventory(stockbean))
			System.out.println("Inventory Record Inserted");
		else
			System.out.println("Inventory Record not Inserted");
	}

	public static void deleteCustomer() {
		CustomerDAO.deleteCustomer();
	}

	public static void updateOrder() {
		BillingDAO.updateOrder();
	}
	
	public static void createInventoryTable(){
		InventoryDAO.createInventory();
	}
}
