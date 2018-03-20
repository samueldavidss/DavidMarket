package com.example.samuel.davidmarket.Adapters;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.samuel.davidmarket.Interface.CarProducts;
import com.example.samuel.davidmarket.Models.Products;
import com.example.samuel.davidmarket.Queries.References;
import com.example.samuel.davidmarket.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

/**
 * Created by Samuel on 15-Mar-18.
 */

public class CarAdapter extends FirebaseRecyclerAdapter<Products,CarAdapter.CarHolder> {

    private CarProducts carProducts;
    public CarAdapter( CarProducts carProducts) {
        super(Products.class, R.layout.list_item_car, CarHolder.class, new References().productsReference());
        this.carProducts=carProducts;
    }

    @Override
    protected void populateViewHolder(final CarHolder viewHolder, final Products model, int position) {
        viewHolder.name.setText(model.getName());
        viewHolder.price.setText(String.valueOf(model.getPrice()));
        viewHolder.measure.setText(String.valueOf(model.getMeasure()));
      //  viewHolder.total.setText(String.valueOf(tota));
        viewHolder.carBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               carProducts.clicked(model.getName(),model.getPrice(),model.getMeasure());
            }
        });

    }

    public static class CarHolder extends RecyclerView.ViewHolder {
        private TextView name,price, measure;
        private Button carBtn;
        public CarHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameCarProductsTv);
            price = (TextView) itemView.findViewById(R.id.priceCarProductsTv);
            measure = (TextView) itemView.findViewById(R.id.totalcarProductsTv);
            carBtn = (Button) itemView.findViewById(R.id.addToCarBtn);
        }
    }


}
