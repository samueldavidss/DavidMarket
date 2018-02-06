package com.example.samuel.davidmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.samuel.davidmarket.Models.Users;
import com.example.samuel.davidmarket.Queries.CurrentUser;
import com.example.samuel.davidmarket.Queries.References;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.database.DatabaseReference;

import java.util.Arrays;


public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

                if(new CurrentUser().getCurrentUser() !=null){
                    logged();
                }else{
                    singUp();
                }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RC_SIGN_IN==requestCode){
            if(ResultCodes.OK==resultCode){
                logged();
            }

        }
    }

    private void singUp(){
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(Arrays.asList(
                                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()/*,
                                        new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build()*/))
                        .build(),
                RC_SIGN_IN);
    }


    private void logged(){


        DatabaseReference dbRef = new References().userReference().child(new CurrentUser().getCurrentUser().getUid());
        Users user = new Users();
        user.setEmail(new CurrentUser().getCurrentUser().getEmail());
        dbRef.setValue(user);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();



    }


    }


