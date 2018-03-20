package com.example.samuel.davidmarket.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.samuel.davidmarket.Adapters.CarAdapter;
import com.example.samuel.davidmarket.Interface.CarProducts;
import com.example.samuel.davidmarket.R;

public class CarActivity extends AppCompatActivity implements CarProducts {

    private TextView nameTV;
    private TextView totalTV;
    private TextView priceTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.carlayoutRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        CarAdapter adapter = new CarAdapter(this);
        recyclerView.setAdapter(adapter);



/*

        nameTV = (TextView) findViewById(R.id.nameCarProductsTv);
        priceTV= (TextView) findViewById(R.id.priceCarProductsTv);
        totalTV= (TextView) findViewById(R.id.totalcarProductsTv);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String total = getIntent().getStringExtra("total");
*/

//        nameTV.setText(name);
//        priceTV.setText(price);
  //      totalTV.setText(total);



    }

    @Override
    public void clicked(String name, String price, String measure) {

    }
}
