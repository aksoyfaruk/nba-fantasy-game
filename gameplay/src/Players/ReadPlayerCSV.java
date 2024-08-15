package Players;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadPlayerCSV {
	public static void main(String[] args) throws IOException {


	        
  
	        String inputFile = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/2022-2023 NBA Player Stats - Regular.csv";
	        String outputFile = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/new_player_stats.csv";
	        
	        try {
	            Map<String, Player> players = readPlayers(inputFile);
	            writeAveragedPlayersToFile(players, outputFile);
	            
	            System.out.println("Processed data has been written to " + outputFile);
	        } 
	        
	        catch (IOException e) {
	            System.err.println("An error occurred: " + e.getMessage());
	        }
	        
	    }

	    public static Map<String, Player> readPlayers(String filePath) throws IOException {
	        Map<String, Player> players = new HashMap<>();
	        Map<String, Integer> playerCounts = new HashMap<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line = reader.readLine(); 
	            
	            while ((line = reader.readLine()) != null) {
	                String[] row = line.split(";");
	                String playerName = row[1];
	                if (players.containsKey(playerName)) {
	                    Player existingPlayer = players.get(playerName);
	                    if (existingPlayer != null) {
	                        updatePlayerStats(existingPlayer, row);
	                    }
	                    playerCounts.put(playerName, playerCounts.get(playerName) + 1);
	                } else {
	                    Player newPlayer = createPlayer(row);
	                    if (newPlayer != null) {
	                        players.put(playerName, newPlayer);
	                        playerCounts.put(playerName, 1);
	                    }
	                }
	            }
	        }

	        for (Map.Entry<String, Player> entry : players.entrySet()) {
	            averagePlayerStats(entry.getValue(), playerCounts.get(entry.getKey()));
	        }

	        return players;
	    }

	    private static Player createPlayer(String[] data) {
	        String playerName = data[1];
	        String position = data[2];
	        int pts = (int) Double.parseDouble(data[29]);
            int trb = (int) Double.parseDouble(data[23]);
            int ast = (int) Double.parseDouble(data[24]);
            int blk = (int) Double.parseDouble(data[26]);
            int stl = (int) Double.parseDouble(data[25]);
            
            switch (position) {
            case "PG": return new PointGuard(playerName, position, pts, trb, ast, blk, stl, stl);
            case "SG": return new ShootingGuard(playerName, position, pts, trb, ast, blk, stl, stl);
            case "SF": return new SmallForward(playerName, position, pts, trb, ast, blk, stl, stl);
            case "PF": return new PowerForward(playerName, position, pts, trb, ast, blk, stl, stl);
            case "C": return new Center(playerName, position, pts, trb, ast, blk, stl, stl);
            
            default: return null;
            }
	        
	        
	       
	    }

	    private static void updatePlayerStats(Player player, String[] data) {
	        
	    	int pts = (int) Double.parseDouble(data[29]);
            int trb = (int) Double.parseDouble(data[23]);
            int ast = (int) Double.parseDouble(data[24]);
            int blk = (int) Double.parseDouble(data[26]);
            int stl = (int) Double.parseDouble(data[25]);
	    	
	    	player.setPTS(player.getPTS() + pts);
	        player.setTRB(player.getTRB() + trb);
	        player.setAST(player.getAST() + ast);
	        player.setBLK(player.getBLK() + blk);
	        player.setSTL(player.getSTL() + stl);
	    }

	    private static void averagePlayerStats(Player player, int count) {
	        
	    	player.setPTS(player.getPTS() / count);
	        player.setTRB(player.getTRB() / count);
	        player.setAST(player.getAST() / count);
	        player.setBLK(player.getBLK() / count);
	        player.setSTL(player.getSTL() / count);
	    

	    }
	    
	    public static void writeAveragedPlayersToFile(Map<String, Player> players, String outputPath) throws IOException {
	    	try (FileWriter csvWriter = new FileWriter("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/new_player_stats.csv")) {
	    		
	    		csvWriter.append("Name;Position;PTS;TRB;AST;BLK;STL\n");

	    	
	    		for (Player player : players.values()) {
	    			csvWriter.append(player.getPlayerName())
	    			.append(";")
	    			.append(player.getPosition())
	    			.append(";")
	    			.append(String.valueOf(player.getPTS()))
	    			.append(";")
	    			.append(String.valueOf(player.getTRB()))
	    			.append(";")
	    			.append(String.valueOf(player.getAST()))
	    			.append(";")
	    			.append(String.valueOf(player.getBLK()))
	    			.append(";")
	    			.append(String.valueOf(player.getSTL()))
	    			.append("\n");
	    		}
	    	}
	    }





}		








// I HAVE USED THESE CODES FOR CHECKING THE PROCESS WHEN CREATING THE CLASS AND LEFT FOR FURTHER CHECK PROCESSES

/* REMOVING FROM DUPLICATES USING SETS
 
		String file = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/2022-2023 NBA Player Stats - Regular.csv";
		BufferedReader reader = null;
		List <Player> playersData = new ArrayList<>();
		Set <String> playerNames = new HashSet<>();
		
		try {
		
		
			reader = new BufferedReader(new FileReader(file));
			String line;
			line = reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(";");
				if (playerNames.add(row[1])) { 
					String playerName = row[1];
                    String position = row[2];
                    int pts = (int) Double.parseDouble(row[29]);
                    int trb = (int) Double.parseDouble(row[23]);
                    int ast = (int) Double.parseDouble(row[24]);
                    int blk = (int) Double.parseDouble(row[26]);
                    int stl = (int) Double.parseDouble(row[25]);
                    
                    Player player = createPlayer(playerName, position, pts, trb, ast, blk, stl);
                    if (player != null) {
                        playersData.add(player);
                    }
                }
            }
			
		} 
		catch (IOException e) {
		    System.err.println("Error reading the file: " + e.getMessage());
		} 
		catch (NumberFormatException e) {
		    System.err.println("Error in number format: " + e.getMessage());
		} 
		catch (Exception e) {
		    System.err.println("An unexpected error occurred: " + e.getMessage());
        }

		
		System.out.println(playersData.size());

		
        for (Player player : playersData) {
            System.out.println(player.getPlayerName() + " - Score: " + String.format("%.2f", player.calculateScore()));
        }
    }
	

	
	
	
		private static Player createPlayer(String playerName, String position, int pts, int trb, int ast, int blk, int stl) {
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




		
	/*	 WHERE WE CHECK PLAYERS AND THEIR DATA 
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] row = line.split(";");
				if (playerNames.add(row[1])) { 
                    String[] playerInfo = {
                        row[1], // Player Name
                        row[2], // Position
                        row[29], // PTS
                        row[23], // TRB
                        row[24], // AST
                        row[26], // BLK
                        row[25]  // STL
                    };
                    playersData.add(playerInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		finally {
			reader.close();
		}
		
		for (String[] player : playersData) {
        for (String data : player) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
		
*/
		
		
//		necessary info: Player Name[1], Position[2], PTS (Points)[29], TRB [23], AST[24], BLK[26], STL[25]
		

