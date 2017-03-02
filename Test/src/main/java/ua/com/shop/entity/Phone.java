package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Phone extends AbstractEntity {

	@ManyToOne
	private Maker maker;
	private String model;
	private int price;
	@ManyToOne
	private Display display;
	private int primaryCamera;
	private int secondaryCamera;
	@ManyToOne
	private Processor processor;
	@ManyToOne
	private Ram ram;
	private int internal;
	private int card;
	@ManyToOne
	private NumberOfSimCards numberOfSimCards;
	@ManyToOne
	private OperatingSystem operatingSystem;
	private int battery;
	@ManyToOne
	private Color color;
	@OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
	private List<Rating> ratings;
	@OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
	private List<Comment> comments;
	@ManyToMany
	@JoinTable(name = "phone_orders", joinColumns = @JoinColumn(name = "id_phone"), inverseJoinColumns = @JoinColumn(name = "id_orders"))
	private List<Orders> orders;

	public Phone() {
	}

	public Maker getMaker() {
		return maker;
	}

	public void setMaker(Maker maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public int getPrimaryCamera() {
		return primaryCamera;
	}

	public void setPrimaryCamera(int primaryCamera) {
		this.primaryCamera = primaryCamera;
	}

	public int getSecondaryCamera() {
		return secondaryCamera;
	}

	public void setSecondaryCamera(int secondaryCamera) {
		this.secondaryCamera = secondaryCamera;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public int getInternal() {
		return internal;
	}

	public void setInternal(int internal) {
		this.internal = internal;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public NumberOfSimCards getNumberOfSimCards() {
		return numberOfSimCards;
	}

	public void setNumberOfSimCards(NumberOfSimCards numberOfSimCards) {
		this.numberOfSimCards = numberOfSimCards;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
