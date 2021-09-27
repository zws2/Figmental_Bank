public class User {
    
    private String firstName;
    
    private String lastName;
    
    private String acctNo;
    
    private double balance;
    
    public User(){}
    
    public User(String firstName, String lastName, String acctNo, double balance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.acctNo = acctNo;
        this.balance = balance;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAcctNo(String acctNo){
        this.acctNo = acctNo;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAcctNo(){
        return acctNo;
    }
    public double getBalance(){
        return balance;
    }
    
    public String toString(){
        return "User Account : [First Name=" + firstName +
                                ", Last Name=" + lastName +
                                ", Account No.=" + acctNo +
                                ", Balance :=" + balance +
                                "]";
    }
}