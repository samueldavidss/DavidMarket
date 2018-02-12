package com.example.samuel.davidmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.samuel.davidmarket.Models.Products;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        TextView descrTv= (TextView) findViewById(R.id.descritTv);
        TextView priceTv = (TextView) findViewById(R.id.priceDEt);
        Button buyButton = (Button) findViewById(R.id.buyBtn);
        EditText countEt = (EditText) findViewById(R.id.countTv);
        Products products = (Products) getIntent().getSerializableExtra(MainActivity.DESCRIPTION);
        getSupportActionBar().setTitle(products.getName());
        String price = String.valueOf(getIntent().getStringExtra("price"));
        String measure = getIntent().getStringExtra("measure");
        String name = getIntent().getStringExtra("name");
     //   descrTv.setText(products.getMeasure());
        priceTv.setText(price);
        descrTv.setText(name);


        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
