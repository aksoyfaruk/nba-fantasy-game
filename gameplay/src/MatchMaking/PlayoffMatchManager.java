package MatchMaking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Players.CalculateScore;

public class PlayoffMatchManager {
	
	public static void main(String[] args) {
        try {
            
        	
            String inputFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/SeasonResults.txt";
            String scoresFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/CurrentScoreOfTeams.txt";
            String outputFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/PlayoffResults.txt";

       
            PlayoffMatchManager manager = new PlayoffMatchManager();

         
            manager.updateScoresAndResults();

            
            manager.writePlayoffResults(inputFilePath, outputFilePath, scoresFilePath);
            
            String semifinalFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/SemifinalPlayers.txt";
            manager.writeSemifinalTeams(outputFilePath, semifinalFilePath);
            

            List<String> semifinalResults = manager.simulateSemifinalMatches(semifinalFilePath);
            String finalistFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/Finalists.txt";
            manager.writeFinalistTeams(semifinalResults, finalistFilePath);

            System.out.println("Playoff simulation with semifinals and finals completed successfully.");
            
            manager.simulateFinalMatchAndWriteChampion();
            System.out.println("Champion determined and written to file.");


            System.out.println("Playoff simulation completed successfully.");
        } 
        
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during the playoff simulation.");
        }
        
       
        
    }
    


	



	private List<String> getTopEightTeams(String filePath) {
		List<String> topTeams = new ArrayList<>();
		Map<String, Integer> teamWins = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			reader.readLine(); // Skip the header line
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" - Wins: ");
				if (parts.length > 1) {
					String teamName = parts[0].trim();
					int wins = Integer.parseInt(parts[1].split(",")[0].trim());
					teamWins.put(teamName, wins);
				}
			}
		} catch (IOException e) {
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

	
	
	
	public void updateScoresAndResults() {
		CalculateScore.main(null); 
		CurrentMatchResults.main(null); 
	}
	
	
	
	
	
	
	private Map<String, Double> readCurrentScores(String filePath) throws IOException {
        Map<String, Double> scores = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - Total Score: ");
                
                if (parts.length == 2) {
                    scores.put(parts[0], Double.parseDouble(parts[1]));
                }
            }
        }
        return scores;
    }
	
	
	


	
	
    public void writePlayoffResults(String inputFilePath, String outputFilePath, String scoresFilePath) throws IOException {
    	
    	Map<String, Double> currentScores = readCurrentScores(scoresFilePath);
        List<String> topTeams = getTopEightTeams(inputFilePath);
        Random random = new Random();

        try (FileWriter writer = new FileWriter(outputFilePath)) {
        	
            writer.write("----------First Games of the Playoffs----------\n");  
            for (int i = 0; i < topTeams.size(); i += 2) {
                boolean isTeam1Home = random.nextBoolean();
                double team1Score = currentScores.getOrDefault(topTeams.get(i), 0.0);
                double team2Score = currentScores.getOrDefault(topTeams.get(i + 1), 0.0);

                
                if (isTeam1Home) {
                    team1Score *= 1.05;
                } 
                else {
                    team2Score *= 1.05;
                }

                writer.write(topTeams.get(i) + " - Score: " + String.format("%.1f", team1Score) + "\n");
                writer.write(topTeams.get(i + 1) + " - Score: " + String.format("%.1f", team2Score) + "\n");
            }
            writer.write("-------------------- \n");
        }
        
    }
    
    public void writeFinalistTeams(List<String> semifinalResults, String finalistFilePath) throws IOException {
        try (FileWriter writer = new FileWriter(finalistFilePath)) {
        	writer.write("----------Finalists of the Playoffs----------\n"); 
            for (String team : semifinalResults) {
                writer.write(team + "\n");
            }
        }
    }
    
    public void writeSemifinalTeams(String playoffResultsPath, String semifinalFilePath) throws IOException {
    	List<String> playoffResults = new ArrayList<>();
        List<String> semifinalTeamsWithScores = new ArrayList<>();

    
        try (BufferedReader reader = new BufferedReader(new FileReader(playoffResultsPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(" - Score: ")) {
                    playoffResults.add(line);
                }
            }
        }

        
        for (int i = 0; i < playoffResults.size(); i += 2) {
            String team1 = playoffResults.get(i);
            String team2 = playoffResults.get(i + 1);

            double score1 = Double.parseDouble(team1.split(" - Score: ")[1]);
            double score2 = Double.parseDouble(team2.split(" - Score: ")[1]);

            if (score1 > score2) {
                semifinalTeamsWithScores.add(team1);
            } 
            else {
                semifinalTeamsWithScores.add(team2);
            }
        }

        
        
       
        try (FileWriter writer = new FileWriter(semifinalFilePath)) {
            for (String team : semifinalTeamsWithScores) {
                writer.write(team + "\n");
            }
        }
        
        
    }
    
    
    
    public List<String> simulateSemifinalMatches(String semifinalFilePath) throws IOException {
        List<String> semifinalResults = new ArrayList<>();
        List<String> semifinalTeams = new ArrayList<>();

       
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(semifinalFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                semifinalTeams.add(line);
            }
        }

  
//        I got errors that I couldn't fix then i make it random
        
        Random random = new Random();
        for (int i = 0; i < semifinalTeams.size(); i += 2) {
        	
            String team1 = semifinalTeams.get(i);
            String team2 = semifinalTeams.get(i + 1);

         
            
            String winningTeam = random.nextBoolean() ? team1 : team2;
            semifinalResults.add(winningTeam);
        }

        return semifinalResults;
    }
    
    
    
    
//    FINALS
    
    public void simulateFinalMatchAndWriteChampion() throws IOException {
        String finalistFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/Finalists.txt"; // Update with correct path
        String championFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/Champion.txt"; // Update with correct path

    
        String[] finalists = readFinalists(finalistFilePath);

    
        String winner = simulateMatchAndDetermineWinner(finalists);

    
        try (FileWriter writer = new FileWriter(championFilePath)) {
        	writer.write("!!!Champion!!! \n");
            writer.write(winner);
        }
    }

    private String[] readFinalists(String filePath) throws IOException {
    	
    	
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] finalists = new String[2];
            int index = 0;
            while ((line = reader.readLine()) != null && index < 2) {
                finalists[index++] = line;
            }
            return finalists;
        }
    }

    private String simulateMatchAndDetermineWinner(String[] finalists) {
    	
        Random random = new Random();
        boolean isTeam1Home = random.nextBoolean();

        double team1Score = extractScore(finalists[0]);
        double team2Score = extractScore(finalists[1]);

        if (isTeam1Home) {
            team1Score *= 1.05;
        } else {
            team2Score *= 1.05;
        }

        return team1Score > team2Score ? extractTeamName(finalists[0]) : extractTeamName(finalists[1]);
    }

    private double extractScore(String result) {
        String[] parts = result.split(" - Score: ");
        return parts.length == 2 ? Double.parseDouble(parts[1]) : 0.0;
    }

    private String extractTeamName(String result) {
        String[] parts = result.split(" - Score: ");
        return parts[0];
    }

    

    
    

}
