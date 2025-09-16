package gestionAdministratifCollege;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;





public class SqlJava {
	
	Connection conn = ConnexionSql.getConnection();
	
	
	public ArrayList<Eleve> list = new ArrayList<Eleve>();
	int i = 1 ;
	public ArrayList<Eleve> listeEleve(String classe , String anneeScolaire)
	{
		Classe cl = null;
		int id = 0;
		try{
		  	PreparedStatement ps = conn.prepareStatement("select niveau , nombre_eleve , Id_classe from classe where classe = ? and Annee = ? ;");
		  	ps.setString(1,classe);
			ps.setString(2, anneeScolaire);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cl = new Classe(rs.getInt(1), rs.getInt(2));
				id = rs.getInt(3);
			}
		  }
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			
			PreparedStatement ps = conn.prepareStatement("select nom , prenom , date_naissance from"
					+ "   classe C , eleve E where C.classe like ? and C.Annee like ? and E.id_classe = ? ");
			ps.setString(1,classe);
			ps.setString(2, anneeScolaire);
			ps.setInt(3, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Eleve(rs.getString(1), rs.getString(2), rs.getString(3), cl));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<Cour> emploi(String classe , String anneeScolaire)
	{
		ArrayList<Cour> c = new ArrayList<Cour>();
		Classe cl = null;
		int id = 0;
		try{
		  	PreparedStatement ps = conn.prepareStatement("select niveau , nombre_eleve , Id_classe from classe where classe = ? and Annee = ? ;");
		  	ps.setString(1,classe);
			ps.setString(2, anneeScolaire);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cl = new Classe(rs.getInt(1), rs.getInt(2));
				id = rs.getInt(3);
			}
		  }
		catch (SQLException e) {
			System.out.println("1 " +e.getMessage());
		}
		Enseignant ens = null;
		Salle sl = null ;
		try
		{
			PreparedStatement ps = conn.prepareStatement("select nom_cour ,jour , heureDebut , heureFin , E.nom , C.NumSalle from "
					+ "cour C , classe cl , enseignant E where c.id_classe = cl.Id_classe and C.id_classe = ? "
					+ "and cl.Annee like ? and C.id_enseignant = E.id_enseignant;");
			ps.setInt(1, id);
			ps.setString(2, anneeScolaire);
			ResultSet rs1 , rs2 , rs;
			rs = ps.executeQuery();
			while(rs.next())
			{
				PreparedStatement ps1 = conn.prepareStatement("select * from enseignant where nom = ?;");
				ps1.setString(1, rs.getString(5));
				rs1 = ps1.executeQuery();
				while(rs1.next())
					 ens = new Enseignant(rs1.getString(2), rs1.getString(3) , rs1.getString(4) , rs1.getString(5) , rs1.getString(6), rs1.getString(7));
				
				
				PreparedStatement ps2 = conn.prepareStatement("select * from salle where NumSalle = ?;");
				ps2.setInt(1, rs.getInt(6));
				rs2 = ps2.executeQuery();
				while(rs2.next())
					sl = new Salle(rs2.getInt(1), rs2.getString(2), rs2.getInt(3));
				
				
				c.add(new Cour(rs.getString(1) ,rs.getString(2),rs.getTime(3) , rs.getTime(4), ens ,cl , sl));
			}
		}
		catch(SQLException e)
		{
			System.out.println("2 " +e.getMessage());
		}
		return c;
	}
	
	public void ajouterCours(String n,String j,Time td,Time tf,String classe,int ide,int nums,String annee) 
	{
				String monco;
				int numeros = 0;
				int idens = 0,idc,idclasse ;

				try {


				PreparedStatement ps1 =conn.prepareStatement("select id_classe from Classe where classe like ? and Annee like ?");
				ps1.setString(1,classe);
				ps1.setString(2,annee);

				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				idc=rs1.getInt(1);System.out.println("idc="+idc);
				//if classe a un autre cour
				PreparedStatement psac =conn.prepareStatement("select id_classe from Classe where  id_classe  not in "+
				"( select CL.id_classe from Classe CL ,cour C where CL.id_classe=C.id_classe and C.jour like ? "
				+ " and C.heureDebut = ?) and  id_classe=?");
				psac.setString(1, j);
				psac.setTime(2, td);
				psac.setInt(3, idc);
				ResultSet rsac=psac.executeQuery();

				idclasse=0;
				while(rsac.next()) {
				idclasse=rsac.getInt(1);idc=rs1.getInt(1);
				System.out.println("idclasse :"+ idclasse);}
				if(idclasse==0) {
				System.out.println("la classe : deja a un autre cour");}



				//if la salle est vide
				numeros=0;
				PreparedStatement psal = conn.prepareStatement("select * from salle where NumSalle not in ( select S.NumSalle from salle S ,"+
				" cour C where S.NumSalle = C.NumSalle and C.jour like ? "+
				" and C.heureDebut = ?) and NumSalle = ?;");
				psal.setString(1, j);
				psal.setTime(2, td);
				psal.setInt(3, nums);
				ResultSet rsal = psal.executeQuery();
				while(rsal.next()){
				numeros=rsal.getInt(1);
				System.out.println("numeros="+numeros);}
				if(numeros==0)
				System.out.println("la salle : est plain");

				//if ensig a un autre cour
				idens=0;
				PreparedStatement psens = conn.prepareStatement("select * from enseignant where id_enseignant  not in ( select E.id_enseignant  from enseignant E ,"+
				" cour C where E.id_enseignant = C.id_enseignant and C.jour like ? "+
				" and C.heureDebut = ?) and id_enseignant =?;");
				psens.setString(1, j);
				psens.setTime(2, td);
				psal.setInt(3, ide);
				ResultSet rsens = psal.executeQuery();
				while(rsens.next()){
				  idens=rsens.getInt(1);
				  System.out.println("idens="+idens);}
				if(idens==0) {
				System.out.println("l Ensignant: a un autre classe en cour");}

				if(idclasse!=0 && idens!=0 && numeros!=0) {
				PreparedStatement pst =conn.prepareStatement("INSERT INTO `cour` ( `nom_cour`, `jour`, `heureDebut`, `heureFin`, `id_classe`, `id_enseignant`, `NumSalle`) VALUES(?,?,?,?,?,?,?)");
				//pst.setInt(1,id);
				pst.setString(1,n);
				pst.setString(2,j);
				pst.setTime(3,td);
				pst.setTime(4,tf);
				pst.setInt(5,idclasse);//
				pst.setInt(6,idens);
				pst.setInt(7,numeros);
				pst.executeUpdate();
				System.out.println("ajou est bien fait");}
				else
				{System.out.println("sisair des information correcte");}
				}catch(Exception e) {
				System.out.println("Exception :"+e);
				}	
	
	}
	
	public void supprimerEleve(int id_eleve) {
		try {// DELETE FROM eleve
		PreparedStatement pst =conn.prepareStatement("DELETE FROM eleve WHERE numero_eleve =?");
		pst.setInt(1, id_eleve);

		pst.executeUpdate();
		} catch (Exception e) {
		System.out.println("echec de la requete"+e);

		}
		}
	
	public void supprimerEnseignant(int id) {

		try {
		PreparedStatement pst =conn.prepareStatement("DELETE FROM enseignant WHERE id_enseignant =?");
		pst.setInt(1, id);

		pst.executeUpdate();
		} catch (Exception e) {
		System.out.println("echec de la requete"+e);

		}
		}
	
	

	public void addEnseignant(Enseignant c) {

		try {
		PreparedStatement pst =conn.prepareStatement("INSERT INTO `enseignant` ( `nom`, `prenom`, `DateNaissance`, `CIN`, `email`, `telephone`) VALUES (?,?,?,?,?,?)");
		// pst.setInt(1, c.getId());
		pst.setString(1, c.getNom() );
		pst.setString(2,c.getPrenom());
		pst.setString(3, c.getDateNaissance());
		pst.setString(4, c.getCin());
		pst.setString(5,c.getMail());
		pst.setString(6, c.getTelephone());


		pst.executeUpdate();

		System.out.println("succer de la requete");
		} catch (Exception e) {
		System.out.println("echec de la requete"+e);

		}

		}
	
	public void supprimerSalle(int Num) {

		try {
		PreparedStatement pst =conn.prepareStatement("DELETE FROM salle WHERE NumSalle =?");
		pst.setInt(1, Num);

		pst.executeUpdate();

		System.out.println("succer de la requete");
		} catch (Exception e) {
		System.out.println("echec de la requete"+e);

		}
		}
		
	public void addSalle(Salle sal) {

		try {
		PreparedStatement pst =conn.prepareStatement("INSERT INTO Salle (NumSalle,type,capacite) VALUES (?,?,?)");
		pst.setInt(1, sal.getNumeroSalle());
		pst.setString(2, sal.getType());
		pst.setInt(3, sal.getCapacite());


		pst.executeUpdate();

		System.out.println("succer de la requete");
		} catch (Exception e) {
		System.out.println("echec de la requete"+e);

		}

		}
	
	
}
