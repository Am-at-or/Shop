<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<table class="table table-striped">
		<tr>
			<th>Model</th>
			<th>Display</th>
			<th>Camera</th>
			<th>Processor</th>
			<th>Memory</th>
			<th>Operating system</th>
			<th>SIM</th>
			<th>Battery</th>
			<th>Color</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${phones}" var="phone">
			<tr>
				<td>${phone.maker.name}${phone.model}$${phone.price}</td>
				<td>${phone.displayValue}
					(${phone.displayResolution.width}x${phone.displayResolution.height})</td>
				<td>Primary - ${phone.primaryCamera} Secondary -
					${phone.secondaryCamera}</td>
				<td>${phone.processor.maker.maker}${phone.processor.model}
					${phone.processor.frequency}GHz ${phone.processor.numberOfCores}
					cores</td>
				<td>RAM - ${phone.ram} Internal - ${phone.internal} Card -
					${phone.card}</td>
				<td>${phone.operatingSystem.name.name}-
					${phone.operatingSystem.version}</td>
				<td>${phone.numberOfSimCards}</td>
				<td>${phone.battery}</td>
				<td>${phone.color.color}</td>
				<td><a class="btn btn-warning"
					href="/update/${phone.id}<custom:allParams/>">Update</a></td>
				<td><a class="btn btn-danger"
					href="/delete/${phone.id}<custom:allParams/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>