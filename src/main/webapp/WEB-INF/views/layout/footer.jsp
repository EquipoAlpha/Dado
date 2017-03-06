

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>
<!-- Scrolling Nav JavaScript -->
<script src="resources/js/jquery.easing.min.js"></script>
<script src="resources/js/scrolling-nav.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- DATABASE -->
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="//cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#example')
								.dataTable(
										{
											"language" : {
												"url" : "//cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
											},
										"bFilter": false,
									    "bLengthChange": false,
									    "order": [[ 2, "desc" ]]
										});
					});
</script>
</body>
</html>