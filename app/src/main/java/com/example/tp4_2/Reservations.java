package com.example.tp4_2;


public class Reservations {
    private String nameResto;
    private String date;
    private String table;
    public Reservations(String nameResto, String date, String table){
        this.nameResto = nameResto;
        this.date = date;
        this.table = table;

    }


    public String getNameResto(){
        return nameResto;
    }
    public String getTable(){
        return table;
    }
    public String getDate(){
        return date;
    }

}
