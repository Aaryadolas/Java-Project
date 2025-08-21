package atm.com;

import java.util.Scanner;

class ATM{
	float Balance;
	int pin=2001;
	
	public void checkPin() {
		
		System.out.println("Enter Your Pin");
		Scanner sc = new Scanner(System.in);
		int enteredPin=sc.nextInt();
		if(enteredPin==pin) {
			menu();
		}
		else {
			System.out.println("Invalid Pin");
		}
		
	}
	
	public void menu() {
		 System.out.println("Enter your choice:" );
		 System.out.println("1.Check Balance");
		 System.out.println("2.WithDraw Amount");
		 System.out.println("3.Deposit Amount");
		 System.out.println("4.Exit");
		 
		 Scanner sc = new Scanner(System.in);
		 int opt=sc.nextInt();
		 
		 
		 if(opt==1) {
			 checkBalance();
		 }
		 else if(opt==2) {
			 withdrawMoney();
		}
		 else if(opt==3) {
			 depositMoney();
		 }
		 else if(opt==4) {
			 return;
		 }
		 else {
			 System.out.println("Enter the valid number");
		 }
	}
	
	public void checkBalance() {
		System.out.println("Balance " + Balance);
		
	}
	
	public void withdrawMoney() {
		System.out.println("Enter the Amount to withdraw");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		if(amount>Balance) {
			System.out.println("Insufficient Balance");
		}else {
			Balance = Balance-amount;
		}
		menu();
		
	}
	
	public void depositMoney() {
		System.out.println("Enter the Amount");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		Balance = Balance + amount;
		System.out.println("Amount Deposited Succesfully");
		menu();
	}
}

public class ATMachine {

	public static void main(String[] args) {
		ATM obj = new ATM();
		obj.checkPin();

	}

}
