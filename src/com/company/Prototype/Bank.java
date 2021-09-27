import java.util.ArrayList;
import java.util.Iterator;

public class BankTransactions {
    
    private String acctNo;
    
    private static ArrayList<UserAccounts> userAccounts;
    
    public BankTransactions(){}
    
    public void setAcctNo(String acctNo){
        this.acctNo = acctNo;
    }
    
    public void setUserAccounts(ArrayList<UserAccounts> userAccounts){
        this.userAccounts = userAccounts;
    }
    
    public String getAcctNo(){
        return acctNo;
    }
    
    //retrieve all user accounts 
    public ArrayList<UserAccounts> getUserAccounts(){
        return userAccounts;
    }
    
    //retreive user account by account number
    public UserAccounts getUserByAccountNo(String acctNo){
        for(UserAccounts u : userAccounts){
            if(u.getAcctNo().equals(acctNo)){
                return u;
            }
        }
        return null;
    }
    
    //update user info 
    public void updateUserInfo(UserAccounts userAccounts){
        Iterator iterate = this.userAccounts.iterator();
        while(iterate.hasNext()){
            UserAccounts u = (UserAccounts)iterate.next();
            if(u.getAcctNo().equals(userAccounts.getAcctNo())){
                this.userAccounts.set(this.userAccounts.get(u), userAccounts);
            }
        }
    }
    
    //delete user account
    public void updateUserInfo(UserAccounts userAccounts){
        Iterator iterate = this.userAccounts.iterator();
        while(iterate.hasNext()){
            UserAccounts u = (UserAccounts)iterate.next();
            if(u.getAcctNo().equals(userAccounts.getAcctNo())){
                iterate.remove();
            }
        }
    }
}