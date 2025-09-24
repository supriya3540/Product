package assignment;

public class Book extends Product implements Discount{
	
	

	

	public Book(String pName) {
		super(pName);
		// TODO Auto-generated constructor stub
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String pName, double price) {
		super(pName, price);
		// TODO Auto-generated constructor stub
	}

	public Book(String pName, int qty, double price) {
		super(pName, qty, price);
		// TODO Auto-generated constructor stub
	}

	public Book(String pName, int qty) {
		super(pName, qty);
		// TODO Auto-generated constructor stub
	}
	

}
