package election;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
public class electeur extends JFrame 
{
	private JTextField cin;
	private JTextField nom;
	private JTextField prenom;
	private JPasswordField passwordField;
	private JTextField textField;
	public electeur() {
		setSize(939,700);
		this.setVisible(true);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 912, 643);
		panel.setToolTipText("");
		getContentPane().add(panel);
		panel.setBorder( BorderFactory. createTitledBorder( "Informations de l'electeur : ") ) ;
		panel.setLayout(null);
		
		
	    cin  = new JTextField();
		cin.setBounds(170, 146, 181, 37);
		panel.add(cin);
	     cin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cin :");
		lblNewLabel.setBounds(22, 146, 56, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		nom = new JTextField();
		nom.setBounds(535, 215, 185, 37);
		panel.add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(429, 230, 72, 22);
		panel.add(lblNewLabel_1);
		
		prenom = new JTextField();
		prenom.setBounds(170, 215, 187, 37);
		panel.add(prenom);
		prenom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(22, 227, 85, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("date de naissance :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 295, 196, 51);
		panel.add(lblNewLabel_4);
		
		 final JRadioButton rdbtnNewRadioButton = new JRadioButton("masculin",true);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(128, 385, 103, 21);
		ButtonGroup sexe = new ButtonGroup();
		sexe.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("feminin",false);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBounds(275, 385, 103, 21);
		sexe.add(rdbtnNewRadioButton_1);
		panel.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("sexe :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(23, 375, 62, 37);
		panel.add(lblNewLabel_3);
		
		  final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(240, 295, 162, 35);
		panel.add(dateChooser);
		
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cinn = cin.getText();
				String no = nom.getText() ;
				String preno = prenom.getText();
				String pass=passwordField.getText();
				java.util.Date date=dateChooser.getDate();
				java.sql.Date sqldate = new java.sql.Date(date.getTime());
				String s;
				if (rdbtnNewRadioButton.isSelected())
					s="Masculin";
				else 
					s="Feminin";
				String requete = "INSERT INTO electeur VALUES ('"+cinn+"','"+no+"','"+preno+"','"+pass+"','"+sqldate+"','"+s+"')";
			      Statement state;
				try {
					
					state = connexion.getconnect().createStatement();
				int res = state.executeUpdate(requete);
				if(res!=0){
					JOptionPane.showMessageDialog(null, "Electeur ajouté avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
						}
						state.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(227, 538, 151, 37);
		panel.add(btnNewButton);
		JButton btnNewButton_4 = new JButton("Retour");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(429, 536, 136, 40);
		panel.add(btnNewButton_4);
		
		Label label = new Label("Password :");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(23, 446, 136, 37);
		panel.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(195, 446, 214, 37);
		panel.add(passwordField);
		
		Label label_1 = new Label("Cre\u00E9r un compte");
		label_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_1.setBounds(102, 38, 366, 59);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(170, 146, 185, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
	}
	
		
	}

	  
