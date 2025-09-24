package kelly;

public class Account {
	private String accountNo;
	 private String name;
	 private double balance;

	 public Account(String accountNo, String name, double balance) {
	     this.accountNo = accountNo;
	     this.name = name;
	     this.balance = balance;
	 }

	 public void deposit(double amount) throws ArithmeticException {
	     if (amount <= 0) {
	         throw new ArithmeticException("Deposit amount must be positive.");
	     }
	     this.balance += amount;
	     System.out.println("Deposited " + amount + ". New balance: " + this.balance);
	 }

	 public void withdraw(double amount) throws InsufficientBalanceException, ArithmeticException {
	     if (amount <= 0) {
	         throw new ArithmeticException("Withdrawal amount must be positive.");
	     }
	     if (amount > this.balance) {
	         throw new InsufficientBalanceException("Insufficient balance for this withdrawal.");
	     }
	     this.balance -= amount;
	     System.out.println("Withdrew " + amount + ". New balance: " + this.balance);
	 }

	 public void showBalance() {
	     System.out.println("Current balance: " + this.balance);
	 }

	
	 public String getAccountNo() {
	     return accountNo;
	 }

	 public String getName() {
	     return name;
	 }

	 public double getBalance() {
	     return balance;
	 }
	}

	 

