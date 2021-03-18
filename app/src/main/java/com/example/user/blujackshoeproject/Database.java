package com.example.user.blujackshoeproject;

import android.content.Context;

import java.util.Vector;

import javax.xml.transform.Templates;

public class Database {

    public static Vector<Users> UsersDB = new Vector<>();
    public static Vector<Shoes> ShoesDB = new Vector<>();
    public static Vector<Orders> OrdersDB = new Vector<>();

    public static Users LOGGED_IN_USERS = null;

    public static String generate_new_users_id(){
        String id = "";
        if(Database.UsersDB.isEmpty()){
            id = "US001";
        }
        else {
            int temp = Database.UsersDB.size() + 1;
            id = String.format("US%03d", temp);
        }
        return id;
    }

    public static void register_users(String UsersID, String Fullname, String Username, String Password, String PhoneNumber, String Gender, String Location){
        UsersDB.add(new Users(UsersID, Fullname, Username, Password, PhoneNumber, Gender, Location));
    }

    public static Users check_login(String Username, String Password){
        for (int i = 0; i < UsersDB.size(); i++){
            Users Temp = UsersDB.get(i);
            if (Temp.Username.equals(Username) && Temp.Password.equals(Password)){
                return Temp;
            }
        }
        return null;
    }

    public static void generateShoeData(Context c) {

        if (ShoesDB.isEmpty()) {
            ShoesDB.clear();
            Shoes.insert(c, new Shoes("SH001", "Nike Kevin Durant 10", "42", "White", 2279000));
            Shoes.insert(c, new Shoes("SH002", "Kyrie 2 Low", "43", "Green", 1550000));
            Shoes.insert(c, new Shoes("SH003", "Kobe 9 Elite", "45", "Red", 2000000));
            Shoes.insert(c, new Shoes("SH004", "Under Armour 4", "44", "Black", 650000));
            Shoes.insert(c, new Shoes("SH005", "PG 3", "44", "Blue", 1800000));
            Shoes.insert(c, new Shoes("SH006", "Nike Air Jordan Retro 1", "41", "Blue", 300000));
            Shoes.insert(c, new Shoes("SH007", "Nike Zoom 2", "47", "White", 780000));
            Shoes.insert(c, new Shoes("SH008", "Ardilles AZA5", "42", "Yellow", 500000));
            Shoes.insert(c, new Shoes("SH009", "Spotec Hornets", "43", "Black", 1995000));
            Shoes.insert(c, new Shoes("SH010", "Curry UA 3 High", "46", "Yellow", 1750000));
        }

    }

    public static void generateUserData(Context c){
        if(UsersDB.isEmpty()){
            UsersDB.clear();
            Users.insert(c, new Users("US001","Admin BluejackShoe","admin","admin",null,null,null));

        }
    }

    public static String generateNewOrderID() {
        String id = "";
        if (Database.OrdersDB.isEmpty()) {
            id = "OR001";
        } else {
            int temp = Database.OrdersDB.size() + 1;
            id = String.format("OR%03d", temp);
        }
        return id;
    }

    public static void register_order(String OrderID, String UserID, String ShoeID, String OrderDate) {
        OrdersDB.add(new Orders(OrderID, UserID, ShoeID, OrderDate));
    }





}
