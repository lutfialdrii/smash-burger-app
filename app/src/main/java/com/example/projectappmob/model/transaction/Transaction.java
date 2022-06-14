package com.example.projectappmob.model.transaction;

import com.google.gson.annotations.SerializedName;

public class Transaction{

	@SerializedName("data")
	private TransactionData transactionData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(TransactionData transactionData){
		this.transactionData = transactionData;
	}

	public TransactionData getData(){
		return transactionData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}