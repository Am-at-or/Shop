package ua.com.shop.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperatingSystemFilter {

	private List<Integer> nameIds = new ArrayList<>();
	private String minVersion = "";
	private String maxVersion = "";
	private BigDecimal minVersionValue;
	private BigDecimal maxVersionValue;

	public List<Integer> getNameIds() {
		return nameIds;
	}

	public void setNameIds(List<Integer> nameIds) {
		this.nameIds = nameIds;
	}

	public String getMinVersion() {
		return minVersion;
	}

	public void setMinVersion(String minVersion) {
		this.minVersion = minVersion;
	}

	public String getMaxVersion() {
		return maxVersion;
	}

	public void setMaxVersion(String maxVersion) {
		this.maxVersion = maxVersion;
	}

	public BigDecimal getMinVersionValue() {
		return minVersionValue;
	}

	public void setMinVersionValue(BigDecimal minVersionValue) {
		this.minVersionValue = minVersionValue;
	}

	public BigDecimal getMaxVersionValue() {
		return maxVersionValue;
	}

	public void setMaxVersionValue(BigDecimal maxVersionValue) {
		this.maxVersionValue = maxVersionValue;
	}

}
