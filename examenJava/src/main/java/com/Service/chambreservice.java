package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.examenJava.chambre;
import com.TD_Hibernate_Git.HibernateUtil;

public class chambreservice implements Serializable {
	
	public boolean create(chambre c, Session s)
	{
		s.save(c); // INSERT INTO Client (nom, prenom) VALUES (c.getNom(), c.getPrenom());
		
		return true;
	}
	
	public void delete(Session s, int id)
	{
		chambre c = s.get(chambre.class, id);
		s.delete(c); 
	}
	
	public void update(Session s, int id)
	{
		chambre c = s.get(chambre.class, id);
		c.setPrenom("Paul");
		s.update(c); // UPDATE client SET nom = c.getNom(), prenom = c.getPrenom() where id = id;
	}
	
	public chambre findById(Session s, int id)
	{
		chambre c = s.get(chambre.class, id); // SELECT * FROM client where id = id;
		return c;
	}
	
	public List<chambre> findAll(Session s)
	{
		Query q = s.createQuery("from chambre");
		List<chambre> listeC = q.list();
		
		return listeC;
	}

}
