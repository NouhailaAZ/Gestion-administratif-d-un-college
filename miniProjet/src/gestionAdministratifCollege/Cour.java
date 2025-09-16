package gestionAdministratifCollege;

import java.sql.Time;

public class Cour {
	private String nomCour;
	private Time heureDebut;
	private Time heureFin;
	private String jour ;
	private Enseignant prof;
	private Classe classe;
	private Salle salle;
	
	

  public Cour(String nomCour, String jour ,Time heureDebut, Time heureFin, Enseignant prof, Classe classe,
			Salle salle) 
  {
	  	this.jour = jour ;
		this.nomCour = nomCour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.prof = prof;
		this.classe = classe;
		this.salle = salle;
	}
  
public String toString() {
  return nomCour + " : " + jour + " " + heureDebut + "h, Mr" + prof.getNom() 
  + "dans la salle " + salle.getNumeroSalle() ;
  }





public String getJour() {
	return jour;
}


public void setJour(String jour) {
	this.jour = jour;
}


public String getNomCour() {
	return nomCour;
}


public void setNomCour(String nomCour) {
	this.nomCour = nomCour;
}


public Time getHeureDebut() {
	return heureDebut;
}


public void setHeureDebut(Time heureDebut) {
	this.heureDebut = heureDebut;
}


public Time getHeureFin() {
	return heureFin;
}


public void setHeureFin(Time heureFin) {
	this.heureFin = heureFin;
}


public Enseignant getProf() {
	return prof;
}


public void setProf(Enseignant prof) {
	this.prof = prof;
}


public Classe getClasse() {
	return classe;
}


public void setClasse(Classe classe) {
	this.classe = classe;
}


public Salle getSalle() {
	return salle;
}


public void setSalle(Salle salle) {
	this.salle = salle;
}

}
