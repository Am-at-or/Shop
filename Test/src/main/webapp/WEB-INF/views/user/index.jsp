<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-2">
		<form action="" method="get">
			<h3>Maker</h3>
			<label for="Samsung">Samsung <input type="checkbox"
				name="Samsung"></label><br> <label for="Lenovo">Lenovo
				<input type="checkbox" name="Lenovo">
			</label><br> <label for="HTC">HTC <input type="checkbox"
				name="HTC"></label><br> <label for="Apple">Apple <input
				type="checkbox" name="Apple"></label><br> <label for="Sony">Sony
				<input type="checkbox" name="Sony">
			</label><br> <input type="submit">
		</form>
	</div>
	<div class="col-md-10">
		<h3>Available models:</h3>
		<ul>
			<c:forEach items="${phones}" var="phone">
				<li><a href="/phone/${phone.id}">${phone.model}</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
