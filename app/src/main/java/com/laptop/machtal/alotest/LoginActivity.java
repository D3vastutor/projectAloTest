package com.laptop.machtal.alotest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private EditText edtEmail, edtPass;
    private TextView txtRegister;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog prgLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        edtEmail = (EditText) findViewById(R.id.edtEmailLogin);
        edtPass = (EditText) findViewById(R.id.edtPassLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtRegister = (TextView) findViewById(R.id.txtKeRegister);

        prgLoading = new ProgressDialog(this);
        btnLogin.setOnClickListener(this);
        txtRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin)
        {
            userLogin();
        }

        if (v == txtRegister)
        {
            finish();
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }

    private void userLogin() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPass.getText().toString().trim();

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Tolong masukkan email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Tolong masukkan passwotd", Toast.LENGTH_LONG).show();
        }

        prgLoading.setMessage("Memuat data user...");
        prgLoading.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        prgLoading.dismiss();

                        if (task.isSuccessful())
                        {
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "User tidak ditemukan", Toast.LENGTH_LONG).show();
                            //prgLoading.dismiss();
                        }
                    }
                });
    }
}
