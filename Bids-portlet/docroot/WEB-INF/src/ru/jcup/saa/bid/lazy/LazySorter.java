package ru.jcup.saa.bid.lazy;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import ru.jcup.saa.bid.Bid;

public class LazySorter implements Comparator<Bid> {
 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(Bid bid1, Bid bid2) {
        try {
            Object value1 = Bid.class.getField(this.sortField).get(bid1);
            Object value2 = Bid.class.getField(this.sortField).get(bid2);
 
			@SuppressWarnings("unchecked")
			int value = ((Comparable<Object>)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}