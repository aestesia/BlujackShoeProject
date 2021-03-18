package com.example.user.blujackshoeproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Users {
    String UsersID;
    String Fullname;
    String Username;
    String Password;
    String Gender;
    String Location;
    String PhoneNumber;

    public Users(String usersID, String fullname, String username, String password, String gender, String location, String phoneNumber) {
        UsersID = usersID;
        Fullname = fullname;
        Username = username;
        Password = password;
        Gender = gender;
        Location = location;
        PhoneNumber = phoneNumber;
    }

    public Users() {

    }

    public static void insert(Context c, Users temp){
        Helper dbh = new Helper(c);

        SQLiteDatabase db = dbh.getWritableDatabase();

        //do insert operation inro table
        ContentValues values = new ContentValues();
        values.put("usersid", temp.UsersID);
        values.put("fullname", temp.Fullname);
        values.put("username", temp.Username);
        values.put("password", temp.Password);
        values.put("gender", temp.Gender);
        values.put("location", temp.Location);
        values.put("phoneNumber", temp.PhoneNumber);

        db.insert("Shoes", null, values);

        Database.UsersDB.add(temp);



    }

    public String getUserID() {
        return UsersID;
    }

    public void setUserID(String userID) {
        UsersID = userID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
