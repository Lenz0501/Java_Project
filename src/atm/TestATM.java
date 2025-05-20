package atm;

import java.util.Scanner;

public class TestATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();

        while (true) {
            System.out.println("\n====== 歡迎使用 ATM 系統 ======");
            System.out.println("1. 使用ATM (登入)");
            System.out.println("0. 離開系統");
            System.out.print("請選擇：");

            int choice = sc.nextInt();
            sc.nextLine(); // 清除換行

            if (choice == 1) {
                useATM(manager, sc);
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
            System.out.print("🔑 請輸入使用者名稱：");
            String username = sc.nextLine();
            System.out.print("🔑 請輸入密碼：");
            String pw = sc.nextLine();

            if (manager.validate(username, pw)) {
                currentUser = manager.getUserByUsername(username);
                System.out.println("✅ 登入成功，歡迎 " + currentUser.getUsername() + "（" + currentUser.getRole() + "）");
            } else {
                System.out.println("❌ 使用者名稱或密碼錯誤，請重新輸入");
            }
        }

        while (true) {
            System.out.println("\n====== ATM 功能選單 ======");
            System.out.println("1. 查詢餘額");
            System.out.println("2. 存款");
            System.out.println("3. 提款");

            if ("admin".equalsIgnoreCase(currentUser.getRole())) {
                System.out.println("4. 新增帳戶（管理員專用）");
            }

            System.out.println("0. 登出");
            System.out.print("請選擇功能：");

            int atmChoice = sc.nextInt();
            sc.nextLine(); // 清除換行

            if (atmChoice == 1) {
                System.out.println("💰 目前餘額：" + currentUser.getBalance() + " 元");
            } else if (atmChoice == 2) {
                System.out.print("💰 輸入存款金額：");
                int amount = sc.nextInt();
                sc.nextLine();
                if (amount <= 0) {
                    System.out.println("⚠️ 金額需大於 0 元！");
                    continue;
                }
                currentUser.deposit(amount);
                System.out.println("✅ 存款成功，目前餘額：" + currentUser.getBalance() + " 元");
            } else if (atmChoice == 3) {
                System.out.print("🏧 輸入提款金額：");
                int amount = sc.nextInt();
                sc.nextLine();
                if (amount <= 0) {
                    System.out.println("⚠️ 金額需大於 0 元！");
                    continue;
                }
                if (currentUser.withdraw(amount)) {
                    System.out.println("✅ 提款成功，目前餘額：" + currentUser.getBalance() + " 元");
                } else {
                    System.out.println("❌ 餘額不足，提款失敗");
                }
            } else if (atmChoice == 4 && "admin".equalsIgnoreCase(currentUser.getRole())) {
                openNewAccount(manager, sc);
            } else if (atmChoice == 0) {
                System.out.println("🚪 已登出");
                break;
            } else {
                System.out.println("⚠️ 無效選項");
            }
        }
    }

    private static void openNewAccount(UserManager manager, Scanner sc) {
        System.out.println("👤 新增帳戶");
        System.out.print("📄 使用者名稱：");
        String username = sc.nextLine();
        System.out.print("🔒 設定密碼：");
        String password = sc.nextLine();
        System.out.print("💰 初始存款金額：");
        int balance = sc.nextInt();
        sc.nextLine(); // 清除換行

        String role = "";
        while (true) {
            System.out.print("⚙️ 設定角色（admin/general）：");
            role = sc.nextLine().toLowerCase();
            if ("admin".equals(role) || "general".equals(role)) {
                break;
            } else {
                System.out.println("⚠️ 請輸入 admin 或 general");
            }
        }

        User newUser = manager.addUser(username, password, balance, role);
        System.out.println("✅ 帳戶新增成功！");
        System.out.println("👉 請記住此帳號ID：" + newUser.getId());
    }
}
