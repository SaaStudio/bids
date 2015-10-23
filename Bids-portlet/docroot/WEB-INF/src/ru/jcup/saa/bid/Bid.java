package ru.jcup.saa.bid;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bid {

	//Обычно они privаte, необходимо для рефлексии, используемой в фильтрации
	public Long id;
	public String error;
	public String fault;
	private Date date;
	private Long phone;
	private Boolean isCall;
	
	//simpleView
	public String simpleCall;
	public String simpleDate;
	public String simplePhone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getFault() {
		return fault;
	}
	public void setFault(String fault) {
		this.fault = fault;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDate = dateFormat.format(date);
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		String phoneStr = ""+phone;
		simplePhone = "(" + phoneStr.substring(0, 3) + ") " 
							+ phoneStr.substring(3, 6) + "-"
							+ phoneStr.substring(6,8) + "-"
							+ phoneStr.substring(8);
		this.phone = phone;
	}
	public Boolean getIsCall() {
		return isCall;
	}
	public void setIsCall(Boolean isCall) {
		simpleCall = isCall ? InputForm.callList.get(1) : InputForm.callList.get(0);
		this.isCall = isCall;
	}
	
	//Simple geteers and setters
	public String getSimpleCall() {
		return simpleCall;
	}
	public void setSimpleCall(String simpleCall) {
		this.simpleCall = simpleCall;
	}
	public String getSimpleDate() {
		return simpleDate;
	}
	public void setSimpleDate(String simpleDate) {
		this.simpleDate = simpleDate;
	}
	public String getSimplePhone() {
		return simplePhone;
	}
	public void setSimplePhone(String simplePhone) {
		this.simplePhone = simplePhone;
		phone = Long.parseLong(simplePhone.replaceAll("[() -]", ""));
	}
}

