package com.example.projectappmob.model.register;

import com.google.gson.annotations.SerializedName;

public class RegisterData {

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
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