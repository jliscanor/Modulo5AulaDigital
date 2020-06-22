function CursoController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").adClass("alert-danger");
	
	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
			url : "/curso_page/list",
			success : function(res) {
				$("#cursoTable").bootstrapTable('load',res);
				$("#cursoTable tbody").on('click', 'tr', function() {
					$("#codigo").val($(this).find("td:eq(0)").text());
					$("#nombre").val($(this).find("td:eq(1)").text());
					$("#myModal .close").click();
				});
				$("#myModal").modal({show:true})
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en la busqueda de curso");
				}
			});
			break;
	case "get":
		$.ajax({
			type : "post",
			url : "/curso_page/get",
			data : "codigo=" + $("#codigo").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontro el registro");
				} else {
					$("#codigo").val(res.rut));
					$("#nombre").val(res.nombre);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en la busqueda de curso");
				}
			});
			break;
			
	case "insert":
		var json =
			{
				'codigo' : $("#codigo").val(),
				'nombre' : $("#nombre").val(),
			}
		var postData = JSON.stringify(json);
		$.ajax({
			type : "post",
			url : "/curso_page/insert",
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
				$("#msg").html("Error en la busqueda de curso");
				}
			});
			break;
			
	case "update":
		var json =
			{
				'codigo' : $("#codigo").val(),
				'nombre' : $("#nombre").val(),
			}
		var postData = JSON.stringify(json);
		$.ajax({
			type : "post",
			url : "/curso_page/update",
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
				$("#msg").html("Error en la actualizacion de curso");
				}
			});
			break;
			
	case "delete":
		$.ajax({
			type : "post",
			url : "/curso_page/delete",
			data : "codigo=" + $("#codigo").val(),
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
				$("#msg").html("Error en la eliminacion de curso");
				}
			});
			break;
		default:
			$("#msg").show();
			$("#msg").html("Opcion incorrecta")
	}
}