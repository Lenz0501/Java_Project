package atm;

import java.io.*;
import java.util.HashMap;

public class UserManager {
    //用來記錄所有帳戶的表格（id - user的資料）
    private HashMap<String, User> users = new HashMap<>();

    //檔名設定
    private static final String FILE_NAME =
    		System.getProperty("user.dir") + File.separator + "accounts.csv";
    
    private static final String Transaction_FILE_NAME =
    		System.getProperty("user.dir") + File.separator + "transaction.csv";

    //啟動時讀取帳戶資料
    public UserManager() {
        loadAccountsFromFile();
    }

    //讀取csv的資料
    private void loadAccountsFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("檔案不存在，將建立新的帳戶檔案。");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String id = data[0];
                    String username = data[1];
                    String password = data[2];
                    int balance = Integer.parseInt(data[3]);
                    String role = data[4];
                    
                    //建立帳戶並放進users
                    User user = new User(id, username, password, balance,role);
                    users.put(id, user);

                    //更新ID避免重複
                    User.updateCounter(id);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("讀取帳戶資料時發生錯誤！");
            e.printStackTrace();
        }
    }

    //新增帳戶，回傳新增的帳戶資料
    public User addUser(String username, String password, int balance, String role) {
        User newUser = new User(username, password, balance, role);
        users.put(newUser.getId(), newUser);
        saveUserToFile(newUser);
        return newUser;
    }

    //把新帳戶寫入csv
    private void saveUserToFile(User user) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            String line = user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getBalance() + "," + user.getRole();
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("寫入帳戶資料時發生錯誤！");
            e.printStackTrace();
        }
    }
    
  //把所有更新的帳戶覆蓋寫入存回CSV
    public void saveToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User u : users.values()) {
                String line = u.getId() + "," + u.getUsername() + "," + u.getPassword() + "," + u.getBalance() + "," + u.getRole();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("✅ 帳戶資料已儲存");
        } catch (IOException e) {
            System.out.println("❌ 儲存時發生錯誤！");
            e.printStackTrace();
        }
    }
    

    //用id查詢帳戶
    public User getUser(String id) {
        return users.get(id);
    }

    //用使用者名稱查詢帳戶（用於登入）
    public User getUserByUsername(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    //驗證帳密
    public boolean validate(String username, String password) {
    	User user = getUserByUsername(username); 
        if (user != null) {
            return user.checkPassword(password);
        } else {
            return false;
        }
    }

    //顯示所有帳戶（可留可不留，主要是檢查帳戶有沒有真的寫到檔案）
    public void showAllUsers() {
        for (User u : users.values()) {
            System.out.println(u.showInfo());
            System.out.println("----------------------");
        }
    }
}