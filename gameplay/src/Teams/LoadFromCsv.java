package Teams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class LoadFromCsv {
	
	public static List<NewPlayersInfo> loadPlayers(String filePath) {
		
        List<NewPlayersInfo> players = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/new_player_stats.csv"))) {
            String line = br.readLine(); 

            while ((line = br.readLine()) != null) {
            	
                String[] values = line.split(";");
                String name = values[0].trim();
                String position = values[1].trim();
                
                
                int points = Integer.parseInt(values[2].trim());
                int totalRebounds = Integer.parseInt(values[3].trim());
                int assists = Integer.parseInt(values[4].trim());
                int blocks = Integer.parseInt(values[5].trim());
                int steals = Integer.parseInt(values[6].trim());
                
                players.add(new NewPlayersInfo(name, position, points, totalRebounds, assists, blocks, steals));
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }


}
