package com.rec.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Candidat implements Serializable {
	private static final long serialVersionUID = 2155140385142620737L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String tel;

	private String adresse;

	private String login;

	private String password;

	private String date_naissance;

	@Column(columnDefinition = "text default 'Non definie'")
	private String titre;

	@Column(columnDefinition = "text default 'Non definie'")
	private String bio;

	@ManyToOne
	private Nationalite nationalite;

	@ManyToOne
	private SituationFamiliale situation_familiale;

	@Column(columnDefinition = "text default 'avatar-1.jpg'")
	private String photo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = { @JoinColumn(name = "CANDIDAT_ID", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "COMPETENCE_ID", referencedColumnName = "id") })
	private List<Competence> competences;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidat", fetch = FetchType.EAGER)
	private Set<Formation> formations;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidat", fetch = FetchType.EAGER)
	private Set<Experience> experiences;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = { @JoinColumn(name = "CANDIDAT_ID", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "LANGUE_ID", referencedColumnName = "id") })
	private Set<Langue> langues;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "candidat")
	private CV cv;

	public String getNom() {
		return nom.toUpperCase();
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		char first = Character.toUpperCase(prenom.charAt(0));
		prenom = first + prenom.substring(1);
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email.trim().toLowerCase();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel.trim().toLowerCase();
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse.trim().toLowerCase();
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLogin() {
		return login.trim().toLowerCase();
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password.trim().toLowerCase();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Set<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	public Set<Langue> getLangues() {
		return langues;
	}

	public void setLangues(Set<Langue> langues) {
		this.langues = langues;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public Long getId() {
		return id;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public Nationalite getNationalite() {
		return nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	public SituationFamiliale getSituation_familiale() {
		return situation_familiale;
	}

	public void setSituation_familiale(SituationFamiliale situation_familiale) {
		this.situation_familiale = situation_familiale;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void addFormation(Formation f) {
		this.formations.add(f);
	}

	public void addExperience(Experience e) {
		this.experiences.add(e);
	}

	public void addCompetence(Competence c) {
		this.competences.add(c);
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
