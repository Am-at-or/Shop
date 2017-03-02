package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class NumberOfSimCards extends AbstractEntity {

	private int simCards;
	@OneToMany(mappedBy = "numberOfSimCards", fetch = FetchType.LAZY)
	private List<Phone> phones;

	public NumberOfSimCards() {
	}

	public int getSimCards() {
		return simCards;
	}

	public void setSimCards(int simCards) {
		this.simCards = simCards;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
