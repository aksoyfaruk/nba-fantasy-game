package MatchMaking;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class PlayoffsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	private JLabel lblNewLabel_1_6;
	private JLabel lblNewLabel_1_7;
	private JLabel lblNewLabel_1_8;
	private JLabel lblNewLabel_1_9;
	private JLabel lblNewLabel_1_10;

	private javax.swing.Timer timer;
	private javax.swing.Timer timer2;
	private javax.swing.Timer timer3;


	private boolean isPaused = false;
	private JLabel lblNewLabel_1_11;
	private JLabel lblNewLabel_1_12;
	private JLabel lblNewLabel_1_13;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayoffsGUI frame = new PlayoffsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public PlayoffsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Team 1");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel.setBounds(18, 98, 154, 22);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Team 2");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(18, 126, 154, 22);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_1_1 = new JLabel("Team 3");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(18, 194, 154, 22);
		contentPane.add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("Team 4");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(18, 228, 154, 22);
		contentPane.add(lblNewLabel_1_2);

		lblNewLabel_1_3 = new JLabel("Team 5");
		lblNewLabel_1_3.setForeground(Color.BLUE);
		lblNewLabel_1_3.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(18, 282, 154, 22);
		contentPane.add(lblNewLabel_1_3);

		lblNewLabel_1_4 = new JLabel("Team 6");
		lblNewLabel_1_4.setForeground(Color.BLUE);
		lblNewLabel_1_4.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(18, 316, 154, 22);
		contentPane.add(lblNewLabel_1_4);

		lblNewLabel_1_5 = new JLabel("Team 7");
		lblNewLabel_1_5.setForeground(Color.BLUE);
		lblNewLabel_1_5.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(18, 360, 154, 22);
		contentPane.add(lblNewLabel_1_5);

		lblNewLabel_1_6 = new JLabel("Team 8");
		lblNewLabel_1_6.setForeground(Color.BLUE);
		lblNewLabel_1_6.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(18, 394, 154, 22);
		contentPane.add(lblNewLabel_1_6);

		lblNewLabel_1_7 = new JLabel("Team label");
		lblNewLabel_1_7.setForeground(Color.BLUE);
		lblNewLabel_1_7.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_7.setBounds(185, 139, 145, 22);
		contentPane.add(lblNewLabel_1_7);

		lblNewLabel_1_8 = new JLabel("Team label");
		lblNewLabel_1_8.setForeground(Color.BLUE);
		lblNewLabel_1_8.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_8.setBounds(184, 174, 146, 22);
		contentPane.add(lblNewLabel_1_8);

		lblNewLabel_1_9 = new JLabel("Team label");
		lblNewLabel_1_9.setForeground(Color.BLUE);
		lblNewLabel_1_9.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_9.setBounds(185, 326, 145, 22);
		contentPane.add(lblNewLabel_1_9);

		lblNewLabel_1_10 = new JLabel("Team label");
		lblNewLabel_1_10.setForeground(Color.BLUE);
		lblNewLabel_1_10.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_10.setBounds(185, 360, 145, 22);
		contentPane.add(lblNewLabel_1_10);

		lblNewLabel_1_11 = new JLabel("Team label");
		lblNewLabel_1_11.setForeground(Color.BLUE);
		lblNewLabel_1_11.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_11.setBounds(309, 228, 128, 22);
		contentPane.add(lblNewLabel_1_11);

		lblNewLabel_1_12 = new JLabel("Team label");
		lblNewLabel_1_12.setForeground(Color.BLUE);
		lblNewLabel_1_12.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_12.setBounds(309, 269, 128, 22);
		contentPane.add(lblNewLabel_1_12);

		lblNewLabel_1_13 = new JLabel("Team label");
		lblNewLabel_1_13.setForeground(Color.BLUE);
		lblNewLabel_1_13.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1_13.setBounds(449, 240, 134, 22);
		contentPane.add(lblNewLabel_1_13);





		displayTopEightTeams();
		
		
		

				timer = new javax.swing.Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSecondRoundWinners();
			}
		});
		timer.setRepeats(false); 

		timer.start(); 

		
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(438, 482, 117, 29);
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()) {
					timer.stop();
					btnPause.setText("Resume");
					isPaused = true;
				} 
				
				else if (isPaused) {
					timer.start();
					btnPause.setText("Pause");
					isPaused = false;
				}
			}
		});
		contentPane.add(btnPause);
		
		JLabel lblNewLabel_2 = new JLabel("2024 NBA Playoffs");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(221, 6, 154, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quarter Finals");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(18, 70, 94, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Semi Finals");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(174, 69, 94, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Final");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblNewLabel_3_2.setBounds(297, 69, 94, 16);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Champion");
		lblNewLabel_3_3.setForeground(Color.RED);
		lblNewLabel_3_3.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblNewLabel_3_3.setBounds(438, 69, 94, 16);
		contentPane.add(lblNewLabel_3_3);
		
		JButton btnNewButton = new JButton("End the Game");
		btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		btnNewButton.setBounds(18, 482, 117, 29);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
    			dispose(); }
        });        
	
		
		
		timer2 = new javax.swing.Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateFinalists();
			}
		});
		timer2.setRepeats(false); 
		timer2.start(); 

		
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer2.isRunning()) {
					timer2.stop();
					btnPause.setText("Resume");
					isPaused = true;
				} 
				
				else if (isPaused) {
					timer2.start();
					btnPause.setText("Pause");
					isPaused = false;
				}
			}
		});

		timer3 = new javax.swing.Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateChampion();
			}
		});
		timer3.setRepeats(false); 
		timer3.start(); 


		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer2.isRunning()) {
					timer2.stop();
					btnPause.setText("Resume");
					isPaused = true;
				} 
				
				else if (isPaused) {
					timer2.start();
					btnPause.setText("Pause");
					isPaused = false;
				}
			}
		});


	}




	private List<String> getTopEightTeams(String filePath) {
		List<String> topTeams = new ArrayList<>();
		Map<String, Integer> teamWins = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			reader.readLine(); 
			
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" - Wins: ");
				if (parts.length > 1) {
					String teamName = parts[0].trim();
					int wins = Integer.parseInt(parts[1].split(",")[0].trim());
					teamWins.put(teamName, wins);
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(teamWins.entrySet());
		entries.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		
		for (int i = 0; i < Math.min(entries.size(), 8); i++) {
			topTeams.add(entries.get(i).getKey());
		}

		return topTeams;
	}


	private void displayTopEightTeams() {
		List<String> topTeams = getTopEightTeams("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/SeasonResults.txt");
		JLabel[] teamLabels = getTeamLabelsArray();

		for (int i = 0; i < topTeams.size(); i++) {
			teamLabels[i].setText(topTeams.get(i));
		}
	}

	
	private JLabel[] getTeamLabelsArray() {

		
		return new JLabel[] { lblNewLabel, lblNewLabel_1, lblNewLabel_1_1, lblNewLabel_1_2,
				lblNewLabel_1_3, lblNewLabel_1_4, lblNewLabel_1_5, lblNewLabel_1_6 };
	}


	private List<String> readPlayoffResults(String filePath) throws IOException {
		List<String> results = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				results.add(line);
			}
		}
		return results;
	}


	private void updateSecondRoundWinners() {
		try {
			List<String> playoffResults = readPlayoffResults("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/PlayoffResults.txt");
			JLabel[] secondRoundLabels = { lblNewLabel_1_7, lblNewLabel_1_8, lblNewLabel_1_9, lblNewLabel_1_10 };

			for (int i = 0; i < 4; i++) {

				String team1Result = playoffResults.get(2 * i);
				String team2Result = playoffResults.get(2 * i + 1);
				String winningTeam = determineWinner(team1Result, team2Result);
				secondRoundLabels[i].setText(winningTeam);
				System.out.println(team1Result);
				System.out.println(team2Result);
			}

		} 
		catch (IOException e) {
			e.printStackTrace();
			
		}


	}



	private void updateFinalists() {
		try {
			List<String> finalists = readPlayoffResults("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/Finalists.txt");
			JLabel[] finalLabels = { lblNewLabel_1_11, lblNewLabel_1_12 };

//			System.out.println(finalists.size());
			for (int i = 0; i < finalists.size(); i++) {
				finalLabels[i].setText(finalists.get(i));
			}

		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	private String determineWinner(String team1Result, String team2Result) {
		double team1Score = extractScore(team1Result);
		double team2Score = extractScore(team2Result);
		
		return team1Score > team2Score ? extractTeamName(team1Result) : extractTeamName(team2Result);
	}

	private double extractScore(String result) {
		String[] parts = result.split(" - Score: ");
		
		return parts.length == 2 ? Double.parseDouble(parts[1]) : 0.0;
	}

	private String extractTeamName(String result) {
		
		String[] parts = result.split(" - Score: ");
		return parts[0];
	}
	
	
	private void updateChampion() {
		try {
			List<String> champion = readPlayoffResults("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/Champion.txt");
			
			JLabel[] championLabels = { lblNewLabel_1_13 };
		
			for (int i = 0; i < champion.size(); i++) {
				championLabels[i].setText(champion.get(i));
			}

		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}
}
