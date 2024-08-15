package NBASimulationGame;

public class Users {
	
//	Each user has a
//	unique nickname, a password, real name and surname, age,
//	and a unique email address with the constraints below
	
	private String nickname; // unique
	private char[] password; // user can modify
	private String realName; 
	private String surname; 
	private int age; // user can modify
	private String email; // unique + user can modify
	private String profilePhoto; // it's optional, it user don't choose default photo will be displayed + user can modify
	
//	Existing users should have all their
//	account details saved in a text file called `users.txt`, and when a
//	user is logging in, the username + password should be
//	compared against the information in `users.txt`.
	
	
	
//	constructor
	public Users(String nickname, char[] password, String realName, String surname, int age, String email,
			String profilePhoto) {
//		super();
		setNickname(nickname);
		setPassword(password);
		setRealName(realName);
	    setSurname(surname);
	    setAge(age);
	    setEmail(email);
	    setProfilePhoto(profilePhoto);
		
	}

//	getters and setters
	public String getNickname() {
		return nickname;
	}

	public char[] getPassword() {
		return password;
	}

	public String getRealName() {
		return realName;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setNickname(String nickname) {
		if (isValidUsername(nickname) == false) {
			throw new IllegalArgumentException("It's an invalid username, please try again.");
		}
		this.nickname = nickname;
	}

	public void setPassword(char[] password) {
		if (isValidPassword(password) == false) {
			throw new IllegalArgumentException("It's an invalid password, please try again.");
		}

		this.password = password; 
	}

	public void setRealName(String realName) {
		if (isValidNames(realName) == false ) {
			throw new IllegalArgumentException("It's an invalid name, please try again.");
			
		}
		this.realName = realName;
	}

	public void setSurname(String surname) {
		if (isValidNames(surname) == false ) {
			throw new IllegalArgumentException("It's an invalid surname, please try again.");
			
		}
		this.surname = surname;
	}

	public void setAge(int age) {
		if (isValidAge(age)==false) {
			throw new IllegalArgumentException("It's an invalid age, please try again.");
		}
		this.age = age;
	}

	public void setEmail(String email) {
		if (isValidEmail(email)==false) {
			throw new IllegalArgumentException("It's an invalid email, please try again.");
		}
		this.email = email;
	}

	public void setProfilePhoto(String profilePhoto) { // if there is no photo, use default one (HOW?)
		this.profilePhoto = profilePhoto;
	}
	
	
//	implement isValidPassword: 1)must be at least 8 characters + 2)including letters, numbers, and special characters.
	
	public static boolean isValidPassword(char[] password) {
		if (password == null || password.length < 8 ) {
			return false;
		}
		
		String strPassword = new String(password);
		return strPassword.matches("[A-Za-z0-9!@#$%^&*()]*"); // we have used regex to eliminate undesirable characters
	}
	
//	implement isValidNames: 1)it's for names and surnames + 2)only letters + 3)each should have at least 3 characters 

	public static boolean isValidNames(String names) {
		if (names == null || names.isEmpty() == true ||  (names.length() < 3)) {
			return false;
		}
		
		return names.matches("[A-Za-z]+");
		
	}
	
//	implement isValidUsername: 1) contains only letters and numbers
	public static boolean isValidUsername(String username) {
		if (username == null || username.isEmpty() == true) {
			return false;
		}
		return username.matches("[A-Za-z0-9]+");
	}
	
//	implement isValidAge: 1) age must be >=12
	public static boolean isValidAge(int age) {
		return age >= 12;
	}
	
//	implement isValidEmail: 1) check the format through regex 
	
	public static boolean isValidEmail(String email) {
	    if (email == null || email.isEmpty()) {
	        return false;
	    }
	    return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$");
	}
	
	

	
	
	
	
	
	
	
	
	
	

}
