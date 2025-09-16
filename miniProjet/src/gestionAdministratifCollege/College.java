package gestionAdministratifCollege;

public class College {
	private String nom;
	  private Salle [] listeSalle;
	  private Classe [] tabClasses;

	  public College(String nom) 
	  {
		this.nom = nom;
		this.listeSalle = new Salle[20];
		this.tabClasses = new Classe[17];
	  }

	public String toString() {
	  return nom + " ---> nombre des salles " + listeSalle.length + " nombre des classes " + tabClasses.length ;
	  }

	public Salle[] getListeSalle() {
		return listeSalle;
	}

	public void setListeSalle(Salle[] listeSalle) {
		this.listeSalle = listeSalle;
	}

	public Classe[] getTabClasses() {
		return tabClasses;
	}

	public void setTabClasses(Classe[] tabClasses) {
		this.tabClasses = tabClasses;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
