package ua.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Rating extends AbstractEntity {

	@ManyToOne
	private Phone phone;
	@ManyToOne
	private User user;
	@ManyToOne
	private Mark mark;

	public Rating() {
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

}
