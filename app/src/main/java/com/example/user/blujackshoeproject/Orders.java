package com.example.user.blujackshoeproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Orders {
    String OrdersID;
    String UsersID;
    String ShoesID;
    String OrderDate;

    public Orders(String ordersID, String userID, String shoeID, String orderDate) {
        OrdersID = ordersID;
        UsersID = userID;
        ShoesID = shoeID;
        OrderDate = orderDate;
    }

    public Orders() {

    }

    public static void insert(Context c, Orders temp){
        Helper dbh = new Helper(c);

        SQLiteDatabase db = dbh.getWritableDatabase();

        //do insert operation into table
        ContentValues values = new ContentValues();
        values.put("orderId", temp.OrdersID);
        values.put("shoeName", temp.UsersID);
        values.put("shoeSize", temp.ShoesID);
        values.put("shoeColor", temp.OrderDate);


        db.insert("Orders", null, values);

        Database.OrdersDB.add(temp);



    }


    public String getOrderID() {
        return OrdersID;
    }

    public void setOrderID(String orderID) {
        OrdersID = orderID;
    }

    public String getUserID() {
        return UsersID;
    }

    public void setUserID(String userID) {
        UsersID = userID;
    }

    public String getShoeID() {
        return ShoesID;
    }

    public void setShoeID(String shoeID) {
        ShoesID = shoeID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

}
