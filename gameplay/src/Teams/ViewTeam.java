package Teams;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class ViewTeam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JList<String> list;

	
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTeam frame = new ViewTeam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	
	
	public ViewTeam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);

       
        String teamName = ChooseTeamGUI.selectedTeam; 
        List<String> players = getPlayersForTeam(teamName);

    
        list = new JList<>(players.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(50, 50, 500, 400);
        contentPane.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("YOUR TEAM:");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("American Typewriter", Font.PLAIN, 14));
        lblNewLabel.setBounds(57, 4, 204, 34);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Go back");
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
        btnNewButton.setBounds(419, 503, 117, 29);
        contentPane.add(btnNewButton);
        
        
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		DraftingGUI draftPage = new DraftingGUI();
    			draftPage.setVisible(true);
        		
        	}
        });       

        
        
        
        
        
        list.addMouseListener(new MouseAdapter() {
        	
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) { // Double-click
                    int index = list.locationToIndex(evt.getPoint());
                    String selectedPlayer = (String)list.getModel().getElementAt(index);
                    openPlayerDetails(selectedPlayer);
                }
            }
        });
		
	}
	
	
	
	
	private void openPlayerDetails(String playerName) {
		
        ViewPlayerDetail detailsFrame = new ViewPlayerDetail();
        detailsFrame.setVisible(true);
        detailsFrame.setPlayerName(playerName);
    }
	
	
	
	
	
	
	private List<String> getPlayersForTeam(String teamName) {
		List<String> players = new ArrayList<>();
        boolean isTeamSection = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("draftHistory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	
            	
                if (line.trim().startsWith("Team: " + teamName)) {
                    isTeamSection = true;
                    continue;
                }
                
                if (isTeamSection) {
                    if (line.trim().isEmpty() || line.contains("-----")) {
                        break; 
                    }
                    players.add(line.trim()); 
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
          
        }
        
        return players;
    }
}
