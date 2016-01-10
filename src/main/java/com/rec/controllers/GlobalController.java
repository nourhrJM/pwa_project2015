package com.rec.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rec.beans.EmployeeBean;
import com.rec.models.Admin;
import com.rec.models.Annonceur;
import com.rec.models.Candidat;
import com.rec.models.Employee;
import com.rec.models.RH;
import com.rec.repositories.AdminRepo;
import com.rec.repositories.AnnonceurRepo;
import com.rec.repositories.CandidatRepo;
import com.rec.repositories.EmployeeRepo;
import com.rec.repositories.OffreRepo;
import com.rec.repositories.RHRepo;

@Controller
public class GlobalController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	CandidatRepo candidatRepo;

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	AnnonceurRepo annonceurRepo;

	@Autowired
	RHRepo rhRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	OffreRepo orepo;

	@RequestMapping(value = "/2929/login", method = RequestMethod.POST)
	public ModelAndView haythoum(@RequestParam("login") String login, @RequestParam("pass") String pass,
			final RedirectAttributes redirectAttrs, HttpServletRequest request) {
		Candidat c = candidatRepo.findByLoginAndPassword(login, pass);
		Annonceur a = annonceurRepo.findByLoginAndPassword(login, pass);
		RH r = rhRepo.findByLoginAndPassword(login, pass);
		Admin ad = adminRepo.findByLoginAndPassword(login, pass);
		String location;
		if (c != null) {
			System.out.println("candidat");
			location = "candidat";
			redirectAttrs.addFlashAttribute("oCandidat", c);
		} else if (a != null) {
			System.out.println("annonceur");
			location = "annonceur";
			// redirectAttrs.addFlashAttribute("oAnnonceur", a);
			request.getSession().setAttribute("oAnnonceur", a);
		} else if (r != null) {
			System.out.println("rh");
			location = "rh";
			redirectAttrs.addFlashAttribute("oRH", r);
		} else if (ad != null) {
			System.out.println("admin");
			location = "admin";
			redirectAttrs.addFlashAttribute("oAdmin", ad);
		} else
			location = "index";
		System.out.println("location = " + location);
		return new ModelAndView("redirect:/" + location + ".html");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, @RequestParam("login") String login,
			@RequestParam("pass") String pass) {
		HttpSession session = request.getSession();
		Candidat candidat = candidatRepo.findByLoginAndPassword(login, pass);
		Annonceur annonceur = annonceurRepo.findByLoginAndPassword(login, pass);
		RH rh = rhRepo.findByLoginAndPassword(login, pass);
		Admin admin = adminRepo.findByLoginAndPassword(login, pass);
		if (candidat != null) {
			session.setAttribute("me", candidat);
			return new ModelAndView("redirect:/candidat_dash.html");
		} else if (annonceur != null) {
			// haytham
			// init session annonceur
			// redirection vers dashboard annonceur
			session.setAttribute("me", annonceur);
			return new ModelAndView("redirect:/annonceur.html");
		} else if (rh != null) {
			// yassin
			// init session rh
			// redirection vers dashboard rh
			return new ModelAndView("redirect:/RH_AccueilRH.html");
		} else if (admin != null) {
			// nour ?
			// init session admin
			// redirection vers dashboard admin
			return new ModelAndView("redirect:/dash_admin.html");
		} else {
			// redirect vers page login avec affichage erreur
			return new ModelAndView("redirect:/index.html");
		}
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexG(HttpSession session) {
		Object o = session.getAttribute("me");
		if (o != null) {
			if (o instanceof Candidat) {
				return new ModelAndView("candidat_dash");
			}
		}
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
	public ModelAndView deconnexion(HttpSession session) {
		session.invalidate();
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/candidat_dash", method = RequestMethod.GET)
	public ModelAndView candidat_dash(HttpSession session) {
		int num = orepo.findAll().size();
		session.setAttribute("num", num);
		return new ModelAndView("candidat_dash");
	}

	@RequestMapping(value = "/dash_annonceur", method = RequestMethod.GET)
	public ModelAndView dash_annonceur() {
		return new ModelAndView("dash_annonceur");
	}

	@RequestMapping(value = "/RH_AccueilRH", method = RequestMethod.GET)
	public ModelAndView dash_rh() {
		return new ModelAndView("RH_AccueilRH");
	}

	@RequestMapping(value = "/dash_admin", method = RequestMethod.GET)
	public ModelAndView dash_admin() {
		return new ModelAndView("dash_admin");
	}
	
	
	@RequestMapping(value = "/authentification", method = RequestMethod.GET)
	public ModelAndView auth() {
		return new ModelAndView("authentification");
	}

	// gestion des erreurs
	@RequestMapping(value = "/400")
	public ModelAndView error400() {
		return new ModelAndView("400");
	}

	@RequestMapping(value = "/403")
	public ModelAndView error403() {
		return new ModelAndView("403");
	}

	@RequestMapping(value = "/404")
	public ModelAndView error404() {
		return new ModelAndView("404");
	}

	@RequestMapping(value = "/500")
	public ModelAndView error500() {
		return new ModelAndView("500");
	}

	@RequestMapping(value = "/503")
	public ModelAndView error503() {
		return new ModelAndView("503");
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Junk code
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Employee employee = prepareModel(employeeBean);
		employeeRepo.saveAndFlush(employee);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", prepareListofBean(employeeRepo.findAll()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", prepareListofBean(employeeRepo.findAll()));
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		employeeRepo.delete(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees", prepareListofBean(employeeRepo.findAll()));
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeRepo.findOne(employeeBean.getId())));
		model.put("employees", prepareListofBean(employeeRepo.findAll()));
		return new ModelAndView("addEmployee", model);
	}

	private Employee prepareModel(EmployeeBean employeeBean) {
		Employee employee = new Employee();
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpName(employeeBean.getName());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}

	private List<EmployeeBean> prepareListofBean(List<Employee> employees) {
		List<EmployeeBean> beans = null;
		if (employees != null && !employees.isEmpty()) {
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for (Employee employee : employees) {
				bean = new EmployeeBean();
				bean.setName(employee.getEmpName());
				bean.setId(employee.getEmpId());
				bean.setAddress(employee.getEmpAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getEmpAge());
				beans.add(bean);
			}
		}
		return beans;
	}

	private EmployeeBean prepareEmployeeBean(Employee employee) {
		EmployeeBean bean = new EmployeeBean();
		bean.setAddress(employee.getEmpAddress());
		bean.setAge(employee.getEmpAge());
		bean.setName(employee.getEmpName());
		bean.setSalary(employee.getSalary());
		bean.setId(employee.getEmpId());
		return bean;
	}

}
