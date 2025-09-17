package gestionAdministratifCollege.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import gestionAdministratifCollege.dao.ConnexionSql;
import gestionAdministratifCollege.dao.SqlJava;




public class Absences extends JFrame {

	private JPanel contentPane;
	private JTextField numSem;
	private JTable table;
	DefaultTableModel model;
	private JTextField annee;
	Connection conn = ConnexionSql.getConnection();

	/**
	 * Create the frame.
	 */
	public Absences() {
		setResizable(false);
		setTitle("Gestion administratif d'un college");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\20220514_182048.jpg"));		
		setBounds(100, 100, 1000, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Num\u00E9ro de la semaine");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 110, 188, 33);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblJour = new JLabel("Jour");
		lblJour.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJour.setBounds(24, 66, 115, 33);
		contentPane.add(lblJour);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClasse.setBounds(24, 154, 159, 33);
		contentPane.add(lblClasse);
		
		JLabel lblAnneScolaire = new JLabel("Ann\u00E9e scolaire");
		lblAnneScolaire.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnneScolaire.setBounds(24, 22, 159, 33);
		contentPane.add(lblAnneScolaire);
		
		numSem = new JTextField();
		numSem.setBounds(222, 112, 115, 33);
		contentPane.add(numSem);
		numSem.setColumns(10);
		
		annee = new JTextField();
		annee.setColumns(10);
		annee.setBounds(222, 24, 115, 33);
		contentPane.add(annee);
		
		JComboBox jour = new JComboBox();
		jour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jour.setModel(new DefaultComboBoxModel(new String[] {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi"}));
		jour.setBounds(222, 66, 115, 33);
		contentPane.add(jour);
		
		JComboBox classe = new JComboBox();
		classe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		classe.setModel(new DefaultComboBoxModel(new String[] {"3/1", "3/2", "3/3", "3/4", "4/1", "4/2", "4/3", "4/4", "5/1", "5/2", "5/3", "5/4", "6/1", "6/2", "6/3", "6/4", "6/5"}));
		classe.setBounds(222, 154, 115, 33);
		contentPane.add(classe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 0, 523, 461);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(new Color(204, 204, 255));
		model = new DefaultTableModel();
		Object[] culumn = { "Numero d'eleve" , "Nom" , "Prenom" , "Cour" , "Justification"};
		final Object [] row = new Object[5];
		model.setColumnIdentifiers(culumn);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Afficher les absents");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(243, 293, 187, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel dtm = (DefaultTableModel)table.getModel();
				dtm.setNumRows(0);
				if(numSem.getText().equals("") ||  annee.getText().equals(""))
					JOptionPane.showMessageDialog(null , "Entrez les champs Annee scolaire , Numero de semaine ... !!");
				else
				{
					
					String cl = (String)classe.getSelectedItem();
					String j = (String)jour.getSelectedItem();
						try
						{
							PreparedStatement ps = conn.prepareStatement("select E.numero_eleve , E.nom , E.prenom , C.nom_cour , V.justification from"
									+ " feuille_presence F , viescolaire V , eleve E , cour C , classe cl where cl.classe like ? "
									+ "and F.numSemaine = ? and F.jour like ? and cl.Annee like ? and f.Annee = cl.Annee "
									+ "and E.numero_eleve = V.numero_eleve and E.id_classe = cl.Id_classe and V.id_feuille = F.id_feuille  and V.id_cour = C.id_cour;");
							ps.setString(1, cl);
							ps.setInt(2, Integer.parseInt(numSem.getText()));
							ps.setString(3, j);
							ps.setString(4, annee.getText());
							ResultSet rs = ps.executeQuery();
							//if(rs.next())
							{
								while(rs.next())
								{
									row[0] = rs.getString(1);
									row[1] = rs.getString(2);
									row[2] = rs.getString(3);
									row[3] = rs.getString(4);
									row[4] = rs.getString(5);
									
									model.addRow(row);
								}
							}
							//else
						//JOptionPane.showMessageDialog(null , "il n'existe pas cette semaine !!");
				
						}
						catch(SQLException o)
						{
							o.printStackTrace();
						}
						
						numSem.setText(""); annee.setText("");
					
					
					}
					}
			
		});
		
		
		
		JButton btnAjouterUnAbsent = new JButton("Ajouter un absent");
		btnAjouterUnAbsent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAjouterUnAbsent.setBackground(Color.ORANGE);
		btnAjouterUnAbsent.setBounds(10, 293, 212, 33);
		contentPane.add(btnAjouterUnAbsent);
		
		btnAjouterUnAbsent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String j = (String)jour.getSelectedItem();
				
				if(numSem.getText().equals("") ||  annee.getText().equals(""))
					JOptionPane.showMessageDialog(null , "Entrez les champs Annee scolaire , Numero de semaine ... ");
				else
				{ 
					int IdF = 0 , IdCl = 0,idc = 0;
					String num =JOptionPane.showInputDialog("Entrez le numero d'eleve : ",JOptionPane.QUESTION_MESSAGE);
					 if(num!=null) 
					 {
						 String nom =JOptionPane.showInputDialog("Entrez le nom d'eleve : ",JOptionPane.QUESTION_MESSAGE);
						 if(nom!=null) 
						 {
							 String prenom =JOptionPane.showInputDialog("Entrez le prenom d'eleve : ",JOptionPane.QUESTION_MESSAGE);
							 if(prenom!=null) 
							 {
								 String cour =JOptionPane.showInputDialog("Entrez le nom du cour : ",JOptionPane.QUESTION_MESSAGE);
								 if(cour!=null) 
								 {
									 String justification =JOptionPane.showInputDialog("Entrez la justification d'eleve : ",JOptionPane.QUESTION_MESSAGE);
									 if(justification!=null) 
									 {
										
										try {
												PreparedStatement ps = conn.prepareStatement("select id_classe , id_cour from cour where nom_cour like ? and jour like ? ;");
												ps.setString(1, cour);
												ps.setString(2, j);
												ResultSet rs = ps.executeQuery();
												while(rs.next())
												{
													IdCl = rs.getInt(1);
													idc = rs.getInt(2);
												}
											}
										catch (SQLException e1) 
										{
											e1.printStackTrace();
										}
										
										try 
										{	
												PreparedStatement ps = conn.prepareStatement("select id_feuille from feuille_presence where Annee like ? and jour like ? and numSemaine = ? and id_classe = ?;");
												ps.setString(1, annee.getText());
												ps.setString(2, j);
												ps.setInt(3, Integer.parseInt(numSem.getText()));
												ps.setInt(3, IdCl);
												ResultSet rs = ps.executeQuery();
												while(rs.next())
												{
													IdF = rs.getInt(1);
												}
										} 
										catch (SQLException e1)
										{
											e1.printStackTrace();
										}
										
										 try 
										 {
												PreparedStatement ps = conn.prepareStatement("INSERT INTO `viescolaire` (`id_feuille`, `id_cour`, `numero_eleve`, `justification`) VALUES (?,?,?,?);");
												ps.setInt(1, IdF);
												ps.setInt(2, idc);
												ps.setInt(3, Integer.parseInt(num));
												ps.setString(4, justification);
												ps.executeUpdate();
												JOptionPane.showMessageDialog(null , "L'absent a ajoute ");
	
												PreparedStatement ps1 = conn.prepareStatement("update feuille_presence set nmbAbsence = (select count(id_feuille) from viescolaire where id_feuille = ?)"
														+ " where id_feuille = ?;");
												ps1.setInt(1, IdF);
												ps1.setInt(2, IdF);
												ps1.executeUpdate();
										 } 
										 catch (SQLException e1)
										 {
											 System.out.println(e1.getMessage());
										 }
									 }
								 }
							 }
						 }
					 }
				}
					
			} 
				
				
			
		});
		
		JButton btnfeuille = new JButton("Creation d'une feuille de presence");
		btnfeuille.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnfeuille.setBackground(Color.ORANGE);
		btnfeuille.setBounds(83, 353, 305, 34);
		contentPane.add(btnfeuille);
		
		btnfeuille.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//JOptionPane.showMessageDialog(null , "S'il vous plait entrez les champs Annee scolaire , Numero de semaine et Jour");	
				if(numSem.getText().equals("") ||  annee.getText().equals(""))
					JOptionPane.showMessageDialog(null , "Entrez les champs Annee scolaire , Numero de semaine et Jour !!");
				else
				{
					String j = (String)jour.getSelectedItem();
					 try 
					 {
						 PreparedStatement ps1 = conn.prepareStatement("select id_classe  from classe where Annee like ? ;");
							ps1.setString(1, annee.getText());
							ResultSet rs1 = ps1.executeQuery();
							
						 
							PreparedStatement ps = conn.prepareStatement("INSERT INTO feuille_presence (Id_classe , Annee , numSemaine , jour , nmbAbsence) VALUES (?,?,?,?,0);");
							while(rs1.next())
								ps.setInt(1,rs1.getInt(1));
							ps.setString(2, annee.getText());
							ps.setInt(3, Integer.parseInt(numSem.getText()));
							ps.setString(4, j);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null , "L'affeuille a ajoute ");
	
					 } 
					 catch (SQLException e1)
					 {
						 System.out.println(e1.getMessage());
					 }
					 numSem.setText(""); annee.setText("");
				}
			}
		});
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFermer.setBackground(new Color(255, 0, 0));
		btnFermer.setBounds(332, 416, 128, 34);
		contentPane.add(btnFermer);
		
		btnFermer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\Diagramme de classes\\R.gif"));
		lblNewLabel_1.setBounds(110, 0, 212, 438);
		contentPane.add(lblNewLabel_1);
		
	}
}
