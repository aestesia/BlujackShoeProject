package com.example.user.blujackshoeproject;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Vector;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txt_fullname, txt_username, txt_password, txt_phone, txt_sms;
    RadioGroup rg_gender;
    RadioButton rb_gender,Male, Female;
    Spinner spin_location;
    Button btn_register;
    TextView lbl_login;


    private final static int SEND_SMS_PERMISSION_REQUEST_CODE = 111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_fullname = findViewById(R.id.txt_fullname);
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
        txt_phone = findViewById(R.id.txt_phone);
        rg_gender = findViewById(R.id.rg_gender);
        Male = findViewById(R.id.rb_male);
        Female = findViewById(R.id.rb_female);
        spin_location = findViewById(R.id.spin_location);
        btn_register = findViewById(R.id.btn_register);
        lbl_login = findViewById(R.id.lbl_login);
        txt_sms = findViewById(R.id.txt_sms);

        if(checkPermission(Manifest.permission.SEND_SMS)){
            btn_register.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE );
        }




        Vector<String> Location = new Vector<>();
        Location.add("-Select-");
        Location.add("Indonesia");
        Location.add("Malaysia");
        Location.add("Singapore");
        Location.add("Philippines");

        SpinnerAdapter x = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Location);
        spin_location.setAdapter(x);
        btn_register.setOnClickListener(this);
        lbl_login.setOnClickListener(this);


    }

    private boolean checkPermission(String permission) {
        int checkPermission = ContextCompat.checkSelfPermission(this, permission);
        return checkPermission == PackageManager.PERMISSION_GRANTED;
    }



    @Override
    public void onClick(View v) {
        if(v==btn_register){

            rb_gender=findViewById(rg_gender.getCheckedRadioButtonId());

            String Fullname = txt_fullname.getText().toString();
            String Username = txt_username.getText().toString();
            String Password = txt_password.getText().toString();
            String PhoneNumber = txt_phone.getText().toString();
            String Sms = txt_sms.getText().toString();
            //String Gender = rb_gender.getText().toString();
            String Location = spin_location.getSelectedItem().toString();

            //String msg = "Welcome to Bluejack Shoes";

            if(Fullname.isEmpty()){
                Toast.makeText(this, "Fullname must be filled",Toast.LENGTH_SHORT).show();
            }
            else if(Fullname.split("").length<2){
                Toast.makeText(this,"Fullname must be more than 1 word",Toast.LENGTH_SHORT).show();
            }
            else if(Username.isEmpty()){
                Toast.makeText(this,"Username must be filled",Toast.LENGTH_SHORT).show();
            }
            else if(Username.length()<5 || Username.length()>15){
                Toast.makeText(this,"Username must be between 5 and 15 character",Toast.LENGTH_SHORT).show();
            }
            else if(Password.isEmpty()){
                Toast.makeText(this,"Password must be filled",Toast.LENGTH_SHORT).show();
            }
            else if(Password.length()<6){
                Toast.makeText(this,"Password must be more than 6 character",Toast.LENGTH_SHORT).show();
            }
            else if(PhoneNumber.length()<8){
                Toast.makeText(this,"Phone number must be more than 8 digits",Toast.LENGTH_SHORT).show();
            }
            else if(!Male.isChecked() && !Female.isChecked()){
                Toast.makeText(this,"Gender must be Selected",Toast.LENGTH_SHORT).show();
            }
            else if(Location == "-Select-"){
                Toast.makeText(this,"Location must be Selected",Toast.LENGTH_SHORT).show();
            }
            else{
                String UsersID = Database.generate_new_users_id();
                Database.register_users(UsersID, Fullname, Username, Password, PhoneNumber, rb_gender.getText().toString(), Location);
                Toast.makeText(this,"Registration Success",Toast.LENGTH_SHORT).show();


                if(checkPermission(Manifest.permission.SEND_SMS)){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(PhoneNumber, null, Sms, null, null);
                }

                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }
        else if(v==lbl_login){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }

    }


    public void onRequestPermissionResult(int requestCode, String[] permission, int[]grantResult){
        switch (requestCode){
            case SEND_SMS_PERMISSION_REQUEST_CODE :
                if(grantResult.length > 0 && (grantResult[0] == PackageManager.PERMISSION_GRANTED)){
                    btn_register.setEnabled(true);
                }

                break;
        }
    }
}
