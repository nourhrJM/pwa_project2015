package com.rec.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rec.repositories.AdminRepo;

@Controller
public class AdminController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	AdminRepo adminRepo;

}
