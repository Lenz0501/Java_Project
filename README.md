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


## 5/3 更新
- 導入 MainWindow: 主視窗程式  
> 掌控各個分頁  
> 換頁函式  

- 新增 HomePage:  
> 上方顯示title ATM Simulation System  
> 單個按鈕前往menu頁面  

- 新增 Menu:  
> 5項基本選單功能 ( Balance, Deposit, Withdrawal, Recent Transaction, Logout )  
> 每個按鈕按下皆會在termainl顯示所按的按鈕名稱  
> Logout會回到homepage  
  
  
## 5/10 更新  
- HomePage 更新  
> Username、Password 輸入框  
> Submit、Reset 按鈕  
> > Submit 按鈕前往menu頁面  
> > Reset 按鈕清空兩個輸入框  
  
  
## 5/12 更新
- 新增 User類別:  
> 類別成員: id, username, password, balance  
> 類別方法: getId(), getUsername(), getPassword(), getBalance(), checkPassword(), deposit(), withdraw(), showInfo()  

- 新增 UserManager類別:  
> 帳戶資料csv儲存、處理  
> 類別方法: saveToCSV(), validate(), getUser(), addUser()  

- 新增 accounts.csv  
> 儲存使用者帳戶資料  
> |id|username|password|balance|
> |:---:|:---:|:---:|:---:|
> | 1 | abcd | 111 | 1000 |

- 新增 TestATM.java:  
> 完整的ATM測試程式，可在terminal執行  
  
  
## 5/13 更新  
- 新增 CreateAccountPage:  
> 開戶介面(username, password, confirm password, initial amount)  
> 加入ATM class功能  
驗證密碼不同、無username有錯誤提示框  
初始存款若未填定為0  
開戶資料同步到csv檔  

- HomePage 更新:  
> 登入頁面加入密碼驗證機制，錯誤有提示框  

- Menu更新:  
> 變數domin，true會多出CreateAccountPage的選項  

**:x:bug**  
新開帳戶無法馬上登入 (已解決)

**:clipboard:愈追加功能**   
使用username登入
  
  
## 5/15 修復更新
- HomePage bug 修補:  
> 能順利登入新增的帳號

- Menu更新: 
> User參數能順利傳入
> 左上角顯示username

**:clipboard:愈追加功能**   
運用Java的繼承功能區分一般使用者和管理員
