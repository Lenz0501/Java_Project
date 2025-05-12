package atm;

public class User {
    //用來產生id(counter)
    private static int counter = 1;

    //個別帳戶的資料
    private String id;
    private String username;
    private String password;
    private int balance;

    //從CSV讀入時會用這個
    public User(String id, String username, String password, int balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    //新增帳戶時會用這個(自動產生id)
    public User(String username, String password, int balance) {
        this.id = String.format("%05d", counter);  //產生五位數id（補0）
        counter++;  // counter遞增
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    //從CSV讀取資料時，並把counter更新到最新
    public static void updateCounter(String latestId) {
        int num = Integer.parseInt(latestId);  //把id轉成數字
        if (num >= counter) {
            counter = num + 1;  //更新counter
        }
    }

    //取得id
    public String getId() {
        return id;
    }

    //取得使用者名稱
    public String getUsername() {
        return username;
    }

    //取得密碼
    public String getPassword() {
        return password;
    }

    //取得餘額
    public int getBalance() {
        return balance;
    }
    
    //檢查密碼
    public boolean checkPassword(String inputPW) {
        return password.equals(inputPW);
    }

    //存款功能
    public void deposit(int amount) {
        balance += amount;
    }

    //提款功能，若餘額足夠扣除金額
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;  //餘額不足則提款失敗
    }

    //顯示帳戶資訊
    public String showInfo() {
        return "帳號：" + id + "\n使用者：" + username + "\n餘額：" + balance + " 元";
    }
}
