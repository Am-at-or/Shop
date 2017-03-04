<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<td>${phone.maker.name}${phone.model} $${phone.price}</td>
				<td>${phone.display.size.size}
					(${phone.display.width.width}x${phone.display.height.height})
					${phone.display.technology.technology}</td>
				<td>Primary - ${phone.primaryCamera} Secondary -
					${phone.secondaryCamera}</td>
				<td>${phone.processor.maker.maker}${phone.processor.model}
					${phone.processor.frequency}GHz
					${phone.processor.numberOfCores.cores} cores</td>
				<td>RAM - ${phone.ram.ram} Internal -
					${phone.internal.internal} Card - ${phone.card.card}</td>
				<td>${phone.operatingSystem.name.name}-
					${phone.operatingSystem.version}</td>
				<td>${phone.numberOfSimCards.simCards}</td>
				<td>${phone.battery}</td>
				<td>${phone.color.color}</td>
				<td><a class="btn btn-warning"
					href="/admin/phone/update/${phone.id}">Update</a></td>
				<td><a class="btn btn-danger"
					href="/admin/phone/delete/${phone.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>