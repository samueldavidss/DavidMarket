package com.example.samuel.davidmarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.samuel.davidmarket.Adapters.MarketAdapter;
import com.example.samuel.davidmarket.Models.Products;

public class MainActivity extends AppCompatActivity implements ListernerProducts {

    public static final String DESCRIPTION ="com.example.samuel.davidmarket.KEY.DESCRIPTION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.layoutRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MarketAdapter adapter = new MarketAdapter(this);
        recyclerView.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void click(Products products, String name, String measure, int price) {
        Intent intent = new Intent(this,DescriptionActivity.class);
        intent.putExtra(DESCRIPTION,products);
        intent.putExtra("name",price);
        intent.putExtra("measure",measure);
        intent.putExtra("name", name);
        startActivity(intent);

    }
}
