package NBASimulationGame;


import NBASimulationGame.LoginUser;
import Teams.ChooseTeamGUI;
import Teams.DraftingGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class StartOrChangeInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * starts application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartOrChangeInfo frame = new StartOrChangeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * frame creation
	 */
	
	public StartOrChangeInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 255, 255));
		panel.setBounds(6, 0, 150, 266);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(NewUser.class.getResource("/images/nba.png")));
		lblNewLabel.setBounds(-55, 6, 248, 254);
		panel.add(lblNewLabel);
	
		
		
		JLabel lblNewLabel_1 = new JLabel("Hi Coach! I can't wait to start the game!");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(168, 6, 276, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Change Info");
		btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(254, 187, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnStartTheGame = new JButton("Start the Game!");
		btnStartTheGame.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		btnStartTheGame.setForeground(Color.RED);
		btnStartTheGame.setBounds(238, 228, 150, 29);
		contentPane.add(btnStartTheGame);
		
		btnStartTheGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			ChooseTeamGUI choseTeam = new ChooseTeamGUI();
			choseTeam.setVisible(true);
			}
		});
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChangeInfo changeInfo = new ChangeInfo();
				changeInfo.setVisible(true);
			}
		});
		
		
		
//		String username1 = LoginUser.loggedInUsername;
//		
//        String coachPhotoPath = getCoachPhotoPath(username1);
//        
//        
//        
//        JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBounds(272, 55, 79, 98);
//		lblNewLabel_2.setIcon(new ImageIcon(getCoachPhotoPath(username1)));
//		contentPane.add(lblNewLabel_2);
//		
		
		
		
		

		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(272, 55, 79, 98);
		lblNewLabel_2.setIcon(new ImageIcon(NewUser.class.getResource("/images/Steve Kerr.png")));
		contentPane.add(lblNewLabel_2);
	

		
		

		

	}
	
//	 here I tried to implement dynamic version of getting coach photo from previous page but couldn't. 
//	if time lefts i will complete
	
	private String getCoachPhotoPath(String username) {
	    String profilePhotoPath = null;
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/NBASimulationGame/users.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] userDetails = line.split(";"); 
	            
	            if (userDetails[5].trim().equals(username)) { 
	                profilePhotoPath = userDetails[userDetails.length - 1].trim(); 
	                System.out.println(profilePhotoPath);
	                break;
	            }
	        }
	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	    return profilePhotoPath;
	}
}
