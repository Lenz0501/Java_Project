# ATM Simulation System

## 目前資料夾結構
<pre>
Swing_Test/
├── accounts.csv       ← 帳戶資料
└── src/
    ├── myapp/
    │   ├── atm/       ← (功能之後放這)
    │   │   ├── TestATM.java       ← 測試程式
    │   │   ├── User.java       ← 使用者class
    │   │   └── UserManager.java         ← 使用者帳戶管理
    │   ├── pages/
    │   │   ├── CreateAccountPage.java       ← 開戶頁面
    │   │   ├── HomePage.java       ← 登入頁面
    │   │   └── Menu.java         ← 功能選單頁面
    │   └── MainWindow.java       ← 主視窗程式
    │
    └── images/
        └── demo.png         ← icon 圖片
</pre>

執行程式為MainWindow.java

---
## 5/13 更新

- 新增 CreateAccountPage: 開戶介面(username, password, confirm password, initial amount)  
> 加入ATM class功能
驗證密碼不同、無username有錯誤提示框  
初始存款若未填定為0  
開戶資料同步到csv檔  

- HomePage更新:  
> 登入頁面加入密碼驗證機制，錯誤有提示框  

- Menu更新:  
> 變數domin，true會多出CreateAccountPage的選項  

**:x:bug**  
新開帳戶無法馬上登入

**:clipboard:愈追加功能**   
使用username登入
