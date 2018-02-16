package com.example.samuel.davidmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.samuel.davidmarket.Models.Products;

public class DescriptionActivity extends AppCompatActivity {


    private EditText countEt;
    private TextView descrTv;
    private TextView priceTv;
    private TextView totaltv;
    private TextView pruebatv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        pruebatv = (TextView) findViewById(R.id.price2DEt);
        descrTv= (TextView) findViewById(R.id.descritTv);
       priceTv = (TextView) findViewById(R.id.priceDEt);
       totaltv = (TextView) findViewById(R.id.totalTv);
        Button buyButton = (Button) findViewById(R.id.buyBtn);
       countEt = (EditText) findViewById(R.id.countTv);
        Products products = (Products) getIntent().getSerializableExtra(MainActivity.DESCRIPTION);
        getSupportActionBar().setTitle(products.getName());
        String price = getIntent().getStringExtra("price");
        String measure = getIntent().getStringExtra("measure");
        String name = getIntent().getStringExtra("name");
     //   descrTv.setText(products.getMeasure());

        priceTv.setText(price);
        descrTv.setText(name);
        countEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num1= countEt.getText().toString();
                String num2= pruebatv.getText().toString();
                int val1 = Integer.parseInt(num1);
                int val2 = Integer.parseInt(num2);

                if((val1 >= 0)){
                    int total = (val1*val2);
                    String totalR= String.valueOf(total);
                    totaltv.setText(totalR);

                }else{
                    val1 = val1 + 1;
                    int total = (val1*val2);
                    String totalR= String.valueOf(total);
                    totaltv.setText(totalR);
                }

            }
        });



        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               total();


            }
        });

    }
    public void total(){

        String num1= countEt.getText().toString();
        String num2= pruebatv.getText().toString();

        int val1 = Integer.parseInt(num1);
        int val2 = Integer.parseInt(num2);

        int total = (val1*val2);
        String totalR= String.valueOf(total);

        totaltv.setText(totalR);


    }
}
