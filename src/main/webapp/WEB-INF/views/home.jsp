<%@include file="layout/header.jsp"%>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<%@include file="layout/nav.jsp"%>
	<!-- Intro Section -->
	<section id="intro" class="intro-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1>Dado</h1>
					<p>
						<strong>Funcion:</strong> Lanzar el dado para poder elegir una
						persona para que lea cuando no hay voluntarios
					</p>
				</div>
			</div>
			<div class="row">
				<div id="dado">
					<h3>Seleccionar afortunado</h3>
					<img width="200px" height="200px" title="dado" alt="dado"
						src="http://2.bp.blogspot.com/-sQLWdIP4vQg/VMzkAv5qefI/AAAAAAAAAZA/Jowfw5tZkz4/s1600/Dado%2B(GIF).gif" />
					<c:if test="${afortunado!=null }">
						<p>
							<strong>El afortunado es:</strong> ${afortunado}
						</p>
					</c:if>
					<form method="post">
						<button type="submit" class="btn btn-primary">Lanzar</button>
					</form>
				</div>
				<div id="ranking">
					<h3>Ranking</h3>
					<table id="example" class="display" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>#Id</th>
								<th>Nombre</th>
								<th>Número tiradas</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${usuarios}" var="u">
								<tr>
									<td>${u.id}</td>
									<td>${u.nombre}</td>
									<td>${fn:length(u.listaTiradas)}</td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>



	<%@include file="layout/footer.jsp"%>
