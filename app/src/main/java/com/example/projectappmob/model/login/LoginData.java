package com.example.projectappmob.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("no_hp")
	private int noHp;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setNoHp(int noHp){
		this.noHp = noHp;
	}

	public int getNoHp(){
		return noHp;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
	}

	public void setIdUser(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser(){
		return idUser;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}