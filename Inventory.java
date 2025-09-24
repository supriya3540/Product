package assignment;



public class Inventory {
	private static Product prods []= {
			 new Book("Inspiration", 23, 200),
             new Novel("witch", 15, 150),
             new Classic("Hero", 10, 1000),
             new Thriller("The Roar", 12, 1200),
             
             new Garments("BasicGarment", 30, 100),
             new Shirt("Shirt", 22, 400),
             
             new Pant("Pant", 34, 500),
             new HalfPant("Shorts", 20, 200),
             
             new Phone("BasicMobile", 10, 15000),
             new KeyPad("Nokia", 12, 2500),
             new SmartPhone("GenericSmartPhone", 8, 50000),
             new SmartPhone("iPadPro", 10, 80000),
            
             new Tv("BasicTV", 5, 10000),
             new LG("SmartTV", 5, 30000),
             new Sony("SonyBravia", 6, 68000)
     };
	public static Product [] getProducts() {
		return prods;
	}
}
	
			
			
			
	


