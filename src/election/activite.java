package election;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.awt.Color;

public class activite extends JFrame{
	private JTable table;
	private int i;
	private JTable table_1;
	public activite() {
		getContentPane().setLayout(null);
		this.setVisible(true);
		setSize(826,700);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 679, 643);
		getContentPane().add(panel);
		panel.setBorder( BorderFactory. createTitledBorder( "Activités par candidat: ") ) ;
		panel.setLayout(null);
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(154, 386, 126, 21);
		for(i=0;i<colfil().size();i++)
		{comboBox_1.addItem(colfil().get(i));}
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("activit\u00E9 :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(39, 378, 85, 28);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(369, 383, 300, 170);
		panel.add(scrollPane);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 37, 609, 248);
		panel.add(scrollPane_1);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		affiche1();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int j=table.getSelectedRow();
				comboBox_1.setSelectedItem(table.getValueAt (j,0).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Affecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String activite=comboBox_1.getSelectedItem().toString();
				String id_act=idlib(activite);
				int j=table.getSelectedRow();
				String idcand=table.getValueAt (j,0).toString();
				String requete ="INSERT INTO `candidatactivite` (`id`, `idcand`, `idact`) VALUES (NULL, '"+idcand+"','"+id_act+"')";
				Statement state;
				try {
					
					state = connexion.getconnect().createStatement();
				int res = state.executeUpdate(requete);
				if(res!=0){
					 //state.execute(requete);
						//setVisible( false) ;
						JOptionPane.showMessageDialog(null, "acitivité affecté à un candidat avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
						affiche1();
						}
						//setVisible( false) ;
						state.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(activite.class.getResource("/img/ajouter.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(71, 451, 232, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitter\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setIcon(new ImageIcon(activite.class.getResource("/img/sortie.gif")));
		btnNewButton_1.setBounds(508, 584, 139, 35);
		panel.add(btnNewButton_1);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("S\u00E9lectionner un candidat et une activit\u00E9 :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(29, 319, 591, 40);
		panel.add(lblNewLabel);
		affiche();
	}
	public void affiche ()
	{
		try {
			String requete ="SELECT `id`, `nom`, `prenom`FROM `candidats` ";
			PreparedStatement  ps =connexion.getconnect().prepareStatement(requete);
			ResultSet res=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res));
		}catch (Exception exp) {
			System.out.println("exception="+exp);
		}
		
	}
	public void affiche1 ()
	{
		try {
			String requete ="SELECT candidats.nom, candidats.prenom ,activite.libelle FROM `candidatactivite`,candidats ,activite WHERE candidatactivite.idcand=candidats.id AND candidatactivite.idact=activite.id ";
			PreparedStatement  ps =connexion.getconnect().prepareStatement(requete);
			ResultSet res=ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(res));
		}catch (Exception exp) {
			System.out.println("exception="+exp);
		}
		
	}
	 public ArrayList colmat()
		{
			String query = " select libelle from matiere  ";
			ArrayList<String> list = new ArrayList<String>();

			try {
				Statement state  =connexion.getconnect().createStatement();
				ResultSet res =state.executeQuery(query);
				while (res.next())
				{
					list.add(res.getString("libelle"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return  list;
		}
	 public ArrayList colfil()
		{
			String query = " select libelle from activite  ";
			ArrayList<String> list = new ArrayList<String>();

			try {
				Statement state  =connexion.getconnect().createStatement();
				ResultSet res =state.executeQuery(query);
				while (res.next())
				{
					list.add(res.getString("libelle"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return  list;
		}
	    public String idlib(String s)
		{
			String query = " SELECT `id` FROM `activite` WHERE activite.libelle='"+s+"' ";
			ArrayList<String> list = new ArrayList<String>();

			try {
				Statement state  =connexion.getconnect().createStatement();
				ResultSet res =state.executeQuery(query);
				while (res.next())
				{
					list.add(res.getString("id"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}return list.get(0);}
		public String idlibfil(String s)
				{
					String query = " SELECT `id_fil` FROM `filiere` WHERE filiere.libelle='"+s+"' ";
					ArrayList<String> list = new ArrayList<String>();

					try {
						Statement state  =connexion.getconnect().createStatement();
						ResultSet res =state.executeQuery(query);
						while (res.next())
						{
							list.add(res.getString("id_fil"));
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}return list.get(0);
				}
}
