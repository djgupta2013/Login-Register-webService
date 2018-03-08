package bean;

public class User {
	private String name,password,email;
	private String newEmail;
	public String getNewEmail() {
		return newEmail;
	}
	
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}
	
	public User(){
		
	}
	
	//register
	public User(String name,String password,String email)
	{
		this.name=name;
		this.password=password;
		this.email=email;
	}
	//login
	public User(String email,String password){
		this.email=email;
		this.password=password;
	}
	
	//update name
	public void updateName(String name,String email){
		this.name=name;
		this.email=email;
	}
	
	//update password
	public void updatePassword(String password,String email){
		this.password=password;
		this.email=email;
	}
	//update email
	public void updateEmail(String newEmail,String email){
		this.newEmail=newEmail;
		this.email=email;
	}
	
	//find Id
	public User(String email){
		this.email=email;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
