<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<script src="/resources/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript">
	$(function() {
		$(".chosen-select").chosen();
	});
</script>
<title><tiles:getAsString name="title" /></title>
</head>
<style>
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
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
	margin-bottom: 30px;
}

.table-striped {
	margin-top: 20px;
}

.nav a {
	color: #333;
}

.btn-below {
	margin-top: 27px;
}

.input-below {
	margin-top: 15px;
}

.product {
	padding: 5px;
	margin-top: 10px;
	display: inline-block;
	cursor: default;
	width: 24.62%;
	height: 250px;
	background-color: #fff;
	border-radius: 10px;
	display: inline-block;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
	margin-top: 10px;
}

.photo {
	margin-bottom: 10px;
}

a:hover {
	cursor: pointer;
	text-decoration: none;
}

.price {
	margin: 0 10%;
	border-radius: 10px;
	background-color: #47c266;
	font-size: 20px;
	font-weight: bold;
}

.min-max {
	float: left;
	width: 50%;
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
<body>
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>