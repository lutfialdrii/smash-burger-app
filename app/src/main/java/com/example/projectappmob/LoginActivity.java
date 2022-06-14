package com.example.projectappmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectappmob.api.ApiClient;
import com.example.projectappmob.api.ApiInterface;
import com.example.projectappmob.model.login.Login;
import com.example.projectappmob.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvSignup;
    EditText etUsername, etPassword;
    ImageButton btnSignIn;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvSignup = findViewById(R.id.tvSignup);
        tvSignup.setOnClickListener(this);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSignup:
                Intent i = new Intent(this, RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.btnSignIn:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
                break;
        }


    }

    private void login(String username, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(username, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

                    // Ini untuk menyimpan sesi
                    sessionManager = new SessionManager(LoginActivity.this);
                    LoginData loginData = response.body().getData();
                    sessionManager.createLoginSession(loginData);

                    //Ini untuk pindah
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}