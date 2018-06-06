package com.example.john.pricecalculatordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    static ArrayList<Item> items;
    static ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Comparing product by weight");
        items = new ArrayList<>();
        items.add(new Item("poop",5.00,500,Unit.g));
        items.add(new Item("pee",1.00,1000,Unit.lb));
        items.add(new Item("poop",9.00,2,Unit.lb));
        items.add(new Item("poop",4.00,1,Unit.lb));
        items.add(new Item("copy",4.00,1,Unit.lb));

        mItemAdapter = new ItemAdapter(getApplicationContext(), items);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(mItemAdapter);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Collections.sort(items, new ItemComparator());
        mItemAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(getApplicationContext(), EditItemActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
