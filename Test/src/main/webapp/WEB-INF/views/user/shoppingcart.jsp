<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="col-md-1">
	<a href="/makeorder"><button type="button" class="btn btn-success"
			style="margin-top: 8px;">Confirm</button></a>
</div>
<div class="col-md-10">
	<div class="row">
		<ul>
			<c:forEach items="${qwer}" var="phone">
				<li class="product text-center" style="margin: 8px 0px;"><a><img
						class="photo"
						src="/images/phone/${phone.id}.jpg?version=${phone.version}"><br>
						${phone.maker.name} ${phone.model} ${phone.internal}GB
						${phone.color.color}</a>
					<p class="price">$${phone.price}</p> <sec:authorize
						access="isAuthenticated()">
						<form:form style="display:inline-block;margin-top:8px;"
							action="/deletefromcart/${phone.id}" method="POST">
							<button type="submit" class="btn btn-danger">Remove</button>
						</form:form>
					</sec:authorize></li>
			</c:forEach>
		</ul>
	</div>
</div>