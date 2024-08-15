package Teams;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NBASimulationGame.LoginUser;
import NBASimulationGame.NewUser;
import javax.swing.JComboBox;

public class ChooseTeamGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String selectedTeam;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseTeamGUI frame = new ChooseTeamGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	public ChooseTeamGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 255, 255));
		panel.setBounds(6, 0, 150, 266);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(NewUser.class.getResource("/images/nba.png")));
		lblNewLabel.setBounds(-55, 6, 248, 254);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose your team!");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(236, 6, 208, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(259, 60, 98, 86);
		contentPane.add(lblNewLabel_2);
		
		
		Button button = new Button("Go to Draft!");
		button.setForeground(Color.RED);
		button.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		button.setBackground(new Color(254, 255, 255));
		button.setBounds(240, 207, 117, 29);
		contentPane.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			DraftingGUI draftPage = new DraftingGUI();
			draftPage.setVisible(true);
			}
		});
		

		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(204, 158, 208, 27);
		
		contentPane.add(comboBox);
		
		
		String[] teamNames = { "Atlanta Hawks",
			    "Boston Celtics",
			    "Chicago Bulls",
			    "Cleveland Cavaliers",
			    "Dallas Mavericks",
			    "Denver Nuggets",
			    "Detroit Pistons",
			    "Golden State Warriors",
			    "Houston Rockets",
			    "Los Angeles Clippers",
			    "Los Angeles Lakers",
			    "Miami Heat",
			    "Milwaukee Bucks",
			    "New York Knicks",
			    "Orlando Magic",
			    "Phoenix Suns"};

		for (String teamName : teamNames) {
		    comboBox.addItem(teamName);
		}
		lblNewLabel_2.setIcon(new ImageIcon(NewUser.class.getResource("/images/AtlantaHawks.png")));
		
		comboBox.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            selectedTeam = (String) comboBox.getSelectedItem();
	            
	            lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource(updateTeamLogo(selectedTeam))));
	        }
	    });
		
		
		
		
	
		
		
		
	}
	
	
	
	private String updateTeamLogo(String teamName) {
	    
		
	    Map<String, String> logoPaths = new HashMap<>();
	    logoPaths.put("Atlanta Hawks", "/images/AtlantaHawks.png"); 
	    logoPaths.put("Boston Celtics", "/images/BostonCeltics.png"); 
	    logoPaths.put("Chicago Bulls", "/images/ChicagoBulls.png"); 
	    logoPaths.put("Cleveland Cavaliers", "/images/ClevelandCavaliers.png"); 
	    logoPaths.put("Dallas Mavericks", "/images/DallasMavericks.png"); 
	    logoPaths.put("Denver Nuggets", "/images/DenverNuggets.png"); 
	    logoPaths.put("Detroit Pistons", "/images/DetroitPistons.png"); 
	    logoPaths.put("Golden State Warriors", "/images/GoldenStateWarriors.png"); 
	    logoPaths.put("Houston Rockets", "/images/HoustonRockets.png"); 
	    logoPaths.put("Los Angeles Clippers", "/images/LosAngelesClippers.png"); 
	    logoPaths.put("Los Angeles Lakers", "/images/LosAngelesLakers.png"); 
	    logoPaths.put("Miami Heat", "/images/MiamiHeat.png"); 
	    logoPaths.put("Milwaukee Bucks", "/images/MilwaukeeBucks.png"); 
	    logoPaths.put("New York Knicks", "/images/NewYorkKnicks.png"); 
	    logoPaths.put("Orlando Magic", "/images/OrlandoMagic.png"); 
	    logoPaths.put("Phoenix Suns", "/images/PhoenixSuns.png"); 

	    String logoPath = logoPaths.get(teamName);
	    return logoPath;
	    
	}
	
	
}
