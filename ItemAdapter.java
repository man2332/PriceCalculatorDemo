package com.example.john.pricecalculatordemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(@NonNull Context context, List<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }
        Item item = getItem(position);
        if(item != null) {
            TextView nameTV = v.findViewById(R.id.item_name_txtView);
            TextView qtyTV = v.findViewById(R.id.qty_txtView);
            TextView priceTV = v.findViewById(R.id.price_txtView);
            TextView unitTV = v.findViewById(R.id.unit_txtView);
            TextView rankTV = v.findViewById(R.id.rank_txtView);
            //set the item's detail
            nameTV.setText(item.getName());
            qtyTV.setText(String.valueOf(item.getQuantity()));
            priceTV.setText(String.valueOf(item.getPrice()));
            unitTV.setText(item.getItemUnit().toString());

            //set the ranking from cheapest to most expensive textview
            if (position == 0) {
                rankTV.setText("Cheapest item!!!");
            } else if (position == 1) {
                rankTV.setText("2nd Cheapest");
            } else if (position == 2) {
                rankTV.setText("3rd Cheapest");
            }else if(position + 1 == MainActivity.items.size()){
                rankTV.setText("Most EXPENSIVE!!");
            }else{
                rankTV.setText(String.valueOf(position + 1)+"th Cheapest");
            }

        }

        return v;
    }
}
