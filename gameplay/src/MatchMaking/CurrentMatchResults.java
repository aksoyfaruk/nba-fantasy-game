package MatchMaking;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentMatchResults {
	
	public static void main(String[] args) {
		String draftFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/draftHistory.txt";
		String scoresFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/ScoresInCurrentMatch.txt";
		String outputFilePath ="/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/CurrentScoreOfTeams.txt";
		try {
			writeTeamScoresToFile(draftFilePath,scoresFilePath,outputFilePath);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static Map<String, List<String>> readDraftHistory(String filePath) throws IOException {
        Map<String, List<String>> teamDrafts = new HashMap<>();
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String currentTeam = null;
            List<String> players = null;

            while ((line = reader.readLine()) != null) {
            	
                if (line.startsWith("Team: ")) {
                	
                    if (currentTeam != null) {
                        teamDrafts.put(currentTeam, players);
                    }
                    currentTeam = line.substring(6); 
                    players = new ArrayList<>();
                } 
                else if (!line.trim().isEmpty() && !line.startsWith("-----")) {
                    players.add(line.trim());
                }
            }
            if (currentTeam != null) {
                teamDrafts.put(currentTeam, players); 
            }
        }
        return teamDrafts;
    }
	
	
	
	public static Map<String, Double> readPlayerScores(String filePath) throws IOException {
		

	    Map<String, Double> playerScores = new HashMap<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;

	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(" - Score: ");
	            if (parts.length == 2) {
	                String playerName = parts[0].trim();
	                double score = Double.parseDouble(parts[1].trim());
	                playerScores.put(playerName, score);
	            }
	        }
	    }
	    
	    return playerScores;
	}
	
	public static Map<String, Double> calculateTeamScores(String draftFilePath, String scoresFilePath) throws IOException {
		
	    Map<String, List<String>> teamDrafts = readDraftHistory(draftFilePath);
	    Map<String, Double> playerScores = readPlayerScores(scoresFilePath);
	    Map<String, Double> teamScores = new HashMap<>();

	    for (Map.Entry<String, List<String>> teamEntry : teamDrafts.entrySet()) {
	        double totalScore = 0;
	        for (String player : teamEntry.getValue()) {
	            totalScore += playerScores.getOrDefault(player, 0.0);
	        }
	        teamScores.put(teamEntry.getKey(), totalScore);
	    }

	    return teamScores;
	}
	
	
	public static void writeTeamScoresToFile(String draftFilePath, String scoresFilePath, String outputFilePath) throws IOException {
		
		
        Map<String, Double> teamScores = calculateTeamScores(draftFilePath, scoresFilePath);

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (Map.Entry<String, Double> entry : teamScores.entrySet()) {
                writer.write(entry.getKey() + " - Total Score: " + String.format("%.2f", entry.getValue()) + "\n");
            }
        }
    }

	
}
