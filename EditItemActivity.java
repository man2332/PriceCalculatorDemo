package com.example.john.pricecalculatordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActivity extends AppCompatActivity {
    EditText nameET, priceET, quantityET, unitET;
    Button createBtn, cancelBtn;
    Item item;
    Unit unit = Unit.invalidUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        createBtn = findViewById(R.id.createbtn);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameET = findViewById(R.id.name_editText);
                priceET = findViewById(R.id.price_editText);
                quantityET = findViewById(R.id.quantity_editText);
                //unitET = findViewById(R.id.unit_editText);

                String name = nameET.getText().toString();
                String price = priceET.getText().toString();
                String quantity = quantityET.getText().toString();

                if(name.equals("") || price.equals("") || quantity.equals("") || unit == Unit.invalidUnit){
                    Toast.makeText(v.getContext(),"Please fill out the fields", Toast.LENGTH_SHORT).show();

                }else{
                    Item item = new Item(name, Double.valueOf(price),Integer.valueOf(quantity), unit);
                    MainActivity.items.add(item);
                    MainActivity.mItemAdapter.notifyDataSetChanged();
                    finish();

                }
            }
        });
    }
    public void MeasurementClicked(View view){
        switch(view.getId()){
            case R.id.unit_g:
                Toast.makeText(view.getContext(),"G CLICKED",Toast.LENGTH_SHORT).show();
                unit = Unit.g;
                return;
            case R.id.unit_oz:
                Toast.makeText(view.getContext(),"OZ CLICKED",Toast.LENGTH_SHORT).show();
                unit = Unit.oz;
                return;
            case R.id.unit_kg:
                Toast.makeText(view.getContext(),"KG CLICKED",Toast.LENGTH_SHORT).show();
                unit = Unit.kg;
                return;
            case R.id.unit_ml:
                unit = Unit.ml;
                Toast.makeText(view.getContext(),"ML CLICKED",Toast.LENGTH_SHORT).show();
                return;
            case R.id.unit_l:
                unit = Unit.l;
                Toast.makeText(view.getContext(),"L CLICKED",Toast.LENGTH_SHORT).show();
                return;
            case R.id.unit_floz:
                unit = Unit.fluidOz;
                Toast.makeText(view.getContext(),"FOZ CLICKED",Toast.LENGTH_SHORT).show();
                return;
            case R.id.unit_gal:
                unit = Unit.gal;
                Toast.makeText(view.getContext(),"GAL CLICKED",Toast.LENGTH_SHORT).show();
                return;
            default:
                Toast.makeText(view.getContext(),"Default CLICKED",Toast.LENGTH_SHORT).show();
                return;
        }
    }
}
