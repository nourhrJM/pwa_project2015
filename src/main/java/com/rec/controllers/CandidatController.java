package com.rec.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rec.models.Candidat;
import com.rec.models.Competence;
import com.rec.models.Experience;
import com.rec.models.Formation;
import com.rec.models.Nationalite;
import com.rec.models.SituationFamiliale;
import com.rec.repositories.CandidatRepo;
import com.rec.repositories.CompetanceRepo;
import com.rec.repositories.ExperienceRepo;
import com.rec.repositories.FormationRepo;
import com.rec.repositories.NationaliteRepo;
import com.rec.repositories.SituationFamRepo;

@Controller
public class CandidatController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	CandidatRepo crep;

	@Autowired
	SituationFamRepo srep;

	@Autowired
	NationaliteRepo nrep;

	@Autowired
	FormationRepo frep;

	@Autowired
	ExperienceRepo erep;

	@Autowired
	CompetanceRepo corep;

	@RequestMapping(value = "/candidatsave", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView candidatSave(@RequestParam("email") String email, @RequestParam("login") String login,
			@RequestParam("pass") String pass) {
		Candidat c = new Candidat();
		c.setEmail(email);
		c.setLogin(login);
		c.setPassword(pass);
		crep.saveAndFlush(c);
		return new ModelAndView("redirect:/index.html");
	}

	@RequestMapping(value = "/canformationsave", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView canFormationSave(HttpServletRequest request, @RequestParam("dated") String dated,
			@RequestParam("datef") String datef, @RequestParam("desc") String desc) {
		HttpSession session = request.getSession();
		Object o = session.getAttribute("me");
		if (o == null)
			return new ModelAndView("index");
		else {
			Candidat c = (Candidat) o;
			Formation f = new Formation();
			f.setDate_debut(dated);
			f.setDate_fin(datef);
			f.setDescription(desc);
			f.setCandidat(c);
			frep.saveAndFlush(f);
			c.addFormation(f);
			crep.saveAndFlush(c);
		}
		return new ModelAndView("redirect:/candidat_formation.html");
	}

	@RequestMapping(value = "/canexperiencesave", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView canExperienceSave(HttpServletRequest request, @RequestParam("dated") String dated,
			@RequestParam("datef") String datef, @RequestParam("desc") String desc) {
		HttpSession session = request.getSession();
		Object o = session.getAttribute("me");
		if (o == null)
			return new ModelAndView("index");
		else {
			Candidat c = (Candidat) o;
			Experience f = new Experience();
			f.setDate_debut(dated);
			f.setDate_fin(datef);
			f.setDescription(desc);
			f.setCandidat(c);
			erep.saveAndFlush(f);
			c.addExperience(f);
			crep.saveAndFlush(c);
			session.setAttribute("me", c);
		}
		return new ModelAndView("redirect:/candidat_experience.html");
	}

	@RequestMapping(value = "/cancompsave", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView canCompSave(HttpServletRequest request, @RequestParam("skill") String skill,
			@RequestParam("level") String level) {
		HttpSession session = request.getSession();
		Object o = session.getAttribute("me");
		if (o == null)
			return new ModelAndView("index");
		else {
			Candidat c = (Candidat) o;
			Competence co = corep.findByIntitule(skill);
			if (co == null)
				co = new Competence();
			co.setIntitule(skill);
			int tmp = (int) Math.random() * 100;
			co.setLevel(tmp);
			c.addCompetence(co);
			corep.save(co);
			crep.save(c);
			session.setAttribute("me", c);
		}
		return new ModelAndView("redirect:/candidat_competence.html");
	}

	@RequestMapping(value = "/canetatcivsave", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView canEtatcivSave(HttpServletRequest request, @RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, @RequestParam("email") String email, @RequestParam("tel") String tel,
			@RequestParam("adresse") String adresse, @RequestParam("date") String date,
			@RequestParam("nat") String nationalite, @RequestParam("sit") String situation,
			@RequestParam("titre") String titre, @RequestParam("bio") String bio) {
		HttpSession session = request.getSession();
		Long n = (nationalite != null) ? Long.valueOf(nationalite) : -1L;
		Long s = (situation != null) ? Long.valueOf(situation) : -1L;
		Object o = session.getAttribute("me");
		if (o == null)
			return new ModelAndView("index");
		else {
			Candidat c = (Candidat) o;
			c.setNom(nom);
			c.setPrenom(prenom);
			c.setEmail(email);
			c.setTel(tel);
			c.setAdresse(adresse);
			c.setDate_naissance(date);
			c.setBio(bio);
			c.setTitre(titre);
			c.setNationalite(nrep.findOne(n));
			c.setSituation_familiale(srep.findOne(s));
			crep.saveAndFlush(c);
			session.setAttribute("me", c);
		}
		return new ModelAndView("redirect:/candidat_etatcivil.html");
	}

	@RequestMapping(value = "/candidat-insc", method = RequestMethod.GET)
	public ModelAndView candidatInsc() {
		return new ModelAndView("redirect:/candidat_insc.html");
	}

	@RequestMapping(value = "/candidat_insc", method = RequestMethod.GET)
	public ModelAndView candidatInscP() {
		return new ModelAndView("candidat_insc");
	}

	@RequestMapping(value = "/candidat-etatcivil", method = RequestMethod.GET)
	public ModelAndView etatCivile() {
		return new ModelAndView("redirect:/candidat_etatcivil.html");
	}

	@RequestMapping(value = "/candidat_etatcivil", method = RequestMethod.GET)
	public ModelAndView etatCivileP() {
		return new ModelAndView("candidat_etatcivil");
	}

	@RequestMapping(value = "/candidat-formation", method = RequestMethod.GET)
	public ModelAndView candidatFormation() {
		return new ModelAndView("redirect:/candidat_formation.html");
	}

	@RequestMapping(value = "/candidat_formation", method = RequestMethod.GET)
	public ModelAndView candidatFormationP() {
		return new ModelAndView("candidat_formation");
	}

	@RequestMapping(value = "/candidat-experience", method = RequestMethod.GET)
	public ModelAndView candidatExperience() {
		return new ModelAndView("redirect:/candidat_experience.html");
	}

	@RequestMapping(value = "/candidat_experience", method = RequestMethod.GET)
	public ModelAndView candidatExperienceP() {
		return new ModelAndView("candidat_experience");
	}

	@RequestMapping(value = "/candidat-competence", method = RequestMethod.GET)
	public ModelAndView candidatCompetence() {
		return new ModelAndView("redirect:/candidat_competence.html");
	}

	@RequestMapping(value = "/candidat_competence", method = RequestMethod.GET)
	public ModelAndView candidatCompetenceP() {
		return new ModelAndView("candidat_competence");
	}

	@RequestMapping(value = "/refreshnats", method = RequestMethod.POST)
	@ResponseBody
	public String refreshNats(HttpServletRequest request) {
		String data = "<option value=0>Non definie</option>", tmp = "", sel = "";
		HttpSession session = request.getSession();
		Object o = session.getAttribute("me");
		if (o == null)
			new ModelAndView("index");
		else {
			Candidat c = (Candidat) o;
			Long cn;
			if (c.getNationalite() == null)
				cn = -1L;
			else
				cn = c.getNationalite().getId();
			List<Nationalite> nats = nrep.findAll();
			for (Nationalite n : nats) {
				if (n.getId() == cn)
					sel = "SELECTED";
				tmp = "<option value=" + n.getId() + " " + sel + ">" + n.getIntitule() + "</option>";
				data = data.concat(tmp);
				sel = "";
			}
		}
		return data;
	}

	@RequestMapping(value = "/refreshsits", method = RequestMethod.POST)
	@ResponseBody
	public String refreshSits(HttpServletRequest request) {
		String data = "<option value=0>Non definie</option>", tmp = "", sel = "";
		HttpSession session = request.getSession();
		Object o = session.getAttribute("me");
		if (o == null)
			new ModelAndView("index");
		else {
			Candidat c = (Candidat) o;
			Long sn;
			if (c.getSituation_familiale() == null)
				sn = -1L;
			else
				sn = c.getSituation_familiale().getId();
			List<SituationFamiliale> sits = srep.findAll();
			for (SituationFamiliale s : sits) {
				if (s.getId() == sn)
					sel = "SELECTED";
				tmp = "<option value=" + s.getId() + " " + sel + ">" + s.getIntitule() + "</option>";
				data = data.concat(tmp);
				sel = "";
			}
		}
		return data;
	}

}
