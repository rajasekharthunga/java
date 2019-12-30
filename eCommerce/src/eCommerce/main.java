package eCommerce;
import java.io.ObjectInputStream.GetField;
import java.util.*;

import org.omg.CORBA.DynAnyPackage.Invalid;

public class main {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner in = new Scanner(System.in);
		products prdts = new products();
		Order order = new Order();
		//admin ad = new admin();
		Login ln = new Login();
		admin am = new admin();
		Cart ct  = new Cart();
			
		System.out.println("Login ");
		
		boolean login_success = ln.log_in();
		
		if(login_success) {
			
			Thread.sleep(500);
			prdts.PrintProducts();
		
			prdts.PrintStock();
			
			System.out.println("Select the products and Add to cart.....");
			boolean wantToPurchase = true;
			
			while(wantToPurchase) {
			System.out.println("Do you want to purchase...Y/N");
			String shop = in.next();
			
			boolean repeat = true;
			
			if(shop.toLowerCase().contentEquals("y")) {
				wantToPurchase = false;
				while(repeat) {
					
					boolean  ch = true;
					
					System.out.println("\nEnter the id of the product to shop");
					int prodId = in.nextInt();
					
					if(am.productAvailablity(prodId)) {
						System.out.println("\nQuantity...");
						int quantityOfProd = in.nextInt();
						
						if(am.quantityAvailability(am, prodId, quantityOfProd)) {
							double price = am.getProd(prodId).getPrice();
							String name = am.getProd(prodId).getName();
							
							order.addProductToCart(prodId, name, quantityOfProd, price); //Adding Product to Cart
							am.updateStock(prodId, -quantityOfProd);
						}
						else {
							System.out.println("\nSorry...!!\n" + "Available Stock for the product " + am.getProd(prodId).getName() + " is "+ am.getProd(prodId).getStock());
						}
					}
					else {
						System.out.println("Product is not available in Product list..!");
					}
					
				while(ch) {
					
					System.out.println("\nContinue Shopping....Y/N");
					String Shop = in.next();
					
					if(Shop.toLowerCase().equals("n")) {
						repeat = false;
						ch=false;
						
						boolean other = true;
						System.out.println("Choose from the below options :");
						while(other) {
							
							System.out.println("\n1. Check Product List\n2. Check Your Cart\n3. Check Bill");
							int select = in.nextInt();
							switch(select) {
							case 1:
								prdts.printRemaining();
								break;
							case 2:
								ct.viewOrders();
								other = false;
								break;
							case 3:
								ct.goTOBill();
								other = false;
								break;
							default:
								System.out.println("Choose from the given options ..!");
							}
							
						}
						
					}
					else if(Shop.toLowerCase().equals("y")) {
						ch = false;
					}
					else {
						System.out.println("\nInvalid ..");
					}
				} //ends continueShopping loop
								
				}
				login_success = false; //LogOut
			}
			
			else if(shop.toLowerCase().contentEquals("n")) {
				System.out.println("\nThanks For Visting....\nHave a nice day..!!");
				wantToPurchase = false;
			}
			
			else {
				System.out.println("\nInvalid....Select the appropriate key....");
			}
			}
		}
	
	}	
}
