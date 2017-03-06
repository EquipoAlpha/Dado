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
	<section>
		<!-- DONUT CHART BLOCK (LEFT-CONTAINER) -->
		<div class="donut-chart-block block">
			<h2 class="titular">Estadisticas</h2>
			<div class="donut-chart">
				<!-- PORCIONES GRAFICO CIRCULAR
      ELIMINADO #donut-chart
      MODIFICADO CSS de .donut-chart -->
				<div id="porcion1" class="recorte">
					<div class="quesito ios" data-rel="21"></div>
				</div>
				<div id="porcion2" class="recorte">
					<div class="quesito mac" data-rel="39"></div>
				</div>
				<div id="porcion3" class="recorte">
					<div class="quesito win" data-rel="31"></div>
				</div>
				<div id="porcionFin" class="recorte">
					<div class="quesito linux" data-rel="9"></div>
				</div>
				<!-- FIN AÑADIDO GRÄFICO -->
				<p class="center-date">
					<span class="scnd-font-color">2017</span>
				</p>
			</div>
		</div>

	</section>

	<%@include file="../layout/footer.jsp"%>