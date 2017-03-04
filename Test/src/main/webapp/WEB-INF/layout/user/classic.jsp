<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<style type="text/css">
body {
	background: #989898;
	background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0.15) 0%,
		rgba(0, 0, 0, 0.15) 100%),
		-webkit-radial-gradient(at top center, rgba(255, 255, 255, 0.4) 0%,
		rgba(0, 0, 0, 0.4) 120%);
	background: linear-gradient(to bottom, rgba(255, 255, 255, 0.15) 0%,
		rgba(0, 0, 0, 0.15) 100%),
		radial-gradient(at top center, rgba(255, 255, 255, 0.4) 0%,
		rgba(0, 0, 0, 0.4) 120%);
	background-blend-mode: multiply, multiply;
	width: 1024px;
	padding-bottom: 0px;
	padding-top: 10px;
	margin: 0 auto;
}

.navbar {
	margin-bottom: 0;
}

.edit {
	margin-bottom: 20px;
	font-weight: 600;
	font-family: Verdana;
	text-align: center;
}

.form {
	border-radius: 10px;
	padding: 30px 40px 60px 40px;
	background: rgba(0, 0, 0, 0.1);
	 box-shadow: 0 0 10px rgba(0,0,0,0.5);
}

.table-striped {
	margin-top: 40px;
}

.nav a {
	color: #333;
}

@media ( min-width : 1000px) {
	.navbar .navbar-nav {
		display: inline-block;
		float: none;
		vertical-align: top;
	}
	.navbar .navbar-collapse {
		text-align: center;
	}
}

@media ( max-width :1000px) {
	.nav>li {
		float: none;
		position: relative;
		display: block;
	}
	.navbar-collapse.collapse {
		display: none !important;
	}
	.navbar-collapse {
		overflow-x: visible !important;
	}
	.navbar-collapse.in {
		overflow-y: auto !important;
	}
	.collapse.in {
		display: block !important;
	}
	.navbar-toggle {
		display: block;
	}
}
</style>
<!-- сюди буде підставлено атрибут з ім'ям title -->
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<!-- 	а сюди jsp файл з ім'ям header -->
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
		<!-- 	сюди jsp файл з ім'ям body -->
		<tiles:insertAttribute name="body" />
	</div>
	<!-- 	сюди jsp файл з ім'ям footer -->
	<tiles:insertAttribute name="footer" />
	<!-- 	зверніть увагу на те що в темплейт файлі (тут) -->
	<!-- 	вже описано основний HTML код, в інших файлах -->
	<!-- 	його писати не потрібно(я про <head><body><html>) -->
</body>
</html>