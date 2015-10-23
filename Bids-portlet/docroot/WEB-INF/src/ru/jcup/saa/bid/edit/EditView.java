package ru.jcup.saa.bid.edit;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ru.jcup.saa.bid.Bid;
import ru.jcup.saa.bid.BidDao;
import ru.jcup.saa.bid.lazy.BidService;

@ManagedBean(name="bidEditView")
@ViewScoped
public class EditView implements Serializable {
     
	private static final long serialVersionUID = -3124204315879263486L;

	private List<Bid> bids;
         
    @ManagedProperty("#{bidService}")
    private BidService service;
     
    @PostConstruct
    public void init() {
        bids = service.createBids();
    }
 
    public List<Bid> getCars1() {
        return bids;
    }
 
    public void setService(BidService service) {
        this.service = service;
    }
     
    public void onRowEdit(RowEditEvent event) {
    	Bid updateBid = (Bid) event.getObject();
        BidDao.updateBid(updateBid);
        
        FacesMessage msg = new FacesMessage("Заявка обновлена", "№" + updateBid.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Редактирование отменено", "№" + ((Bid) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}