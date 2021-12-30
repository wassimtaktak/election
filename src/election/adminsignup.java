package election;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class adminsignup extends JFrame {
		private JTextField cin;
		private JTextField prenom;
		private JPasswordField passwordField;
		private JTextField textField;
		public adminsignup() {
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
			
			JLabel lblNewLabel = new JLabel("id :");
			lblNewLabel.setBounds(22, 146, 56, 37);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel.add(lblNewLabel);
			
			prenom = new JTextField();
			prenom.setBounds(170, 215, 187, 37);
			panel.add(prenom);
			prenom.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("username:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_2.setBounds(22, 215, 124, 37);
			panel.add(lblNewLabel_2);
			ButtonGroup sexe = new ButtonGroup();
			
			JButton btnNewButton = new JButton("ajouter");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cinn = cin.getText();
					String no = prenom.getText() ;
					String preno = prenom.getText();
					String pass=passwordField.getText();
					String requete = "INSERT INTO admin VALUES ('"+cinn+"','"+no+"','"+pass+"')";
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
			label.setBounds(10, 303, 136, 37);
			panel.add(label);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(170, 303, 214, 37);
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
