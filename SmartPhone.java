package assignment;

public class SmartPhone extends Phone implements Discount{
	

	

	public SmartPhone(String pName) {
		super(pName);
		// TODO Auto-generated constructor stub
	}

	public SmartPhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String pName, double price) {
		super(pName, price);
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String pName, int qty, double price) {
		super(pName, qty, price);
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String pName, int qty) {
		super(pName, qty);
		// TODO Auto-generated constructor stub
	}
}