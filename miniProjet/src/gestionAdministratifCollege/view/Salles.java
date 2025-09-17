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
import gestionAdministratifCollege.entity.Salle;



public class Salles extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textnumsale;
	private JTextField textCapacite;
	private JTextField textType;
	
	/**
	* Launch the application.
	*/
	SqlJava sj =new  SqlJava();
	Connection conn = ConnexionSql.getConnection();
	
	
	private JTable table;
	DefaultTableModel model;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_1;
	
	
	/**
	* Create the frame.
	*/
	public Salles() {
	setResizable(false);
	setTitle("Gestion administratif d'un college");
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\Capture d\u2019\u00E9cran 2022-05-21 021306.png"));
	setBounds(100, 100, 1000, 500);
	
	contentPane = new JPanel();
	contentPane.setToolTipText("");
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(549, 0, 435, 461);
	contentPane.add(scrollPane);
	
	table = new JTable();
	table.setFont(new Font("Tahoma", Font.BOLD, 15));
	table.setVisible(true);
	table.setBackground(Color.WHITE);
	table.setBounds(351, 11, 336, 40);
	table.setSize(400,200);
	model=new DefaultTableModel();
	
	
	JButton btnNewButton_2 = new JButton("Afficher tous les salles");
	btnNewButton_2.setBackground(Color.ORANGE);
	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton_2.setBounds(262, 356, 218, 26);
	contentPane.add(btnNewButton_2);
	
	btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	Object [] culumn = { "Salle", "Type", "Capacite"};
	final Object[] row=new Object [3];
	model.setColumnIdentifiers(culumn );
	table.setModel(model);
	scrollPane.setViewportView(table);
	
	try {
	DefaultTableModel dtm=(DefaultTableModel)table.getModel();
	dtm.setNumRows(0);
	PreparedStatement ps= conn.prepareStatement("SELECT * FROM salle");
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
	row[0]=rs.getString(1);
	row[1]=rs.getString(2);
	row[2]=rs.getString(3);
	 model.addRow(row);}
	
	}catch(Exception ex) {
	System.out.println("Exception :"+ ex);
	}
	
	}
	});
	
	btnNewButton_3 = new JButton("Emploi du salle");
	btnNewButton_3.setBackground(Color.ORANGE);
	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton_3.setBounds(265, 283, 167, 23);
	contentPane.add(btnNewButton_3);
	
	btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	Object [] culumn = { "Cour","Nom d'enseignant", "Jour","classe", "Heure de debut","Heure de fin"};
	final Object[] row=new Object [6];
	model.setColumnIdentifiers(culumn );
	table.setModel(model);
	scrollPane.setViewportView(table);
	DefaultTableModel dtm=(DefaultTableModel)table.getModel();
	dtm.setNumRows(0);
	
	
	try {
	String NumSalle =JOptionPane.showInputDialog("Entrez le numero de la salle ",JOptionPane.QUESTION_MESSAGE);
	
	PreparedStatement ps= conn.prepareStatement("select Type,capacite,nom_cour,nom,jour,heureDebut,heureFin , classe from classe ,cour ,salle,enseignant where cour.NumSalle=salle.NumSalle and cour.id_enseignant=enseignant.id_enseignant and cour.id_classe = classe.id_classe and salle.NumSalle=? ");
	ps.setInt(1,Integer.parseInt(NumSalle));
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
	row[0]=rs.getString(3);
	row[1]=rs.getString(4);
	row[2]=rs.getString(5);
	row[3]=rs.getString(8);
	row[4]=rs.getString(6);
	row[5]=rs.getString(7);
	model.addRow(row);
	}
	
	}catch(Exception ex) {
	System.out.println("Exception :"+ ex);
	}
	
	}
	});
	
	JButton btnNewButton_1_1 = new JButton("Supprimer une salle");
	btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton_1_1.setBackground(Color.ORANGE);
	btnNewButton_1_1.setBounds(10, 355, 212, 28);
	contentPane.add(btnNewButton_1_1);
	btnNewButton_1_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	String id =JOptionPane.showInputDialog("Entrez le numero de la salle ",JOptionPane.QUESTION_MESSAGE);
	if(id!=null) {
	int res=JOptionPane.showConfirmDialog(null,"VOULEZ VOUS SUPPRIMER","SUPPRIMER", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null);
	
	if(res==JOptionPane.YES_OPTION) {
	sj.supprimerSalle(Integer.parseInt(id));
	JOptionPane.showMessageDialog(null,"La salle a supprime","CONFERMER",JOptionPane.INFORMATION_MESSAGE);}
	else
	
	JOptionPane.showMessageDialog(null,"Salle n'a pas supprime","CONFERMER",JOptionPane.WARNING_MESSAGE );
	
	}}});
	
	btnNewButton_4 = new JButton("Salle vide");
	btnNewButton_4.setBackground(Color.ORANGE);
	btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton_4.setBounds(30, 283, 167, 23);
	contentPane.add(btnNewButton_4);
	btnNewButton_4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	Object [] culumn = { "Salle","Type", "Capacite", "heureDebut"};
	final Object[] row=new Object [4];
	model.setColumnIdentifiers(culumn );
	table.setModel(model);
	scrollPane.setViewportView(table);
	
	try
	{
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setNumRows(0);
	String jour =JOptionPane.showInputDialog("Entrez le jour ",JOptionPane.QUESTION_MESSAGE);
	 if(jour!=null) {
		 
	String capacite =JOptionPane.showInputDialog("Entrez la capacite ",JOptionPane.QUESTION_MESSAGE);
	if(capacite!=null) {
	String heur =JOptionPane.showInputDialog("Entrez l'heure ",JOptionPane.QUESTION_MESSAGE);
	 if(heur!=null) {
	PreparedStatement ps = conn.prepareStatement("select * from salle where NumSalle not in ( select S.NumSalle from salle S ,"+
	" cour C where S.NumSalle = C.NumSalle and C.jour like ? "+
	"and S.capacite = ? and C.heureDebut like ?) and capacite = ?;");
	ps.setString(1, jour);
	ps.setInt(2, Integer.parseInt(capacite));
	ps.setString(3, heur);
	ps.setInt(4, Integer.parseInt(capacite));
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
	row[0]=rs.getInt(1);
	row[1]=rs.getString(2);
	row[2]=rs.getInt(3);
	row[3]=heur;
	
	model.addRow(row);
	}
	}}
	
	 }}catch(Exception es) {
	System.out.println("Exception :"+es);
	}
	}});
	;
	
	btnNewButton_5 = new JButton("FERMER");
	btnNewButton_5.setBackground(new Color(220, 20, 60));
	btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton_5.setBounds(415, 427, 120, 23);
	contentPane.add(btnNewButton_5);
	
	btnNewButton_5.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	        int res= JOptionPane.showConfirmDialog(null, "VOULEZ VOUS QUITTER ", "FERMER",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
		 if(res==JOptionPane.YES_OPTION)
		dispose();
	}
	});
	
	JLabel lblNewLabel = new JLabel("Salle");
	lblNewLabel.setBounds(66, 47, 97, 30);
	contentPane.add(lblNewLabel);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
	
	JLabel lblCapacit = new JLabel("Type");
	lblCapacit.setBounds(68, 88, 119, 30);
	contentPane.add(lblCapacit);
	lblCapacit.setFont(new Font("Tahoma", Font.BOLD, 17));
	
	JLabel lblCapacit_1 = new JLabel("Capacit\u00E9");
	lblCapacit_1.setBounds(66, 129, 119, 30);
	contentPane.add(lblCapacit_1);
	lblCapacit_1.setFont(new Font("Tahoma", Font.BOLD, 17));
	
	textnumsale = new JTextField();
	textnumsale.setBounds(193, 50, 149, 30);
	contentPane.add(textnumsale);
	textnumsale.setColumns(10);
	
	textType = new JTextField();
	textType.setBounds(193, 91, 149, 30);
	contentPane.add(textType);
	textType.setColumns(10);
	
	JButton btnNewButton_1 = new JButton("Ajouter la salle");
	btnNewButton_1.setBounds(241, 173, 158, 27);
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	contentPane.add(btnNewButton_1);
	btnNewButton_1.setBackground(Color.ORANGE);
	
	btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	if(textnumsale.getText().equals("")||textType.getText().equals("")|| textCapacite.getText().equals("") )
	JOptionPane.showMessageDialog(null, "ENTREZ TOUS LES CHAMPS");
	else {
	try {
	
	Salle s= new Salle (Integer.parseInt(textnumsale.getText()),textType.getText(),Integer.parseInt(textCapacite.getText()));
	sj.addSalle(s);
	JOptionPane.showMessageDialog(null,"La salle a ajoute","CONFERMER",JOptionPane.INFORMATION_MESSAGE);
	}catch(Exception ex) {
	System.out.println("Exception :"+ex);
	}
	textnumsale.setText("");textType.setText(""); textCapacite.setText("");}
	}});
	
	
	
	textCapacite = new JTextField();
	textCapacite.setBounds(193, 132, 149, 30);
	contentPane.add(textCapacite);
	textCapacite.setColumns(10);
	
	JButton btnNewButton_3 = new JButton("Affictation hebdomadaire des salles");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AffictationHebdomadaire a = new AffictationHebdomadaire();
			a.setVisible(true);
		}
	});
	btnNewButton_3.setBounds(83, 228, 314, 27);
	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
	contentPane.add(btnNewButton_3);
	btnNewButton_3.setBackground(Color.ORANGE);
	
	
	
	lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\Diagramme de classes\\OIP (4).jfif"));
	lblNewLabel_1.setBounds(0, 0, 549, 461);
	contentPane.add(lblNewLabel_1);
	
	}
}


