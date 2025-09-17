package gestionAdministratifCollege.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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


public class Eleves extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField date_naissance;
	private JTextField Class;
	private JTextField AnneeS;
	private JTextField DateInscription;
	private JTextField telephone_pere;
	private JTextField tele_meres;
    private JTable table_1;
	DefaultTableModel model;

    SqlJava sj = new SqlJava();
	ConnexionSql conn= new ConnexionSql();
	
	/**
	 * Create the frame.
	 */
	public Eleves() {
		setResizable(false);
		setTitle("Gestion administratif d'un college");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\Capture d\u2019\u00E9cran 2022-05-21 021306.png"));
		setBounds(100, 100, 1000, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 11, 103, 30);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
        nom = new JTextField();
		nom.setBounds(188, 13, 114, 30);
		contentPane.add(nom);
		nom.setColumns(10);
				
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(10, 63, 103, 30);
		contentPane.add(lblPrnom);
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		prenom = new JTextField();
		prenom.setBounds(188, 63, 114, 30);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date de naissance");
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(10, 111, 150, 30);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		date_naissance = new JTextField();
		date_naissance.setBounds(188, 113, 114, 30);
		contentPane.add(date_naissance);
		date_naissance.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Classe");
		lblNewLabel_2_2.setBounds(10, 152, 103, 30);
		contentPane.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		Class = new JTextField();
		Class.setBounds(188, 153, 114, 30);
		contentPane.add(Class);
		Class.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Class.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Ann\u00E9e scolaire");
		lblNewLabel_2_2_1.setBounds(10, 200, 129, 30);
		contentPane.add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		AnneeS = new JTextField();
		AnneeS.setBounds(188, 194, 114, 30);
		contentPane.add(AnneeS);
		AnneeS.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date d'inscription");
		lblNewLabel_2.setBounds(10, 241, 135, 30);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		DateInscription = new JTextField();
		DateInscription.setBounds(188, 235, 114, 30);
		contentPane.add(DateInscription);
		DateInscription.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("T\u00E9l\u00E9.p\u00E8re");
		lblNewLabel_3.setBounds(10, 289, 123, 35);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));

		telephone_pere = new JTextField();
		telephone_pere.setBounds(188, 289, 114, 30);
		contentPane.add(telephone_pere);
		telephone_pere.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("T\u00E9l\u00E9.m\u00E8re");
		lblNewLabel_3_1.setBounds(10, 335, 123, 35);
		contentPane.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		tele_meres = new JTextField();
		tele_meres.setBounds(188, 330, 114, 30);
		contentPane.add(tele_meres);
		tele_meres.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(489, 20, 460, 121);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(SystemColor.activeCaption);
		model =new DefaultTableModel();
		Object[] column= {"numero_eleve"," nom","prenom","Classe"};
		final Object[] row= new Object[4];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
            
        JButton btnNewButton = new JButton("Supprimer un \u00E9l\u00E8ve");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(707, 307, 212, 48);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
		
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try 
					{
						String id =JOptionPane.showInputDialog("Entrez l'id d'eleve ",JOptionPane.QUESTION_MESSAGE);
						if(id != null)
						{
							int res=	JOptionPane.showConfirmDialog(null, "VOULEZ VOUS SUPPRIMER", "SUPPRIMER", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							if(res== JOptionPane.YES_OPTION) 
							{
								sj.supprimerEleve(Integer.parseInt(id));
								JOptionPane.showMessageDialog(null,"Eleve a Supprime","SUPPRIMER",JOptionPane.INFORMATION_MESSAGE);
							}
							else 
								JOptionPane.showMessageDialog(null,"Eleve n'a pas Supprime","SUPPRIMER",JOptionPane.WARNING_MESSAGE);
						}
					}catch(Exception z)
					{
						System.out.println("exception  :"+z);
					}
				}
			});
			
			JButton btnNewButton_3 = new JButton("Chercher sur un \u00E9l\u00E8ve");
			btnNewButton_3.setBackground(Color.ORANGE);
			btnNewButton_3.setBounds(707, 248, 212, 48);
			contentPane.add(btnNewButton_3);
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			btnNewButton_3.addActionListener(new ActionListener() 
			{
				 public void actionPerformed(ActionEvent e) 
				 {
					DefaultTableModel dtm = (DefaultTableModel)table_1.getModel();
					dtm.setNumRows(0);
		       		try 
		       		{
		       			String id =JOptionPane.showInputDialog("Entrez l'id d'eleve ",JOptionPane.QUESTION_MESSAGE);
		       			if(id != null)
						{
		       				String sql= "select numero_eleve,nom,prenom,Classe from eleve,classe where eleve.id_classe=classe.id_classe and  numero_eleve=?";
		       		        PreparedStatement pst =conn.getConnection().prepareStatement(sql);
		       		        int p = Integer.parseInt(id);
						    pst.setInt(1,p);
						    ResultSet rs = pst.executeQuery();
						    while(rs.next())
						    {
						    		row[0]=rs.getInt(1);
						    		row[1]=rs.getString(2);
						    		row[2]=rs.getString(3);
						    		row[3]=rs.getString(4);
						    		model.addRow(row);
						    }
						}
		              }
		       		catch(Exception z) 
		       		{
		            	System.out.println("Exception :"+z);
		       		}
						
				}
			});
			
			JButton btnNewButton_1 = new JButton("Modifier les information ");
			btnNewButton_1.setBackground(Color.ORANGE);
			btnNewButton_1.setBounds(707, 193, 212, 44);
			contentPane.add(btnNewButton_1);
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
		     btnNewButton_1.addActionListener(new ActionListener()
		     {  
		    	 public void actionPerformed(ActionEvent e) 
		    	 {
		    		
		    	 	String sql="update eleve set nom=?,prenom= ?,date_naissance= ?,id_Classe= ?,date_inscription=?,telephone_pere= ?,telephone_mere=? where numero_eleve= ?";
						
					 if((nom.getText().equals(""))||(prenom.getText().equals(""))||(date_naissance.getText().equals(""))||(Class.getText().equals(""))||(AnneeS.getText().equals(""))||(DateInscription.getText().equals(""))||(telephone_pere.getText().equals(""))||(tele_meres.getText().equals(""))) {
						 JOptionPane.showMessageDialog(null,"Saisiez tous les champs  ");}
					else
					{
							int i=0;
							try{
								
									PreparedStatement ps =conn.getConnection().prepareStatement("select Id_classe from classe where Classe=? and Annee=?" );
									ps.setString(1, Class.getText());
									ps.setString(2,AnneeS.getText());
									ResultSet rs=ps.executeQuery();
									while(rs.next()) 
									{
										i=rs.getInt(1);
									}
								
							}
							catch( Exception P) 
							{
								System.out.println("Exception1  "+P);
							}
							try 
							{
									String id =JOptionPane.showInputDialog("Entrez l'id d'eleve  ",JOptionPane.QUESTION_MESSAGE);
									if(id != null)
									{
											int res=JOptionPane.showConfirmDialog(null, "VOULEZ VOUS MODIFIER", "Modifier", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								       		PreparedStatement pst =conn.getConnection().prepareStatement(sql); 
											int p = Integer.parseInt(id);
									       	pst.setInt(8,p);
									    	pst.setString(1,nom.getText().toString());
										  	pst.setString(2, prenom.getText().toString());
										  	pst.setString(3, date_naissance.getText().toString());
										  	pst.setInt(4, i);
										  	pst.setString(5, DateInscription.getText().toString());
										  	pst.setString(6, telephone_pere.getText().toString());
										  	pst.setString(7, tele_meres.getText().toString());
										  	pst.executeUpdate();
							  	
											if((nom.getText().equals(""))||(prenom.getText().equals(""))||(date_naissance.getText().equals(""))
													||(Class.getText().equals(""))||(AnneeS.getText().equals(""))||(DateInscription.getText().equals(""))
													||(telephone_pere.getText().equals(""))||(tele_meres.getText().equals("")))
													 	
														JOptionPane.showMessageDialog(null,"Saisiez tous les champs  ");
														  	 
											else {
											            JOptionPane.showMessageDialog(null,"Eleve a Modifie");
											      }
									}
				 
						  		
						}    
						catch(Exception p) 
						{
							JOptionPane.showMessageDialog(null,"Eleve n'est pas Modifier");
						}
						
							 
						nom.setText("");	prenom.setText("");	date_naissance.setText("");	Class.setText("");	AnneeS.setText(""); DateInscription.setText("");
						 telephone_pere.setText("");	tele_meres.setText("");  
							
					}
					
				} 
				
			});
		
		JButton btnNewButton_2 = new JButton("Ajouter un \u00E9l\u00E8ve");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(59, 391, 163, 44);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					String sql=	"INSERT INTO eleve(nom,prenom,date_naissance,id_classe,date_inscription,telephone_pere,telephone_mere) VALUES (?,?,?,?,?,?,?)";
					
					 if((nom.getText().equals(""))||(prenom.getText().equals(""))||(date_naissance.getText().equals(""))||(Class.getText().equals(""))||(AnneeS.getText().equals(""))||(DateInscription.getText().equals(""))||(telephone_pere.getText().equals(""))||(tele_meres.getText().equals(""))) {
			  			  
			 	  		 
					  	 JOptionPane.showMessageDialog(null,"Saisiez tous les champs  ");}
					 else 
					 {
						int i=0;
						try
						{
							PreparedStatement ps =conn.getConnection().prepareStatement("select Id_classe from classe where classe=? and Annee=?   " );
							
							ps.setString(1, Class.getText());
							ps.setString(2,AnneeS.getText());
							ResultSet rs=ps.executeQuery();
							while(rs.next())
								i=rs.getInt(1);
							
						} 
						catch( Exception P) 
						{
							System.out.println("Exception1"+P);
						}
						try 
						{
							PreparedStatement pst =conn.getConnection().prepareStatement(sql); 
							pst.setString(1,nom.getText().toString());
					  		pst.setString(2, prenom.getText().toString());
					  		pst.setString(3, date_naissance.getText().toString());
					  		pst.setInt(4, i);
					  		pst.setString(5, DateInscription.getText().toString());
					  		pst.setString(6, telephone_pere.getText().toString());
					  		pst.setString(7, tele_meres.getText().toString());
					  		pst.executeUpdate();
					  		JOptionPane.showMessageDialog(null,"Eleve a Ajouter");
						}    
						catch(Exception o)
						{
							JOptionPane.showMessageDialog(null,"utilisateur n'est pas Ajouter");
						}
					
					    nom.setText("");	prenom.setText("");	date_naissance.setText("");	Class.setText("");	AnneeS.setText(""); DateInscription.setText("");
					     telephone_pere.setText("");	tele_meres.setText("");   
					 }	
					
			}
		});
		JButton btnNewButton_1_1 = new JButton("Fermer");
		btnNewButton_1_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(814, 396, 103, 34);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\Diagramme de classes\\OIP (1).jfif"));
		lblNewLabel_1.setBounds(261, 66, 478, 364);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		}
	}
