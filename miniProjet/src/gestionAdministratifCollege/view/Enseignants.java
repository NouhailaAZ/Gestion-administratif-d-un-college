package gestionAdministratifCollege.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
import gestionAdministratifCollege.entity.Enseignant;


public class Enseignants extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textDateDeNaissence;
	private JTextField textCIN;
	private JTextField textMail;
	private JTextField textTelephone;
	
	/**
	* Launch the application.
	*/
	SqlJava  c = new SqlJava ();
	Connection conn = ConnexionSql.getConnection();
	
	private JTable table;
	DefaultTableModel model;
	
	/**
	* Create the frame.
	*/
	public Enseignants() {
		
	setResizable(false);
	setTitle("Gestion administratif d'un college");
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\Capture d\u2019\u00E9cran 2022-05-21 021306.png"));
	setBounds(100, 100, 1000, 500);
	
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	JLabel lblNom = new JLabel("Nom");
	lblNom.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNom.setBounds(32, 23, 131, 22);
	contentPane.add(lblNom);
	
	JLabel lblPrnom = new JLabel("Pr\u00E9nom");
	lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblPrnom.setBounds(32, 64, 131, 22);
	contentPane.add(lblPrnom);
	
	JLabel lblDateDeNaissence = new JLabel("Date de naissence");
	lblDateDeNaissence.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblDateDeNaissence.setBounds(32, 105, 152, 22);
	contentPane.add(lblDateDeNaissence);
	
	JLabel lblCin = new JLabel("CIN");
	lblCin.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblCin.setBounds(32, 145, 152, 22);
	contentPane.add(lblCin);
	
	JLabel lblEmail = new JLabel("Email");
	lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblEmail.setBounds(32, 185, 152, 22);
	contentPane.add(lblEmail);
	
	JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone");
	lblTlphone.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblTlphone.setBounds(32, 226, 152, 22);
	contentPane.add(lblTlphone);
	
	textNom = new JTextField();
	textNom.setColumns(10);
	textNom.setBounds(208, 21, 134, 30);
	contentPane.add(textNom);
	
	textPrenom = new JTextField();
	textPrenom.setColumns(10);
	textPrenom.setBounds(208, 62, 134, 30);
	contentPane.add(textPrenom);
	
	textDateDeNaissence = new JTextField();
	textDateDeNaissence.setColumns(10);
	textDateDeNaissence.setBounds(208, 103, 134, 30);
	contentPane.add(textDateDeNaissence);
	
	textCIN = new JTextField();
	textCIN.setColumns(10);
	textCIN.setBounds(208, 144, 134, 28);
	contentPane.add(textCIN);
	
	textMail = new JTextField();
	textMail.setColumns(10);
	textMail.setBounds(208, 183, 134, 30);
	contentPane.add(textMail);
	
	textTelephone = new JTextField();
	textTelephone.setColumns(10);
	textTelephone.setBounds(208, 224, 134, 30);
	contentPane.add(textTelephone);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(510, 0, 474, 461);
	contentPane.add(scrollPane);
	
	table = new JTable();
	table.setFont(new Font("Tahoma", Font.BOLD, 15));
	table.setBackground(new Color(204, 204, 255));
	model=new DefaultTableModel();
	
	JButton btnNewButton_1 = new JButton("Supprimer enseignant");
	btnNewButton_1.setBackground(Color.ORANGE);
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnNewButton_1.setBounds(35, 306, 262, 34);
	contentPane.add(btnNewButton_1);
	
	btnNewButton_1.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			
			try {
					String id =JOptionPane.showInputDialog("Entrez l'id de l'enseignant : ",JOptionPane.QUESTION_MESSAGE);
					if(id != null)
					{
						int res=JOptionPane.showConfirmDialog(null,"VOULEZ VOUS SUPPRIMER","SUPPRIMER", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null);
						
						if(res==JOptionPane.YES_OPTION) {
							c.supprimerEnseignant(Integer.parseInt(id));
							JOptionPane.showMessageDialog(null,"Enseignant est supprimer","CONFERMER",JOptionPane.INFORMATION_MESSAGE);}
						else
						
						JOptionPane.showMessageDialog(null,"Enseignant n'est pas supprimer","CONFERMER",JOptionPane.WARNING_MESSAGE );
					}
			
				}catch(Exception ex) 
			{
				System.out.println("exception :"+ex);
			}
		}
	});
	
	
	
	JButton btnNewButton_1_2 = new JButton("Ajouter un enseignant");
	btnNewButton_1_2.setBackground(Color.ORANGE);
	btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnNewButton_1_2.setBounds(61, 265, 199, 30);
	contentPane.add(btnNewButton_1_2);
	
	btnNewButton_1_2.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(textNom.getText().equals("")||textPrenom.getText().equals("")|| textDateDeNaissence.getText().equals("")||textCIN .getText().equals("") ||textMail.getText().equals("") || textTelephone.getText().equals(""))
					JOptionPane.showMessageDialog(null , "Entrez tous les champs !!");
			else
			{
				try 
				{
					int res= JOptionPane.showConfirmDialog(null,"VOULEZ_VOUS AJOUTER","AJOUTER", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null);
					
					if(res==JOptionPane.YES_OPTION) 
					{
						Enseignant en=new Enseignant(textNom.getText(),textPrenom.getText(),textCIN .getText(), textDateDeNaissence.getText() ,textMail.getText(),textTelephone.getText());
						
						c.addEnseignant(en);
						JOptionPane.showMessageDialog(null,"Enseignant est ajoute","CONFERMER",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					
					JOptionPane.showMessageDialog(null,"Enseignant n'a pas ajoute","CONFERMER",JOptionPane.WARNING_MESSAGE );
				}
				catch(Exception ex) 
				{
					System.out.println("exception :"+ex);
				}
				textNom.setText("");textPrenom.setText("");textDateDeNaissence.setText("");
				textCIN.setText("");textMail.setText("");textTelephone.setText("");	
			}
		}
	});
	
	
	
	JButton btnNewButton_1_1_1 = new JButton("Fermer");
	btnNewButton_1_1_1.setBackground(new Color(220, 20, 60));
	btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnNewButton_1_1_1.setBounds(366, 416, 117, 34);
	contentPane.add(btnNewButton_1_1_1);
	
	btnNewButton_1_1_1.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			int res= JOptionPane.showConfirmDialog(null,"VOULEZ_VOUS QUITER","QUITER", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null);
			
			if(res==JOptionPane.YES_OPTION)
			{
				dispose();
			}
		}
	});
	
	
	
	
	
	JButton btnNewButton_2 = new JButton("Afficher tous les enseignants");
	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton_2.setBackground(Color.ORANGE);
	btnNewButton_2.setBounds(35, 351, 262, 34);
	contentPane.add(btnNewButton_2);
	
	btnNewButton_2.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			Object [] culumn = { "IdE","nom", "prenom", "CIN", "email", "telephone"};
			final Object[] row=new Object [6];
			model.setColumnIdentifiers(culumn );
			table.setModel(model);
			scrollPane.setViewportView(table);
			DefaultTableModel dtm=(DefaultTableModel)table.getModel();
			dtm.setNumRows(0);
	
			try 
			{
				PreparedStatement ps= conn.prepareStatement("select  id_enseignant,`nom`, `prenom`, `CIN`, `email`, `telephone` from enseignant");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) 
				{
					row[0]=rs.getInt(1);
					row[1]=rs.getString(2);
					row[2]=rs.getString(3);
					row[3]=rs.getString(4);
					row[4]=rs.getString(5);
					row[5]=rs.getString(6);
					model.addRow(row);
				}
	
			}catch(Exception ex) {
			System.out.println("Exception :"+ ex);
			}
	
		}
	});
	
	
	JButton btnNewButton = new JButton("Emploi");
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton.setBackground(Color.ORANGE);
	btnNewButton.setBounds(346, 332, 115, 34);
	contentPane.add(btnNewButton);
	
	btnNewButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			DefaultTableModel dtm=(DefaultTableModel)table.getModel();
			dtm.setNumRows(0);
			Object [] culumn = { "nom_cour", "jour", "heureDebu", "heureFin","la salle"};
			final Object[]row=new Object [5];
			model.setColumnIdentifiers(culumn );
			table.setModel(model);
	
			try {
				String nom=JOptionPane.showInputDialog("qu'il nom ");
				PreparedStatement ps= conn.prepareStatement("select nom_cour,jour,heureDebut,heureFin,NumSalle from cour ,enseignant where cour.id_enseignant=enseignant.id_enseignant and enseignant.nom=?");
		
				ps.setString(1,nom);
				ResultSet rs = ps.executeQuery();
		
				while(rs.next()) 
				{
					row[0]=rs.getString(1);
					row[1]=rs.getString(2);
					row[2]=rs.getString(3);
					row[3]=rs.getString(4);
					row[4]=rs.getString(5);
					model.addRow(row);
				}
			}catch(Exception ex) 
			{
				System.out.println("Exception :"+ ex);
			}
		}
	});

	
	
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\Diagramme de classes\\istockphoto-990361620-612x612.jpg"));
	lblNewLabel.setBounds(42, 0, 468, 461);
	contentPane.add(lblNewLabel);
	
	}
}