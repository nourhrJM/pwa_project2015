package com.rec.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Offre implements Serializable {
	private static final long serialVersionUID = -5552481702773598509L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String intitule;

	private String reference;

	@ManyToOne
	private Salaire salaire;

	@ManyToOne
	private Mobilite mobilite;

	@Column(columnDefinition = "text")
	private String description;

	@ManyToOne
	private Annonceur annonceur;

	@ManyToOne
	private Contrat contrat;

	@OneToMany(mappedBy = "offre", fetch = FetchType.EAGER)
	private Set<Candidature> listCandidatures;

	@Column(columnDefinition = "BIGINT(19) default '0'")
	private int affected;

	public Set<Candidature> getListCandidatures() {
		return listCandidatures;
	}

	public void setListCandidatures(Set<Candidature> listCandidatures) {
		this.listCandidatures = listCandidatures;
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

	public Long getId() {
		return Id;
	}

	public int getAffected() {
		return affected;
	}

	public void setAffected(int affected) {
		this.affected = affected;
	}

}
