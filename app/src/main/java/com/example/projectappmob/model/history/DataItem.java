package com.example.projectappmob.model.history;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("kuantitas")
	private String kuantitas;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("total_harga")
	private String totalHarga;

	@SerializedName("id_transaksi")
	private String idTransaksi;

	@SerializedName("alamat")
	private String alamat;

	public void setKuantitas(String kuantitas){
		this.kuantitas = kuantitas;
	}

	public String getKuantitas(){
		return kuantitas;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setTotalHarga(String totalHarga){
		this.totalHarga = totalHarga;
	}

	public String getTotalHarga(){
		return totalHarga;
	}

	public void setIdTransaksi(String idTransaksi){
		this.idTransaksi = idTransaksi;
	}

	public String getIdTransaksi(){
		return idTransaksi;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}
}