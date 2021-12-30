package election;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class score extends JFrame 
{
	private JTable table;
	public score() {
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(570,448);
		JLabel lblNewLabel = new JLabel("Scores des candidats");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(167, 28, 295, 56);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 113, 525, 217);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		affiche();
	}
	public void affiche ()
	{
		try {
			String requete ="SELECT `nom`, `prenom`, `nbrdevotes` FROM `score`";
			PreparedStatement  ps =connexion.getconnect().prepareStatement(requete);
			ResultSet res=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res));
		}catch (Exception exp) {
			System.out.println("exception="+exp);
		}
		
	}
}
