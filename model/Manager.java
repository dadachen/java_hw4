package model;

public class Manager {
	private String account;
	private String password;
	private String name;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String account, String password, String name) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
