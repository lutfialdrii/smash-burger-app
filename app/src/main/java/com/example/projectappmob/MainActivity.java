package com.example.projectappmob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int add1, add2, add3, add4, add5, add6, add7, add8, add9, add10, add11, add12 = 0;
    int harga = 0;
    ImageButton btnMenu1Add, btnMenu2Add, btnMenu3Add, btnMenu4Add, btnMenu5Add, btnMenu6Add,
            btnMenu7Add, btnMenu8Add, btnMenu9Add, btnMenu10Add, btnMenu11Add, btnMenu12Add,
            btnMenu1Min, btnMenu2Min, btnMenu3Min, btnMenu4Min, btnMenu5Min, btnMenu6Min,
            btnMenu7Min, btnMenu8Min, btnMenu9Min, btnMenu10Min, btnMenu11Min, btnMenu12Min,
            btnCheckOut, btnProfil;
    TextView tvMenu1, tvMenu2, tvMenu3, tvMenu4, tvMenu5, tvMenu6,
            tvMenu7, tvMenu8, tvMenu9, tvMenu10, tvMenu11, tvMenu12;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);

        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }
        btnProfil = findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(this);

        //Button Plus
        btnMenu1Add = findViewById(R.id.btnMenu1Add);
        btnMenu1Add.setOnClickListener(this);
        btnMenu2Add = findViewById(R.id.btnMenu2Add);
        btnMenu2Add.setOnClickListener(this);
        btnMenu3Add = findViewById(R.id.btnMenu3Add);
        btnMenu3Add.setOnClickListener(this);
        btnMenu4Add = findViewById(R.id.btnMenu4Add);
        btnMenu4Add.setOnClickListener(this);
        btnMenu5Add = findViewById(R.id.btnMenu5Add);
        btnMenu5Add.setOnClickListener(this);
        btnMenu6Add = findViewById(R.id.btnMenu6Add);
        btnMenu6Add.setOnClickListener(this);
        btnMenu7Add = findViewById(R.id.btnMenu7Add);
        btnMenu7Add.setOnClickListener(this);
        btnMenu8Add = findViewById(R.id.btnMenu8Add);
        btnMenu8Add.setOnClickListener(this);
        btnMenu9Add = findViewById(R.id.btnMenu9Add);
        btnMenu9Add.setOnClickListener(this);
        btnMenu10Add = findViewById(R.id.btnMenu10Add);
        btnMenu10Add.setOnClickListener(this);
        btnMenu11Add = findViewById(R.id.btnMenu11Add);
        btnMenu11Add.setOnClickListener(this);
        btnMenu12Add = findViewById(R.id.btnMenu12Add);
        btnMenu12Add.setOnClickListener(this);

        //Button Minus
        btnMenu1Min = findViewById(R.id.btnMenu1Min);
        btnMenu1Min.setOnClickListener(this);
        btnMenu2Min = findViewById(R.id.btnMenu2Min);
        btnMenu2Min.setOnClickListener(this);
        btnMenu3Min = findViewById(R.id.btnMenu3Min);
        btnMenu3Min.setOnClickListener(this);
        btnMenu4Min = findViewById(R.id.btnMenu4Min);
        btnMenu4Min.setOnClickListener(this);
        btnMenu5Min = findViewById(R.id.btnMenu5Min);
        btnMenu5Min.setOnClickListener(this);
        btnMenu6Min = findViewById(R.id.btnMenu6Min);
        btnMenu6Min.setOnClickListener(this);
        btnMenu7Min = findViewById(R.id.btnMenu7Min);
        btnMenu7Min.setOnClickListener(this);
        btnMenu8Min = findViewById(R.id.btnMenu8Min);
        btnMenu8Min.setOnClickListener(this);
        btnMenu9Min = findViewById(R.id.btnMenu9Min);
        btnMenu9Min.setOnClickListener(this);
        btnMenu10Min = findViewById(R.id.btnMenu10Min);
        btnMenu10Min.setOnClickListener(this);
        btnMenu11Min = findViewById(R.id.btnMenu11Min);
        btnMenu11Min.setOnClickListener(this);
        btnMenu12Min = findViewById(R.id.btnMenu12Min);
        btnMenu12Min.setOnClickListener(this);

        //Button CheckOut
        btnCheckOut = findViewById(R.id.btnCheckOut);
        btnCheckOut.setOnClickListener(this);

        //TextView Menu
        tvMenu1 = findViewById(R.id.jumlah_menu1);
        tvMenu2 = findViewById(R.id.jumlah_menu2);
        tvMenu3 = findViewById(R.id.jumlah_menu3);
        tvMenu4 = findViewById(R.id.jumlah_menu4);
        tvMenu5 = findViewById(R.id.jumlah_menu5);
        tvMenu6 = findViewById(R.id.jumlah_menu6);
        tvMenu7 = findViewById(R.id.jumlah_menu7);
        tvMenu8 = findViewById(R.id.jumlah_menu8);
        tvMenu9 = findViewById(R.id.jumlah_menu9);
        tvMenu10 = findViewById(R.id.jumlah_menu10);
        tvMenu11 = findViewById(R.id.jumlah_menu11);
        tvMenu12 = findViewById(R.id.jumlah_menu12);




    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnProfil:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMenu1Add:
                add1++;
                harga += 40000;
                String text = "" + add1;
                tvMenu1.setText(text);
                break;

            case R.id.btnMenu1Min:
                if (add1 > 0) {
                    add1--;
                    harga -= 40000;
                    text = "" + add1;
                    tvMenu1.setText(text);
                } else {
                    add1 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu2Add:
                add2++;
                harga += 50000;
                text = "" + add2;
                tvMenu2.setText(text);
                break;

            case R.id.btnMenu2Min:
                if (add2 > 0) {
                    add2--;
                    harga -= 50000;
                    text = "" + add2;
                    tvMenu2.setText(text);
                } else {
                    add2 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu3Add:
                add3++;
                harga += 40000;
                text = "" + add3;
                tvMenu3.setText(text);
                break;

            case R.id.btnMenu3Min:
                if (add3 > 0) {
                    add3--;
                    harga -= 40000;
                    text = "" + add3;
                    tvMenu3.setText(text);
                } else {
                    add3 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu4Add:
                add4++;
                harga += 40000;
                text = "" + add4;
                tvMenu4.setText(text);
                break;

            case R.id.btnMenu4Min:
                if (add4 > 0) {
                    add4--;
                    harga -= 40000;
                    text = "" + add4;
                    tvMenu4.setText(text);
                } else {
                    add4 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu5Add:
                add5++;
                harga += 20000;
                text = "" + add5;
                tvMenu5.setText(text);
                break;

            case R.id.btnMenu5Min:
                if (add5 > 0) {
                    add5--;
                    harga -= 20000;
                    text = "" + add5;
                    tvMenu5.setText(text);
                } else {
                    add5 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu6Add:
                add6++;
                harga += 40000;
                text = "" + add6;
                tvMenu6.setText(text);
                break;

            case R.id.btnMenu6Min:
                if (add6 > 0) {
                    add6--;
                    harga -= 40000;
                    text = "" + add6;
                    tvMenu6.setText(text);
                } else {
                    add6 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu7Add:
                add7++;
                harga += 20000;
                text = "" + add7;
                tvMenu7.setText(text);
                break;

            case R.id.btnMenu7Min:
                if (add7 > 0) {
                    add7--;
                    harga -= 20000;
                    text = "" + add7;
                    tvMenu4.setText(text);
                } else {
                    add7 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu8Add:
                add8++;
                harga += 40000;
                text = "" + add8;
                tvMenu8.setText(text);
                break;

            case R.id.btnMenu8Min:
                if (add8 > 0) {
                    add8--;
                    harga -= 40000;
                    text = "" + add8;
                    tvMenu8.setText(text);
                } else {
                    add8 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu9Add:
                add9++;
                harga += 25000;
                text = "" + add9;
                tvMenu9.setText(text);
                break;

            case R.id.btnMenu9Min:
                if (add9 > 0) {
                    add9--;
                    harga -= 25000;
                    text = "" + add9;
                    tvMenu9.setText(text);
                } else {
                    add9 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu10Add:
                add10++;
                harga += 40000;
                text = "" + add10;
                tvMenu10.setText(text);
                break;

            case R.id.btnMenu10Min:
                if (add10 > 0) {
                    add10--;
                    harga -= 40000;
                    text = "" + add10;
                    tvMenu10.setText(text);
                } else {
                    add10 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu11Add:
                add11++;
                harga += 30000;
                text = "" + add11;
                tvMenu11.setText(text);
                break;

            case R.id.btnMenu11Min:
                if (add11 > 0) {
                    add11--;
                    harga -= 30000;
                    text = "" + add11;
                    tvMenu11.setText(text);
                } else {
                    add11 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnMenu12Add:
                add12++;
                harga += 55000;
                text = "" + add12;
                tvMenu12.setText(text);
                break;

            case R.id.btnMenu12Min:
                if (add12 > 0) {
                    add12--;
                    harga -= 55000;
                    text = "" + add12;
                    tvMenu12.setText(text);
                } else {
                    add12 = 0;
                    Toast.makeText(this, "Pesanan Tidak Boleh Dibawah 0", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnCheckOut:
                int totalAdd = add1 + add2 + add3 + add4 + add5 + add6 + add7 + add8 + add9 + add10 + add11 + add12;
                int price = harga;
                Intent i = new Intent(this, TransactionActivity.class);
                i.putExtra("Price", price);
                i.putExtra("Kuantitas", totalAdd);
                startActivity(i);
                break;

        }
    }
}