package com.example.projectappmob.model.register;

import com.google.gson.annotations.SerializedName;

public class RegisterData {

	@SerializedName("namalengkap")
	private String namalengkap;

	@SerializedName("nohp")
	private String nohp;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setNamalengkap(String namalengkap){
		this.namalengkap = namalengkap;
	}

	public String getNamalengkap(){
		return namalengkap;
	}

	public void setNohp(String nohp){
		this.nohp = nohp;
	}

	public String getNohp(){
		return nohp;
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