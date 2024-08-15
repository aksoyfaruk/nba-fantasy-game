package MatchMaking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class SeasonGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextArea textArea;


	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeasonGUI frame = new SeasonGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public SeasonGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(88, 106, 380, 316);
        contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Start the Season");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 14));
		btnNewButton.setBounds(233, 22, 145, 29);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        MatchDataManager manager = new MatchDataManager();
		        manager.runSeason();
		        manager.writeResultsToFile("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/SeasonResults.txt");
		        
		        displaySeasonResults();
		    }
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(88, 111, 423, 311);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Results:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(88, 57, 85, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnGoToPlayoffs = new JButton("Go to Playoffs");
		btnGoToPlayoffs.setForeground(Color.RED);
		btnGoToPlayoffs.setFont(new Font("American Typewriter", Font.PLAIN, 14));
		btnGoToPlayoffs.setBounds(233, 502, 145, 29);
		contentPane.add(btnGoToPlayoffs);
		
		

	    btnGoToPlayoffs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PlayoffsGUI startPlayoffs = new PlayoffsGUI();
				startPlayoffs.setVisible(true);
				
				
			}
		});

	    
	}
	
	
	
	private void displaySeasonResults() {
		String filePath = "/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/SeasonResults.txt";
		
        textArea.setText(""); 
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } 
        catch (IOException e) {
            textArea.setText("Failed to load season results.");
            e.printStackTrace();
        }
	    
	}

}