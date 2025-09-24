🛒 Product Hub Store
This is a simple console-based e-commerce application built in Java. It simulates a product shopping system where users can browse products by category, add items to a shopping cart, and generate a final bill with applicable discounts. The project demonstrates core object-oriented programming (OOP) concepts such as inheritance, polymorphism, and interfaces.

✨ Features
Product Catalog: Browse a variety of products organized into categories like Books, Garments, Mobiles, and TVs.

Shopping Cart: Add products and specify quantities to a shopping cart.

Dynamic Discounts: Discounts are automatically calculated based on the product type (e.g., specific discounts for Garments or TVs).

Bulk Purchase Discount: A special discount of 40% is applied to the final bill if the sub-total exceeds ₹50,000.

Duplicate Item Handling: If a user tries to add an item that is already in the cart, the system prompts them to update the quantity instead of adding a new entry.

Automated Bill Generation: A detailed bill is generated at checkout, showing line-item totals, discounts, sub-total, and the final amount.

🚀 How to Run
Clone the repository:

Bash

git clone <your_repo_url>
Navigate to the project directory:

Bash

cd assignment
Compile the Java files:

Bash

javac -d . *.java
Run the application:

Bash

java assignment.ProductHub
📂 Project Structure
ProductHub.java: The main class containing the main method. It handles user interaction, manages the shopping cart, and orchestrates the entire process.

Product.java: The base class for all products. It implements the Discount and Comparable interfaces. It contains common product properties and methods for bill generation.

Inventory.java: A utility class that initializes and holds the list of available products.

Discount.java: An interface that defines the discount() method, ensuring all product types can provide a discount rate.

sub-classes: Various product-specific classes (Book, Garments, Phone, Tv, etc.) that extend the Product class to provide specialized behavior.
