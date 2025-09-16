package gestionAdministratifCollege;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class Classes extends JFrame {

	private JPanel contentPane;
	private JTextField Annee;
	private JTable table;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	SqlJava s = new SqlJava();

	/**
	 * Create the frame.
	 */
	public Classes() {
		
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.WHITE);
		setResizable(false);
		setTitle("Gestion administratif d'un college");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\Capture d\u2019\u00E9cran 2022-05-21 021306.png"));
		setBounds(100, 100, 1000, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Ann\u00E9e scolaire");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(20, 98, 131, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblClasse.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblClasse.setBounds(20, 161, 131, 33);
		contentPane.add(lblClasse);
		
		
		JComboBox classe = new JComboBox();
		classe.setFont(new Font("Tahoma", Font.BOLD, 11));
		classe.setBackground(Color.WHITE);
		classe.setModel(new DefaultComboBoxModel(new String[] {"3/1", "3/2", "3/3", "3/4", "4/1", "4/2", "4/3", "4/4", "5/1", "5/2", "5/3", "5/4", "6/1", "6/2", "6/3", "6/4", "6/5"}));
		classe.setBounds(202, 163, 143, 34);
		contentPane.add(classe);
		

		Annee = new JTextField();
		Annee.setBounds(205, 101, 140, 33);
		contentPane.add(Annee);
		Annee.setColumns(10);
		 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 0, 489, 461);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(new Color(204, 204, 255));
		model = new DefaultTableModel();
		
		JButton ButtonAfficher = new JButton("Classe");
		ButtonAfficher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ButtonAfficher.setBackground(Color.ORANGE);
		ButtonAfficher.setBounds(23, 252, 128, 34);
		contentPane.add(ButtonAfficher);
		
		ButtonAfficher.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					Object[] culumn = { "Nom" , "Prenom" , "Date de naissance"};
					final Object [] row = new Object[3];
					model.setColumnIdentifiers(culumn);
					table.setModel(model);
					scrollPane.setViewportView(table);
					DefaultTableModel dtm = (DefaultTableModel)table.getModel();
					dtm.setNumRows(0);
					
					if(Annee.getText().equals("") )
						JOptionPane.showMessageDialog(null , "Entrez une annee scolaire !!");
					else
					{
						String cl = (String) classe.getSelectedItem();
						ArrayList<Eleve> list = s.listeEleve(cl , Annee.getText()) ;
						if(list.size() != 0)
						{
							Iterator it = list.iterator();
	
							while(it.hasNext())
							{
								Eleve el = (Eleve) it.next();
								row[0] = el .getNom();
								row[1] = el.getPrenom();
								row[2] = el.getDateNaissance();
								model.addRow(row);
							}
							s.listeEleve(cl , Annee.getText()).clear();
							Annee.setText("");
						}
						else
							JOptionPane.showMessageDialog(null , "Cette annee scolaire n'existe pas !!");
					}
					
			}
		});
		
		
		JButton btnEmploi = new JButton("Emploi");
		btnEmploi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEmploi.setBackground(Color.ORANGE);
		btnEmploi.setBounds(292, 252, 128, 34);
		contentPane.add(btnEmploi);
		
		btnEmploi.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				Object[] culumn = { "Cour" , "Jour" , "Heure de debut" , "Heure de fin" , "Enseignant","salle"};
				final Object [] row = new Object[6];
				model.setColumnIdentifiers(culumn);
				table.setModel(model);
				scrollPane.setViewportView(table);
				DefaultTableModel dtm = (DefaultTableModel)table.getModel();
				dtm.setNumRows(0);
				if(Annee.getText().equals(""))
					JOptionPane.showMessageDialog(null , "Entrez une annee scolaire !!");
				else
				{
					String cl = (String) classe.getSelectedItem();
					ArrayList<Cour> empl = s.emploi(cl , Annee.getText()) ;
					
					if(empl.size() != 0)
					{
						Iterator it = empl.iterator();
						while(it.hasNext())
						{
							Cour el = (Cour)it.next();
							row[0] = el.getNomCour();
							row[1] = el.getJour();
							row[2] = el.getHeureDebut();
							row[3] = el.getHeureFin();
							row[4] = el.getProf().getNom();
							row[5] = el.getSalle().getNumeroSalle();
							model.addRow(row);
						}
						s.emploi(cl , Annee.getText()).clear();
						Annee.setText("");
					}
					else
						JOptionPane.showMessageDialog(null , "Cette annee scolaire n'existe pas !!");
				}
			}
		});
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFermer.setBackground(new Color(220, 20, 60));
		btnFermer.setBounds(315, 396, 128, 34);
		contentPane.add(btnFermer);
		
		btnFermer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\Diagramme de classes\\OIP (3).jfif"));
		lblNewLabel_1.setBounds(0, 0, 495, 441);
		contentPane.add(lblNewLabel_1);
	}
}

