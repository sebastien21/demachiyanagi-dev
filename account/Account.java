package account;

/**
 * account entity
 * @author acmil
 *
 */
public class Account {
	private String id;
	private String password;
	private Authority authority;
	
	//constructor
	public Account(String id, String password, Authority authority) {
		this.id = id;
		this.password = password;
		this.authority = authority;
	}
	
	//setter
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	//getter
	public String getId() {
		return this.id;
	}
	public String getPassword() {
		return this.password;
	}
	public Authority getAuthority() {
		return this.authority;
	}
}
