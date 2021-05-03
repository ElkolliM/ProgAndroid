package com.example.tp4_2;


import java.util.Iterator;
import java.util.LinkedList;

public class ListAccounts {
    private static LinkedList<Account> listAccount = new LinkedList<>();
    private static ListAccounts obj = new ListAccounts();
    private static Account currentAccount;

    private ListAccounts(){}

    public static ListAccounts getInstance(){
        return obj;
    }

     public Account createAccount(String fullName, String phoneNum, String email, String password, String nas) {
         // check if empty (just whitespace) string
         if (!fullName.matches("^(?=\\s*\\S).*$") ||
                 !phoneNum.matches("^(?=\\s*\\S).*$") ||
                 !email.matches("^(?=\\s*\\S).*$") ||
                 !password.matches("^(?=\\s*\\S).*$") ||
                 !nas.matches("^(?=\\s*\\S).*$"))
         {
         return null;
         }
         // nas 9 chiffre
         if(!nas.matches("^\\d{9}$"))
         {
             return null;
         }
         if(!phoneNum.matches("^\\d{10}$"))
         {
             return null;
         }
         if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
         {
             return null;
         }
         Account acc = new Account( fullName,  phoneNum,  email,  password,  nas);
         setAccountInBuffer(acc);
         listAccount.add(acc);

         return acc;
     }


    public Account getAccount(String email, String password){
        Iterator it = listAccount.iterator();
        while(it.hasNext()){
            Account acc = (Account) it.next();
            if(acc.getEmail().equals(email) && acc.getPassword().equals(password)) {
                setAccountInBuffer(acc);
                return acc;
            }
        }
        return null;
    }

    public void setAccountInBuffer(Account acc){
        this.currentAccount = acc;
    }
    public Account getAccountInBuffer(){
        return currentAccount;
    }
}
