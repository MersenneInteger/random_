public class CheckingAccount_Johnson extends Account_Johnson{
    
    private double monthlyFee;

    public CheckingAccount_Johnson(){ super();}
    public CheckingAccount_Johnson(String name, String aNum, double bal){

	super(name, aNum, bal);
    }
    //returns Account_Johnson obj
    public static Account_Johnson createAccount(String n, String a, double b){
	Account_Johnson test = Account_Johnson.createAccount(n, a, b);
	return test;
    }
    //depositMoney, return updated statement as string
    public String depositMoney(double deposit){
	System.out.println("--------------------");
	String str = super.depositMoney(deposit);
	String type = "\nType: Checking Account";
	str.concat(type);
	return str;
    }
    //call parent classes withdrawMoney
    public String withdrawMoney(double amount){

	String str = super.withdrawMoney(amount);
	return str;
    }
    //return bankstatement as string
    public String checkCurrentBalance(){
	String str = "Account Name:\t " + super.getName() + 
                     "\nAccount Number: " + super.getAccountNumber()+
	             "\nCurrent Balance: $" + super.getBalance()+
	             "\nType: Checking Account";
        return str;
    }
    //returns checking account's monthly statement as string
    public String printMonthlyStatement(){
        
	double newBal = super.getBalance() -10;
        String str = checkCurrentBalance();
	String app = "\nMonthly Fee: $" + 10 + 
	    "\nNew Balance: " + newBal;
	str = str.concat(app);
	super.setBalance(newBal);
	return str;
                                                                               
    }    
}
