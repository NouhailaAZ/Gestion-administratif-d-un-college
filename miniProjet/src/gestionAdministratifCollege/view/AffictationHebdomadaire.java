package gestionAdministratifCollege.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gestionAdministratifCollege.dao.ConnexionSql;
import gestionAdministratifCollege.dao.SqlJava;



public class AffictationHebdomadaire extends JFrame {

		private JPanel contentPane;
		private JTextField textNomCour;
		private JTextField textjour;
		private JTextField texthd;
		private JTextField texthf;
		private JTextField textClasse;
		private JTextField textensig;
		private JTextField textNUMS;
		private JTextField textAnnesco;


		SqlJava sj =new  SqlJava();
		Connection conn = ConnexionSql.getConnection();

		/**
		* Create the frame.
		*/
		public AffictationHebdomadaire() {
			setResizable(false);
			setTitle("Gestion administratif d'un college");
			setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\Capture d\u2019\u00E9cran 2022-05-21 021306.png"));
			setBounds(100, 100, 459, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cour");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(55, 11, 93, 21);
		contentPane.add(lblNewLabel);

		JLabel lblJour = new JLabel("Jour");
		lblJour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJour.setHorizontalAlignment(SwingConstants.LEFT);
		lblJour.setBounds(55, 43, 93, 21);
		contentPane.add(lblJour);

		JLabel lblHd = new JLabel("Heure d\u00E9but");
		lblHd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHd.setBounds(55, 72, 93, 21);
		contentPane.add(lblHd);

		JLabel lblHf_1 = new JLabel("Heure de fin");
		lblHf_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHf_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHf_1.setBounds(55, 104, 93, 21);
		contentPane.add(lblHf_1);

		JLabel lblHf = new JLabel("Classe");
		lblHf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHf.setHorizontalAlignment(SwingConstants.LEFT);
		lblHf.setBounds(55, 136, 93, 21);
		contentPane.add(lblHf);

		JLabel lblEnsig = new JLabel("Enseignant");
		lblEnsig.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnsig.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnsig.setBounds(55, 171, 93, 21);
		contentPane.add(lblEnsig);

		JLabel lblNumsa = new JLabel("Salle");
		lblNumsa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumsa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumsa.setBounds(55, 203, 93, 21);
		contentPane.add(lblNumsa);

		JLabel lblHd_4_1 = new JLabel("Ann\u00E9e scolaire");
		lblHd_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHd_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHd_4_1.setBounds(60, 235, 126, 21);
		contentPane.add(lblHd_4_1);

		textNomCour = new JTextField();
		textNomCour.setBounds(245, 13, 106, 20);
		contentPane.add(textNomCour);
		textNomCour.setColumns(10);

		textjour = new JTextField();
		textjour.setColumns(10);
		textjour.setBounds(245, 45, 106, 20);
		contentPane.add(textjour);

		texthd = new JTextField();
		texthd.setColumns(10);
		texthd.setBounds(245, 74, 106, 20);
		contentPane.add(texthd);

		texthf = new JTextField();
		texthf.setColumns(10);
		texthf.setBounds(245, 106, 106, 20);
		contentPane.add(texthf);

		textClasse = new JTextField();
		textClasse.setColumns(10);
		textClasse.setBounds(245, 138, 106, 20);
		contentPane.add(textClasse);

		textensig = new JTextField();
		textensig.setColumns(10);
		textensig.setBounds(245, 170, 106, 20);
		contentPane.add(textensig);

		textNUMS = new JTextField();
		textNUMS.setColumns(10);
		textNUMS.setBounds(245, 201, 106, 20);
		contentPane.add(textNUMS);

		textAnnesco = new JTextField();
		textAnnesco.setColumns(10);
		textAnnesco.setBounds(245, 231, 106, 20);
		contentPane.add(textAnnesco);

		JButton btnNewButton = new JButton("Affectation");
		btnNewButton.setBounds(310, 292, 106, 29);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e) 
				{

					if(textNomCour.getText().equals("")||textjour.getText().equals("")|| texthd.getText().equals("")|| texthf.getText().equals("")||textClasse.getText().equals("")||textensig.getText().equals("")||textNUMS.getText().equals("")||textAnnesco.getText().equals(""))
						JOptionPane.showMessageDialog(null, "ENTREZ TOUS LES CHAMPS");
					else {
							try 
							{
								int numeros = 0;
								int idens = 0,idc,idclasse ;
		
						
								PreparedStatement ps1 =conn.prepareStatement("select id_classe from Classe where classe like ? and Annee like ?");
								ps1.setString(1,textClasse.getText());
								ps1.setString(2,textAnnesco.getText());
		
								ResultSet rs1=ps1.executeQuery();
								rs1.next();
								idc=rs1.getInt(1);System.out.println("idc="+idc);
								PreparedStatement psac =conn.prepareStatement("select id_classe from Classe where  id_classe  not in "+
								"( select CL.id_classe from Classe CL ,cour C where CL.id_classe=C.id_classe and C.jour like ? "
								+ " and C.heureDebut = ?) and  id_classe=?");
								psac.setString(1, textjour.getText());
								psac.setTime(2, Time.valueOf(texthd.getText()));
								psac.setInt(3, idc);
								ResultSet rsac=psac.executeQuery();
		
								idclasse=0;
								while(rsac.next()) 
								{
									idclasse=rsac.getInt(1);idc=rs1.getInt(1);
								}
								if(idclasse==0)
								{
		
									JOptionPane.showMessageDialog(null,"la classe : deja a un autre cour","CONFERMER",JOptionPane.INFORMATION_MESSAGE);
								}
		
								else 
								{
		
									//if la salle est vide
									numeros=0;
									PreparedStatement psal = conn.prepareStatement("select * from salle where NumSalle not in ( select S.NumSalle from salle S ,"+
									" cour C where S.NumSalle = C.NumSalle and C.jour like ? "+
									" and C.heureDebut = ?) and NumSalle = ?;");
									psal.setString(1, textjour.getText());
									psal.setTime(2, Time.valueOf(texthd.getText()));
									psal.setInt(3, Integer.parseInt(textNUMS.getText()));
									ResultSet rsal = psal.executeQuery();
									while(rsal.next())
									{
										numeros=rsal.getInt(1);
										System.out.println("numeros="+numeros);
									}
									if(numeros==0)
											JOptionPane.showMessageDialog(null,"la salle : est plain","CONFERMER",JOptionPane.INFORMATION_MESSAGE);
									else 
									{
										//if ens n'a pas de cour
										idens=0;
										PreparedStatement psens = conn.prepareStatement("select * from enseignant where id_enseignant  not in ( select E.id_enseignant  from enseignant E ,"+
										" cour C where E.id_enseignant = C.id_enseignant and C.jour like ? "+
										" and C.heureDebut = ?) and id_enseignant =?;");
										psens.setString(1, textjour.getText());
										psens.setTime(2, Time.valueOf(texthd.getText()));
										psal.setInt(3, Integer.parseInt(textensig.getText()));
										ResultSet rsens = psal.executeQuery();
										while(rsens.next())
										{
											idens=rsens.getInt(1);
										}
										if(idens==0) 
										{
				
											JOptionPane.showMessageDialog(null,"l Ensignant: a un autre classe en cour","CONFERMER",JOptionPane.INFORMATION_MESSAGE);
										}
										else
											//pas de cour pr la classe
										if(idclasse!=0 && idens!=0 && numeros!=0) 
										{
											PreparedStatement pst =conn.prepareStatement("INSERT INTO `cour` ( `nom_cour`, `jour`, `heureDebut`, `heureFin`, `id_classe`, `id_enseignant`, `NumSalle`) VALUES(?,?,?,?,?,?,?)");
											pst.setString(1,textNomCour.getText());
											pst.setString(2,textjour.getText());
											pst.setTime(3,Time.valueOf(texthd.getText()));
											pst.setTime(4,Time.valueOf(texthf.getText()));
											pst.setInt(5,idclasse);//
											pst.setInt(6,idens);
											pst.setInt(7,numeros);
											pst.executeUpdate();
					
											JOptionPane.showMessageDialog(null,"le cour est affecter a la salle","CONFERMER",JOptionPane.INFORMATION_MESSAGE);
										}
										else
										{
											JOptionPane.showMessageDialog(null,"sisair des information correcte","CONFERMER",JOptionPane.INFORMATION_MESSAGE);
										}
									}
								}		
		
							}
							catch(Exception ex) {
						System.out.println("Exception :"+ex);
						}
						textNomCour.setText(""); textjour.setText(""); texthd.setText(""); texthf.setText("");textClasse.setText("");textensig.setText("");textNUMS.setText("");textAnnesco.setText("");
						dispose();
					}
					}});
	
			
			
			}
		}
