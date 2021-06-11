package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.examenJava.salarie;
import com.TD_Hibernate_Git.HibernateUtil;

public class salarieservice implements Serializable {
	
	public boolean create(salarie c, Session s)
	{
		s.save(c); // INSERT INTO Client (nom, prenom) VALUES (c.getNom(), c.getPrenom());
		
		return true;
	}
	
	public void delete(Session s, int id)
	{
		salarie c = s.get(salarie.class, id);
		s.delete(c); 
	}
	
	public void update(Session s, int id)
	{
		salarie c = s.get(salarie.class, id);
		c.setPrenom("Paul");
		s.update(c); // UPDATE client SET nom = c.getNom(), prenom = c.getPrenom() where id = id;
	}
	
	public salarie findById(Session s, int id)
	{
		salarie c = s.get(salarie.class, id); // SELECT * FROM client where id = id;
		return c;
	}
	
	public List<salarie> findAll(Session s)
	{
		Query q = s.createQuery("from salarie");
		List<salarie> listeC = q.list();
		
		return listeC;
	}

}
