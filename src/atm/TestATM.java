package atm;

import java.util.Scanner;

public class TestATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();

        while (true) {
            System.out.println("\n====== 歡迎使用 ATM 系統 ======");
            System.out.println("1. 使用ATM (登入)");
            System.out.println("2. 新增帳戶 (開戶)");
            System.out.println("0. 離開系統");
            System.out.print("請選擇：");

            int choice = sc.nextInt();
            sc.nextLine(); // 清掉換行

            if (choice == 1) {
                useATM(manager, sc);
            } else if (choice == 2) {
                openNewAccount(manager, sc);
            } else if (choice == 0) {
                System.out.println("👋 感謝使用，再見！");
                manager.saveToCSV();
                break;
            } else {
                System.out.println("⚠️ 無效選項，請重新選擇");
            }
        }

        sc.close();
    }

    private static void useATM(UserManager manager, Scanner sc) {
        User currentUser = null;

        while (currentUser == null) {
            System.out.print("🔑 請輸入帳號ID：");
            String id = sc.nextLine();
            System.out.print("🔑 請輸入密碼：");
            String pw = sc.nextLine();

            if (manager.validate(id, pw)) {
                currentUser = manager.getUser(id);
                System.out.println("✅ 登入成功，歡迎 " + currentUser.getUsername());
            } else {
                System.out.println("❌ 帳號或密碼錯誤，請重新輸入");
            }
        }

        while (true) {
            System.out.println("\n====== ATM 功能選單 ======");
            System.out.println("1. 查詢餘額");
            System.out.println("2. 存款");
            System.out.println("3. 提款");
            System.out.println("0. 登出");
            System.out.print("請選擇功能：");

            int atmChoice = sc.nextInt();

            if (atmChoice == 1) {
                System.out.println("💰 目前餘額：" + currentUser.getBalance() + " 元");
            } else if (atmChoice == 2) {
                System.out.print("💰 輸入存款金額：");
                int amount = sc.nextInt();
                currentUser.deposit(amount);
                System.out.println("✅ 存款成功，目前餘額：" + currentUser.getBalance() + " 元");
            } else if (atmChoice == 3) {
                System.out.print("🏧 輸入提款金額：");
                int amount = sc.nextInt();
                if (currentUser.withdraw(amount)) {
                    System.out.println("✅ 提款成功，目前餘額：" + currentUser.getBalance() + " 元");
                } else {
                    System.out.println("❌ 餘額不足，提款失敗");
                }
            } else if (atmChoice == 0) {
                System.out.println("🚪 已登出");
                break;
            } else {
                System.out.println("⚠️ 輸入錯誤，請重新選擇");
            }
        }
    }

    private static void openNewAccount(UserManager manager, Scanner sc) {
        System.out.print("📄 輸入新帳戶名稱：");
        String username = sc.nextLine();
        System.out.print("🔒 設定密碼：");
        String password = sc.nextLine();
        System.out.print("💰 初始存款金額：");
        int balance = sc.nextInt();
        sc.nextLine(); // 清掉換行

        // ⭐️ 新增帳戶並拿回 newUser 物件
        User newUser = manager.addUser(username, password, balance);

        // ⭐️ 把新帳戶ID顯示出來
        System.out.println("✅ 帳戶新增成功！");
        System.out.println("👉 請記住您的帳號ID：" + newUser.getId());
    }
}
