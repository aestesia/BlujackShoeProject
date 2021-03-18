package com.example.user.blujackshoeproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RequestedOrderAdapter extends BaseAdapter{
    Context x;

    public RequestedOrderAdapter(Context c){this.x = c;}

    @Override
    public int getCount() {
        return Database.OrdersDB.size();
    }

    @Override
    public Object getItem(int position) {
        return Database.OrdersDB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) x.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_layout_requested_order, null, false);
        TextView txt_shoename = view.findViewById(R.id.txt_shoename);
        TextView txt_orderdate = view.findViewById(R.id.txt_orderdate);

        final Orders temp = Database.OrdersDB.get(position);
        txt_orderdate.setText(temp.OrderDate);
        String b = temp.ShoesID;
        for (int i = 0; i < Database.ShoesDB.size(); i++){
            Shoes temp2 = Database.ShoesDB.get(i);
            if(temp2.ShoesID.equals(b)){
                txt_shoename.setText(temp2.ShoeName);
                break;
            }
        }
        return view;
    }
}
