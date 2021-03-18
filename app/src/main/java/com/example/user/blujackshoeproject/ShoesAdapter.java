package com.example.user.blujackshoeproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ShoesAdapter extends BaseAdapter{

    Context x;
    TextView txt_shoename, txt_shoesize, txt_shoecolor;


    public ShoesAdapter(Context c){this.x = c;}

    @Override
    public int getCount() {
        return Database.ShoesDB.size();
    }

    @Override
    public Object getItem(int i) {
        return Database.ShoesDB.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) x.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View a = inflater.inflate(R.layout.list_layout_shoes, null, false);
        txt_shoename = a.findViewById(R.id.txt_shoename);
        txt_shoesize = a.findViewById(R.id.txt_shoesize);
        txt_shoecolor = a.findViewById(R.id.txt_shoecolor);

        final Shoes Temp = Database.ShoesDB.get(position);

        txt_shoename.setText(Temp.ShoeName);
        txt_shoesize.setText(Temp.ShoeSize);
        txt_shoecolor.setText(Temp.ShoeColor);

        //final Shoes Temp = Database.ShoesDB.get(position);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(x, OrderActivity.class);

                i.putExtra("ID", Temp.ShoesID);
                i.putExtra("Name", Temp.ShoeName);
                i.putExtra("Size", Temp.ShoeSize);
                i.putExtra("Color", Temp.ShoeColor);
                i.putExtra("Price", Temp.ShoePrice);
                x.startActivity(i);
            }
        });
        return a;
    }
}
