package NBASimulationGame;

import java.awt.Button;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import NBASimulationGame.StartOrChangeInfo;


public class LoginUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String loggedInUsername;

	/**
	 * applies methods
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
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
	
	public LoginUser() {
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
		
		Button button = new Button("Log In");
		button.setForeground(Color.RED);
		button.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		button.setBackground(new Color(254, 255, 255));
		button.setBounds(225, 195, 117, 29);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to NBA Fantasy Game!");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(190, 6, 208, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(190, 59, 111, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(190, 122, 111, 16);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(190, 84, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 144, 130, 26);
		contentPane.add(passwordField);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkUserInfo();
			}
		});
		
	}
	
	
	private void checkUserInfo() {
		String givenUsername = textField.getText();
		char[] givenPassword = passwordField.getPassword();
		boolean isAuthenticated = false;
	
		
//		StringBuilder errorMsg = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/NBASimulationGame/users.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	
	            String[] userDetails = line.split(";");
	            String username = userDetails[5]; 
	            String password = userDetails[3]; 

	            if (username.trim().equals(givenUsername) && 
	                new String(givenPassword).equals(password.trim())) {
	                isAuthenticated = true;
	                loggedInUsername = givenUsername;
	                break;
	            }
	        }
	    } 
		catch (IOException e) {
	        e.printStackTrace();
	    }

	    if (isAuthenticated) {
	    	
	        JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	        this.dispose(); 
	        StartOrChangeInfo startPage = new StartOrChangeInfo(); 
	        startPage.setVisible(true);
	        loggedInUsername = givenUsername;
	        
	    } 
	    
	    else {
	        JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
	    }
		
		
		
	}
}
