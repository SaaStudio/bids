package ru.jcup.saa.bid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SuppressWarnings("serial")
public class InputForm {

	private String error;
	private String fault;
	private Date date;
	private String phone;
	private Boolean isCall;
	
	public static ArrayList<String> faultList = new ArrayList<String>(){
		{
			add("ничего");
			add("кое-что");
			add("что-то");
			add("нечто");
		}
	};
	
	public static ArrayList<String> callList = new ArrayList<String>(){
		{
			add("нет");
			add("да");
		}
	};
	
	//error
	public void setErrorCode(String error) {
		this.error = error;
	}
	
	public String getErrorCode() {
		return error;
	}
	
	public List<String> completeErrorText(String query) {
		List<String> results = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			results.add(query + i);
		}
		return results;
	}
	
	//fault
	
	public List<String> getFaultList() {
		return InputForm.faultList;
	}

	public String getFault() {
		return fault;
	}

	public void setFault(String fault) {
		this.fault = fault;
	}

	//date
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//phone
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//isCall
	
	public List<String> getCallList() {
		return InputForm.callList;
	}
	
	public Boolean getIsCall() {
		return isCall;
	}

	public void setIsCall(Boolean isCall) {
		this.isCall = isCall;
	}
	
	//Button
	
    public void buttonAction(ActionEvent actionEvent) {
    	/*System.out.println("\n\n*******************************");
    	System.out.println(error);
    	System.out.println(fault);
    	System.out.println(date);
    	System.out.println(phone);
    	System.out.println(isCall);*/
        addMessage("«а€вка прин€та");
        
        Long numPhone = Long.parseLong(phone.replaceAll("[() -]", ""));
        
		Bid bid = new Bid();
		bid.setError(error);
		bid.setFault(fault);
		bid.setDate(date);
		bid.setPhone(numPhone);
		bid.setIsCall(isCall);
		
		error = null;
		fault = null;
		date = null;
		phone = null;
		numPhone = null;
		
		BidDao.newBid(bid);
		
		//RequestContext.getCurrentInstance().update(":showform:bidTable");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}
