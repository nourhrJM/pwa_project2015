package com.rec.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proposition implements Serializable {
	private static final long serialVersionUID = -5933921984243764093L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Candidat candidat;

	@ManyToOne
	private Offre offre;

	@ManyToOne
	private RH rh;

	@ManyToOne
	@JoinColumn(name = "ETAT_ID", columnDefinition = "BIGINT(19) default '3'")
	private Etat etat;

	@Column(name = "VUE_PAR_CANDIDAT", columnDefinition = "BOOLEAN(1) default FALSE")
	private Boolean vueParCandidat;

	@Column(name = "VUE_PAR_ANNONCEUR", columnDefinition = "BOOLEAN(1) default FALSE")
	private Boolean vueParAnnonceur;

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public RH getRh() {
		return rh;
	}

	public void setRh(RH rh) {
		this.rh = rh;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Boolean getVueParCandidat() {
		return vueParCandidat;
	}

	public void setVueParCandidat(Boolean vueParCandidat) {
		this.vueParCandidat = vueParCandidat;
	}

	public Boolean getVueParAnnonceur() {
		return vueParAnnonceur;
	}

	public void setVueParAnnonceur(Boolean vueParAnnonceur) {
		this.vueParAnnonceur = vueParAnnonceur;
	}

	public Long getId() {
		return id;
	}

}
