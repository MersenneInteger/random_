import java.util.Scanner;

public class Account_Johnson{
    
    private String name;
    private String accountNumber;
    private double balance;

    public Account_Johnson(){}
    public Account_Johnson(String n, String a, double b){

        name = n;
        accountNumber = a;
        balance = b;
    
    }
    //create account, returns copy of Account_Johnson obj
    public static Account_Johnson createAccount(String n, String a, double b){ 
        
        Scanner kb = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.print("Select which account you would like to create: " +
                            "\n1: Checking\n2: Savings\n3: Exit \n");
        int choice = kb.nextInt();
        kb = null;
	//initialize reference variables
        Account_Johnson check, saving;
	
        if(choice == 1){ //create checking account
           check = new CheckingAccount_Johnson(n, a, b);
           String type = "\nType:\t Checking Account\n";
           String str = check.checkCurrentBalance();
           str.concat(type);
           System.out.println("\n" + str + "\n");

           return check;
        }
        else if(choice == 2){ //create savings account
           saving = new SavingAccount_Johnson(n, a, b);
           String type = "\nType:\t Saving Account\n";
           String str = saving.checkCurrentBalance();
           str.concat(type);
           System.out.println("\n" + str +"\n");

           return saving;
        }
        else
            System.exit(0); //exit program
        return null;
            
    }
    //adds deposit to balance, return bankstatement as string
    public String depositMoney(double deposit){ 
            
        balance += deposit;

        String str = "Account Name:\t " + name + 
                     "\nAccount Number: " + accountNumber +
                     "\nDeposit Amount: " + deposit +
                     "\nBalance :\t $" + balance + "\n";

        return str;
    }
    //withdraws money from balance, return updated bankstatement
    //as string
    public String withdrawMoney(double amount){
        
	//prevent user from withdrawing more money than they have 
        if(balance < amount){
            System.out.println("You do not have enough money in your account");
            return null;
        }
	//prevent user from withdrawing if the balance after amount is 
	//subtracted is less than 20
        else if(balance - amount < 20){
            String withdraw = "\nWithdraw amount: $" + amount + " - denied";
            String str = checkCurrentBalance();
            str = str.concat(withdraw);
            return str;
        }
	//withdraw money, return bankstatement as string
        else{
            balance -= amount;
            String withdraw = "\nWithdraw amount: $" + amount;
            String str = checkCurrentBalance();
            str = str.concat(withdraw);
            return str;
        }
    }
    
    //return bankstatement as string
    public String checkCurrentBalance(){
     
        String str = "Account Name:\t " + name + 
                     "\nAccount Number: " + accountNumber +
                     "\nBalance:\t $" + balance; 
        return str;
    }
    //accessor methods
    public String getAccountNumber(){return accountNumber;}
    public String getName(){return name;}
    public double getBalance(){return balance;}
    public void setBalance(double b){ balance = b;}
    
    //generic printMonthlyStatement method, will be overrided
    public String printMonthlyStatement(){
    
        String str = checkCurrentBalance();
        return str;
            
    }
  
}
