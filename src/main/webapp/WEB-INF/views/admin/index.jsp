<%@include file="../layout/header.jsp"%>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<%@include file="../layout/nav.jsp"%>
	<!-- Intro Section -->
	<section id="intro" class="intro-section">
		<div class="container">
			<!-- Heading Row -->
			<c:if test="${usuariosBaja.size()!=0}">
				
					<a  href="admin/dar-alta" class="btn btn-info left" role="button">Alta
						usuario</a><br/><br/>

			</c:if>
			<div class="row">
				<div class="col-md-8">
					<table id="example" class="display boderRadius" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>#Id</th>
								<th>Nombre</th>
								<th>Modificar</th>
								<th>Dar de baja</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${usuarios}" var="u">
								<tr>
									<td>${u.id}</td>
									<td><a href="admin/${u.id}">${u.nombre}</a></td>
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
				<!-- /.col-md-8 -->
				<div class="col-md-4"></div>
				<c:if test="${usuario==null}">
					<a href="admin/crear" class="btn btn-success" role="button">Crear
						Usuario</a>
				</c:if>
				<c:if test="${usuario!=null}">
					<div class="row">
						<div class="posDiv">
							<form:form modelAttribute="usuario" method="post">
								<c:if test="${usuario.id!=-1}">
									<div class="col-xs-12">
										<form:label path="id">Id</form:label>
										<form:input class="form-control" path="id" readonly="true"
											size="" />
									</div>
									<br />
									<br>
									<br />
									<br>
								</c:if>
								<div class="col-xs-12">
									<form:label path="nombre">Nombre</form:label>
									<form:input path="nombre" class="form-control" />
								</div>
								<br />
								<br>
								<br />
								<br />
								<div class="col-xs-12">
									<form:button type="submit" class="btn btn-success"
										value="enviar">Enviar</form:button>
								</div>
							</form:form>
						</div>
					</div>
				</c:if>
			</div>
			<!-- /.col-md-4 -->
		</div>

	</section>



	<%@include file="../layout/footer.jsp"%>