package com.example.user.blujackshoeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class RequestedOrderActivity extends AppCompatActivity {

    ListView lv_requested_order_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_order);

        lv_requested_order_item = findViewById(R.id.lv_requested_order_item);
        RequestedOrderAdapter RequestedOrderAd = new RequestedOrderAdapter(this);
        lv_requested_order_item.setAdapter(RequestedOrderAd);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_requested_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_home:
                startActivity(new Intent(RequestedOrderActivity.this, HomeActivity.class));
                return true;

            case R.id.menu_logout:
                startActivity(new Intent (RequestedOrderActivity.this, LoginActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
