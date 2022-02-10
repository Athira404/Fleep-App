$('document').ready(function(){

// for edit button
    $('table #editButton').on('click', function(event){//if i don't use table here than the following js code will only have effect on the first row
            event.preventDefault(); //prevents the default--> if i don't add it, then the method i have write in controller will be executed, and if
        // there is no method in controller obviously it will throw 404 error status

        // i need to get the url like countries/findById/?id=1
        // so i've to make a req from js
        // we get that link by the href attribute of the clicked btn
        // the current button that clicked is --> THIS
        var href = $(this).attr('href');

        $.get(href, function(country, status){
        //we get country record from the controller by findById method
        //to make request $.get(), we need url(href) to make req
        //when the req is made, that function will execute
            $('#idEdit').val(country.id);//idEdit is the id from the html page(modal form)
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
        });
        $('#editModal').modal();
    });

//for delete button

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');//this refers to the button clicked rn(eg: countries/delete/?id1)

        $('#confirmDeleteButton').attr('href', href);//in this line we are setting the href link that is countries/delete/?id1
//         to the href in the html page <a> which has id confirmDeleteButton(refer html page deleteModal)
        $('#deleteModal').modal();
    });

//    details Modal
    $('table #detailsButton').on('click',function(event) {
    		event.preventDefault();
    		var href= $(this).attr('href');
    		$.get(href, function(country, status){
    			$('#idDetails').val(country.id);
    			$('#codeDetails').val(country.code);
    			$('#capitalDetails').val(country.capital);
    			$('#descriptionDetails').val(country.description);
    			$('#nationalityDetails').val(country.nationality);
    			$('#continentDetails').val(country.continent);
    		});
    		$('#detailsModal').modal();
    	});

});