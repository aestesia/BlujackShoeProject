package com.example.user.blujackshoeproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Shoes {
    String ShoesID;
    String ShoeName;
    String ShoeSize;
    String ShoeColor;
    int ShoePrice;

    public Shoes(String shoesID, String shoeName, String shoeSize, String shoeColor, int shoePrice){
        this.ShoesID = shoesID;
        this.ShoeName = shoeName;
        this.ShoeSize = shoeSize;
        this.ShoeColor = shoeColor;
        this.ShoePrice = shoePrice;

    }

    public Shoes() {

    }

    public static void insert(Context c, Shoes temp){
        Helper dbh = new Helper(c);

        SQLiteDatabase db = dbh.getWritableDatabase();

        //do insert operation into table
        ContentValues values = new ContentValues();
        values.put("shoesId", temp.ShoesID);
        values.put("shoeName", temp.ShoeName);
        values.put("shoeSize", temp.ShoeSize);
        values.put("shoeColor", temp.ShoeColor);
        values.put("shoePrice", temp.ShoePrice);

        db.insert("Shoes", null, values);

        Database.ShoesDB.add(temp);



    }

    public String getShoeID() {
        return ShoesID;
    }

    public void setShoeID(String shoeID) {
        ShoesID = shoeID;
    }

    public String getShoeName() {
        return ShoeName;
    }

    public void setShoeName(String shoeName) {
        ShoeName = shoeName;
    }

    public String getShoeSize() {
        return ShoeSize;
    }

    public void setShoeSize(String shoeSize) {
        ShoeSize = shoeSize;
    }

    public String getShoeColor() {
        return ShoeColor;
    }

    public void setShoeColor(String shoeColor) {
        ShoeColor = shoeColor;
    }

    public int getShoePrice() {
        return ShoePrice;
    }

    public void setShoePrice(int shoePrice) {
        ShoePrice = shoePrice;
    }
}
