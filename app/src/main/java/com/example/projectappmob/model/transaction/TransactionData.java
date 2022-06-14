package com.example.projectappmob.model.transaction;

import com.google.gson.annotations.SerializedName;

public class TransactionData {

	@SerializedName("kuantitas")
	private String kuantitas;

	@SerializedName("total_harga")
	private String totalHarga;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("alamat")
	private String alamat;

	public void setKuantitas(String kuantitas){
		this.kuantitas = kuantitas;
	}

	public String getKuantitas(){
		return kuantitas;
	}

	public void setTotalHarga(String totalHarga){
		this.totalHarga = totalHarga;
	}

	public String getTotalHarga(){
		return totalHarga;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}
}