package atm;

import java.util.HashMap;

public class UserManager {  //管理帳戶
	//HashMap用來放使用者帳戶，對照用
	private HashMap<String, User> users = new HashMap<>();
	
	public UserManager() {  //初始值，先放了兩個帳戶
		users.put("A001", new User("A001", "user1", "aaaa", 1000));
		users.put("A002", new User("A002", "user2", "bbbb", 5000));
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

	
	public void addUser(String id, String username, String password, int balance) {  //新增帳戶
		users.put(id, new User(id, username, password, balance));
	}
}
	