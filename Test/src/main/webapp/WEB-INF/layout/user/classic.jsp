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
<script type="text/javascript">
	$(function() {
		$(".chosen-select").chosen();
	});
</script>
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
	margin-top: 25px;
}
.input-below {
	margin-top: 15px;
}
.pag-below {
	margin-top: 245px;
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
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>