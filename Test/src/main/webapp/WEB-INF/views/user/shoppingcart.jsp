<div class="col-md-12 row">
	<ul>
		<c:forEach items="${ord.phones}" var="phone">
			<li class="product text-center"><a><img class="photo"
					src="/images/phone/${phone.id}.jpg?version=${phone.version}"><br>
					${phone.maker.name} ${phone.model} ${phone.internal}GB
					${phone.color.color}</a>
				<p class="price">$${phone.price}</p>
		</c:forEach>
	</ul>
</div>