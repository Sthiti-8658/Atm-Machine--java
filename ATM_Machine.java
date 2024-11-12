package Data_structure_algorithms;
import java.util.Scanner;
import java.util.ArrayList;

class ATM_Machine {
      private double balance;
      private int pin;
      private ArrayList<String>transactionHistory;
      public ATM_Machine(int pin){
          this.balance=0.0;
          this.pin = pin;
          this.transactionHistory =new ArrayList<>();
      }
      //Check balance
      public double getBalance(){
          return balance;
      }
      //Deposit Money
    public void deposit(double amount){
          if(amount > 0){
              balance+=amount;
              transactionHistory.add("Deposited: $"+amount);
              System.out.println("Successfully deposited: $"+amount);
          }else{
              System.out.println("Invalid deposit amount.");
          }
    }
    //Withdraw Money
    public void Withdraw(double amount){
          if(amount > 0 && amount<= balance){
              balance-= amount;
              transactionHistory.add("Withdraw: $"+amount);
              System.out.println("Successfully Withdraw: $"+amount);
          }else if(amount > balance){
              System.out.println("Insufficient balance.");
          }else{
              System.out.println("Invalid withdraw amount.");
          }
    }
    //show transaction History
    public void showTransactionHistory(){
          if(transactionHistory.isEmpty()){
              System.out.println("No transactions yet.");
          }else{
              System.out.println("Transaction History:");
              for(String transaction :transactionHistory){
                  System.out.println(transaction);
              }
          }
    }
    public boolean validatePin(int inputPin){
        return this.pin == inputPin;
    }
    public static void main(String[] args) {
        ATM_Machine ATM_Machine = new ATM_Machine(2001);
          Scanner scanner =new Scanner(System.in);
        System.out.println("WELCOME TO SBI ATM: ");
        System.out.println("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if(!ATM_Machine.validatePin(enteredPin)) {
            System.out.println("Incorrect PIN.Exiting . . .");
            return;
        }
          int choice;
               do{

                   System.out.println("Choose an option: ");
                   System.out.println("1. Check Balance");
                   System.out.println("2.Deposit");
                   System.out.println("3.Withdraw");
                   System.out.println("4.Transaction History");
                   System.out.println("5.Exit");
                   choice =scanner.nextInt();

                   switch (choice){
                       case 1:
                           System.out.println("Current Balance: $"+ATM_Machine.getBalance());
                           break;
                       case 2:
                           System.out.println("Enter amount to deposit: ");
                           double depositAmount =scanner.nextDouble();
                           ATM_Machine.deposit(depositAmount);
                           break;
                       case 3:
                           System.out.println("Enter amount to Withdraw: ");
                           double WithdrawAmount = scanner.nextDouble();
                           ATM_Machine.Withdraw(WithdrawAmount);
                           break;
                       case 4:
                          ATM_Machine.showTransactionHistory();
                          break;
                       case 5:
                           System.out.println("Thank you for using the ATM.Goodbye");
                       default:
                           System.out.println("Invalid choice.Please try again.");
                   }
                   if(choice !=5){
                       System.out.println("\nPress Enter to return to the Menu...");
                       scanner.nextLine();
                       scanner.nextLine();
                   }

               }while(choice !=5);
               scanner.close();
    }
    }

