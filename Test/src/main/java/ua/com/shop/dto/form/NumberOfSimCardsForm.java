package ua.com.shop.dto.form;

public class NumberOfSimCardsForm {

	private int id;
	private String simCards;
	private String ifExist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSimCards() {
		return simCards;
	}

	public void setSimCards(String simCards) {
		this.simCards = simCards;
	}

	public String getIfExist() {
		return ifExist;
	}

	public void setIfExist(String ifExist) {
		this.ifExist = ifExist;
	}

}
