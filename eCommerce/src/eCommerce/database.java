package eCommerce;
import java.util.HashMap;
import java.util.Map;


public class database {
	
	static Map<String, String> users = new HashMap<>();
	
	public database() {
		users.put("a","aa");
	}
	
	public boolean setUser(String name, String password) {
		users.put(name,password);
		System.out.println("Added Successfully..!");
		return true;
		
	}
	
	public boolean checkUser(String name, String password) {
		
		if(users.containsKey(name)) {
			if(password.equals(users.get(name))) {
				return true;
			}
		}
		
		return false;
	}
	
}