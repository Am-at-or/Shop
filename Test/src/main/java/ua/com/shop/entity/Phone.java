package ua.com.shop.entity;

import java.math.BigDecimal;
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
	private BigDecimal price;
	private double displayValue;
	@ManyToOne
	private DisplayResolution displayResolution;
	private double primaryCamera;
	private double secondaryCamera;
	@ManyToOne
	private Processor processor;
	private double ram;
	private double internal;
	private double card;
	private int numberOfSimCards;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(double displayValue) {
		this.displayValue = displayValue;
	}

	public DisplayResolution getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(DisplayResolution displayResolution) {
		this.displayResolution = displayResolution;
	}

	public double getPrimaryCamera() {
		return primaryCamera;
	}

	public void setPrimaryCamera(double primaryCamera) {
		this.primaryCamera = primaryCamera;
	}

	public double getSecondaryCamera() {
		return secondaryCamera;
	}

	public void setSecondaryCamera(double secondaryCamera) {
		this.secondaryCamera = secondaryCamera;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public double getInternal() {
		return internal;
	}

	public void setInternal(double internal) {
		this.internal = internal;
	}

	public double getCard() {
		return card;
	}

	public void setCard(double card) {
		this.card = card;
	}

	public int getNumberOfSimCards() {
		return numberOfSimCards;
	}

	public void setNumberOfSimCards(int numberOfSimCards) {
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
