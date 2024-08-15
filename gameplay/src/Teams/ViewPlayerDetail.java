package Teams;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ViewPlayerDetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPlayerDetail frame = new ViewPlayerDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	
	public ViewPlayerDetail() {
		
		
		setTitle("Player Details");
	    setBounds(500, 300, 450, 300);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	

        
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 420, 203);
        contentPane.add(scrollPane);
        
        
        JButton btnNewButton = new JButton("Close Player Info");
        btnNewButton.setForeground(Color.BLUE);
        btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 14));
        btnNewButton.setBounds(261, 225, 155, 29);
        getContentPane().add(btnNewButton);
        
        

        btnNewButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
    			dispose(); }
        });        }
	
	
	
	
	public void setPlayerName(String playerName) {
		
		String[] playerDetails = getPlayerDetails(playerName);
        if (playerDetails != null) {
            String details = "Name: " + playerDetails[0] + "\n" +
                             "Position: " + playerDetails[1] + "\n" +
                             "Points: " + playerDetails[2] + "\n" +
                             "Assists: " + playerDetails[3] + "\n" +
                             "Total Rebounds: " + playerDetails[4] + "\n" +
                             "Blocks: " + playerDetails[5] + "\n" +
                             "Steals: " + playerDetails[6];
            textArea.setText(details);
        } 
        
        else {
            textArea.setText("Player not found: " + playerName);
        }
    
    }

	
	
	
	public static String[] getPlayerDetails(String playerName) {
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/new_player_stats.csv"));
            while ((line = br.readLine()) != null) {
                String[] player = line.split(";");
                if (player[0].equalsIgnoreCase(playerName)) {
                    return player; 
                }
            }
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
}
