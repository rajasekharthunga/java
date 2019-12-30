package eCommerce;
import java.util.Scanner;


public class Cart {
	
	Billing bill = new Billing();
	OrderList ol = new OrderList();
	Order o = new Order();
	admin ad = new admin();
	Scanner sc = new Scanner(System.in);
	double totalPrice = 0 ;
	
	public void viewOrders() throws InterruptedException {
		
		System.out.println("\nProducts in the Cart...");
		System.out.println("-------------------------------");
		System.out.println("Name" + "\t" + "Quantity" + "\t" + "Price"  );
		System.out.println("-------------------------------");
				
		//OrderList.ordList.forEach(i -> System.out.println(i.getName() + "\t" + i.getQuantity() + "\t" + i.getPrice()));
		
		OrderList.ordList.forEach((i,j) -> System.out.println(j.getName()+"\t"+i+"\t"+j.getQuantity()+"\t"+j.getPrice()));
		
		System.out.println("Choose from the below options...\n1. Remove products\n2. Update Order\n3. Go to Bill ");
		boolean other = true;
		
		while(other) {
			int alterCart = sc.nextInt();
			switch(alterCart) {
			case 1:
				System.out.println("\nEnter the id of the product to remove");
				int removeId = sc.nextInt();
			
				if(ol.productInCart(removeId)){
					OrderList.ordList.remove(removeId);
					System.out.println("\nRemoved successfully...");

					Thread.sleep(300);
					viewOrders();
					break;
				}
				else {
					System.out.println("Check your Product Id... ");
					Thread.sleep(300);
					viewOrders();
					break;
				}
						
			case 2:
				System.out.print("\nEnter the id of the product to update...");
				int updateId = sc.nextInt();
				System.out.println("\nEnter the Quantity to update...");
				int updateQuantity = sc.nextInt();
				if(ad.quantityAvailability(ad, updateId,updateQuantity)) {
					OrderList.ordList.get(updateId).setQuantity(updateQuantity);
					OrderList.ordList.get(updateId).setPrice(ad.getProd(updateId).getPrice()*updateQuantity);
					viewOrders();
					break;
				}
				else {
					System.out.println("Q");
				}
			case 3:
				goTOBill();
				other =false;
				break;
				
			default:
				System.out.println("Choose from the given options..!");
			}
			
				
		}
		
		
	}
	
	public void goTOBill() {
		
		boolean billProcess = true ;
		
		while(billProcess) {
			System.out.println("\nProceed to billing....! Y/N");
			String proceedToBill = sc.next();
			
			if(proceedToBill.toLowerCase().equals("y")) {
//				for(OrderList o : OrderList.ordList)
//				{
//					totalPrice=totalPrice+o.getPrice();
//				}
				OrderList.ordList.forEach(
						(i,j)->
								{
									totalPrice = totalPrice + j.getPrice();
								});
				bill.printBill(totalPrice);
				billProcess = false;
			}
			else if(proceedToBill.toLowerCase().equals("n")) {
				System.out.println("Thank you...");
				billProcess = false;
			}
			else {
				System.out.println("Invalid input...");
			}
		}
	}
}
