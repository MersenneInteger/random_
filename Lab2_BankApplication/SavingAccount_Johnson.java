public class SavingAccount_Johnson extends Account_Johnson{

    private double interestRate = 1.5;

    public SavingAccount_Johnson(){
        super();        
    }
    public SavingAccount_Johnson(String name, String aNum, double bal){
	super(name, aNum, bal);
    }
    //depositMoney, return updated statement as string
    public String depositMoney(double deposit){

	String str = super.depositMoney(deposit);
	String type = "\nType: Saving Account";
	str.concat(type);
	return str;

    }
    //withdrawMoney, call parent classes method
    public String withdrawMoney(double amount){

	String str = super.withdrawMoney(amount);
	return str;
    }
    //return saving account's bankstatement as string
    public String checkCurrentBalance(){
	       
	String str = "Account Name:\t " + super.getName() + 
                     "\nAccount Number: " + super.getAccountNumber() +
                     "\nCurrent Balance: $" + super.getBalance() +
	             "\nType:\t Saving Account";

        return str;

    }
    //printMonthlyStatement, return saving account's updated 
    //statement including interest rate to update balance
    public String printMonthlyStatement(){
        
	double rate = 0.015 * super.getBalance();
	double newBal = rate + super.getBalance();
        String str = checkCurrentBalance();
        String app = "\nInterest Rate: " + interestRate + "%" +
	             "\nInterest Amount: " + rate +
	             "\nBalance: $" + newBal;
        str = str.concat(app);
	super.setBalance(newBal);
        return str;
    }
    public void changeInterestRate(double rate){
        interestRate = rate;        
    }                                                                                           
}
