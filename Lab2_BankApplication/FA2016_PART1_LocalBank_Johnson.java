import java.util.Scanner;

public class FA2016_PART1_LocalBank_Johnson{
        
   public static void main(String[] args){

    Scanner kb = new Scanner(System.in);  
    String firstName, lastName, accountNum;
    double balance;
    int counter = 0, choice, tempNum;
    Account_Johnson account = new Account_Johnson();
    
    //menu loop
    do {
	//menu
        System.out.println("\n--------------------" +
                           "\nChoose an operation: " +
                           "\n1. Open a new account" + 
                           "\n2. Check current balance" +
                           "\n3. Deposit" +
                           "\n4. Withdraw" +
                           "\n5. Print monthly statement" +
                           "\n6. Exit");

        choice = kb.nextInt();
        kb.nextLine(); //clear buffer
	//if choice is out of ranger, restart loop
        if(choice < 1 || choice > 6){
            System.out.println("\nChoose a number between 1 and 6\n");
            continue;
        }
	//if user attempts to perform operation without opening account
	//first, restart loop
        if(counter == 0 && (choice != 1 && choice != 6)){
            System.out.println("\nYou must open an account before performing " +
                                "that operation.\n");
            continue;
        }
	
        switch(choice){
            
           case 1: {
                        System.out.println("Enter your first name: ");
                        firstName = kb.nextLine();
                        System.out.println("Enter your last name: ");
                        lastName = kb.nextLine();
                        firstName = lastName + ", " + firstName;

                        System.out.println("Enter the account number: ");
			accountNum = kb.nextLine();

                        System.out.println("Enter your balance: ");
                        balance = kb.nextDouble();

                        account = Account_Johnson.createAccount(firstName,
                                                                accountNum,
                                                                balance); 

                        break;
                    }

            case 2: {
                        System.out.println("\n" + account.checkCurrentBalance());
                        break;
                    }    
            
            case 3: {
                        System.out.print("How much would you like to deposit? ");
                        double deposit = kb.nextDouble();
                        System.out.println("\n" + account.depositMoney(deposit));
                        break;
                    }

            case 4: {
                        System.out.print("How much would you like to withdraw? ");
                        double withdraw = kb.nextDouble();
                        System.out.println("\n" + account.withdrawMoney(withdraw));
                        break;
                    }    
             
            case 5: {
                        System.out.println("\n" + account.printMonthlyStatement());
                        break;
                    }

            case 6: {
                        System.out.println("The application is terminating..");
                        System.exit(0);
                        break;
                    }    
                 
        }//end of switch
            
    counter++;
    }while(choice != 6); //end of do-while loop
    
    }             
}
