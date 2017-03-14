package ua.com.shop.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProcessorFilter {

	private List<Integer> makerIds = new ArrayList<>();
	private String modelFilter = "";
	private String minFrequency = "";
	private String maxFrequency = "";
	private BigDecimal minFrequencyValue;
	private BigDecimal maxFrequencyValue;
	private String numberOfCoresFilter = "";
	private Integer numberOfCoresValue;

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

	public String getMinFrequency() {
		return minFrequency;
	}

	public void setMinFrequency(String minFrequency) {
		this.minFrequency = minFrequency;
	}

	public String getMaxFrequency() {
		return maxFrequency;
	}

	public void setMaxFrequency(String maxFrequency) {
		this.maxFrequency = maxFrequency;
	}

	public BigDecimal getMinFrequencyValue() {
		return minFrequencyValue;
	}

	public void setMinFrequencyValue(BigDecimal minFrequencyValue) {
		this.minFrequencyValue = minFrequencyValue;
	}

	public BigDecimal getMaxFrequencyValue() {
		return maxFrequencyValue;
	}

	public void setMaxFrequencyValue(BigDecimal maxFrequencyValue) {
		this.maxFrequencyValue = maxFrequencyValue;
	}

	public String getNumberOfCoresFilter() {
		return numberOfCoresFilter;
	}

	public void setNumberOfCoresFilter(String numberOfCoresFilter) {
		this.numberOfCoresFilter = numberOfCoresFilter;
	}

	public Integer getNumberOfCoresValue() {
		return numberOfCoresValue;
	}

	public void setNumberOfCoresValue(Integer numberOfCoresValue) {
		this.numberOfCoresValue = numberOfCoresValue;
	}

}
