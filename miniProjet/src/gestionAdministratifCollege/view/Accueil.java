package gestionAdministratifCollege.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueil extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	Salles sal = new Salles();
	Classes classes = new Classes();
	Enseignants ens = new Enseignants();
	Eleves elv = new Eleves();
	Absences abs = new Absences();
	
	
	
	public Accueil() 
	{
		setResizable(false);
		setTitle("Gestion administratif d'un college");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\Capture d\u2019\u00E9cran 2022-05-21 021306.png"));
		setBounds(100, 100, 1000, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel_1 = new JLabel("GESTION ADMINISTRATIF D'UN COLLEGE");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(295, 11, 380, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SALLES");
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnNewButton.setForeground(SystemColor.infoText);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(33, 72, 228, 47);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				sal.setVisible(true);
			}
		});
		
		
		JButton btnClasse = new JButton("CLASSES");
		btnClasse.setForeground(SystemColor.infoText);
		btnClasse.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnClasse.setBackground(SystemColor.activeCaption);
		btnClasse.setBounds(33, 138, 228, 47);
		contentPane.add(btnClasse);
		
		btnClasse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				classes.setVisible(true);
			}
		});
		
		JButton btnEnseignant = new JButton("ENSEIGNANTS");
		btnEnseignant.setForeground(SystemColor.infoText);
		btnEnseignant.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnEnseignant.setBackground(SystemColor.activeCaption);
		btnEnseignant.setBounds(33, 206, 228, 47);
		contentPane.add(btnEnseignant);
		
		btnEnseignant.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				ens.setVisible(true);
			}
		});
		
		JButton btnEleve = new JButton("ELEVES");
		btnEleve.setForeground(SystemColor.infoText);
		btnEleve.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnEleve.setBackground(SystemColor.activeCaption);
		btnEleve.setBounds(33, 264, 228, 47);
		contentPane.add(btnEleve);
		
		btnEleve.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				elv.setVisible(true);
			}
		});
		
		JButton btnAbsences = new JButton("FEUILLES DE PRESENCE");
		btnAbsences.setForeground(SystemColor.infoText);
		btnAbsences.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnAbsences.setBackground(SystemColor.activeCaption);
		btnAbsences.setBounds(33, 322, 228, 47);
		contentPane.add(btnAbsences);
		
		btnAbsences.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				abs.setVisible(true);
			}
		});
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("D\u00E9connexion");
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBackground(new Color(128, 0, 0));
		chckbxNewCheckBox.setBounds(839, 408, 109, 23);
		contentPane.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				elv.setVisible(false);
				abs.setVisible(false);
				ens.setVisible(false);
				classes.setVisible(false);
				sal.setVisible(false);
				
				dispose();
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\Diagramme de classes\\groupe-d-enfants-marchant-devant-l-\u00E9cole-bulding-id-e-ducation-et-de-tude-enfant-allant-\u00E0-autobus-scolaire-jaune-\u00E9l\u00E8ve-dans-152626200.jpg"));
		lblNewLabel.setBounds(89, 0, 803, 441);
		contentPane.add(lblNewLabel);
	}
}


