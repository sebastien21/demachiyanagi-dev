package login;

public class LoginView {

	//constructor
	public LoginView() {
		//nothing to complete here
	}
	
	//login message
	public void showLogin() {
		System.out.println("Enter your id & password, add space between these two.");
	}
	
	//login succeed
	public void showSuccessfulLogin() {
		System.out.println("Login succeeded.");
	}
	
	//login fail
	public void showFailedLogin() {
		System.out.println("Login failed. Try again.");
	}
}
