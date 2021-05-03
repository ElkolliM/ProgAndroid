package com.example.tp4_2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Account {
    private String fullName = null;
    private String phoneNum = null;
    private String email = null;
    private String password = null;
    private String nas = null;
    ArrayList<Reservations> reservations = null;
    public Account(String fullName, String phoneNum, String email, String password, String nas){
        this.fullName = fullName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
        this.nas = nas;
        System.out.println("ACCOUNT created");
        this.reservations = new ArrayList<>();
    }
    public void addReservation(Reservations r){reservations.add(r);}
//--------------getter----------------------

    public ArrayList<Reservations> getReservations(){return reservations;}
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getFullName() {
        return fullName;
    }
    public String getNas() { return nas; }
    public String getPassword() {
        return password;
    }
    public String getEmail(){
        return email;
    }

    //------------setter------------------

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNas(String nas) {
        this.nas = nas;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
