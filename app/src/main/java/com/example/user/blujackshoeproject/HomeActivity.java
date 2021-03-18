package com.example.user.blujackshoeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    ListView lv_home_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lv_home_item = findViewById(R.id.lv_home_item);
        ShoesAdapter ShoesAd = new ShoesAdapter(this);
        lv_home_item.setAdapter(ShoesAd);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
//            case R.id.menu_top_selling:
//                startActivity(new Intent(HomeActivity.this, TopSellingActivity.class));
//                return true;

            case R.id.menu_requested_order:
                startActivity(new Intent(HomeActivity.this, RequestedOrderActivity.class));
                return true;

            case R.id.menu_our_location:
                startActivity(new Intent(HomeActivity.this, OurLocationActivity.class));
                return true;

            case R.id.menu_logout:
                startActivity(new Intent (HomeActivity.this, LoginActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
