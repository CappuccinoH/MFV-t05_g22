package mvf.model;

public class User {
	private String account;
	private String password;
	private String userStatus;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String account, String password, String userStatus) {
		super();
		this.account = account;
		this.password = password;
		this.userStatus = userStatus;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", userStatus=" + userStatus + "]";
	}

}
