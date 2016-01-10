package com.rec.beans;

import com.rec.models.Annonceur;
import com.rec.models.Contrat;
import com.rec.models.Mobilite;
import com.rec.models.Salaire;

public class OffreBean {
	private Long Id;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public Mobilite getMobilite() {
		return mobilite;
	}

	public void setMobilite(Mobilite mobilite) {
		this.mobilite = mobilite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Annonceur getAnnonceur() {
		return annonceur;
	}

	public void setAnnonceur(Annonceur annonceur) {
		this.annonceur = annonceur;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	private String intitule;

	private String reference;

	private Salaire salaire;

	private Mobilite mobilite;

	private String description;

	private Annonceur annonceur;

	private Contrat contrat;
}
