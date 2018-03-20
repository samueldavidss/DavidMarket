package com.example.samuel.davidmarket.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.samuel.davidmarket.Models.Users;
import com.example.samuel.davidmarket.Queries.CurrentUser;
import com.example.samuel.davidmarket.Queries.References;
import com.example.samuel.davidmarket.R;
import com.google.firebase.database.DatabaseReference;

public class FormActivity extends AppCompatActivity {

    DatabaseReference dbref = new References().userReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        final EditText nameEdt = (EditText) findViewById(R.id.nameEdt);
        final EditText addresEdt = (EditText) findViewById(R.id.addresEdt);
        final EditText phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        final String key = getIntent().getStringExtra("key");
        Button saveBtn = (Button) findViewById(R.id.guardarbt);
        nameEdt.setText(new CurrentUser().nameUser());
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users user = new Users();
                user.setEmail(new CurrentUser().getEmail());
                user.setKey(new CurrentUser().getUid());
                user.setName(String.valueOf(nameEdt.getText()));
                user.setDireccion(String.valueOf(addresEdt.getText()));
                user.setPhone(String.valueOf(phoneEdt.getText()));
                dbref.child(key).setValue(user);

                Intent intent = new Intent(FormActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                            }
        });
    }
}
