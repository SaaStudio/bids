package ru.jcup.saa.bid.lazy;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ru.jcup.saa.bid.Bid;
import ru.jcup.saa.bid.BidDao;
 
@ManagedBean(name = "bidService")
@ApplicationScoped
public class BidService {
          
    public List<Bid> createBids() {	
        return BidDao.getAllBid();
    }
     
 }
