/* Account, Withdraw, and Deposit */
/* Invariant Implementation*/


import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	/* Set the customer number */

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	/* Get the customer number */

	public int getCustomerNumber() {
		return customerNumber;
	}

	/* Set the pin number */

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	/* Get the pin number */

	public int getPinNumber() {
		return pinNumber;
	}

	/* Get Checking Account Balance */

	public double getCheckingBalance() {
		return checkingBalance;
	}

	/* Get Saving Account Balance */

	public double getSavingBalance() {
		return savingBalance;
	}

	/* Calculate Checking Account withdrawal */

	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	/* Calculate Saving Account withdrawal */

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	/* Calculate Checking Account deposit */

	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	/* Calculate Saving Account deposit */

	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}

	void Invariant(){
		assert checkingBalance > 0 || checkingBalance == 0: "Balance cannot be negative.";
		assert savingBalance > 0 || savingBalance == 0: "Balance cannot be negative.";
	}

	/* Customer Checking Account Withdraw input */
	public void getCheckingWithdrawInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to withdraw from Checking Account: ");
		double amount = input.nextDouble();
		//pre-condition
		assert amount > 0 : "Input value must be postive number.";
		assert checkingBalance > 0 : "Balance must be greater than 0 to make withdrawal.";
		assert amount < checkingBalance : "Withdrawal amount must be less than balance.";

		//process
		calcCheckingWithdraw(amount);
		
		//post-condition
		Invariant();
		System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance) + "\n");	
	}

	/* Customer Saving Account Withdraw input */
	public void getSavingWithdrawInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to withdraw from Saving Account: ");
		double amount = input.nextDouble();
		//pre-condition
		assert amount > 0 : "Input value must be postive number.";
		assert savingBalance > 0 : "Balance must be greater than 0 to make withdrawal.";
		assert amount < savingBalance : "Withdrawal amount must be less than balance.";
		
		//process
		calcSavingWithdraw(amount);

		//post-condition
		Invariant();
		System.out.println("New Saving Account balance: " + savingBalance + "\n");
	}

	/* Customer Checking Account Deposit input */

	public void getCheckingDepositInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to deposit from Checking Account: ");
		double amount = input.nextDouble();
		//pre-condition
		assert amount > 0 : "Input value must be postive number.";

		//process
		calcCheckingDeposit(amount);

		//post-condition
		Invariant();
		System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance) + "\n");
	}

	/* Customer Saving Account Deposit input */

	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to deposit from Saving Account: ");
		double amount = input.nextDouble();
		//pre-condition
		assert amount > 0 : "Input value must be postive number.";
		
		//process
		calcSavingDeposit(amount);
		
		//post-condition
		Invariant();
		System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance) + "\n");
	}

	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
}