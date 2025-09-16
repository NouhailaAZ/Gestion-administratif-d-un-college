package gestionAdministratifCollege;



public class Absence {
		private Eleve eleve ;
		private Cour cour ;
		private String justification ;
		
		public Absence(Eleve eleve, Cour cour, String justification)
		{
			this.eleve = eleve;
			this.cour = cour;
			this.justification = justification;
		}

		public String toString()
		{
			return eleve.getNom() + " " + eleve.getPrenom() + " " + cour.getNomCour() + " " + justification ;
		}
		
		public Eleve geteleve() {
			return eleve;
		}

		public void seteleve(Eleve eleve) {
			this.eleve = eleve;
		}

		public Cour getCour() {
			return cour;
		}

		public void setCour(Cour cour) {
			this.cour = cour;
		}

		public String getJustification() {
			return justification;
		}

		public void setJustification(String justification) {
			this.justification = justification;
		}
		
		

}
