package gestionAdministratifCollege;



public class AnneeScolaire {
	private String anneeScolaire;
	private Classe [] classes;
	int t = 0;
	public AnneeScolaire(String anneeScolaire) 
	{
		this.anneeScolaire = anneeScolaire;
		this.classes = new Classe[17];
	}

	public void ajouterClasse(Classe classe)
	{
		if(t < classes.length)
		{
			classes[t] = classe ;
			t++;
		}
	}
	
	
	public String toString() {
	  return anneeScolaire  ; 
	  }

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public Classe[] getClasses() {
		return classes;
	}

	public void setClasses(Classe[] classes) {
		this.classes = classes;
	}
}
