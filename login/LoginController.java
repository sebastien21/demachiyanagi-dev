package login;

import java.io.*;
import account.Account;
import account.AccountRepository;

public class LoginController {
	private Account[] accountRepository;
	private LoginView loginView;
	
	//login id and password
	private Account loginAccount;
	
	//constructor
	public LoginController() {
		this.loginView = new LoginView();
		this.accountRepository = setAccountsForLogin();
	}
	
	//set accounts
	private Account[] setAccountsForLogin() {
		AccountRepository repository = new AccountRepository(); 
		return repository.getAccounts(); 
	}
	
	//login process
	public boolean isLoginSuccessful(String user, String password) throws IOException{
		this.loginView.showLogin();
		
		if(!checkIdAndPassword(this.accountRepository, user, password)) {
			this.loginView.showFailedLogin();
			return false;
		} else {
			this.loginView.showSuccessfulLogin();
			return true;
		}
		
		
	}
	//check inputed id and password
	private boolean checkIdAndPassword(Account[] accounts, String inputedId, String inputedPassword) {
		for(Account account : accounts) {
			if(inputedId.equals(account.getId())) {
				if(inputedPassword.equals(account.getPassword())) {
					this.loginAccount = account;
					return true;
				}
			}
		}
		return false;
	}
	
	//get login account
	public Account getLoginAccount() {
		return this.loginAccount;
	}
}
