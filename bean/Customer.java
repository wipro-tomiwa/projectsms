package bean;
public class Customer {

	private int customer_id;
	private String name;
	private String address;
	private int contact;
	private String email;

	public Customer(int customer_id, String customer_name, 
			String address, int contact_number, String email_address) {
		super();
		this.customer_id = customer_id;
		this.name = customer_name;
		this.address = address;
		this.contact = contact_number;
		this.email = email_address;
	}

	public int getId() {
		return customer_id;
	}

	public void setId(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String customer_name) {
		name = customer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact_number) {
		this.contact = contact_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email_address) {
		email = email_address;
	}

}
