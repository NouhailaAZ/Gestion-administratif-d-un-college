package gestionAdministratifCollege.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Authentification extends JFrame {

private JPanel contentPane;
private JTextField textlogin;
private JPasswordField passwordField;

/**
* Create the frame.
*/
public Authentification() {
setResizable(false);
setTitle("Gestion administratif d'un college");
setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\tec_cl\\Capture d\u2019\u00E9cran 2022-05-21 021306.png"));
setBounds(100, 100, 614, 482);

contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel_1 = new JLabel("Login");
lblNewLabel_1.setBounds(173, 133, 83, 27);
contentPane.add(lblNewLabel_1);
lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Documents\\s2\\Capture d\u2019\u00E9cran 2022-05-30 143002.png"));
lblNewLabel_1.setBackground(Color.CYAN);
lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setForeground(Color.BLACK);

JLabel lblNewLabel_1_1 = new JLabel("Password");
lblNewLabel_1_1.setBounds(173, 188, 112, 29);
contentPane.add(lblNewLabel_1_1);
lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Documents\\s2\\Capture d\u2019\u00E9cran 2022-05-30 143513.png"));
lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
lblNewLabel_1_1.setForeground(Color.BLACK);
lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1_1.setBackground(Color.CYAN);

passwordField = new JPasswordField();
passwordField.setBounds(321, 190, 130, 29);
contentPane.add(passwordField);

textlogin = new JTextField();
textlogin.setBounds(321, 135, 130, 26);
contentPane.add(textlogin);
textlogin.setColumns(10);

JButton btnAnnuler = new JButton("Annuler");
btnAnnuler.setBounds(334, 285, 130, 31);
contentPane.add(btnAnnuler);
btnAnnuler.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
}
});
btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 15));

JButton btnNewButton = new JButton("Valider");
btnNewButton.setBounds(133, 285, 120, 31);
contentPane.add(btnNewButton);
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

if(passwordField.getText().equals("") || !passwordField.getText().equals("iiii") || !textlogin.getText().equals("ilham") || textlogin.getText().equals(""))
JOptionPane.showMessageDialog(null, "Password ou login est incorrect" , "Valider",JOptionPane.INFORMATION_MESSAGE);

//JOptionPane.showMessageDialog(null, "Login est incorrect" , "Valider",JOptionPane.INFORMATION_MESSAGE);

else {
if(passwordField.getText().equals("iiii") && textlogin.getText().equals("ilham"))
{
	passwordField.setText("");
	textlogin.setText("");
	Accueil f =new Accueil();
	f.setVisible(true);
//this.hashCode();
}

}






}});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));

JLabel lblNewLabel = new JLabel("New label");
lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Downloads\\Capture d\u2019\u00E9cran 2022-05-25 192835 (1).png"));
lblNewLabel.setBounds(0, 0, 598, 441);
contentPane.add(lblNewLabel);
}
}


