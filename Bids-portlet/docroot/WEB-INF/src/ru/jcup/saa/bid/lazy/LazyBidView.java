package ru.jcup.saa.bid.lazy;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import ru.jcup.saa.bid.Bid;

@ManagedBean
@ViewScoped
public class LazyBidView implements Serializable {
     
	private static final long serialVersionUID = 1L;

	private LazyDataModel<Bid> lazyModel;
     
    private Bid selectedBid;
     
    @ManagedProperty("#{bidService}")
    private BidService service;
     
    @PostConstruct
    public void init() {
        lazyModel = new LazyBidDataModel(service.createBids());
    }
 
    public LazyDataModel<Bid> getLazyModel() {
        return lazyModel;
    }
 
    public Bid getSelectedBid() {
        return selectedBid;
    }
 
    public void setSelectedBid(Bid selectedBid) {
        this.selectedBid = selectedBid;
    }
     
    public void setService(BidService service) {
        this.service = service;
    }
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Bid Selected", ""+((Bid) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
