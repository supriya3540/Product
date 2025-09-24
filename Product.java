package assignment;

public class Product implements Discount, Comparable<Product> {
	private long pid;
	private String pName;
	private int qty;
    
	private double price;
	
	public Product(String pName) {
		super();
		this.pName = pName;
		this.pid=generatePid();
	}
	
	@Override
	public String toString() {
		return "PID=" + pid + ", ProductName=" + pName + ", Quantity=" + qty + ", Price=" + price;
	}
	
	private long generatePid() {
		return Math.round(Math.random()*100);
	}
	
	public Product() {
		super();
		this.pid=generatePid();
	}
	
	public Product(long pid, String pName, int qty, double discount, double price) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.qty = qty;
		this.price = price;
	}

	public Product(String pName, int qty, double price) {
		super();
		this.qty=qty;
		this.price=price;
		this.pName = pName;
		this.pid=generatePid();
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product(String pName, int qty) {
		super();
		this.pName = pName;
		this.qty = qty < 0 ? 1 : qty;
		this.pid=generatePid();
	}
	
	public Product(String pName, double price) {
		super();
		this.pName = pName;
		this.pid=generatePid();
	}
	
	public long getPid() {
		return pid;
	}
	
	public String getPname() {
		return pName;
	}
	
	public int getQty() {
		return qty;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setQty(int qty) {
		this.qty = qty < 0 ? 1 : qty;
	}
	
	public void setQuantity(int qty) {
		this.qty = 1;
	}
	
    public String generateBillLine() {
        double itemTotal = this.price * this.qty;
        double discountAmount = discount() * itemTotal;
        
        return String.format("PID: %-10d Product: %-20s Price: %-10.2f Qty: %-5d Total: %-10.2f rupees Discount: %10.2f",
                this.pid, this.pName, this.price, this.qty, itemTotal, discountAmount );
    }

    public double getItemTotal() {
        return this.price * this.qty;
    }
   
    public String getpName() {
		return pName;
	}

	public static String generateBill(Product[] purchasedItems, int purchaseCount) {
        String bill = "\n=== Purchase Summary ===\n";
        double subTotal = 0;
        double totalDiscount = 0;

        for (int i = 0; i < purchaseCount; i++) {
            if (purchasedItems[i] != null) {
                subTotal += purchasedItems[i].getItemTotal();
            }
        }
        
        double finalBill = subTotal;
        double overallDiscount = 0.0;
        
      
        if (subTotal > 50000) {
            
            overallDiscount = subTotal * 0.40;
            finalBill = subTotal - overallDiscount;
           
            for (int i = 0; i < purchaseCount; i++) {
                if (purchasedItems[i] != null) {
                    double itemTotal = purchasedItems[i].getItemTotal();
                    bill += String.format("PID: %-10d Product: %-20s Price: %-10.2f Qty: %-5d Total: %-10.2f rupees\n",
                        purchasedItems[i].getPid(), purchasedItems[i].getPname(), purchasedItems[i].getPrice(), purchasedItems[i].getQty(), itemTotal);
                }
            }
            
        } else {
            
            for (int i = 0; i < purchaseCount; i++) {
                if (purchasedItems[i] != null) {
                    double itemTotal = purchasedItems[i].getItemTotal();
                    double itemDiscount = purchasedItems[i].discount() * itemTotal;
                    totalDiscount += itemDiscount;
                    finalBill = subTotal - totalDiscount;
                    
                    bill += String.format("PID: %-10d Product: %-20s Price: %-10.2f Qty: %-5d Total: %-10.2f rupees Discount: %10.2f\n",
                        purchasedItems[i].getPid(), purchasedItems[i].getPname(), purchasedItems[i].getPrice(), purchasedItems[i].getQty(), itemTotal, itemDiscount);
                }
            }
            overallDiscount = totalDiscount; 
        }
        
        bill += "------------------------------------------------\n";
        bill += String.format("Sub-Total: %10.2f rupees\n", subTotal);
        bill += String.format("Total Discount: %10.2f rupees\n", overallDiscount);
        bill += String.format("Final Bill: %10.2f rupees\n", finalBill);
        bill += "....Thank You for purchasing from our store...!" + "\n*****keep Visting our store*****\n****Have a great Day****";
        return bill;
    }

	@Override
	final public double discount() {
		double discountRate = 0.0;
		String name = this.pName.toLowerCase();
		
		switch (name) {
			case "garments":
			case "tv":
				discountRate = 0.20; 
				break;
			case "shirt":
			case "thriller":
				discountRate = 0.15; 
				break;
			case "halfpant":
			case "lg":
				discountRate = 0.10; 
				break;
			case "sony bravia":
			case "book":
			case "pant":
			case "smartphone":
			case "novel":
			case "keypad":
				discountRate = 0.05; 
				break;
			default:
				discountRate = 0.04; 
				break;
		}
		return discountRate;
	}
	
	@Override
    public int compareTo(Product other) {
        return this.pName.compareToIgnoreCase(other.pName);
    }
}