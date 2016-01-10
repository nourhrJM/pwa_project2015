package com.rec.beans;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rec.models.CV;
import com.rec.models.Competence;
import com.rec.models.Experience;
import com.rec.models.Formation;
import com.rec.models.Langue;
import com.rec.models.Nationalite;
import com.rec.models.SituationFamiliale;

@Component
@Scope("session")
public class CandidatBean {
	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String tel;

	private String adresse;

	private String login;

	private String password;

	private String date_naissance;

	private Nationalite nationalite;

	private SituationFamiliale situation_familiale;

	private String photo;

	private Set<Competence> competences;

	private Set<Formation> formations;

	private Set<Experience> experiences;

	private Set<Langue> langues;

	private CV cv;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<Competence> getCompetences() {
		return new HashSet<>(this.competences);
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	public Set<Formation> getFormations() {
		return new HashSet<>(this.formations);
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Set<Experience> getExperiences() {
		return new HashSet<>(this.experiences);
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	public Set<Langue> getLangues() {
		return new HashSet<>(this.langues);
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

}
