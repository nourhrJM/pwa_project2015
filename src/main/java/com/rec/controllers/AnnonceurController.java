package com.rec.controllers;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rec.models.Annonceur;
import com.rec.models.Candidature;
import com.rec.models.Contrat;
import com.rec.models.Etat;
import com.rec.models.Mobilite;
import com.rec.models.Offre;
import com.rec.models.Salaire;
import com.rec.models.Secteur;
import com.rec.repositories.AnnonceurRepo;
import com.rec.repositories.CandidaturesRepo;
import com.rec.repositories.ContratRepo;
import com.rec.repositories.EtatRepo;
import com.rec.repositories.MobiliteRepo;
import com.rec.repositories.OffreRepo;
import com.rec.repositories.SalaireRepo;
import com.rec.repositories.SecteurRepo;

@Controller
public class AnnonceurController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	AnnonceurRepo annonceurRepo;
	@Autowired
	SecteurRepo secteurRepo;
	@Autowired
	SalaireRepo salaireRepo;
	@Autowired
	MobiliteRepo mobRepo;
	@Autowired
	ContratRepo contRepo;
	@Autowired
	OffreRepo offreRepo;
	@Autowired
	CandidaturesRepo candsRepo;
	@Autowired
	EtatRepo etatsRepo;

	@RequestMapping(value = "/annonceur", method = RequestMethod.GET)
	public ModelAndView annonceur(Model model, HttpServletRequest request) {
		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		Secteur sec = a.getSecteur();
		System.out.println("//" + a.getNom() + "//");
		List<Secteur> secteurs = new ArrayList<Secteur>();
		secteurs = secteurRepo.findAll();
		model.addAttribute("ann", a);
		model.addAttribute("sec_id", Long.toString(sec.getId()));
		model.addAttribute("secteurs", secteurs);
		System.out.println("__" + a.getEmail() + "___");
		System.out.println(sec.getId());
		return new ModelAndView("annonceurIndex");
	}

	@RequestMapping(value = "/annonceurProfil", method = RequestMethod.GET)
	public ModelAndView annonceurProfil(Model model, HttpServletRequest request) {
		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		Secteur sec = a.getSecteur();
		System.out.println("//" + a.getNom() + "//");
		List<Secteur> secteurs = new ArrayList<Secteur>();
		secteurs = secteurRepo.findAll();
		model.addAttribute("ann", a);
		model.addAttribute("sec_id", Long.toString(sec.getId()));
		model.addAttribute("secteurs", secteurs);
		System.out.println("__" + a.getEmail() + "___");
		System.out.println(sec.getId());
		return new ModelAndView("annonceurProfil");
	}

	@RequestMapping(value = "/annonceurProfil", method = RequestMethod.POST)
	public ModelAndView saveAnnonceur(@RequestParam("aID") String id, @RequestParam("aNom") String nom,
			@RequestParam("aEmail") String email, @RequestParam("aTel") String tel, @RequestParam("aPass") String pass,
			@RequestParam("aLogin") String login, @RequestParam("aSecteur") String sec, HttpServletRequest request) {
		// Annonceur a = annonceurRepo.findById(Long.parseLong(id));
		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		a.setEmail(email);
		a.setLogin(login);
		a.setNom(nom);
		a.setPassword(pass);
		a.setTel(tel);
		a.setSecteur((Secteur) secteurRepo.findById(Long.parseLong(sec)));
		annonceurRepo.saveAndFlush(a);
		System.out.println("****" + sec + "****");
		// request.getSession().removeAttribute("oAnnonceur");
		return new ModelAndView("redirect:/annonceurProfil.html");
	}

	@RequestMapping(value = "/annonceurNewOffre", method = RequestMethod.GET)
	public ModelAndView annonceurNewOffre(Model model, HttpServletRequest request) {
		SecureRandom random = new SecureRandom();
		String randomRef = new BigInteger(130, random).toString(32).substring(0, 5).toUpperCase();
		model.addAttribute("ref", randomRef);
		List<Salaire> salaires = new ArrayList<Salaire>();
		salaires = salaireRepo.findAll();
		model.addAttribute("salaires", salaires);
		List<Mobilite> mobs = new ArrayList<Mobilite>();
		mobs = mobRepo.findAll();
		model.addAttribute("mobs", mobs);
		List<Contrat> contrats = new ArrayList<Contrat>();
		contrats = contRepo.findAll();
		model.addAttribute("contrats", contrats);
		return new ModelAndView("annonceurNewOffre");
	}

	@RequestMapping(value = "/annonceurNewOffre", method = RequestMethod.POST)
	public ModelAndView saveNewOffre(@RequestParam("aID") String id, @RequestParam("aInt") String aInt,
			@RequestParam("aRef") String aRef, @RequestParam("aCont") String aCont, @RequestParam("aSal") String aSal,
			@RequestParam("aMob") String aMob, @RequestParam("desc") String desc, HttpServletRequest request) {
		System.out.println(aInt);
		System.out.println(aRef);
		System.out.println(aCont);
		System.out.println(aSal);
		System.out.println(aMob);
		System.out.println(desc);
		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		Contrat con = (Contrat) contRepo.findOne(Long.parseLong(aCont));
		Salaire sal = (Salaire) salaireRepo.findOne(Long.parseLong(aSal));
		Mobilite mob = (Mobilite) mobRepo.findOne(Long.parseLong(aMob));
		Offre off = new Offre();
		off.setAnnonceur(a);
		off.setContrat(con);
		off.setDescription(desc);
		off.setIntitule(aInt);
		off.setMobilite(mob);
		off.setReference(aRef);
		off.setSalaire(sal);
		offreRepo.save(off);
		/*
		 * List<Offre> offres = new ArrayList<Offre>(); offres =
		 * offreRepo.findAll(); for(Offre offf : offres) {
		 * System.out.println(offf.getId() + offf.getDescription()); }
		 * 
		 * 
		 * System.out.println("----" + con.getId() + "/" + con.getIntitule());
		 * System.out.println("----" + sal.getId() + "/" + sal.getIntitule());
		 * System.out.println("----" + mob.getId() + "/" + mob.getIntitule());
		 */
		return new ModelAndView("redirect:/annonceurOffres.html");
	}

	@RequestMapping(value = "/annonceurOffres", method = RequestMethod.GET)
	public ModelAndView annonceurOffres(Model model, HttpServletRequest request) {
		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		List<Offre> offres = new ArrayList<Offre>();
		offres = offreRepo.findByAnnonceur(a);
		Collections.reverse(offres);
		model.addAttribute("offres", offres);

		// offres = offreRepo.findAll(a);
		// for (Offre of : offres) {
		//
		// System.out.println(offf.getId() + offf.getDescription());
		// }
		//
		return new ModelAndView("annonceurOffres");
	}

	@RequestMapping(value = "/annonceurOffres", method = RequestMethod.POST)
	public ModelAndView annonceurRemoveOffre(@RequestParam("id") String idOffre, @RequestParam("supp") String supp,
			@RequestParam("affect") String affect, Model model, HttpServletRequest request) {
		if (supp.equals("1")) {
			Offre offre = offreRepo.findOne(Long.parseLong(idOffre));
			Set<Candidature> listCands = offre.getListCandidatures(); 
			candsRepo.delete(listCands);
			offreRepo.delete(Long.parseLong(idOffre));
		}
		if (affect.equals("1")) {
			Offre off = offreRepo.findOne(Long.parseLong(idOffre));
			if (off.getAffected() == 0) {
				off.setAffected(1);
			} else {
				off.setAffected(0);
			}

			offreRepo.saveAndFlush(off);
		}
		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		List<Offre> offres = new ArrayList<Offre>();
		offres = offreRepo.findByAnnonceur(a);
		Collections.reverse(offres);
		model.addAttribute("offres", offres);
		return new ModelAndView("annonceurOffres");
	}

	@RequestMapping(value = "/annonceurEditOffre", method = RequestMethod.GET)
	public ModelAndView annonceurEditOffre(@RequestParam("id") String idOffre, Model model,
			HttpServletRequest request) {
		System.out.println(idOffre);
		model.addAttribute("idOff", idOffre);
		Offre of = new Offre();
		of = offreRepo.findOne(Long.parseLong(idOffre));
		model.addAttribute("offre", of);
		List<Salaire> salaires = new ArrayList<Salaire>();
		salaires = salaireRepo.findAll();
		model.addAttribute("salaires", salaires);
		List<Mobilite> mobs = new ArrayList<Mobilite>();
		mobs = mobRepo.findAll();
		model.addAttribute("mobs", mobs);
		List<Contrat> contrats = new ArrayList<Contrat>();
		contrats = contRepo.findAll();
		model.addAttribute("contrats", contrats);

		// model.addAttribute("idOffre", idOffre);
		// List<Salaire> salaires = new ArrayList<Salaire>();
		// salaires = salaireRepo.findAll();
		// model.addAttribute("salaires", salaires);
		// List<Mobilite> mobs = new ArrayList<Mobilite>();
		// mobs = mobRepo.findAll();
		// model.addAttribute("mobs", mobs);
		// List<Contrat> contrats = new ArrayList<Contrat>();
		// contrats = contRepo.findAll();
		// model.addAttribute("contrats", contrats);
		//
		return new ModelAndView("annonceurEditOffre");
	}

	@RequestMapping(value = "/annonceurEditOffre", method = RequestMethod.POST)
	public ModelAndView saveEditOffre(@RequestParam("oID") String id, @RequestParam("aInt") String aInt,
			@RequestParam("aRef") String aRef, @RequestParam("aCont") String aCont, @RequestParam("aSal") String aSal,
			@RequestParam("aMob") String aMob, @RequestParam("desc") String desc, HttpServletRequest request) {
		System.out.println(aInt);
		System.out.println(aRef);
		System.out.println(aCont);
		System.out.println(aSal);
		System.out.println(aMob);
		System.out.println(desc);
		Offre off = (Offre) offreRepo.findOne(Long.parseLong(id));
		// Annonceur a = (Annonceur)
		// request.getSession().getAttribute("me");
		Contrat con = (Contrat) contRepo.findOne(Long.parseLong(aCont));
		Salaire sal = (Salaire) salaireRepo.findOne(Long.parseLong(aSal));
		Mobilite mob = (Mobilite) mobRepo.findOne(Long.parseLong(aMob));
		off.setContrat(con);
		off.setDescription(desc);
		off.setIntitule(aInt);
		off.setMobilite(mob);
		off.setSalaire(sal);
		offreRepo.saveAndFlush(off);
		/*
		 * List<Offre> offres = new ArrayList<Offre>(); offres =
		 * offreRepo.findAll(); for(Offre offf : offres) {
		 * System.out.println(offf.getId() + offf.getDescription()); }
		 * 
		 * 
		 * System.out.println("----" + con.getId() + "/" + con.getIntitule());
		 * System.out.println("----" + sal.getId() + "/" + sal.getIntitule());
		 * System.out.println("----" + mob.getId() + "/" + mob.getIntitule());
		 */
		return new ModelAndView("redirect:/annonceurOffres.html");
	}

	@RequestMapping(value = "/annonceurNewProfil", method = RequestMethod.GET)
	public ModelAndView annonceurNewProfil(Model model, HttpServletRequest request) {
		List<Secteur> secteurs = new ArrayList<Secteur>();
		secteurs = secteurRepo.findAll();
		model.addAttribute("secteurs", secteurs);
		return new ModelAndView("annonceurNewProfil");
	}

	@RequestMapping(value = "/annonceurNewProfil", method = RequestMethod.POST)
	public ModelAndView saveNewAnnonceur(@RequestParam("aNom") String nom, @RequestParam("aEmail") String email,
			@RequestParam("aTel") String tel, @RequestParam("aPass") String pass, @RequestParam("aLogin") String login,
			@RequestParam("aSecteur") String sec, HttpServletRequest request) {
		// Annonceur a = annonceurRepo.findById(Long.parseLong(id));
		Annonceur a = new Annonceur();
		a.setEmail(email);
		a.setLogin(login);
		a.setNom(nom);
		a.setPassword(pass);
		a.setTel(tel);
		a.setSecteur((Secteur) secteurRepo.findById(Long.parseLong(sec)));
		annonceurRepo.save(a);
		// System.out.println("****" + sec + "****");
		// request.getSession().removeAttribute("oAnnonceur");
		return new ModelAndView("redirect:/annonceurNewProfil.html");
	}

	@RequestMapping(value = "/annonceurCandidatures", method = RequestMethod.GET)
	public ModelAndView annonceurCandidatures(Model model, HttpServletRequest request) {
		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		List<Offre> offres = new ArrayList<Offre>();
		List<Candidature> cands = new ArrayList<Candidature>();
		List<Etat> etats = new ArrayList<Etat>();
		etats = etatsRepo.findAll();
		offres = offreRepo.findByAnnonceur(a);
		for (Offre off : offres) {
			Candidature c = new Candidature();
			c = (Candidature) candsRepo.findByOffre(off);
			// System.out.println(c.getCandidat().getNom());
			if (c != null && c.getOffre().getId() == off.getId()) {
				cands.add(c);
				// System.out.println(c.getCandidat().getNom());
			}
		}
		model.addAttribute("candidatures", cands);
		model.addAttribute("etats", etats);
		return new ModelAndView("annonceurCandidatures");
	}

	@RequestMapping(value = "/annonceurCandidatures", method = RequestMethod.POST)
	public ModelAndView annonceurModifCandidatures(@RequestParam("aEt") String etat, @RequestParam("cid") String cid,
			Model model, HttpServletRequest request) {
		Etat et = (Etat) etatsRepo.findOne(Long.parseLong(etat));
		Candidature cd = (Candidature) candsRepo.findOne(Long.parseLong(cid));
		cd.setEtat(et);
		candsRepo.saveAndFlush(cd);

		Annonceur a = (Annonceur) request.getSession().getAttribute("me");
		List<Offre> offres = new ArrayList<Offre>();
		List<Candidature> cands = new ArrayList<Candidature>();
		List<Etat> etats = new ArrayList<Etat>();
		etats = etatsRepo.findAll();
		offres = offreRepo.findByAnnonceur(a);
		for (Offre off : offres) {
			Candidature c = new Candidature();
			c = (Candidature) candsRepo.findByOffre(off);
			// System.out.println(c.getCandidat().getNom());
			if (c != null && c.getOffre().getId() == off.getId()) {
				cands.add(c);
				// System.out.println(c.getCandidat().getNom());
			}
		}
		model.addAttribute("candidatures", cands);
		model.addAttribute("etats", etats);
		return new ModelAndView("annonceurCandidatures");
	}
}
