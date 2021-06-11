package com.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "nom", nullable = true, unique = false, length = 50)
	private String nom;
	
	@Column(name = "adresse", nullable = true, unique = false, length = 50)
	private String adresse;
	
	@Column(name = "telephone", nullable = true, unique = false, length = 50)
	private int telephone;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="client_id")
	private Set<Produit> produits;
	
	@OneToOne
	@JoinColumn(name="compte_id")
	private Compte compte;

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getadresse() {
		return adresse;
	}

	public void setadresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String gettelephone() {
		return telephone;
	}

	public void settelephone(String telephone) {
		this.telephone = telephone;
	}

}
