package thuan.com.fa.demomvc.model;

import org.springframework.beans.factory.annotation.Value;

public class User {
	@Value("#{'localhost default'}")
	private String userName;
	private String password;

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
