/*
$("${developers}").each(function () {
	
})
*/
document.getElementById('saveDeveloper').onclick = function () {

    var developer = {

        name : $('#nameDeveloper').val(),

    }

    document.getElementById('nameDeveloper').value = '';

    $.ajax({
    	
        url: 'saveDeveloper?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(developer),
        success : function (res) {
        	
        }
    })
}