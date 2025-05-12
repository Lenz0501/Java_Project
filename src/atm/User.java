package atm;

public class User {  //帳戶資訊
	private static int counter = 1;
	private String id;
	private String username;
	private String password;
	private int balance;
	
	public User(String username, String password, int balance) {  //初始值
		this.id = String.format("%05d", counter); //5位數的編號
		counter++;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	public String getId() {  //取得id
		return id;
	}
	
	public boolean checkPassword(String inputPW) {  //檢查密碼
		return password.equals(inputPW);
	}
	
	public void deposit(int amount) {  //存款
		balance += amount;
	}
	
	public boolean withdraw(int amount) {  //提款
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	public int getBalance() {  //取得餘額
		return balance;
	}
	
	public String showInfo() {  //顯示帳戶資訊
		return "帳號：" + id + "\n使用者：" + username + "\n餘額" + balance + " 元";
	}
}
