package NBASimulationGame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ChangeInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JSpinner spinner;
	private JPasswordField passwordField;

	/**
	 * applies methods
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeInfo frame = new ChangeInfo();
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
	public ChangeInfo() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Don't forget to save!");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(207, 6, 208, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Surname:");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(285, 34, 61, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email:");
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2.setBounds(168, 34, 61, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Password:");
		lblNewLabel_2_3.setForeground(Color.BLUE);
		lblNewLabel_2_3.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_3.setBounds(285, 73, 61, 16);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Age:");
		lblNewLabel_2_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2_1.setBounds(168, 73, 61, 16);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Profile Photo:");
		lblNewLabel_2_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2_2.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		lblNewLabel_2_2_2.setBounds(168, 127, 87, 16);
		contentPane.add(lblNewLabel_2_2_2);
		
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
		textField_2.setBounds(168, 49, 107, 26);
		contentPane.add(textField_2);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 92, 98, 28);
		contentPane.add(passwordField);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.DARK_GRAY);
		textField_4.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		textField_4.setColumns(10);
		textField_4.setBounds(168, 95, 107, 26);
		contentPane.add(textField_4);
		
		
		String[] photoOptions = {"-", "Gregg Popovich", "Erik Spoelstra", "Steve Kerr", "Michael Malone", "Tyronn Lue"};
		
		spinner = new JSpinner(new SpinnerListModel(photoOptions));
		spinner.setFont(new Font("American Typewriter", Font.PLAIN, 10));
		spinner.setBounds(168, 147, 107, 26);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(168, 207, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnGoBackTo = new JButton("Go back");
		btnGoBackTo.setForeground(Color.RED);
		btnGoBackTo.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		btnGoBackTo.setBounds(298, 206, 117, 29);
		contentPane.add(btnGoBackTo);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changeUserInfo();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		btnGoBackTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StartOrChangeInfo backButton = new StartOrChangeInfo();
				backButton.setVisible(true);
			}
		});		
		

		
		
	}
	private void changeUserInfo() throws FileNotFoundException, IOException {
		
	    String newSurname = textField_1.getText();
	    String newEmail = textField_2.getText();
	    char[] newPassword = passwordField.getPassword();
	    String newAgeText = textField_4.getText();
	    int newAge = Integer.parseInt(newAgeText);
	    String newSelectedCoachName = spinner.getValue().toString();
	    String profilePhotoPath = getCoachPhotoPath(newSelectedCoachName);
	    
	    
	    StringBuilder errors = new StringBuilder();
	    
	   
	    if (!Users.isValidNames(newSurname)) {
	        errors.append("Invalid surname. ");
	    }
	    if (!Users.isValidEmail(newEmail)) {
	        errors.append("Invalid email. ");
	    }
	    if (!Users.isValidPassword(newPassword)) {
	        errors.append("Invalid password. ");
	    }
	    if (!Users.isValidAge(newAge)) {
	        errors.append("Invalid age. ");
	    }

	    if (errors.length() > 0) {
	        JOptionPane.showMessageDialog(this, errors.toString(), "Input Errors", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    ArrayList<String> updatedUsers = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/NBASimulationGame/users.txt"))) {
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            String[] userDetails = line.split(";");
	            if (userDetails[5].trim().equals(LoginUser.loggedInUsername)) {
	                // Update user's information
	                userDetails[1] = newSurname;
	                userDetails[2] = newEmail;
	                userDetails[3] = new String(newPassword);
	                userDetails[4] = Integer.toString(newAge);
	                userDetails[userDetails.length - 1] = profilePhotoPath;
	            }
	            updatedUsers.add(String.join(";", userDetails));
	        }
	    }

	    // Rewrite the file with updated information
	    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/faruksartik/eclipse-workspace/COMP132 Term Project/src/NBASimulationGame/users.txt")))) {
	        for (String userInfo : updatedUsers) {
	            out.println(userInfo);
	        }
	        JOptionPane.showMessageDialog(this, "Change is successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	    } 
	    catch (IOException e) {
	        JOptionPane.showMessageDialog(this, "Error writing to file.", "File Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	    
	    
	    
	}
	
	
	
	
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

}
