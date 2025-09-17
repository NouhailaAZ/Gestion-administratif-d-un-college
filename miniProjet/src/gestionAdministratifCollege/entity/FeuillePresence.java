package gestionAdministratifCollege.entity;

import java.util.ArrayList;

public class FeuillePresence {
	private static int id = 1 ;
	private int idFeuille;
	private int numSemaine ;
	private String jour ;
	private int nmbAbsences ;
	private  ArrayList<Absence> absent ;
	Classe cl;
	
	public FeuillePresence(int numSemaine , String jour , int nmbAbsence) 
	{
		
		this.idFeuille = id++;
		this.nmbAbsences = nmbAbsence;
		this.numSemaine = numSemaine ;
		this.jour = jour ;
		this.absent = new ArrayList<Absence>();
	}
	public String toString() 
		{
			return "la feuille " + idFeuille + " , numSemaine " + numSemaine + " ,jour " + jour 
					+", nmbabsences :" + nmbAbsences + " " + absent;
		}
	public void ajouterabsent(Absence e)
	{
		absent.add(e);
	}
	
	public void suprimerabsent(Eleve e)
	{
		absent.remove(e);
	}
	public int getIdFeuille() {
		return idFeuille;
	}
	public void setIdFeuille(int idFeuille) {
		this.idFeuille = idFeuille ;
	}
	public ArrayList<Absence> geteleves() {
		return absent;
	}
	public void seteleves(ArrayList<Absence> absent) {
		this.absent = absent;
	}
	
	
}
