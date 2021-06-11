package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.examenJava.hotel;
import com.TD_Hibernate_Git.HibernateUtil;

public class hotelservice implements Serializable {
	
	public boolean create(hotel c, Session s)
	{
		s.save(c); // INSERT INTO Client (nom, prenom) VALUES (c.getNom(), c.getPrenom());
		
		return true;
	}
	
	public void delete(Session s, int id)
	{
		hotel c = s.get(hotel.class, id);
		s.delete(c); 
	}
	
	public void update(Session s, int id)
	{
		hotel c = s.get(hotel.class, id);
		c.setPrenom("Paul");
		s.update(c); // UPDATE client SET nom = c.getNom(), prenom = c.getPrenom() where id = id;
	}
	
	public hotel findById(Session s, int id)
	{
		hotel c = s.get(directeur.class, id); // SELECT * FROM client where id = id;
		return c;
	}
	
	public List<hotel> findAll(Session s)
	{
		Query q = s.createQuery("from hotel");
		List<hotel> listeC = q.list();
		
		return listeC;
	}

}
