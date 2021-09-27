import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
    
    private String acctNo;
    
    private static ArrayList<User> userAccounts;
    
    public Bank(){}
    
    public void setAcctNo(String acctNo){
        this.acctNo = acctNo;
    }
    
    public void setUserAccounts(ArrayList<User> userAccounts){
        this.userAccounts = userAccounts;
    }
    
    public String getAcctNo(){
        return acctNo;
    }
    
    //retrieve all user accounts 
    public ArrayList<User> getUserAccounts(){
        return userAccounts;
    }
    
    //retreive user account by account number
    public User getUserByAccountNo(String acctNo){
        for(User u : userAccounts){
            if(u.getAcctNo().equals(acctNo)){
                return u;
            }
        }
        return null;
    }
    
    //update user info 
    public void updateUserInfo(User userAccounts){
        Iterator iterate = this.userAccounts.iterator();
        while(iterate.hasNext()){
            User u = (User)iterate.next();
            if(u.getAcctNo().equals(userAccounts.getAcctNo())){
                this.userAccounts.set(this.userAccounts.indexOf(u), userAccounts);
            }
        }
    }
    
    //delete user account
    public void deleteUserInfo(User userAccounts){
        Iterator iterate = this.userAccounts.iterator();
        while(iterate.hasNext()){
            User u = (User)iterate.next();
            if(u.getAcctNo().equals(userAccounts.getAcctNo())){
                iterate.remove();
            }
        }
    }
}