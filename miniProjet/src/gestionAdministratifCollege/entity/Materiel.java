package gestionAdministratifCollege.entity;


public class Materiel {
	private int matricule;
	private String nomMateriel;
	private Salle salle;

	public Materiel(int matricule ,String nomMateriel, Salle salle) 
	{
		this.matricule = matricule;
		this.nomMateriel = nomMateriel;
		this.salle = salle;
	}

	public String toString() {
	return "Materiel :" + matricule  + " ," + nomMateriel + salle.getNumeroSalle() ;
	}

	public int getIdMateriel() {
		return matricule;
	}

	public void setIdMateriel(int matricule) {
		this.matricule = matricule;
	}

	public String getNomMateriel() {
		return nomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	
	
}
