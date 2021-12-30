package election;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginelecteur extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	public loginelecteur() {
		getContentPane().setLayout(null);
		this.setVisible(true);
		setSize(553,388);
		textField = new JTextField();
		textField.setBounds(279, 111, 138, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(118, 111, 148, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(118, 188, 138, 27);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login\r\n");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				 String userName = textField.getText();
	                String pass = passwordField.getText();
	               String requete="Select nom_electeur,password_electeur  from electeur where nom_electeur='"+userName+"' and password_electeur='"+pass+"'";
	                Statement state;
	                try {
	                	state = connexion.getconnect().createStatement();
	                	ResultSet res = state.executeQuery(requete);
	                    if (res.next()) {
	                    	dispose();
	                      
	                        vote ah = new vote();
	                        ah.setTitle("Welcome");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
	                    }
	                } catch (SQLException e1) {
	                   e1.printStackTrace();
	                }
	            }
		});
		btnNewButton.setIcon(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(93, 262, 163, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel\r\n");
		btnNewButton_1.setIcon(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(318, 261, 163, 29);
		getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 188, 138, 27);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(candidat.class.getResource("/img/wallpapertip_website-wallpaper-backgrounds_1963020.jpg")));
		lblNewLabel_2.setBounds(0, 0, 572, 411);
		getContentPane().add(lblNewLabel_2);
	}

}
