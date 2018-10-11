package fr.ousmane.spring.ui.model;

import java.io.Serializable;

public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomRue;

	private Integer codePostal;

	private String commune;

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

}
