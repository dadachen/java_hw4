package model;

public class Member {
	private String member_id;
	private String identity;
	private String account;
	private String password;
	private String name;
	private String birthday;
	private String gender;
	private String date;
	private String address;
	private String phone;
	private String library_card;
	private String level;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String identity, String account, String password, String name, String birthday,
			String gender, String date, String address, String phone) {
		super();
		this.identity = identity;
		this.account = account;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.date = date;
		this.address = address;
		this.phone = phone;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLibrary_card() {
		return library_card;
	}

	public void setLibrary_card(String library_card) {
		this.library_card = library_card;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
