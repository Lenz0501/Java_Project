package atm;

import java.util.HashMap;
import atm.User;

public class UserManager {  //管理帳戶
	//HashMap用來放使用者帳戶，對照用
	private HashMap<String, User> users = new HashMap<>();
	
	public UserManager() {  //初始值，先放了兩個帳戶
		addUser("aaaa", "1234", 1000);
		addUser("jimin", "0000", 5000);
	}
	
	public User getUser(String id) {  //用id取得帳戶
		return users.get(id);  
	}
	
	public boolean validate(String id, String password) {  //驗證帳密
	    User u = users.get(id);  //根據帳號找帳戶

	    if (u != null) {  //找得到這個帳號
	        if (u.checkPassword(password)) {  //密碼也對
	            return true;  
	        }
	    }
	    return false;  
	}

	
	public void addUser(String username, String password, int balance) {  //新增帳戶
		User newUser = new User(username, password, balance);
		users.put(newUser.getId(), newUser);
	}
}