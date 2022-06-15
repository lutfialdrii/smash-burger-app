package com.example.projectappmob.api;

import com.example.projectappmob.model.history.History;
import com.example.projectappmob.model.login.Login;
import com.example.projectappmob.model.register.Register;
import com.example.projectappmob.model.transaction.Transaction;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("no_hp") String nohp,
            @Field("nama_lengkap") String namalengkap
    );
    @FormUrlEncoded
    @POST("transaction.php")
    Call<Transaction> transactionResponse(
            @Field("id_user") String id_user,
            @Field("alamat") String alamat,
            @Field("kuantitas") Integer kuantitas,
            @Field("total_harga") Integer total_harga
    );
    @FormUrlEncoded
    @POST("retrieve.php")
    Call<History> historyResponse(
            @Field("id_user") String id_user
    );
}
