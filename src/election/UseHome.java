package election;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UseHome extends JFrame {
	public UseHome() {
		getContentPane().setLayout(null);
		setSize(511,460);
		JButton btnNewButton = new JButton("Gestion des  candidats ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestiondescandidats g=new gestiondescandidats();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(100, 56, 248, 69);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Calcul des scores");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				score s=new score();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(100, 193, 248, 69);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("activit\u00E9/candidat");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activite a= new activite();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(100, 309, 248, 69);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UseHome.class.getResource("/img/wallpapertip_website-wallpaper-backgrounds_1963020.jpg")));
		lblNewLabel.setBounds(0, 0, 497, 423);
		getContentPane().add(lblNewLabel);
		
	}
}
