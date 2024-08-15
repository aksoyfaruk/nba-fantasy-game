package Teams;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MatchMaking.SeasonGUI;
import NBASimulationGame.LoginUser;

import java.awt.Font;
import java.awt.Color;

public class DraftingGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int NUMBER_OF_TEAMS = 16;
	private static final int PLAYERS_PER_TEAM = 12;
	private JPanel contentPane;
	private JButton draftButton;
	private JComboBox<String> playerComboBox;
	private JLabel roundLabel;
	private List<NewPlayersInfo> players;
	private Map<String, Map<String, Integer>> teamCompositions;
	private List<String> teams;
	private int currentRound;
	private int currentPlayerIndex;
	private Random random = new Random();
	private Map<String, String> draftedPlayers;

	
	String userTeam = ChooseTeamGUI.selectedTeam;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;


	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DraftingGUI frame = new DraftingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public DraftingGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		players = LoadFromCsv.loadPlayers("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/new_player_stats.csv"); 
		initializeTeams();
		
		draftedPlayers = new HashMap<>();

		
		playerComboBox = new JComboBox<>();
		playerComboBox.setBounds(199, 257, 194, 27);
		roundLabel = new JLabel("Round: 1");
		roundLabel.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		roundLabel.setBounds(94, 261, 56, 16);
		draftButton = new JButton("Draft Player");
		draftButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		draftButton.setBounds(425, 256, 117, 29);
		draftButton.addActionListener(new DraftButtonListener());
		contentPane.setLayout(null);


		contentPane.add(roundLabel);
		contentPane.add(playerComboBox);
		contentPane.add(draftButton);
		
		String logoPath = updateTeamLogo(userTeam);
	    ImageIcon teamLogo = new ImageIcon(getClass().getResource(logoPath));
	    JLabel lblNewLabel = new JLabel(teamLogo);
	    lblNewLabel.setBounds(242, 146, 104, 84);
	    contentPane.add(lblNewLabel);
	    
	    lblNewLabel_1 = new JLabel("Welcome to 2024 NBA Drafts!");
	    lblNewLabel_1.setForeground(Color.BLUE);
	    lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
	    lblNewLabel_1.setBounds(176, 21, 239, 34);
	    contentPane.add(lblNewLabel_1);
	    
	    btnNewButton = new JButton("View Team");
	    btnNewButton.setForeground(Color.RED);
	    btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
	    btnNewButton.setBounds(351, 470, 117, 29);
	    contentPane.add(btnNewButton);
	    
	    btnNewButton_1 = new JButton("Match Making");
	    btnNewButton_1.setFont(new Font("American Typewriter", Font.PLAIN, 13));
	    btnNewButton_1.setForeground(Color.RED);
	    btnNewButton_1.setBounds(125, 469, 117, 29);
	    contentPane.add(btnNewButton_1);
	    
	    
	    
	    btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SeasonGUI startSeason = new SeasonGUI();
				startSeason.setVisible(true);
				
			}
		});
	    
	    
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    		ViewTeam viewTeam = new ViewTeam();
	    		viewTeam.setVisible(true);
	    	}
	    })	;    
	    


		
		currentRound = 1;
		currentPlayerIndex = 0;
		updatePlayerComboBox();
		
		performDraft();
		
		draftedPlayers = new HashMap<>();
	}

	private void initializeTeams() {
		teams = new ArrayList<>();
        teamCompositions = new HashMap<>();
        
        
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
            teams.add(teamName);
            Map<String, Integer> positions = new HashMap<>();
            positions.put("PG", 0);
            positions.put("SF", 0);
            positions.put("SG", 0);
            positions.put("PF", 0);
            positions.put("C", 0);
            teamCompositions.put(teamName, positions);
        }
        Collections.shuffle(teams);
    }
	

	private void updatePlayerComboBox() {
		playerComboBox.removeAllItems();
        for (NewPlayersInfo player : players) {
        	String playerInfo = player.getPlayerName() + " - " + player.getPosition();
            playerComboBox.addItem(playerInfo);
        }
    }
	

	
	
	
	private String findPositionNeedingPlayers(String team) {
        Map<String, Integer> positions = teamCompositions.get(team);
        return positions.entrySet().stream()
                        .min(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse("");
    }
	
	private NewPlayersInfo autoDraftPlayerForTeam(String team) {
        Map<String, Integer> positions = teamCompositions.get(team);
        List<NewPlayersInfo> eligiblePlayers = new ArrayList<>();
        
    
        String neededPosition = findPositionNeedingPlayers(team);
        
        for (NewPlayersInfo player : players) {
            if (player.getPosition().equals(neededPosition)) {
                eligiblePlayers.add(player);
            }
        }

        if (!eligiblePlayers.isEmpty()) {
            NewPlayersInfo draftedPlayer = eligiblePlayers.get(random.nextInt(eligiblePlayers.size()));
            positions.put(draftedPlayer.getPosition(), positions.get(draftedPlayer.getPosition()) + 1);
            return draftedPlayer;
        }

        return null;
    }
        
//	IT WAS FOR CHECKING PROCESS OF THE CLASS
//	private void printFinalTeamCompositions() {
//        for (String team : teams) {
//            Map<String, Integer> composition = teamCompositions.get(team);
//            System.out.println("Team: " + team);
//            for (Map.Entry<String, Integer> entry : composition.entrySet()) {
//                System.out.println("Position: " + entry.getKey() + ", Count: " + entry.getValue());
//            }
//            System.out.println("-----------------------------");
//        }
//    }
	

	
	private void writeDraftHistoryToFile() {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("draftHistory.txt"))) {
	        for (String team : teams) {
	        	
	            writer.write("Team: "+ team + "\n");
	            for (Map.Entry<String, String> entry : draftedPlayers.entrySet()) {
	                if (entry.getValue().equals(team)) {
	                    writer.write(entry.getKey() + "\n"); 
	                }
	            }
	            writer.write("-------------------------------\n");
	        }
	    } 
		
		catch (IOException e) {
	        e.printStackTrace();
	    }
    }
	
	
	
	
	
	private void performDraft() {
		while (currentPlayerIndex < NUMBER_OF_TEAMS * PLAYERS_PER_TEAM) {
	        String currentTeam = teams.get(currentPlayerIndex % NUMBER_OF_TEAMS);
	        
	        
	        if (!currentTeam.equals(userTeam)) {
	            NewPlayersInfo draftedPlayer = autoDraftPlayerForTeam(currentTeam);
	            if (draftedPlayer != null) {
	                players.remove(draftedPlayer);
	                draftedPlayers.put(draftedPlayer.getPlayerName(), currentTeam);
	                System.out.println(currentTeam + " auto-selected " + draftedPlayer.getPlayerName() + " - " + draftedPlayer.getPosition());
	            }
	            proceedToNextPick();
	        } 
	        else {
	            
	            updatePlayerComboBox();
	            break; 
	        }
	    }
		
		
	    if (currentPlayerIndex >= NUMBER_OF_TEAMS * PLAYERS_PER_TEAM) {
	        endDraft();
	    }
	}

	
	
	
	
	private void proceedToNextPick() {
	    currentPlayerIndex++;
	    if (currentPlayerIndex % NUMBER_OF_TEAMS == 0) {
	        currentRound++;
	        roundLabel.setText("Round: " + currentRound);
	        Collections.reverse(teams); 
	    }
	}

	
	
	
	
	private void endDraft() {
	    JOptionPane.showMessageDialog(DraftingGUI.this, "Draft is complete");
	    draftButton.setEnabled(false);
	    writeDraftHistoryToFile();
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
    
    

	
	

	private class DraftButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedPlayerInfo = (String) playerComboBox.getSelectedItem();
	        handleUserSelection(selectedPlayerInfo);
	        continueDrafting(); // Continue the draft after user's pick
	    }

	    private void handleUserSelection(String playerInfo) {
	       
	        String selectedPlayerName = playerInfo.split(" - ")[0];
	        NewPlayersInfo draftedPlayer = findPlayerByName(selectedPlayerName);
	        if (draftedPlayer != null) {
	            players.remove(draftedPlayer);
	            draftedPlayers.put(draftedPlayer.getPlayerName(), userTeam);
	            System.out.println(userTeam + " selected " + draftedPlayer.getPlayerName() + " - " + draftedPlayer.getPosition());
	            proceedToNextPick();
	        }
		    
		}
	    
	    
	    
	    
	    
		
	    private void continueDrafting() {
	        while (currentPlayerIndex < NUMBER_OF_TEAMS * PLAYERS_PER_TEAM) {
	            String currentTeam = teams.get(currentPlayerIndex % NUMBER_OF_TEAMS);
	            if (!currentTeam.equals(userTeam)) {
	                NewPlayersInfo draftedPlayer = autoDraftPlayerForTeam(currentTeam);
	                if (draftedPlayer != null) {
	                    players.remove(draftedPlayer);
	                    draftedPlayers.put(draftedPlayer.getPlayerName(), currentTeam);
	                    System.out.println(currentTeam + " auto-selected " + draftedPlayer.getPlayerName() + " - "+ draftedPlayer.getPosition());
	                }
	                proceedToNextPick();
	            } 
	            
	            else {
	                
	                updatePlayerComboBox();
	                break;
	            }
	        }
	        if (currentPlayerIndex >= NUMBER_OF_TEAMS * PLAYERS_PER_TEAM) {
	            endDraft();
	        }
		}
	    
	    
	    
	  
	    
		
	    private NewPlayersInfo findPlayerByName(String name) {
	        for (NewPlayersInfo player : players) {
	            if (player.getPlayerName().equals(name)) {
	                return player;
	            }
	        }
	        return null;
	    }
	    
	    
	    
	    
	    
			

	}
}
