package ua.com.shop.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PhoneFilter {

	private List<Integer> makerIds = new ArrayList<>();
	private String modelFilter = "";
	private String minPrice = "";
	private String maxPrice = "";
	private BigDecimal minPriceValue;
	private BigDecimal maxPriceValue;
	private String minDisplayValue = "";
	private String maxDisplayValue = "";
	private BigDecimal minDisplayValueV;
	private BigDecimal maxDisplayValueV;
	private List<Integer> displayResolutionIds = new ArrayList<>();
	private String minPrimaryCamera = "";
	private String maxPrimaryCamera = "";
	private BigDecimal minPrimaryCameraValue;
	private BigDecimal maxPrimaryCameraValue;
	private String minSecondaryCamera = "";
	private String maxSecondaryCamera = "";
	private BigDecimal minSecondaryCameraValue;
	private BigDecimal maxSecondaryCameraValue;
	private List<Integer> processorIds = new ArrayList<>();
	private String minRam = "";
	private String maxRam = "";
	private BigDecimal minRamValue;
	private BigDecimal maxRamValue;
	private String minInternal = "";
	private String maxInternal = "";
	private BigDecimal minInternalValue;
	private BigDecimal maxInternalValue;
	private String minCard = "";
	private String maxCard = "";
	private BigDecimal minCardValue;
	private BigDecimal maxCardValue;
	private String numberOfSimCardsFilter = "";
	private Integer numberOfSimCardsValue;
	private List<Integer> operatingSystemIds = new ArrayList<>();
	private String minBattery = "";
	private String maxBattery = "";
	private BigDecimal minBatteryValue;
	private BigDecimal maxBatteryValue;
	private List<Integer> colorIds = new ArrayList<>();

	public List<Integer> getMakerIds() {
		return makerIds;
	}

	public void setMakerIds(List<Integer> makerIds) {
		this.makerIds = makerIds;
	}

	public String getModelFilter() {
		return modelFilter;
	}

	public void setModelFilter(String modelFilter) {
		this.modelFilter = modelFilter;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPriceValue() {
		return minPriceValue;
	}

	public void setMinPriceValue(BigDecimal minPriceValue) {
		this.minPriceValue = minPriceValue;
	}

	public BigDecimal getMaxPriceValue() {
		return maxPriceValue;
	}

	public void setMaxPriceValue(BigDecimal maxPriceValue) {
		this.maxPriceValue = maxPriceValue;
	}

	public String getMinDisplayValue() {
		return minDisplayValue;
	}

	public void setMinDisplayValue(String minDisplayValue) {
		this.minDisplayValue = minDisplayValue;
	}

	public String getMaxDisplayValue() {
		return maxDisplayValue;
	}

	public void setMaxDisplayValue(String maxDisplayValue) {
		this.maxDisplayValue = maxDisplayValue;
	}

	public BigDecimal getMinDisplayValueV() {
		return minDisplayValueV;
	}

	public void setMinDisplayValueV(BigDecimal minDisplayValueV) {
		this.minDisplayValueV = minDisplayValueV;
	}

	public BigDecimal getMaxDisplayValueV() {
		return maxDisplayValueV;
	}

	public void setMaxDisplayValueV(BigDecimal maxDisplayValueV) {
		this.maxDisplayValueV = maxDisplayValueV;
	}

	public List<Integer> getDisplayResolutionIds() {
		return displayResolutionIds;
	}

	public void setDisplayResolutionIds(List<Integer> displayResolutionIds) {
		this.displayResolutionIds = displayResolutionIds;
	}

	public String getMinPrimaryCamera() {
		return minPrimaryCamera;
	}

	public void setMinPrimaryCamera(String minPrimaryCamera) {
		this.minPrimaryCamera = minPrimaryCamera;
	}

	public String getMaxPrimaryCamera() {
		return maxPrimaryCamera;
	}

	public void setMaxPrimaryCamera(String maxPrimaryCamera) {
		this.maxPrimaryCamera = maxPrimaryCamera;
	}

	public BigDecimal getMinPrimaryCameraValue() {
		return minPrimaryCameraValue;
	}

	public void setMinPrimaryCameraValue(BigDecimal minPrimaryCameraValue) {
		this.minPrimaryCameraValue = minPrimaryCameraValue;
	}

	public BigDecimal getMaxPrimaryCameraValue() {
		return maxPrimaryCameraValue;
	}

	public void setMaxPrimaryCameraValue(BigDecimal maxPrimaryCameraValue) {
		this.maxPrimaryCameraValue = maxPrimaryCameraValue;
	}

	public String getMinSecondaryCamera() {
		return minSecondaryCamera;
	}

	public void setMinSecondaryCamera(String minSecondaryCamera) {
		this.minSecondaryCamera = minSecondaryCamera;
	}

	public String getMaxSecondaryCamera() {
		return maxSecondaryCamera;
	}

	public void setMaxSecondaryCamera(String maxSecondaryCamera) {
		this.maxSecondaryCamera = maxSecondaryCamera;
	}

	public BigDecimal getMinSecondaryCameraValue() {
		return minSecondaryCameraValue;
	}

	public void setMinSecondaryCameraValue(BigDecimal minSecondaryCameraValue) {
		this.minSecondaryCameraValue = minSecondaryCameraValue;
	}

	public BigDecimal getMaxSecondaryCameraValue() {
		return maxSecondaryCameraValue;
	}

	public void setMaxSecondaryCameraValue(BigDecimal maxSecondaryCameraValue) {
		this.maxSecondaryCameraValue = maxSecondaryCameraValue;
	}

	public List<Integer> getProcessorIds() {
		return processorIds;
	}

	public void setProcessorIds(List<Integer> processorIds) {
		this.processorIds = processorIds;
	}

	public String getMinRam() {
		return minRam;
	}

	public void setMinRam(String minRam) {
		this.minRam = minRam;
	}

	public String getMaxRam() {
		return maxRam;
	}

	public void setMaxRam(String maxRam) {
		this.maxRam = maxRam;
	}

	public BigDecimal getMinRamValue() {
		return minRamValue;
	}

	public void setMinRamValue(BigDecimal minRamValue) {
		this.minRamValue = minRamValue;
	}

	public BigDecimal getMaxRamValue() {
		return maxRamValue;
	}

	public void setMaxRamValue(BigDecimal maxRamValue) {
		this.maxRamValue = maxRamValue;
	}

	public String getMinInternal() {
		return minInternal;
	}

	public void setMinInternal(String minInternal) {
		this.minInternal = minInternal;
	}

	public String getMaxInternal() {
		return maxInternal;
	}

	public void setMaxInternal(String maxInternal) {
		this.maxInternal = maxInternal;
	}

	public BigDecimal getMinInternalValue() {
		return minInternalValue;
	}

	public void setMinInternalValue(BigDecimal minInternalValue) {
		this.minInternalValue = minInternalValue;
	}

	public BigDecimal getMaxInternalValue() {
		return maxInternalValue;
	}

	public void setMaxInternalValue(BigDecimal maxInternalValue) {
		this.maxInternalValue = maxInternalValue;
	}

	public String getMinCard() {
		return minCard;
	}

	public void setMinCard(String minCard) {
		this.minCard = minCard;
	}

	public String getMaxCard() {
		return maxCard;
	}

	public void setMaxCard(String maxCard) {
		this.maxCard = maxCard;
	}

	public BigDecimal getMinCardValue() {
		return minCardValue;
	}

	public void setMinCardValue(BigDecimal minCardValue) {
		this.minCardValue = minCardValue;
	}

	public BigDecimal getMaxCardValue() {
		return maxCardValue;
	}

	public void setMaxCardValue(BigDecimal maxCardValue) {
		this.maxCardValue = maxCardValue;
	}

	public String getNumberOfSimCardsFilter() {
		return numberOfSimCardsFilter;
	}

	public void setNumberOfSimCardsFilter(String numberOfSimCardsFilter) {
		this.numberOfSimCardsFilter = numberOfSimCardsFilter;
	}

	public Integer getNumberOfSimCardsValue() {
		return numberOfSimCardsValue;
	}

	public void setNumberOfSimCardsValue(Integer numberOfSimCardsValue) {
		this.numberOfSimCardsValue = numberOfSimCardsValue;
	}

	public List<Integer> getOperatingSystemIds() {
		return operatingSystemIds;
	}

	public void setOperatingSystemIds(List<Integer> operatingSystemIds) {
		this.operatingSystemIds = operatingSystemIds;
	}

	public String getMinBattery() {
		return minBattery;
	}

	public void setMinBattery(String minBattery) {
		this.minBattery = minBattery;
	}

	public String getMaxBattery() {
		return maxBattery;
	}

	public void setMaxBattery(String maxBattery) {
		this.maxBattery = maxBattery;
	}

	public BigDecimal getMinBatteryValue() {
		return minBatteryValue;
	}

	public void setMinBatteryValue(BigDecimal minBatteryValue) {
		this.minBatteryValue = minBatteryValue;
	}

	public BigDecimal getMaxBatteryValue() {
		return maxBatteryValue;
	}

	public void setMaxBatteryValue(BigDecimal maxBatteryValue) {
		this.maxBatteryValue = maxBatteryValue;
	}

	public List<Integer> getColorIds() {
		return colorIds;
	}

	public void setColorIds(List<Integer> colorIds) {
		this.colorIds = colorIds;
	}

}
