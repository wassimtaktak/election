package election;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vote extends JFrame 
{
	private JTable table;
	public vote() {
		getContentPane().setLayout(null);
		setSize(785,513);
		setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 74, 657, 214);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("S\u00E9lectionner votre candidat pr\u00E9fer\u00E9 :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 23, 453, 44);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VOTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try { 
					Statement stmn;
					stmn= connexion.getconnect().createStatement();
					int i=table.getSelectedRow();
					String s=table.getValueAt (i, 0).toString();
					
					
					if (JOptionPane.showConfirmDialog (null,"vous allez voter ,ce candidat etes vous sure??","vote",
		                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) 
					{
						stmn.executeUpdate("UPDATE candidats SET nbrdevotes =nbrdevotes+1 where id='"+s+"'"); 
						dispose();
					}
				}catch (Exception e1){JOptionPane.showMessageDialog(null,"erreur !!!!!!!");
		        System.err.println(e1);}
			
				
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(253, 400, 180, 37);
		getContentPane().add(btnNewButton);
		affiche();
	}
	public void affiche ()
	{
		try {
			String requete ="SELECT * FROM `candidats` ";
			PreparedStatement  ps =connexion.getconnect().prepareStatement(requete);
			ResultSet res=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res));
		}catch (Exception exp) {
			System.out.println("exception="+exp);
		}
		
	}
	 
	
}
