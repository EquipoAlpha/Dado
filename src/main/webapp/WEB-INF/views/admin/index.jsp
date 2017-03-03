<%@include file="../layout/header.jsp"%>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<%@include file="../layout/nav.jsp"%>
	<!-- Intro Section -->
	<section id="intro" class="intro-section">
		<div class="container">
			<div class="row">
				<h3>Usuarios</h3>
				<table id="example" class="display" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>#Id</th>
							<th>Nombre</th>
							<th>Modificar</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
					<tr>
								<td>#3</td>
								<td>Peco</td>
								<td><a href="admin/modificar/3"><i
										class="fa fa-pencil-square" aria-hidden="true"></i></a></td>
								<td><a href="admin/eliminar/3"><i
										class="fa fa-trash"
										onclick="return confirm('¿Seguro que quiere dar de baja este usuario?')"
										aria-hidden="true"></i></a></td>
							</tr>
						<c:forEach items="${usuarios}" var="u">
							<tr>
								<td>${u.id}</td>
								<td>${u.nombre}</td>
								<td><a href="admin/modificar/${u.id}"><i
										class="fa fa-pencil-square" aria-hidden="true"></i> </a></td>
								<td><a href="admin/eliminar/${u.id}"><i
										class="fa fa-trash"
										onclick="return confirm('¿Seguro que quiere dar de baja este usuario?')"
										aria-hidden="true"></i></a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<a href="admin/crear" class="btn btn-success" role="button">Crear Usuario</a>
			<c:if test="${usuario!=null}">
				<div class="row">
					<form:form modelAttribute="usuario">
						<c:if test="${usuario.id!=-1}">
							<form:label path="id">Id</form:label>
							<form:input path="id" />
						</c:if>
						<form:label path="nombre">Nombre</form:label>
						<form:input path="nombre" />
					</form:form>
				</div>
			</c:if>

		</div>
	</section>



	<%@include file="../layout/footer.jsp"%>