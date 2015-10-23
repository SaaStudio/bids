package ru.jcup.saa.bid;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidDao {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private static Session getSession() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}

	private static void closeSession(Session session) {
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Bid> getAllBid() {
		List<Bid> bids = new ArrayList<Bid>();
		Session session = getSession();
	    try {
		    bids = session.createCriteria(Bid.class).list();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
			closeSession(session);
		}
		return bids;
	}
	
	public static void updateBid(Bid bid) {
		Session session = getSession();
	    try {
	    	session.update(bid);
			session.getTransaction().commit();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
			closeSession(session);
		}
	}
	
	public static void newBid(Bid bid) {
		Session session = getSession();
	    try {
	    	session.save(bid);
			session.getTransaction().commit();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
			closeSession(session);
		}
	}

}
