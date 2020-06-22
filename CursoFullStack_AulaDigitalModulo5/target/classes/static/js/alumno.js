function AlumnoController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").adClass("alert-danger");
	
	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
			url : "/alumno_page/list",
			success : function(res) {
				$("#alumnoTable").bootstrapTable('load',res);
				$("#alumnoTable tbody").on('click', 'tr', function() {
					$("#rut").val($(this).find("td:eq(0)").text());
					$("#nombre").val($(this).find("td:eq(1)").text());
					$("#curso").val($(this).find("td:eq(2)").text());
					$("#myModal .close").click();
				});
				$("#myModal").modal({show:true})
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en la busqueda de alumnos");
				}
			});
			break;
	case "get":
		$.ajax({
			type : "post",
			url : "/alumno_page/get",
			data : "rut=" + $("#rut").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontro el registro");
				} else {
					$("#rut").val(res.rut));
					$("#nombre").val(res.nombre);
					$("#curso").val(curso);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en la busqueda de alumnos");
				}
			});
			break;
			
	case "insert":
		var json =
			{
				'rut' : $("#rut").val(),
				'nombre' : $("#nombre").val(),
				'curso' : $("#rut").val()
			}
		var postData = JSON.stringify(json);
		$.ajax({
			type : "post",
			url : "/alumno_page/insert",
			data : postData,
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").adClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro incertado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar el registro");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en la busqueda de alumnos");
				}
			});
			break;
			
	case "update":
		var json =
			{
				'rut' : $("#rut").val(),
				'nombre' : $("#nombre").val(),
				'curso' : $("#rut").val()
			}
		var postData = JSON.stringify(json);
		$.ajax({
			type : "post",
			url : "/alumno_page/update",
			data : postData,
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").adClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro actualizado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo actualizar el registro");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en la actualizacion de alumnos");
				}
			});
			break;
			
	case "delete":
		$.ajax({
			type : "post",
			url : "/alumno_page/delete",
			data : "rut=" + $("#rut").val(),
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").adClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar el registro");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en la eliminacion de alumnos");
				}
			});
			break;
		default:
			$("#msg").show();
			$("#msg").html("Opcion incorrecta")
	}
}