package NBASimulationGame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;

import java.awt.event.MouseWheelListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.MouseWheelEvent;
import javax.swing.JPasswordField;

public class NewUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JSpinner spinner;
	private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewUser() {
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
		
		Button button = new Button("Sign Up");
		button.setForeground(Color.RED);
		button.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		button.setBackground(new Color(254, 255, 255));
		button.setBounds(168, 217, 117, 29);
		contentPane.add(button);
		
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        saveUserInfo();
		    }
		});

		
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to NBA Fantasy Game!");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(190, 6, 208, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(168, 34, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Surname:");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(285, 34, 61, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email:");
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2.setBounds(168, 75, 61, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Password:");
		lblNewLabel_2_3.setForeground(Color.BLUE);
		lblNewLabel_2_3.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_3.setBounds(285, 73, 61, 16);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Age:");
		lblNewLabel_2_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2_1.setBounds(168, 121, 61, 16);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Profile Photo:");
		lblNewLabel_2_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2_2.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2_2.setBounds(168, 166, 87, 16);
		contentPane.add(lblNewLabel_2_2_2);
		
		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		textField.setBounds(168, 49, 107, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(285, 49, 107, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.DARK_GRAY);
		textField_2.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(168, 94, 107, 26);
		contentPane.add(textField_2);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 92, 98, 28);
		contentPane.add(passwordField);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.DARK_GRAY);
		textField_4.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		textField_4.setColumns(10);
		textField_4.setBounds(168, 140, 107, 26);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Username:");
		lblNewLabel_2_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_2_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2_1_1.setBounds(285, 121, 61, 16);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.DARK_GRAY);
		textField_5.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		textField_5.setColumns(10);
		textField_5.setBounds(285, 140, 107, 26);
		contentPane.add(textField_5);
		
		
		String[] photoOptions = {"-", "Gregg Popovich", "Erik Spoelstra", "Steve Kerr", "Michael Malone", "Tyronn Lue"};
		
		spinner = new JSpinner(new SpinnerListModel(photoOptions));
		spinner.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		spinner.setBounds(168, 185, 107, 26);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Already have an account?");
		lblNewLabel_2_2_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_2_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2_2_1.setBounds(294, 190, 150, 16);
		contentPane.add(lblNewLabel_2_2_2_1);
		
		Button button_1 = new Button("Log In");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		button_1.setBackground(new Color(254, 255, 255));
		button_1.setBounds(299, 217, 117, 29);
		contentPane.add(button_1);
		
//		closing sign up page and opening login page:
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginUser loginPage = new LoginUser();
				loginPage.setVisible(true);
			}
		});

		
		
//		String selectedCoachName = spinner.getValue().toString();
//		
//		String profilePhotoPath = getCoachPhotoPath(selectedCoachName);
		// Now use profilePhotoPath to save along with other user data
		
		
		

	}
	
	/**
	 * method saves the user information to a file after validation
	 * checks for valid name, surname, email, password, age, and username.
	 * if any validation fails, it shows an error message and doesn't proceed.
	 * otherwise, it saves the user information to 'users.txt'.
	 */
	
	private void saveUserInfo() {
	    String name = textField.getText();
	    String surname = textField_1.getText();
	    String email = textField_2.getText();
	    char[] password = passwordField.getPassword();
	    String ageText = textField_4.getText();
	    String username = textField_5.getText();
	    int age = Integer.parseInt(ageText);
	    
	    String selectedCoachName = spinner.getValue().toString();
	    String profilePhotoPath = getCoachPhotoPath(selectedCoachName);
	    
	    StringBuilder errorMessages = new StringBuilder();

	    
	    if (!Users.isValidNames(name)) {
	        errorMessages.append("Invalid name. ");
	    }
	    if (!Users.isValidNames(surname)) {
	        errorMessages.append("Invalid surname. ");
	    }
	    if (!Users.isValidEmail(email)) {
	        errorMessages.append("Invalid email. ");
	    }
	    if (!Users.isValidPassword(password)) {
	        errorMessages.append("Invalid password. ");
	    }
	    if (!Users.isValidAge(age)) {
	        errorMessages.append("Invalid age. ");
	    }
	    if (!Users.isValidUsername(username)) {
	        errorMessages.append("Invalid username. ");
	    }

	    if (errorMessages.length() > 0) {
	        JOptionPane.showMessageDialog(this, errorMessages.toString(), "Input Errors", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    
	    if (isUsernameOrEmailUsed(username, email)) {
	        return;
	    }
	    
	    
	    
	    try {
	    	Users checkUser = new Users(username, password, name, surname, age, email, selectedCoachName);
	    	checkUser.setRealName(name);
	    	checkUser.setSurname(surname);
	    	checkUser.setEmail(email);
	    	checkUser.setPassword(password);
	    	checkUser.setAge(age);
	    	checkUser.setNickname(username);
	    	
	    	
	    	String userInfo = name + ";" + surname + ";" + email + ";" + new String(password) + ";" + age + ";" + username + ";" + profilePhotoPath;
	    	
	    	try (FileWriter fw = new FileWriter("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/NBASimulationGame/users.txt", true);
	   	         BufferedWriter bw = new BufferedWriter(fw);
	   	         PrintWriter out = new PrintWriter(bw)) {
	    		out.println(userInfo);
	   	        JOptionPane.showMessageDialog(this, "You have successfully signed up!", "Success", JOptionPane.INFORMATION_MESSAGE);
	   	    } 
	    	
	    	
	    } catch (IOException e) {
	        // Show file writing error
	        JOptionPane.showMessageDialog(this, "Error writing to file.", "File Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	    	
	
	}
	
	/**
	 * 
	 * applies switch statement to match the coach name with the corresponding photo path
	 * @param coachName The name of the coach
	 * @return A string representing the file path of the coach's photo
	 */
	
	public String getCoachPhotoPath(String coachName) {
	    switch (coachName) {
	        case "Gregg Popovich": return "/images/Gregg Popovich.png";
	        case "Erik Spoelstra": return "/images/Erik Spoelstra.png";
	        case "Steve Kerr": return "/images/Steve Kerr.png";
	        case "Michael Malone": return "/images/Michael Malone.png";
	        case "Tyronn Lue": return "/images/Tyronn Lue.png";
	        default: return "/Gregg Popovich.png"; 
	    }
	}
	
	
	/**
	 * this method checks if the provided username or email is already used
	 * also reads from the users.txt file to compare existing user data
	 * @param username Username to check for uniqueness
	 * @param email Email to check for uniqueness
	 * @return true if username or email is already used, otherwise false
	 */

	
	private boolean isUsernameOrEmailUsed(String username, String email) {
	    StringBuilder errorMessages1 = new StringBuilder();
	    boolean errorFound = false;

	    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/NBASimulationGame/users.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] userDetails = line.split("[,;]");
	            if (userDetails[5].trim().equals(username)) {
	                errorMessages1.append("This username is already used. Log in or sign up with a different username.\n");
	                errorFound = true;
	            }
	            if (userDetails[2].trim().equals(email)) {
	                errorMessages1.append("This email is already used. Log in or sign up with a different email.\n");
	                errorFound = true;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    if (errorFound) {
	        JOptionPane.showMessageDialog(this, errorMessages1.toString(), "Input Errors", JOptionPane.ERROR_MESSAGE);
	    }
	    return errorFound;
	}
}
