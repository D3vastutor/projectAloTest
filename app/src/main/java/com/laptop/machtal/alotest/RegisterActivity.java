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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEmail;
    private EditText edtPass;
    private Button btnRegister;

    private TextView txtToLogin;

    private ProgressDialog prgLoading;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null)
        {
            finish();

            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        edtEmail = (EditText) findViewById(R.id.editEmail);
        edtPass = (EditText) findViewById(R.id.editPass);
        txtToLogin = (TextView) findViewById(R.id.textLogin);
        btnRegister = (Button) findViewById(R.id.btnReg);

        prgLoading = new ProgressDialog(this);

        btnRegister.setOnClickListener(this);
        txtToLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnRegister)
        {
            registerUser();
        }

        if (v == txtToLogin)
        {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private void registerUser() {

        String email = edtEmail.getText().toString().trim();
        String password = edtPass.getText().toString().trim();

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Tolong masukkan email anda", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Tolong masukkan password anda", Toast.LENGTH_LONG).show();
            return;
        }

        prgLoading.setMessage("Proses mendaftarkan...");
        prgLoading.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "Gagal mendaftarkan", Toast.LENGTH_LONG).show();
                        }
                        prgLoading.dismiss();
                    }
                });
    }
}
