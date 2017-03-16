package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders extends AbstractEntity {

	@ManyToOne
	private User user;
	@ManyToMany
	@JoinTable(name = "phone_orders", joinColumns = @JoinColumn(name = "id_orders"), inverseJoinColumns = @JoinColumn(name = "id_phone"))
	private List<Phone> phones;

	public Orders() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
