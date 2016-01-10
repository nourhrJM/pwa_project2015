package com.rec.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Secteur implements Serializable {
	private static final long serialVersionUID = 3377124969857729918L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String intitule;

	@OneToMany(mappedBy = "secteur", fetch = FetchType.EAGER)
	private Set<Annonceur> annonceurs;

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Annonceur> getAnnonceurs() {
		return annonceurs;
	}

	public void setAnnonceurs(Set<Annonceur> annonceurs) {
		this.annonceurs = annonceurs;
	}

	public Long getId() {
		return id;
	}

}
