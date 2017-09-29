package bean;

public class Inventory {

	public int itemID;
	public String itemName;
	public double price;
	public int quantity;

	public Inventory(int itemID, String itemName, double price, int quantity) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
