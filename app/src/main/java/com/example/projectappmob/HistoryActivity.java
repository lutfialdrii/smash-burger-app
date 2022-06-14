package com.example.projectappmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.projectappmob.adapter.Adapter;
import com.example.projectappmob.api.ApiClient;
import com.example.projectappmob.api.ApiInterface;
import com.example.projectappmob.model.history.DataItem;
import com.example.projectappmob.model.history.History;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnBack;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataItem> listData = new ArrayList<>();
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        sessionManager = new SessionManager(this);
        recyclerView = findViewById(R.id.rv_data);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        retrieveData();
    }

    public void retrieveData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<History> tampilData = apiInterface.historyResponse(sessionManager.getUserDetail().get(SessionManager.ID_USER));

        tampilData.enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(HistoryActivity.this, "Kode " + kode + " | Pesan " + pesan, Toast.LENGTH_SHORT).show();

                listData = response.body().getData();
                adapter = new Adapter(HistoryActivity.this, listData);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


                
            }

            @Override
            public void onFailure(Call<History> call, Throwable t) {
                Toast.makeText(HistoryActivity.this, "Gagal !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                Intent i = new Intent(this,ProfileActivity.class);
                startActivity(i);
                break;
        }

    }
}