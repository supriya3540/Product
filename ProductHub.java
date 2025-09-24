package assignment;

import java.util.Scanner;
import java.util.ArrayList;

public class ProductHub {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Product Hub Store....");
        
        Product[] prods = Inventory.getProducts();
        
        ArrayList<Product> purchasedItems = new ArrayList<>();
        
        boolean shopping = true;
        while (shopping) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Browse Products by Category");
            System.out.println("2. Start Shopping");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout & Exit");
            
            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1:
                    System.out.println("\nSelect a category (1-5, 6 for Main Menu):");
                    System.out.println("1. Books");
                    System.out.println("2. Garments");
                    System.out.println("3. Mobiles");
                    System.out.println("4. TVs");
                    System.out.println("5. All Products");
                    System.out.println("6. Main Menu");
                    
                    int categoryChoice = sc.nextInt();
                    sc.nextLine();  

                    switch (categoryChoice) {
                        case 1:
                            System.out.println("\n=== Books ===");
                            for (Product p : prods) if (p instanceof Book) System.out.println(p.toString());
                            break;
                        case 2:
                            System.out.println("\n=== Garments ===");
                            for (Product p : prods) if (p instanceof Garments) System.out.println(p.toString());
                            break;
                        case 3:
                            System.out.println("\n=== Mobiles ===");
                            for (Product p : prods) if (p instanceof Phone) System.out.println(p.toString());
                            break;
                        case 4:
                            System.out.println("\n=== TVs ===");
                            for (Product p : prods) if (p instanceof Tv) System.out.println(p.toString());
                            break;
                        case 5:
                            System.out.println("\n=== All Products ===");
                            for (Product p : prods) System.out.println(p.toString());
                            break;
                        case 6:
                            // Returning to main menu, no specific action needed
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;

                case 2:
                    boolean shoppingActive = true;
                    while(shoppingActive) {
                        System.out.println("\nEnter product name to purchase (or 'back' to return to menu):");
                        String productName = sc.nextLine().trim();

                        if (productName.equalsIgnoreCase("back")) {
                            shoppingActive = false;
                            break;
                        }

                        // Find the product in the inventory
                        Product selected = null;
                        for (Product p : prods) {
                            if (p.getPname().equalsIgnoreCase(productName)) {
                                selected = p;
                                break;
                            }
                        }

                        if (selected == null) {
                            System.out.println("Product not found. Please enter a valid product name.");
                            continue;
                        }

                        System.out.println("Enter the quantity:");
                        int qty;
                        try {
                            qty = sc.nextInt();
                            sc.nextLine();  
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid quantity. Please enter a number.");
                            sc.nextLine();  
                            continue;
                        }

                        if (qty <= 0) {
                            System.out.println("Quantity must be a positive number.");
                            continue;
                        }

                        // Check if the requested quantity exceeds the stock
                        if (qty > selected.getQty()) {
                            System.out.println("Sorry, only " + selected.getQty() + " are in stock.");
                            continue;
                        }
                        
                        // Check if the item is already in the cart
                        boolean foundInCart = false;
                        for (Product cartItem : purchasedItems) {
                            if (cartItem.getPname().equalsIgnoreCase(productName)) {
                                System.out.printf("Item '%s' is already in your cart. Do you want to update the quantity? (yes/no)\n", productName);
                                String updateChoice = sc.nextLine().trim();
                                if (updateChoice.equalsIgnoreCase("yes")) {
                                    // Update the quantity of the existing item in the cart
                                    cartItem.setQty(cartItem.getQty() + qty);
                                    // Also deduct from the main inventory
                                    selected.setQty(selected.getQty() - qty);
                                    System.out.printf("Quantity for '%s' updated to %d.\n", productName, cartItem.getQty());
                                } else {
                                    System.out.println("Quantity not updated. Item was not added to cart again.");
                                }
                                foundInCart = true;
                                break;
                            }
                        }

                        if (!foundInCart) {
                            // If the item is not already in the cart, add it as a new product
                            Product purchasedProduct = new Product(selected.getPname(), qty, selected.getPrice());
                            purchasedItems.add(purchasedProduct);
                            selected.setQty(selected.getQty() - qty);
                            System.out.printf("Added to cart: %s | Subtotal: %.2f rupees\n",
                                    purchasedProduct.getPname(), purchasedProduct.getItemTotal());
                        }
                    }
                    break;

                case 3:
                    if (purchasedItems.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.println("\n=== Your Shopping Cart ===");
                        for (Product item : purchasedItems) {
                            System.out.println(item.generateBillLine());
                        }
                    }
                    break;
                
                case 4:
                    if (!purchasedItems.isEmpty()) {
                        Product[] finalBillItems = purchasedItems.toArray(new Product[0]);
                        System.out.println(Product.generateBill(finalBillItems, finalBillItems.length));
                    } else {
                        System.out.println("Your cart is empty. No bill to generate.");
                    }
                    shopping = false; 
                    break;
                
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
        sc.close();
    }
}