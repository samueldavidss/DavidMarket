package com.example.samuel.davidmarket;

import android.content.Context;
import android.widget.Toast;

import com.example.samuel.davidmarket.Interface.FinderCallback;
import com.example.samuel.davidmarket.Models.Products;
import com.example.samuel.davidmarket.Queries.References;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Samuel on 12-Feb-18.
 */

public class UserSearch {
    private FinderCallback callback;
    private Context context;


    public UserSearch(FinderCallback callback, Context context) {
        this.callback = callback;
        this.context = context;
    }
    public void init (String Name){
        if (Name.trim().length()>0){
            findProduts(Name);

        }else{
            callback.error("no puede dejar el campo vacio");
        }
    }
    private void findProduts(String Name){
        new References().product(Name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Products productsSerch = dataSnapshot.getValue(Products.class);
                if (productsSerch != null){
                    callback.success();
                    Toast.makeText(context, "funciono", Toast.LENGTH_SHORT).show();
                }else{
                    callback.notfound();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
