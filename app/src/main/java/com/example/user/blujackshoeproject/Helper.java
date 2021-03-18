package com.example.user.blujackshoeproject;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
    public Helper(Context context) {
        super(context, "Bluejack Shoes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //TODO: Create scheme of tables below this line
        String CREATE_TABLE_USERS_SQL = "CREATE TABLE IF NOT EXISTS Users(usersId CHAR(5) PRIMARY KEY, fullname VARCHAR(50), username VARCHAR(50), password VARCHAR(50), gender VARCHAR(20), location VARCHAR(50), phoneNumber VARCHAR(50) )";
        String CREATE_TABLE_SHOES_SQL = "CREATE TABLE IF NOT EXISTS Shoes(shoeId CHAR(5) PRIMARY KEY, shoeName VARCHAR(50), shoeSize VARCHAR(50), shoeColor VARCHAR(50), shoePrice VARCHAR(50))";
        String CREATE_TABLE_ORDERS_SQL = "CREATE TABLE IF NOT EXISTS Orders(orderId CHAR(5) PRIMARY KEY, usersid CHAR(5), shoeid CHAR(5), orderDate VARCHAR(50))";

        sqLiteDatabase.execSQL(CREATE_TABLE_SHOES_SQL);
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS_SQL);
        sqLiteDatabase.execSQL(CREATE_TABLE_ORDERS_SQL);


        //TODO: Put the content of tables into vector below this line
        String SELECT_USERS_SQL = "SELECT * FROM Users";
        String SELECT_SHOES_SQL = "SELECT * FROM Shoes";
        String SELECT_ORDERS_SQL = "SELECT * FROM Orders";


        Cursor c = sqLiteDatabase.rawQuery(SELECT_SHOES_SQL,  null);

        while (c.moveToNext()) {
            Shoes temp = new Shoes();

            temp.ShoesID = c.getString(1);
            temp.ShoeName = c.getString(2);
            temp.ShoeSize = c.getString(3);
            temp.ShoeColor = c.getString(4);
            temp.ShoePrice = c.getInt(5);

            Database.ShoesDB.add(temp);

        }

        Cursor c2 = sqLiteDatabase.rawQuery(SELECT_USERS_SQL,  null);

        while (c.moveToNext()) {
            Users temp = new Users();

            temp.UsersID = c2.getString(1);
            temp.Fullname = c2.getString(2);
            temp.Username = c2.getString(3);
            temp.Password = c2.getString(4);
            temp.Gender = c2.getString(5);
            temp.Location = c2.getString(6);
            temp.PhoneNumber = c2.getString(7);

            Database.UsersDB.add(temp);

        }

        Cursor c3 = sqLiteDatabase.rawQuery(SELECT_ORDERS_SQL,  null);

        while (c.moveToNext()) {
            Orders temp = new Orders();

            temp.OrdersID = c3.getString(1);
            temp.UsersID = c3.getString(2);
            temp.ShoesID = c3.getString(3);
            temp.OrderDate = c3.getString(4);

            Database.OrdersDB.add(temp);

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
