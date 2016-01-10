package com.rec.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rec.beans.FormationBean;
import com.rec.models.Formation;
import com.rec.models.RH;
import com.rec.repositories.AnnonceurRepo;
import com.rec.repositories.CandidatRepo;
import com.rec.repositories.FormationRepo;
import com.rec.repositories.OffreRepo;
import com.rec.repositories.RHRepo;

@Controller
public class RHController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	RHRepo rhRepo;

	@Autowired
	OffreRepo offreRepo;

	@Autowired
	CandidatRepo candRepo;

	@Autowired
	FormationRepo forRepo;

	@Autowired
	AnnonceurRepo annRepo;

	@RequestMapping(value = "/RH_offres.html", method = RequestMethod.GET)
	public ModelAndView listOffres() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("offres", offreRepo.findAll());

		return new ModelAndView("RH_RH", model);
	}

	@RequestMapping(value = "/RH_offre.html", method = RequestMethod.GET)
	public ModelAndView goPage(@RequestParam("idParametre") String idParametre) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("offress", offreRepo.findByintitule(idParametre));

		return new ModelAndView("RH_offre", model);
	}

	@RequestMapping(value = "/RH_candidat.html", method = RequestMethod.GET)
	public ModelAndView listCandidats() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidats", candRepo.findAll());

		return new ModelAndView("RH_Candidat", model);
	}

	@RequestMapping(value = "/RH_entreprise.html", method = RequestMethod.GET)
	public ModelAndView listEntreprises() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("entreprises", annRepo.findAll());

		return new ModelAndView("RH_Entreprise", model);
	}

	@RequestMapping(value = "/RH_rh", method = RequestMethod.GET)
	public ModelAndView RH(@ModelAttribute("oRH") RH a, Model model, final RedirectAttributes redirectAttrs1) {
		System.out.println("//" + a.getNom() + "//");
		// List<Secteur> secteurs = new ArrayList<Secteur>();
		// secteurs = secteurRepo.findAll();
		model.addAttribute("rh", a);
		// model.addAttribute("secteurs", secteurs);
		redirectAttrs1.addFlashAttribute("oRH1", a);
		return new ModelAndView("RH_AccueilRH");
	}

	@RequestMapping(value = "/RH_candid.html", method = RequestMethod.GET)
	public ModelAndView afficherFormatin(@RequestParam("idParametre") String idParametre, FormationBean formationBean) {
		// Long id = Long.valueOf(idParametre);
		// Candidat a = candRepo.getOne(1L);
		// ArrayList<Formation> f = (ArrayList<Formation>) a.getFormations();
		// for (Formation x : f) {
		// System.out.println(x.getId());
		// }
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("formation", prepareEmployeeBean(forRepo.findOne(formationBean.getCandidat().getId())));
		model.put("formation", prepareListofBean(forRepo.findAll()));
		return new ModelAndView("RH_DetailCandidats", model);
	}

	private List<FormationBean> prepareListofBean(List<Formation> formations) {
		List<FormationBean> beans = null;
		if (formations != null && !formations.isEmpty()) {
			beans = new ArrayList<FormationBean>();
			FormationBean bean = null;
			for (Formation formation : formations) {
				bean = new FormationBean();
				bean.getCandidat().getNom();
				bean.getDate_debut();
				bean.getDate_fin();
				bean.getDescription();
				beans.add(bean);
			}
		}
		return beans;

	}

	private FormationBean prepareEmployeeBean(Formation formation) {
		FormationBean bean = new FormationBean();
		bean = new FormationBean();
		bean.getCandidat().getNom();
		bean.getDate_debut();
		bean.getDate_fin();
		bean.getDescription();
		return bean;
	}
	/*
	 * @RequestMapping(value = "candid.html", method = RequestMethod.GET) public
	 * ModelAndView titi(@RequestParam("idParametre")Integer idParametre){
	 * 
	 * Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("formations", forRepo.findBycandidat_id(idParametre));
	 * 
	 * return new ModelAndView("DetailCandidats", model); }
	 */
}

/*
 * public ModelAndView toto(@RequestParam("idParametre")String idParametre) {
 * 
 * Map<String, Object> model = new HashMap<String, Object>();
 * model.put("offress", offreRepo.findByintitule(idParametre)); return new
 * ModelAndView("offre", model); }} /*private List<OffreBean>
 * prepareListofBean(List<Offre> offres) { List<OffreBean> beans = null; if
 * (offres != null && !offres.isEmpty()) { beans = new ArrayList<OffreBean>();
 * OffreBean bean = null; for (Offre offre : offres) { bean = new OffreBean();
 * 
 * bean.setId(offre.getId()); bean.setIntitule(offre.getIntitule());
 * bean.setReference(offre.getReference());;
 * bean.setDescription(offre.getDescription()); beans.add(bean); } } return
 * beans; }
 */
