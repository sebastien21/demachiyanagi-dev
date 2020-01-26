package account;

/**
 * account repository
 * @author acmil
 *
 */
public class AccountRepository {
	private Account[] accounts;
	
	//constructor
	public AccountRepository() {
		addAccountsToRepository();
	}
	
	//create repository
	private void addAccountsToRepository() {
		Account front_manager = new Account("manager", "0000", Authority.FRONT_MANAGER);
		Account front_trader = new Account("trader", "0000", Authority.FRONT_GENERAL);
		Account back_office = new Account("back", "0000", Authority.BACK_USER);
		Account[] addAccounts = {front_manager, front_trader, back_office};
		this.accounts = addAccounts;
	}
	
	//getter
	public Account[] getAccounts() {
		return this.accounts;
	}
}
