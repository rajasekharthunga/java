package eCommerce;
import java.util.*;

public class Login {
	Scanner in = new Scanner(System.in);
	database db = new database();
	String name;
	String password;

	public boolean log_in(){
		System.out.println();
		System.out.println("UserName :");
		String name = in.next();
		System.out.println("Password :");
		String pass = in.next();
		boolean checker = check(name, pass);
		return checker;
	}
	
	public boolean check(String name, String password) {
		boolean test_user = db.checkUser(name, password);
		if(test_user) {
			System.out.println("Logged in Successfully..!");
			System.out.println("\nWelcome "+name);
			return true;
		}
		else {
			System.out.println("User not found : "+name);
			System.out.println("Do you want to Sign Up..! Y/N");
			String ask = in.next();
			if(ask.toLowerCase().equals( "y")) {
				Signup su = new Signup();
				System.out.println("Username : " );
				String username = in.next();
				System.out.println("Password: ");
				String pass = in.next();
				return su.register(db,username,pass);
			}
			else {
				System.out.println("Thank You..!");
				return false;
			}
			
		}
	}

	
	
	
}
