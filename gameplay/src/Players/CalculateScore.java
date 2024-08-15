package Players;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CalculateScore {
	
	public static void main(String[] args) {
		String filePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/new_player_stats.csv";
		String outputFilePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/ScoresInCurrentMatch.txt";

        try {
            Map<String, Player> players = readPlayers(filePath);
            try (FileWriter writer = new FileWriter(outputFilePath)) {
                for (Player player : players.values()) {
                    String playerData = player.getPlayerName() + " - Score: " + String.format("%.2f", player.calculateScore()) + "\n";
                    System.out.println(playerData);
                    writer.write(playerData);
                }
            }
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}
	
	
	
	
	
	public static Map<String, Player> readPlayers(String filePath) throws IOException {
		
	    Map<String, Player> players = new HashMap<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line = reader.readLine();
	        
	        while ((line = reader.readLine()) != null) {
	            if (!line.trim().isEmpty()) {
	                String[] row = line.split(";");
	                Player newPlayer = createPlayer(row);
	                if (newPlayer != null) {
	                    players.put(newPlayer.getPlayerName(), newPlayer);
	                }
	            }
	        	}
	    }
	    return players;
	}

	private static Player createPlayer(String[] data) {
		String playerName = data[0];
		String position = data[1];
		int pts = (int) Double.parseDouble(data[2]);
		int trb = (int) Double.parseDouble(data[3]);
		int ast = (int) Double.parseDouble(data[4]);
		int blk = (int) Double.parseDouble(data[5]);
		int stl = (int) Double.parseDouble(data[6]);

		switch (position) {
		case "PG": return new PointGuard(playerName, position, pts, trb, ast, blk, stl, stl);
		case "SG": return new ShootingGuard(playerName, position, pts, trb, ast, blk, stl, stl);
		case "SF": return new SmallForward(playerName, position, pts, trb, ast, blk, stl, stl);
		case "PF": return new PowerForward(playerName, position, pts, trb, ast, blk, stl, stl);
		case "C": return new Center(playerName, position, pts, trb, ast, blk, stl, stl);

		default: return null;
		}


		
	}

}
