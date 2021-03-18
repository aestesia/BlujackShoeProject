//package com.example.user.blujackshoeproject;
//
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URI;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.List;
//
//public class TopSellingActivity extends AppCompatActivity {
//
//    ListView lv_top_selling;
//    String jsonURL = "https://api.myjson.com/bins/z3oqd";
//
//    Vector<shoe> shoeVector = new Vector<>();
//
//    ShoeListAdapter shoeListAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_top_selling);
//
//        lv_top_selling = findViewById(R.id.lv_top_selling);
//
//
//
//    }
//
//    public void allDone(Vector<shoe> shoeVector){
//        shoeListAdapter = new ShoeListAdapter(this, shoeVector);
//
//    }
//
//    public void fetchData (RequestQueue requestQueue){
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(baseURL, new Response.Listener<JoeSONArray>(){
//            @Override
//            public void onResponse(JSONArray response){
//                JSONObject jsonObject = null;
//                Shoe shoe = null;
//                for (int a=0 ; a<response.length() ; a++){
//                    try {
//                        JSONObject = response.getJSONOject(a);
//                        shoe = new Shoe();
//                        shoe.getShoeID(jsonObject.getString("shoeId"));
//                        shoe.getShoeName(jsonObject.getString("shoeName"));
//                        shoe.getShoeSize(jsonObject.getString("ShoeSize"));
//                        shoe.getShoeColor(jsonObject.getString("ShoeColor"));
//                        shoe.getShoePrice(jsonObject.getString("ShoePrice"));
//                        shoeListAdapter.add(shoe);
//                        // Log.e("DATA", jsonObject .toString());
//                    } catch (JSONException exception){
//                        exception.printStackTrace();
//                    }
//                }
//                allDone(shoeListAdapter);
//            }
//
//        }
//
//    }, new Response.ErrorListener()
//
//    {
//        @Override
//        public void onErrorResponse (VolleyError error){
//    }
//    });
//        requestQueue.add(jsonArrayRequest);
//}
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu_requested_order, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menu_home:
//                startActivity(new Intent(TopSellingActivity.this, HomeActivity.class));
//                return true;
//
//            case R.id.menu_logout:
//                startActivity(new Intent (TopSellingActivity.this, LoginActivity.class));
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//}
