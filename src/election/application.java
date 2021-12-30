package election;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class application extends JFrame {
	public application() {
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(570,448);
		JButton btnNewButton = new JButton("Je suis un administrateur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				candidat c=new candidat();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBounds(64, 61, 363, 121);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Je suis un \u00E9lecteur");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginelecteur l=new loginelecteur();
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnNewButton_1.setBounds(64, 238, 363, 121);
		getContentPane().add(btnNewButton_1);
	}

	public static void main(String[] args) {
		application app=new application();

	}

}
