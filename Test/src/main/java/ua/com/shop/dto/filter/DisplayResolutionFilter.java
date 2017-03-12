package ua.com.shop.dto.filter;

import java.math.BigDecimal;

public class DisplayResolutionFilter {

	private String minWidth = "";
	private String maxWidth = "";
	private String minHeight = "";
	private String maxHeight = "";
	private BigDecimal minWidthValue;
	private BigDecimal maxWidthValue;
	private BigDecimal minHeightValue;
	private BigDecimal maxHeightValue;

	public String getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(String minWidth) {
		this.minWidth = minWidth;
	}

	public String getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(String maxWidth) {
		this.maxWidth = maxWidth;
	}

	public String getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}

	public String getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}

	public BigDecimal getMinWidthValue() {
		return minWidthValue;
	}

	public void setMinWidthValue(BigDecimal minWidthValue) {
		this.minWidthValue = minWidthValue;
	}

	public BigDecimal getMaxWidthValue() {
		return maxWidthValue;
	}

	public void setMaxWidthValue(BigDecimal maxWidthValue) {
		this.maxWidthValue = maxWidthValue;
	}

	public BigDecimal getMinHeightValue() {
		return minHeightValue;
	}

	public void setMinHeightValue(BigDecimal minHeightValue) {
		this.minHeightValue = minHeightValue;
	}

	public BigDecimal getMaxHeightValue() {
		return maxHeightValue;
	}

	public void setMaxHeightValue(BigDecimal maxHeightValue) {
		this.maxHeightValue = maxHeightValue;
	}

}
