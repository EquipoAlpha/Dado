<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Lanzar Dado</h1>
	<img alt="imagen de dato"
		src="http://www.gifsanimados.org/data/media/710/dado-imagen-animada-0079.gif">
	<form method="post">
		<button type="submit" class="btn btn-primary">Lanzar</button>
	</form>
	<c:if test="${afortunado!=null}">
		<h2>El afortunado en leer es: ${afortunado.toUpperCase()}</h2>
	</c:if>
</body>
</html>
