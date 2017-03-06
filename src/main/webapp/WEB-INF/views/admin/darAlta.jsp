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
							<th>Fecha baja</th>
							<th>¿Alta?</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${usuarios}" var="u">
							<tr>
								<td>${u.id}</td>
								<td>${u.nombre}</td>
								<td>${u.fechaBaja}</td>
								<td><a href="admin/dar-alta/${u.id}"><i
										class="fa fa-check-square"
										onclick="return confirm('¿Seguro que quiere dar de alta de nuevo a este usuario?')"
										aria-hidden="true"></i></a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>



	<%@include file="../layout/footer.jsp"%>