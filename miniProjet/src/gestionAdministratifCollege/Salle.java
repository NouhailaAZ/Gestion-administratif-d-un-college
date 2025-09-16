package gestionAdministratifCollege;

import java.util.ArrayList;

public class Salle {
	  private int numeroSalle;
	  private String type;
	  private int capacite;
	  private ArrayList<Cour>  cour;
	  private ArrayList<Materiel>  materiels;

	  
	  public Salle( int numeroSalle , String type, int capacite) 
	  {
		  	this.numeroSalle = numeroSalle ;
			this.type = type;
			this.capacite = capacite;
			this.cour = new ArrayList<Cour>();
			this.materiels = new ArrayList<Materiel>();
	}


	  public void afficher()
	  {
		  System.out.print(toString() + " les cours [ ");
		  for(Cour c : cour )
		  {
			  System.out.print( c.toString() + " ,");
		  }
		  System.out.print(" ] ; les materiels : [ ");
		  for( Materiel m : materiels)
		  {
			  System.out.print( m.toString() + " ,");
		  }
		  System.out.println(" ] ");
	  }
	  
	public String toString() 
	{
	  return numeroSalle + " : salle de " + type + " ,capacite : " + capacite ;
	  }

	  public void ajouterCour(Cour cou)
	  {
		  cour.add(cou);
	  }
	  
	  public void supprimerCour(Cour cou)
	  {
		  cour.remove(cou);
	  }
	  
	  
	  public void ajouterMateriel(Materiel mat)
	  {
		  materiels.add(mat);
	  }
	  
	  public void supprimerMateriel(Materiel mat)
	  {
		  materiels.remove(mat);
	  }
	  

	public int getNumeroSalle() {
		return numeroSalle;
	}


	public void setNumeroSalle(int numeroSalle) {
		this.numeroSalle = numeroSalle;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getCapacite() {
		return capacite;
	}


	public void setCapacite(int capacite) {
		capacite = capacite;
	}


	public ArrayList<Cour> getCour() {
		return cour;
	}


	public void setCour(ArrayList<Cour> cour) {
		this.cour = cour;
	}


	public ArrayList<Materiel> getMateriels() {
		return materiels;
	}


	public void setMateriels(ArrayList<Materiel> materiels) {
		this.materiels = materiels;
	}

}
