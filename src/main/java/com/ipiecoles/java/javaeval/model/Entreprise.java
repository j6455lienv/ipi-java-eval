package com.ipiecoles.java.javaeval.model;

import org.joda.time.LocalDate;
import java.util.List;

public final class Entreprise {

	private String nom;
	private List<Employe> employes;

	public Entreprise(String nom, List<Employe> employes) {
		this.nom = nom;
		this.employes = employes;
	}

	public static final Double SALAIRE_BASE = 1480.27;
	public static final Integer NB_CONGES_BASE = 25;
	public static final Integer NB_RTT_BASE = 12;
	public static final Double INDICE_MANAGER = 1.3;
	public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250d;
	public static final Double PRIME_ANCIENNETE = 100d;
	
	public static Double primeAnnuelleBase() {
		return LocalDate.now().getYear() * 0.5;
	}

}
