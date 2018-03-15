package com.example.samuel.davidmarket.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.samuel.davidmarket.Models.Buy;
import com.example.samuel.davidmarket.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by Samuel on 17-Feb-18.
 */

public class CheckoutAdapter extends FirebaseRecyclerAdapter<Buy,CheckoutAdapter.CheckoutHolder>{

    /**
     * @param modelClass      Firebase will marshall the data at a location into
     *                        an instance of a class that you provide
     * @param modelLayout     This is the layout used to represent a single item in the list.
     *                        You will be responsible for populating an instance of the corresponding
     *                        view with the data from an instance of modelClass.
     * @param viewHolderClass The class that hold references to all sub-views in an instance modelLayout.
     * @param ref             The Firebase location to watch for data changes. Can also be a slice of a location,
     *                        using some combination of {@code limit()}, {@code startAt()}, and {@code endAt()}.
     */
    public CheckoutAdapter(Class<Buy> modelClass, int modelLayout, Class<CheckoutHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(CheckoutHolder viewHolder, Buy model, int position) {

    }

    public static class CheckoutHolder extends RecyclerView.ViewHolder{

        private TextView name, price, amount, total, measure;
        public CheckoutHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameCheckoutTV);
            price = (TextView) itemView.findViewById(R.id.priceCheckoutTV);
            amount = (TextView) itemView.findViewById(R.id.amoutCheckoutTV);
            total= (TextView) itemView.findViewById(R.id.totalCheckoutTV);
            measure= (TextView) itemView.findViewById(R.id.measureCheckoutTV);
        }
    }
}
