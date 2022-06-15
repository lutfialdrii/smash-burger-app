package com.example.projectappmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnHistory,btnBack, btnLogout;
    SessionManager sessionManager;
    TextView tvNamaLengkap, tvUsername, tvEmail, tvNoHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(ProfileActivity.this);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnHistory = findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(this);
        tvNamaLengkap = findViewById(R.id.tvNamaLengkap);
        tvUsername = findViewById(R.id.tvUsername);
        tvEmail = findViewById(R.id.tvemail);
        tvNoHp = findViewById(R.id.tvNoHp);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        String username = "Username : " + sessionManager.getUserDetail().get(SessionManager.USERNAME);
        String id_user = "ID_USER " + sessionManager.getUserDetail().get(SessionManager.ID_USER);
        String namalengkap = ""+sessionManager.getUserDetail().get(SessionManager.NAMALENGKAP);
        String nohp = "No Hp : " + sessionManager.getUserDetail().get(SessionManager.NOHP);
        String email = "Email : " + sessionManager.getUserDetail().get(SessionManager.EMAIL);

        tvNamaLengkap.setText(namalengkap);
        tvUsername.setText(username);
        tvEmail.setText(email);
        tvNoHp.setText(nohp);

    }

    private void moveToLogin() {
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnHistory:
                Intent intent = new Intent(this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.btnBack:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.btnLogout:
                moveToLogin();
                sessionManager.logoutSession();
                break;
        }
    }

}