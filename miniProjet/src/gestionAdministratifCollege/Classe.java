package gestionAdministratifCollege;

import java.util.ArrayList;


public class Classe {
	 private String classe ;
	  private static int niv3 = 1 ,niv4 = 1 , niv5 = 1 , niv6 = 1;
	  private int niveau;
	  private int nombreEleve;
	  private int nmb = 0;
	  private ArrayList<Cour>  cours;
	  private ArrayList<Eleve>  listeEleves;
	  private ArrayList<FeuillePresence>  liste;
	  
	  public Classe( int niveau, int nombreEleve) 
	  {
		  if((niveau == 3))
			  {
				  if(niv3 >  5)
					  System.out.println("vous deppacez (5) le nombre de niveau " + niveau);
				  else
					  this.classe = niveau + "/" + niv3++;
			  }
			  
		  if((niveau == 4))
		  {
			  if(niv4 >  4)
				  System.out.println("vous deppacez (4) le nombre de niveau " + niveau);
			  else
				  this.classe = niveau + "/" + niv4++;
		  }
		  
		  if((niveau == 5))
		  {
			  if(niv5 >  4)
				  System.out.println("vous deppacez (4) le nombre de niveau " + niveau);
			  else
				  this.classe = niveau + "/" + niv5++;
		  }
		  
		  if((niveau == 6))
		  {
			  if(niv6 >  4)
				  System.out.println("vous deppacez (4) le nombre de niveau " + niveau);
			  else
				  this.classe = niveau + "/" + niv6++;
		  }
		this.niveau = niveau ;
		this.nombreEleve = nombreEleve;	
		this.cours = new ArrayList<Cour>();
		this.listeEleves = new ArrayList<Eleve>();
	  }
	
	  public void ajouterCour(Cour cour)
	  {
		  cours.add(cour);
	  }
	  
	  public void supprimerCour(Cour cour)
	  {
		  cours.remove(cour);
	  }
	  
	 
	  
	  public void ajouterEleve(Eleve elv)
	  {
		  if(++nmb <= nombreEleve)
			  listeEleves.add(elv);
		  else 
			  System.out.println(" Vous deppacez le nombre des eleves " + nombreEleve);
	  }
	  
	  public void supprimerEleve(Eleve elv)
	  {
		  if(nmb == 0)
			  System.out.println("La classe est vide vous ne pouvez pas supprimer");
		  else
		  {
			  listeEleves.remove(elv);
			  nmb--;
		  }
	  }
	  
	  public void afficheClasse()
	  {
		  System.out.println("CLASSE ---- >   " + getClasse()+ "\nId  nom  prenom  ");
		  System.out.println(listeEleves);
	  }
	  
	  public String toString() {
	  return classe + " " + listeEleves ;
	  }
	
	  
	
	public ArrayList<FeuillePresence> getListe() {
		return liste;
	}

	public void setListe(ArrayList<FeuillePresence> liste) {
		this.liste = liste;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getNombreEleve() {
		return nombreEleve;
	}
	
	public void setNombreEleve(int nombreEleve) {
		this.nombreEleve = nombreEleve;
	}
	
	public ArrayList<Cour> getCours() {
		return cours;
	}
	
	public void setCours(ArrayList<Cour> cours) {
		this.cours = cours;
	}
	
	public ArrayList<Eleve> getListeEleves() {
		return listeEleves;
	}
	
	public void setListeEleves(ArrayList<Eleve> listeEleves) {
		this.listeEleves = listeEleves;
	}

}
