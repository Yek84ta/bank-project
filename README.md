# bank-project
# مستندات سیستم بانکی

## مقدمه

این پروژه یک سیستم ساده مدیریت حساب‌های بانکی را شبیه‌سازی می‌کند. سیستم شامل دو نوع حساب بانکی است: **حساب پس‌انداز** و **حساب جاری**. هر حساب دارای ویژگی‌هایی مانند شماره حساب، نام دارنده حساب و موجودی است. همچنین، این سیستم امکان واریز، برداشت، محاسبه سود و نمایش اطلاعات حساب‌ها را فراهم می‌کند.

## کلاس‌ها و توابع

### کلاس `BankAccount` (حساب بانکی)

- **ویژگی‌ها**:
  - `accountNumber`: شماره حساب (نهایی و تغییرناپذیر).
  - `accountHolderName`: نام دارنده حساب.
  - `balance`: موجودی حساب.
  
- **متدها**:
  - `BankAccount(String newAccountNumber, String newAccountHolderName, double newBalance)`: سازنده کلاس که شماره حساب، نام دارنده و موجودی اولیه را دریافت می‌کند.
  - `calculateInterest()`: یک متد انتزاعی برای محاسبه سود حساب.
  - `deposit(double amount)`: مبلغی را به حساب واریز می‌کند. اگر مبلغ منفی باشد، خطای `IllegalArgumentException` پرتاب می‌شود.
  - `withdraw(double amount)`: مبلغی را از حساب برداشت می‌کند. اگر مبلغ منفی باشد یا موجودی کافی نباشد، خطا پرتاب می‌شود.
  - `getBalance()`: موجودی حساب را برمی‌گرداند.
  - `getAccountNumber()`: شماره حساب را برمی‌گرداند.
  - `getAccountHolderName()`: نام دارنده حساب را برمی‌گرداند.

### کلاس `SavingAccount` (حساب پس‌انداز)

- **ویژگی‌ها**:
  - `interestRate`: نرخ سود حساب پس‌انداز (ثابت و برابر با ۰.۰۳).
  
- **متدها**:
  - `SavingAccount(String newAccountNumber, String newAccountHolderName, double initialBalance)`: سازنده کلاس که شماره حساب، نام دارنده و موجودی اولیه را دریافت می‌کند.
  - `calculateInterest()`: سود حساب را محاسبه کرده و به موجودی اضافه می‌کند.

### کلاس `TransactionAccount` (حساب جاری)

- **ویژگی‌ها**:
  - `overDraftLimit`: حد مجاز برداشت بیش از موجودی (ثابت و برابر با ۵۰۰).
  
- **متدها**:
  - `TransactionAccount(String newAccountNumber, String newAccountHolderName, double initialBalance)`: سازنده کلاس که شماره حساب، نام دارنده و موجودی اولیه را دریافت می‌کند.
  - `calculateInterest()`: پیامی چاپ می‌کند که نشان می‌دهد برای حساب جاری سودی محاسبه نمی‌شود.
  - `withdraw(double amount)`: مبلغی را از حساب برداشت می‌کند. اگر مبلغ منفی باشد یا موجودی به همراه حد مجاز برداشت کافی نباشد، خطا پرتاب می‌شود.

### کلاس `BankCustomers` (مدیریت مشتریان بانک)

- **ویژگی‌ها**:
  - `accountsList`: لیستی از حساب‌های بانکی.
  
- **متدها**:
  - `addAccount(BankAccount newAccount)`: حساب جدیدی به لیست حساب‌ها اضافه می‌کند.
  - `showAllBalances()`: اطلاعات تمام حساب‌ها شامل نام دارنده، شماره حساب و موجودی را نمایش می‌دهد.
  - `findAccount(String accountNumber)`: حساب مربوط به شماره حساب داده شده را پیدا کرده و اطلاعات آن را نمایش می‌دهد. اگر حساب پیدا نشود، پیام خطا نمایش داده می‌شود.

### کلاس `Main` (برنامه اصلی)

- **هدف**: این کلاس نقطه ورود برنامه است و عملیات مختلف مانند ایجاد حساب‌ها، واریز، برداشت، محاسبه سود و نمایش اطلاعات را تست می‌کند.
- **متدها**:
  - `main(String[] args)`: در این متد، چندین حساب بانکی ایجاد شده و عملیات مختلف روی آن‌ها انجام می‌شود.

## مثال نحوه استفاده

1. **ایجاد حساب‌ها**:
   - چندین حساب جاری و پس‌انداز ایجاد می‌شوند.
   
2. **واریز و برداشت**:
   - عملیات واریز و برداشت روی حساب‌ها انجام می‌شود و خطاهای احتمالی مدیریت می‌شوند.

3. **محاسبه سود**:
   - سود حساب‌های پس‌انداز محاسبه شده و به موجودی اضافه می‌شود. برای حساب‌های جاری، پیامی نمایش داده می‌شود که نشان می‌دهد سود محاسبه نمی‌شود.

4. **نمایش اطلاعات حساب‌ها**:
   - اطلاعات تمام حساب‌ها شامل نام دارنده، شماره حساب و موجودی نمایش داده می‌شود.

## خطاهای ممکن

- **IllegalArgumentException**: زمانی که مبلغ واریز یا برداشت منفی باشد.
- **IllegalStateException**: زمانی که موجودی حساب برای برداشت کافی نباشد.

## نتیجه‌گیری

این سیستم مدیریت حساب‌های بانکی یک نمونه ساده و کاربردی از استفاده از مفاهیم شیءگرایی، وراثت و مدیریت خطا در جاوا است. این سیستم می‌تواند به راحتی گسترش یابد تا ویژگی‌های بیشتری مانند مدیریت تراکنش‌ها، گزارش‌گیری و غیره را شامل شود.
