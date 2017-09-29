package bean;
//
public class Billing {
	private String orderId;
	private String itemDesc;
    private String custName;
	private String cardNumber;
    private double price;
    private double discount;
    private String address;
    
    public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

    public Billing(String orderId, String itemDesc,String name, String cardNumber, double price,
            double discount, String address) {
        super();
        this.custName = name;
        this.cardNumber = cardNumber;
        this.price = price;
        this.discount = discount;
        this.address = address;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
