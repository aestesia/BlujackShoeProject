package com.example.user.blujackshoeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txt_username, txt_password;
    Button btn_login;
    TextView lbl_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Helper dbh = new Helper(getApplicationContext());
        Database.generateShoeData(getApplicationContext());
        Database.generateUserData(getApplicationContext());

        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
        btn_login = findViewById(R.id.btn_login);
        lbl_register = findViewById(R.id.lbl_register);

        btn_login.setOnClickListener(this);
        lbl_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_login){
            String Username = txt_username.getText().toString();
            String Password = txt_password.getText().toString();

            if(Username.isEmpty()){
                Toast.makeText(this, "Username must be filled", Toast.LENGTH_SHORT).show();
            }
            else if(Password.isEmpty()){
                Toast.makeText(this,"Password must be filled", Toast.LENGTH_SHORT).show();
            }
            else{

                Database.LOGGED_IN_USERS = Database.check_login(Username, Password);

                if(Database.LOGGED_IN_USERS == null){
                    Toast.makeText(this,"User not Registered yet", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }
            }

        }
        else if(v==lbl_register){
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
            finish();
        }
    }
}
