package com.example.user.blujackshoeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{

    String txt_shoesID;
    TextView txt_shoename, txt_shoesize, txt_shoecolor, txt_shoeprice;
    Button btn_order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        txt_shoename = findViewById(R.id.txt_shoename);
        txt_shoesize = findViewById(R.id.txt_shoesize);
        txt_shoecolor = findViewById(R.id.txt_shoecolor);
        txt_shoeprice = findViewById(R.id.txt_shoeprice);
        btn_order = findViewById(R.id.btn_order);

        btn_order.setOnClickListener(this);

        txt_shoesID = getIntent().getStringExtra("ID");
        txt_shoename.setText(getIntent().getStringExtra("Name"));
        txt_shoesize.setText(getIntent().getStringExtra("Size"));
        txt_shoecolor.setText(getIntent().getStringExtra("Color"));
        txt_shoeprice.setText(getIntent().getStringExtra("Price"));

    }

    @Override
    public void onClick(View v) {
        if(v==btn_order){
            String OrdersID = Database.generateNewOrderID();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            Database.register_order(OrdersID, Database.LOGGED_IN_USERS.getUserID(),getIntent().getStringExtra("ID"),dateFormat.format(date));
            Toast.makeText(this,"Order Success"+OrdersID+" "+Database.LOGGED_IN_USERS.getUserID()+" "+getIntent().getStringExtra("ID")+" "+dateFormat.format(date), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            finish();
        }
    }
}
