package com.rec.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Langue implements Serializable {
	private static final long serialVersionUID = -2907975979351738552L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String intitule;

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Long getId() {
		return Id;
	}

}
