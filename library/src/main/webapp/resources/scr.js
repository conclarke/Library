function getAllTracks(){
	var url = 'rest/query/allTracks';
	$.ajax({
		url : url,
		type : "POST",
		contentType : "application/json",
		dataType : 'json',
		success : function() {
			var text = "<b> Results' </b><br>";
			for (var i = 0; i < data.length; i++) {
				var obj = data[i];
				text = text + obj;
			}
			document.getElementById("results").innerHTML = text;
		}
	});
}
function xml(){
	var url = "rest/xml/init";
	$("#myform").submit(function(e){
		$.ajax({
			url:'/library/rest/xml/init',
			type : "POST",
			data: new FormData(this),
			processData: false,
			contentType: false
		});
		e.preventDefault();
	});
}