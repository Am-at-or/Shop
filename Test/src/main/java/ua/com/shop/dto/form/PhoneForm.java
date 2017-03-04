package ua.com.shop.dto.form;

import ua.com.shop.entity.CardMemory;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.InternalMemory;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.NumberOfSimCards;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Processor;
import ua.com.shop.entity.Ram;

public class PhoneForm {

	private int id;
	private Maker maker;
	private String model;
	private String price;
	private Display display;
	private String primaryCamera;
	private String secondaryCamera;
	private Processor processor;
	private Ram ram;
	private InternalMemory internal;
	private CardMemory card;
	private NumberOfSimCards numberOfSimCards;
	private OperatingSystem operatingSystem;
	private String battery;
	private Color color;
	private String ifExist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public String getPrimaryCamera() {
		return primaryCamera;
	}

	public void setPrimaryCamera(String primaryCamera) {
		this.primaryCamera = primaryCamera;
	}

	public String getSecondaryCamera() {
		return secondaryCamera;
	}

	public void setSecondaryCamera(String secondaryCamera) {
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

	public InternalMemory getInternal() {
		return internal;
	}

	public void setInternal(InternalMemory internal) {
		this.internal = internal;
	}

	public CardMemory getCard() {
		return card;
	}

	public void setCard(CardMemory card) {
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

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getIfExist() {
		return ifExist;
	}

	public void setIfExist(String ifExist) {
		this.ifExist = ifExist;
	}

}
