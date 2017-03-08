<%@include file="../layout/header.jsp"%>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<%@include file="../layout/nav.jsp"%>
	<!-- Intro Section -->
	<section id="intro" class="intro-section">
		<div class="container">

			<div class="row">

				<div width="50%">
					<h3>Estadisticas</h3>
					<table id="example" class="display" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>#Id</th>
								<th>Nombre</th>
								<th>Fecha Tirada</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${usuarios}" var="u">
								<c:forEach items="${u.listaTiradas}" var="t">
									<tr>
										<td>${u.id}</td>
										<td>${u.nombre}</td>
										<td>${t.fechaTirada}</td>
									</tr>
								</c:forEach>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>


	<%@include file="../layout/footer.jsp"%>