package election;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class candidat extends JFrame 
{
	private JTextField textField;
	private JPasswordField passwordField;
	public candidat() {
		getContentPane().setLayout(null);
		this.setVisible(true);
		setSize(570,448);
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
	               String requete="Select username, password from admin where username='"+userName+"' and password='"+pass+"'";
	                Statement state;
	                try {
	                	state = connexion.getconnect().createStatement();
	                	ResultSet res = state.executeQuery(requete);
	                    if (res.next()) {
	                    	dispose();
	                      
	                        UseHome ah = new UseHome();
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
		
		JLabel lblDontHaveAn = new JLabel("don't have an account ?");
		lblDontHaveAn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDontHaveAn.setBounds(214, 330, 163, 39);
		getContentPane().add(lblDontHaveAn);
		
		JButton btnNewButton_2 = new JButton("Sign up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminsignup a=new adminsignup();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(212, 363, 153, 27);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(candidat.class.getResource("/img/wallpapertip_website-wallpaper-backgrounds_1963020.jpg")));
		lblNewLabel_2.setBounds(0, 0, 556, 411);
		getContentPane().add(lblNewLabel_2);
	}
}
