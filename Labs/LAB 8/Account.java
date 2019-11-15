public class Account{

    private double balance;

    public Account() {
        this.balance=0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance+=amount;
        System.out.println("new balance="+getBalance()+"$");
    }

    public void withdraw(double amount){
        if (amount<=balance){
            balance-=amount;
            System.out.println("new balance="+getBalance()+"$");
        }else {
            throw new NotEnoughMoneyException(amount,balance);
        }

    }
}