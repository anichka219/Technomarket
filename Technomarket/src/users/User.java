package users;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	
	private static final int MIN_LENGTH_PASS = 6;
	private static final int MIN_LENGTH_LASTNAME = 6;
	private static final int MIN_LENGTH_FIRSTNAME = 4;
	
	private static int lastUserID = 1;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Gender gender;
	private LocalDate birthDate;
	private boolean isLogged;
	private boolean isAdmin;
	private int userID;
	
	public User(String firstName, String lastName, String email, String password, Gender gender, LocalDate birthDate) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setGender(gender);
		setBirthDate(birthDate);
		setLogged(false);
		setAdmin(false);
		this.userID=User.lastUserID++;
	}
	
	@Override
	public boolean equals(Object u) {
		if(u instanceof User) {
			User user=(User)u;
			return this.email.equals(user.email);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.email.hashCode();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName!=null && firstName.trim().length()>=MIN_LENGTH_FIRSTNAME)
			this.firstName = firstName;
		else{
			System.out.println("Invalid first name!");
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName!=null && lastName.trim().length()>=MIN_LENGTH_LASTNAME)
			this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern p = Pattern.compile(ePattern);
		Matcher m = p.matcher(email);
		if(m.matches())
			this.email = email;
		else 
			System.out.println("Invalid email address!");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password!=null && password.trim().length()>=MIN_LENGTH_PASS)
			this.password = password;
		else
			System.out.println("Invalid password!");
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		if(gender!=null)
			this.gender = gender;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		if(birthDate instanceof LocalDate)
			this.birthDate = birthDate;		
	}
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getUserID() {
		return userID;
	}
	
}
