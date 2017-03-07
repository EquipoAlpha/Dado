<%@include file="../layout/header.jsp"%>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<%@include file="../layout/nav.jsp"%>
	<div class="container">
		<div class="row">
		<div id="imagenGetPost">
			<img width="200px" height="200px" src="http://files.mi-portafolio-virtual0.webnode.es/200000006-829e0839be/perfil-profissional.jpg" class="img-responsive img-rounded"
				alt="usuario">
		</div>
			<div class="posForm">
			<h3><strong>Datos del usuario </strong><em>${usuario.nombre}</em></h3><br/>
				<form:form modelAttribute="usuario" method="post">
					<div class="form-group">
						<form:label path="id">#Id</form:label>
						<form:input class="form-control" path="id" readonly="true" />
					</div>
					<div class="form-group">
						<form:label path="nombre">Nombre:</form:label>
						<form:input class="form-control" path="nombre" />
						<form:errors path="nombre" cssStyle="color:red;" />
					</div>
					<div class="form-group">
						<fmt:formatDate value="${usuario.fechaAlta}" var="dateAlta" pattern="dd/MM/yyyy" />
						<form:label path="fechaAlta">Fecha alta:</form:label>
						<form:input class="form-control" path="fechaAlta" value="${dateAlta}" readonly="true" disabled="true"  />
					</div>
					<div class="form-group">
						<fmt:formatDate value="${usuario.fechaModificacion}" var="fechaMod" pattern="dd/MM/yyyy " />
						<form:label path="fechaModificacion">Ultima modificacion </form:label>
						<form:input class="form-control" path="fechaModificacion" value="${fechaMod}" readonly="true" disabled="true"/>
					</div>
					<c:if test="${usuario.fechaBaja!=null}">
					<div class="form-group">
						<fmt:formatDate value="${usuario.fechaBaja}" var="fechaBaj" pattern="dd/MM/yyyy " />
						<form:label path="fechaBaja">Fecha Baja </form:label>
						<form:input class="form-control" path="fechaBaja" value="${fechaBaj}" readonly="true" disabled="true" />
					</div>
					<a href="admin/dar-alta/${usuario.id}" class="btn btn-success" role="button">Dar de alta</a>
					</c:if>
					<br>
					<c:if test="${usuario.fechaBaja==null}">
					<form:button type="submit" class="btn btn-info">Modificar</form:button>
					<a href="admin/eliminar/${usuario.id}" class="btn btn-danger" role="button">Dar de baja</a>
					
					</c:if>
				</form:form>
			</div>
		</div>
	</div>



	<%@include file="../layout/footer.jsp"%>