package election;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

public class gestiondescandidats extends JFrame 
{
		private JLabel lblNewLabel_9;
		private JTextField id;
		private JTextField nom;
		private JTextField prenom;
		private JFileChooser file = new JFileChooser();
		private JTable table;
		private JTextField partie;
		private JTextField fb;
		private JTextField twitter;
		public gestiondescandidats() {
			setSize(1129,755);
			int i;
			getContentPane().setLayout(null);
			this.setVisible(true);
			JPanel panel = new JPanel();
			panel.setToolTipText("");
			panel.setBounds(10, 10, 1069, 698);
			getContentPane().add(panel);
			panel.setBorder( BorderFactory. createTitledBorder( "Informations de candidat : : ") ) ;
			panel.setLayout(null);
			
			id = new JTextField();
			id.setBounds(125, 38, 162, 37);
			panel.add(id);
			id.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("id :");
			lblNewLabel.setBounds(39, 34, 56, 37);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel.add(lblNewLabel);
			
			nom = new JTextField();
			nom.setBounds(125, 99, 162, 37);
			panel.add(nom);
			nom.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Name:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_1.setBounds(23, 102, 72, 22);
			panel.add(lblNewLabel_1);
			
			prenom = new JTextField();
			prenom.setBounds(111, 162, 187, 37);
			panel.add(prenom);
			prenom.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Prenom:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_2.setBounds(10, 164, 85, 25);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_4 = new JLabel("date de naissance :");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_4.setBounds(10, 224, 196, 51);
			panel.add(lblNewLabel_4);
			
			 JRadioButton rdbtnNewRadioButton = new JRadioButton("masculin",true);
			rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnNewRadioButton.setBounds(140, 295, 103, 21);
			ButtonGroup sexe = new ButtonGroup();
			sexe.add(rdbtnNewRadioButton);
			panel.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("feminin",false);
			rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnNewRadioButton_1.setBounds(270, 295, 103, 21);
			sexe.add(rdbtnNewRadioButton_1);
			panel.add(rdbtnNewRadioButton);
			panel.add(rdbtnNewRadioButton_1);
			
			JLabel lblNewLabel_3 = new JLabel("sexe :");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_3.setBounds(33, 285, 62, 37);
			panel.add(lblNewLabel_3);
			
			  JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(216, 237, 162, 35);
			panel.add(dateChooser);


			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(448, 43, 611, 290);
			panel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {  int i=table.getSelectedRow();
		            deplace(i);
		            String gender=table.getValueAt(i, 3).toString();
		            if(gender.equals("Masculin"))
		            		{
		            		rdbtnNewRadioButton.setSelected(true);
		            		}
		            else {
		            	rdbtnNewRadioButton_1.setSelected(true);
		            }
		            		
		            dateChooser.setDate( new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt (i,3).toString()));
		            
		        }
		        catch (Exception e1){JOptionPane.showMessageDialog(null,"erreur selectionne\n"+e1.getMessage());          }
				}
			});
			scrollPane.setViewportView(table);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JButton btnNewButton = new JButton("ajouter");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String num = id.getText();
					String no = nom.getText() ;
					String preno = prenom.getText();
					String  part=partie.getText();
					String fcb=fb.getText();
					String twit=twitter.getText();

					
					java.util.Date date=dateChooser.getDate();
					java.sql.Date sqldate = new java.sql.Date(date.getTime());
					String s;
					if (rdbtnNewRadioButton.isSelected())
						s="Masculin";
					else 
						s="Feminin";
					/*File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();*/
				      Statement state;
					try {
						//InputStream img= new FileInputStream(path);
						String requete = "INSERT INTO candidats(`id`, `nom`, `prenom`, `date`, `sexe`, `nompartie`, `lienfb`, `lientwitter`)  VALUES (NULL,'"+no+"','"+preno+"','"+sqldate+"','"+s+"','"+part+"','"+fcb+"','"+twit+"')";
						state = connexion.getconnect().createStatement();
					int res = state.executeUpdate(requete);
					if(res!=0){
						 //state.execute(requete);
							//setVisible( false) ;
							JOptionPane.showMessageDialog(null, "candidat ajout? avec succ?s", "info", JOptionPane.INFORMATION_MESSAGE);
							affiche();
							}
							//setVisible( false) ;
							state.close();
					} catch (SQLException  e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton.setIcon(new ImageIcon(gestiondescandidats.class.getResource("/img/nouveau.png")));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setBounds(23, 638, 151, 37);
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("supprimer");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Statement stmn;
						stmn= connexion.getconnect().createStatement();
			             if(JOptionPane.showConfirmDialog(null,"attention vous allez supprimer un candidat,est ce que vous etes sure?"
			                     ,"supprimer etudiant",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
			         
			            if(id.getText().length() != 0){
			        stmn.executeUpdate("Delete From candidats where id = "+id.getText());
			        affiche();
			             }//ca est pour recharger la list des stagiaire
			            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ id !");}
			        
			        }catch (Exception e1){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e1.getMessage());} 
			       
				}
			});
			btnNewButton_1.setIcon(new ImageIcon(gestiondescandidats.class.getResource("/img/supprimer.png")));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1.setBounds(384, 638, 154, 37);
			panel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Modifier");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try { 
						Statement stmn;
						stmn= connexion.getconnect().createStatement();
						java.util.Date date=dateChooser.getDate();
						java.sql.Date sqldate = new java.sql.Date(date.getTime());
						String s;
						if (rdbtnNewRadioButton.isSelected())
							s="Masculin";
						else 
							s="Feminin";
			            if (JOptionPane.showConfirmDialog (null,"confirmer la modification","modification",
			                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

			                stmn.executeUpdate("UPDATE candidats SET nom='"+nom.getText()+"',prenom='"+prenom.getText()+"',date='"+sqldate+"',sexe='"+s+"',nompartie='"+partie.getText()+"',lienfb='"+fb.getText()+"',lientwitter='"+twitter.getText()+"' WHERE id= "+id.getText());
			                affiche();
			                //afficher ();
			            } 
			        } catch (Exception e1){JOptionPane.showMessageDialog(null,"erreur de modification!!!!!!!");
			        System.err.println(e1);}
				}
			});
			btnNewButton_2.setIcon(new ImageIcon(gestiondescandidats.class.getResource("/img/modifier.gif")));
			btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_2.setBounds(199, 638, 151, 37);
			panel.add(btnNewButton_2);
			
			JLabel lblNewLabel_5 = new JLabel("nom de la partie :");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_5.setBounds(35, 346, 196, 35);
			panel.add(lblNewLabel_5);
			
			JButton btnNewButton_3 = new JButton("Quitter");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_3.setIcon(new ImageIcon(gestiondescandidats.class.getResource("/img/sortie.gif")));
			btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_3.setBounds(594, 638, 154, 37);
			panel.add(btnNewButton_3);
			
			partie = new JTextField();
			partie.setBounds(258, 346, 171, 37);
			panel.add(partie);
			partie.setColumns(10);
			
			fb = new JTextField();
			fb.setBounds(241, 423, 229, 37);
			panel.add(fb);
			fb.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Lien Facebook :");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_6.setBounds(23, 423, 183, 37);
			panel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Lien Twitter :");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_7.setBounds(55, 509, 151, 25);
			panel.add(lblNewLabel_7);
			
			twitter = new JTextField();
			twitter.setBounds(241, 507, 229, 37);
			panel.add(twitter);
			twitter.setColumns(10);
			
			lblNewLabel_9 = new JLabel();
			lblNewLabel_9.setBounds(533, 409, 128, 112);
			lblNewLabel_9.setBounds(533, 409, 128, 112);
			panel.add(lblNewLabel_9);
			affiche();
			
			
			
		}
		   public ImageIcon ResizeImage(String ImagePath)
		    {
		        ImageIcon MyImage = new ImageIcon(ImagePath);
		        Image img = MyImage.getImage();
		       Image newImg = img.getScaledInstance(lblNewLabel_9.getWidth(), lblNewLabel_9.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImg);
		        return image;
		    }
		    
		public void affiche ()
		{
			try {
				String requete ="SELECT `id`, `nom`, `prenom`, `date`, `sexe`, `nompartie`, `lienfb`, `lientwitter` FROM `candidats`";
				PreparedStatement  ps =connexion.getconnect().prepareStatement(requete);
				ResultSet res=ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));
			}catch (Exception exp) {
				System.out.println("exception="+exp);
			}
			
		}
		//matiere
	    private void deplace(int i)
	    {
	       try {     //i represente les ligne 
	     
	         id.setText(table.getValueAt (i, 0).toString());
	      // txttp.setSelectedItem(dt.getValueAt (i, 5).toString());
	        nom.setText(table.getValueAt (i, 1).toString());
	        // txtb.setSelectedItem(dt.getValueAt (i, 2).toString());
	         prenom.setText(table.getValueAt (i, 2).toString());
	         partie.setText(table.getValueAt(i, 5).toString());
	         fb.setText(table.getValueAt(i, 6).toString());
	         twitter.setText(table.getValueAt(i, 7).toString());
	         
	         
	      
	       
	       }catch (Exception e){ JOptionPane.showMessageDialog(null,"erreur de deplacement de message !!!!! "+e.getMessage());}
	      }
	    
}
