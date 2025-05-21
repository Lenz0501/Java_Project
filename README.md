# ATM Simulation System

## 目前資料夾結構
<pre>
Swing_Test/
├── accounts.csv       ← 帳戶資料
├── transaction.csv       ← 交易資料
└── src/
    ├── atm/       ← ATM 類別
    │   ├── TestATM.java       ← 測試程式
    │   ├── User.java       ← 使用者類別
    │   └── UserManager.java         ← 使用者帳戶管理類別
    │
    ├── myapp/
    │   ├── pages/
    │   │   ├── BalancePage.java       ← 餘額頁面
    │   │   ├── CreateAccountPage.java       ← 開戶頁面
    │   │   ├── DepositPage.java       ← 存款頁面
    │   │   ├── HomePage.java       ← 登入頁面
    │   │   ├── Menu.java         ← 功能選單頁面
    │   │   ├── RecentTransactionPage.java         ← 交易資料頁面
    │   │   └── WithdrawPage.java         ← 提款頁面
    │   └── MainWindow.java       ← 主視窗程式
    │
    └── images/
        ├── atm-machine.png         ← icon 圖片
        └── demo.png         ← 測試用 icon 圖片
</pre>

執行程式為MainWindow.java  

## HomePage  
<img src="https://github.com/user-attachments/assets/ac01dc96-0cd2-427f-9254-e657474584c5" width="600">   

## Menu  
<img src="https://github.com/user-attachments/assets/2731adfc-275c-4593-bf50-32648bf49542" width="600">  
<img src="https://github.com/user-attachments/assets/dd486f30-b6e4-446e-85d5-799c350265d4" width="600">  

## BalancePage  
<img src="https://github.com/user-attachments/assets/5d78b96f-045f-4a3e-b500-94a0605cac5a" width="600">  


## DepositPage  
<img src="https://github.com/user-attachments/assets/48600c60-2303-4a9f-9d6f-7b539c826a89" width="600">  <br>
<img src="https://github.com/user-attachments/assets/cac91852-6e51-4ed4-88af-3146632fc307" width="300">  
> deposit success messagebox

## WithDrawPage  
<img src="https://github.com/user-attachments/assets/16057c4e-b5aa-4667-9248-4684f2da0f8c" width="600">  <br>
<img src="https://github.com/user-attachments/assets/4a088297-ddbc-4155-9fdb-b1432ed89e66" width="300">  <br>
> withdraw fail messagebox  

<img src="https://github.com/user-attachments/assets/504426b5-1061-47d5-b475-420a02e09417" width="300">  <br>
> deposit success messagebox

## RecentTransactionPage 
<img src="https://github.com/user-attachments/assets/c2ec1588-9487-46fe-a3b3-37a827d873e9" width="600">   <br>


## CreateAccountPage 
<img src="https://github.com/user-attachments/assets/533f03eb-91fd-41fc-a97a-5a8d744576cb" width="600">   <br>

<img src="https://github.com/user-attachments/assets/15739966-8755-402a-89ab-0eb2bc26cb19" width="300">  <br>
> create account error 1  
  
<img src="https://github.com/user-attachments/assets/aa112e9b-2c48-4318-9eb6-5f001c720355" width="300">  <br>
> create account error 2  
  
<img src="https://github.com/user-attachments/assets/3ce3f68c-6c26-4cf4-9a7c-575a05db7a90" width="300">  <br>
> create account error 3  

# 更新日誌

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
使用username登入 (已完成)
  
  
## 5/15 修復更新
- HomePage bug 修補:  
> 能順利登入新增的帳號

- Menu更新: 
> User參數能順利傳入
> 左上角顯示username

**:clipboard:愈追加功能**   
運用Java的繼承功能區分一般使用者和管理員
  
  
## 5/17 更新  
- 新增 BalancePage:  
> 顯示目前User的餘額  
> 下方兩側有兩個按鈕，分別回到menu跟logout  

- 新增 DepositPage:
> 輸入框輸入存款金額  
> submit按鈕按下存入金額，並跳出訊息框呈現存款資訊  
> 存款完會導向BalancePage  

- 新增 WithdrawPage:
> 輸入框輸入提款金額  
> submit按鈕按下提款金額，若餘額不足會跳出錯誤訊息框，成功則呈現存款資訊  
> 提款完會導向BalancePage  

- Menu 更新
> logout後會呼叫saveToCSV()，儲存當次交易內容  
> 暫時移除Recent Transaction按鈕  

- CreateAccountPage 更新
> 右下方加入回到menu按鈕  

- Icon 更新


## 5/20 更新 2  
- User 類別更新
> 建構子傳入參數多加role (admin,general)

- UserManager 類別更新
> 新增方法: getUserByUsername()
> 驗證機制由ID改為username

- TestATM.java 更新
> 改為由username登入
> admin帳號有開戶選項


## 5/20 更新 1  
- 新增 RecentTransactionPage
> 用table呈現所有帳戶的交易資訊
> 資料包括(
