package MatchMaking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Players.CalculateScore;

public class MatchDataManager {
	
	
	private List<String> teamNames = Arrays.asList(
	        "Atlanta Hawks", "Boston Celtics", "Chicago Bulls", "Cleveland Cavaliers",
	        "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Golden State Warriors",
	        "Houston Rockets", "Los Angeles Clippers", "Los Angeles Lakers", "Miami Heat",
	        "Milwaukee Bucks", "New York Knicks", "Orlando Magic", "Phoenix Suns"
	    );
	
	private List<List<String>> matchups = new ArrayList<>();
    private Map<String, Integer> wins = new HashMap<>();
    private Map<String, Integer> losses = new HashMap<>();
    private Map<String, Integer> ties = new HashMap<>();
    
    

    public MatchDataManager() {
       
    	for (String team : teamNames) {
            wins.put(team, 0);
            losses.put(team, 0);
            ties.put(team, 0);
        }
    }

    private void generateMatchups() {
        
    	List<String> teamsPool = new ArrayList<>(teamNames);
        Map<String, Integer> matchCount = new HashMap<>();
        for (String team : teamNames) {
            matchCount.put(team, 0);
        }

        
        
        while (teamsPool.size() > 1) {
            Collections.shuffle(teamsPool);
            String team1 = teamsPool.get(0);
            String team2 = teamsPool.get(1);

            if (!team1.equals(team2) && matchCount.get(team1) < 5 && matchCount.get(team2) < 5) {
                List<String> matchup = new ArrayList<>();
                matchup.add(team1);
                matchup.add(team2);
                matchups.add(matchup);

              
            
                matchCount.put(team1, matchCount.get(team1) + 1);
                matchCount.put(team2, matchCount.get(team2) + 1);

                
                if (matchCount.get(team1) == 5) {
                    teamsPool.remove(team1);
                }
                if (matchCount.get(team2) == 5) {
                    teamsPool.remove(team2);
                }
            }
        }
    	


    }
    
    
    public void runCalculateScoreAndUpdateResults() {
        CalculateScore.main(null); 
        CurrentMatchResults.main(null); 
        
    }
    
    

    private void simulateMatch(String team1, String team2) {
    	double team1Score = readTeamScore(team1);
        double team2Score = readTeamScore(team2);

        
        boolean isTeam1Home = new Random().nextBoolean();
        if (isTeam1Home) {
            team1Score *= 1.05;
        } else {
            team2Score *= 1.05;
        }

       
        if (team1Score > team2Score) {
            wins.put(team1, wins.get(team1) + 1);
            losses.put(team2, losses.get(team2) + 1);
        } else if (team2Score > team1Score) {
            wins.put(team2, wins.get(team2) + 1);
            losses.put(team1, losses.get(team1) + 1);
        } else {
            ties.put(team1, ties.get(team1) + 1);
            ties.put(team2, ties.get(team2) + 1);
        }
    }
    
    
   
    
    private double readTeamScore(String teamName) {
        String filePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/CurrentScoreOfTeams.txt"; // Update with the actual file path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(teamName)) {
                    
                	
                    String[] parts = line.split(" - Total Score: ");
                    if (parts.length > 1) {
                        return Double.parseDouble(parts[1].trim());
                    }
                    break;
                }
            }
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    
    public void runSeason() {
    	generateMatchups();
    	for (List<String> matchup : matchups) {
            runCalculateScoreAndUpdateResults(); 
            simulateMatch(matchup.get(0), matchup.get(1));
        }
    }
    
    
    void writeResultsToFile(String filePath) {
    	try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Team - Wins - Losses - Ties\n");

            
            List<String> sortedTeams = new ArrayList<>(teamNames);
            Collections.sort(sortedTeams, new Comparator<String>() {
            	
            	
                @Override
                public int compare(String team1, String team2) {
                    return wins.get(team2).compareTo(wins.get(team1));
                }
            });

            
            for (String team : sortedTeams) {
                String result = team + " - Wins: " + wins.get(team) + ", Losses: " + losses.get(team) + ", Ties: " + ties.get(team) + "\n";
                writer.write(result);
            }
        } 
    	catch (IOException e) {
            e.printStackTrace();
        }
    }

   

    
    public static void main(String[] args) {
        MatchDataManager manager = new MatchDataManager();
        manager.runSeason();
        manager.writeResultsToFile("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/SeasonResults.txt");
        
        
    }

}
