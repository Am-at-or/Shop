<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone</title>
</head>
<body>
	<div class="row">
		<div class="col-md-10 col-md-offset-1 specification">
			<div class="col-md-6 photo-background">
				<img class="phone-photo-big"
					src="/images/phone/${phone.id}.jpg?version=${phone.version}">
			</div>
			<div class="col-md-6">
				<h3>Model: ${phone.maker.name} ${phone.model} $${phone.price}</h3>
				<b>Display</b>
				<p>${phone.displayResolution.width}x${phone.displayResolution.height}</p>
				<b>Camera:</b>
				<p>primary ${phone.primaryCamera} px, secondary
					${phone.secondaryCamera} px.</p>
				<b>Processor:</b>
				<p>${phone.processor.maker.maker} ${phone.processor.model}
					(${phone.processor.frequency} GHz), cores:
					${phone.processor.numberOfCores}</p>
				<b>Memory:</b>
				<p>RAM ${phone.ram} GB, internal ${phone.internal} GB, card
					${phone.card} GB</p>
				<b>SIM:</b>
				<p>${phone.numberOfSimCards}</p>
				<b>Operating System:</b>
				<p>${phone.operatingSystem.name.name} ${phone.operatingSystem.version}</p>
				<b>Battery:</b>
				<p>${phone.battery} mA</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-10 col-md-offset-1 other-phones">
			<h3>Other phones this maker:</h3>
		</div>
	</div>
	<div class="row text-center">
		<ul>
			<c:forEach items="${phones}" var="phone">
				<li class="product text-center" style="width: 20%;"><a
					href="/phone/${phone.id}"><img class="photo"
						src="/images/phone/${phone.id}.jpg?version=${phone.version}"><br>
						${phone.maker.name} ${phone.model} ${phone.internal}GB
						${phone.color.color}</a>
					<p class="price">$${phone.price}</p> <sec:authorize
						access="isAuthenticated()">
						<form:form style="display:inline-block;margin-top:8px;"
							action="/addtocart/${phone.id}" method="POST">
							<button type="submit" class="btn btn-success">Add</button>
						</form:form>
					</sec:authorize></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>