$(document).ready(function() {
	window.setInterval(function(){
		$.ajax({
			type: "GET",
	        url: "//" + location.host + "/iot-hub-example/rest/temperature/list",
	        dataType: "json",
	        success: function(data){
	        	$("#temperatures").find("tr:gt(0)").remove();
	        	$.each(data,function(i,line){
	        		var date = new Date(line['time']);
	        		var value = line['value'];
	        		$('#temperatures tr:last').after('<tr><td>'+ date.toLocaleString() + '</td><td>' + value + '</td></tr>');
	        	});
	        }
	    })
	}, 5000);
});