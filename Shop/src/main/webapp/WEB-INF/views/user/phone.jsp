<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone</title>
</head>
<body>
	<h3>Model: ${phone.maker.name} ${phone.model}</h3>
	<h4>Specifications:</h4>
	<h5>
		<b>Display</b> ${phone.display.size}, ${phone.display.technology},
		${phone.display.resolutionWidth}x${phone.display.resolutionHeight}
	</h5>
	<h5>
		<b>Camera:</b> primary ${phone.primaryCamera} px, secondary
		${phone.secondaryCamera} px.
	</h5>
	<h5>
		<b>Processor:</b> ${phone.processor.maker} ${phone.processor.name}
		(${phone.processor.frequency} Hz), cores:
		${phone.processor.numberOfCores}
	</h5>
	<h5>
		<b>Memory:</b> RAM ${phone.ram} MB, internal ${phone.internal} MB,
		card ${phone.card} MB
	</h5>
	<h5>
		<b>Number Of Sim Cards:</b> ${phone.numberOfSimCards}
	</h5>
	<h5>
		<b>Operating System:</b> ${phone.operatingSystem.name}
		${phone.operatingSystem.version}
	</h5>
	<h5>
		<b>Battery:</b> ${phone.battery} mA
	</h5>
</body>
</html>