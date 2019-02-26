package com.laptop.machtal.alotest.Method;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.laptop.machtal.alotest.LoginActivity;
import com.laptop.machtal.alotest.R;

public class ProfileUser extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView txtUserEmail;
    private Button btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contain_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        txtUserEmail = (TextView) findViewById(R.id.txtUserEmail);
        btnKeluar = (Button) findViewById(R.id.btnLogout);

        txtUserEmail.setText("Selamat Datang! " +user.getEmail());

        btnKeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnKeluar){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
