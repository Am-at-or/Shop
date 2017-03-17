package ua.com.shop.dto.filter;

public class UserFilter {

	private String emailFilter = "";
	private String loginFilter = "";
	private String passwordFilter = "";
	private String phoneNumberFilter = "";
	private String firstNameFilter = "";
	private String lastNameFilter = "";

	public String getEmailFilter() {
		return emailFilter;
	}

	public void setEmailFilter(String emailFilter) {
		this.emailFilter = emailFilter;
	}

	public String getLoginFilter() {
		return loginFilter;
	}

	public void setLoginFilter(String loginFilter) {
		this.loginFilter = loginFilter;
	}

	public String getPasswordFilter() {
		return passwordFilter;
	}

	public void setPasswordFilter(String passwordFilter) {
		this.passwordFilter = passwordFilter;
	}

	public String getPhoneNumberFilter() {
		return phoneNumberFilter;
	}

	public void setPhoneNumberFilter(String phoneNumberFilter) {
		this.phoneNumberFilter = phoneNumberFilter;
	}

	public String getFirstNameFilter() {
		return firstNameFilter;
	}

	public void setFirstNameFilter(String firstNameFilter) {
		this.firstNameFilter = firstNameFilter;
	}

	public String getLastNameFilter() {
		return lastNameFilter;
	}

	public void setLastNameFilter(String lastNameFilter) {
		this.lastNameFilter = lastNameFilter;
	}

}
