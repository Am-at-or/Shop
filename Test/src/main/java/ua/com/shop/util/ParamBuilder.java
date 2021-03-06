package ua.com.shop.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.filter.SimpleFilterDecimal;

public interface ParamBuilder {

	public static String getParams(Pageable pageable) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber() + 1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if (pageable.getSort() != null) {
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order) -> {
				buffer.append(order.getProperty());
				if (order.getDirection() != Direction.ASC)
					buffer.append(",desc");
			});
		}

		return buffer.toString();
	}

	public static String getParams(Pageable pageable, SimpleFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber() + 1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if (pageable.getSort() != null) {
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order) -> {
				buffer.append(order.getProperty());
				if (order.getDirection() != Direction.ASC)
					buffer.append(",desc");
			});
		}
		if (!filter.getSearch().isEmpty()) {
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
		return buffer.toString();
	}

	public static String getParams(Pageable pageable, SimpleFilterDecimal filter) {
		String page = getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getMin().isEmpty()) {
			buffer.append("&max=");
			buffer.append(filter.getMin());
		}
		if (!filter.getMax().isEmpty()) {
			buffer.append("&min=");
			buffer.append(filter.getMax());
		}
		return buffer.toString();
	}

}