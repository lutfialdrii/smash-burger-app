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
import com.example.projectappmob.model.transaction.Transaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvPrice, tvPayment, tvId;
    ImageButton btnBack, btnOrder;
    EditText etLocation;
    ApiInterface apiInterface;
    SessionManager sessionManager;
    int total_harga, kuantitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        sessionManager = new SessionManager(TransactionActivity.this);

        tvPrice = findViewById(R.id.tvPrice);
        tvPayment = findViewById(R.id.tvTotalPayment);
        tvId = findViewById(R.id.tvId);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(this);

        etLocation = findViewById(R.id.etLocation);

        total_harga = getIntent().getIntExtra("Price", 0);
        String textPrice = "Price : " + total_harga;

        kuantitas = getIntent().getIntExtra("Kuantitas", 0);

        int payment = total_harga + 15000;
        String textPayment = "Total Payment : " + payment;
        tvPrice.setText(textPrice);
        tvPayment.setText(textPayment);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.btnOrder:
                String id_user = sessionManager.getUserDetail().get(SessionManager.ID_USER);
                String alamat = etLocation.getText().toString();
                transaction(id_user, alamat, kuantitas, total_harga);

        }
    }

    private void transaction(String id_user, String alamat, int kuantitas, int total_harga) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Transaction> call = apiInterface.transactionResponse(id_user, alamat, kuantitas, total_harga);
        call.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(TransactionActivity.this, "Pesanan Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(TransactionActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Toast.makeText(TransactionActivity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}