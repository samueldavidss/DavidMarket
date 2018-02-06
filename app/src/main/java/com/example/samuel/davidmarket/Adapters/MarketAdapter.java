package com.example.samuel.davidmarket.Adapters;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.samuel.davidmarket.ListernerProducts;
import com.example.samuel.davidmarket.Models.Buy;
import com.example.samuel.davidmarket.Models.Products;
import com.example.samuel.davidmarket.Queries.References;
import com.example.samuel.davidmarket.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.Query;

/**
 * Created by Samuel on 02-Feb-18.
 */

public class MarketAdapter extends FirebaseRecyclerAdapter<Products,MarketAdapter.buyHolder> {

    private ListernerProducts listernerProducts;
    public MarketAdapter( ListernerProducts listernerProducts) {
        super(Products.class, R.layout.list_item_market, buyHolder.class, new References().productsReference());
        this.listernerProducts=listernerProducts;

    }
    @Override
    protected void populateViewHolder(buyHolder viewHolder, final Products model, int position) {
        viewHolder.price.setText(String.valueOf(model.getPrice()));
        viewHolder.measure.setText(model.getMeasure());
       // viewHolder.produts.setText(model.getProducts());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listernerProducts.click(model.getMeasure(),model.getPrice());
            }
        });
    }

    public static class buyHolder extends RecyclerView.ViewHolder{
        private TextView produts, price, measure;
        public buyHolder(View itemView) {
            super(itemView);
          //  produts= (TextView) itemView.findViewById(R.id.productsEt);
            measure= (TextView) itemView.findViewById(R.id.measureEt);
            price= (TextView) itemView.findViewById(R.id.priceEt);
        }
    }
}
