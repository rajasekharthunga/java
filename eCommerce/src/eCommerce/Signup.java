package eCommerce;
import java.util.*;

public class Signup {
	
	Login ln = new Login();
	Scanner in = new Scanner(System.in);
	public boolean register(database db,String name, String password) {
		boolean cck = db.setUser(name,password);
		
		if(cck) {
			System.out.println("\nSuccesfully registed : "+ name);
			System.out.println("\nWelcome "+name);
			System.out.println("\nLog in..");
			ln.log_in();
		}
		return cck;
	}
}
