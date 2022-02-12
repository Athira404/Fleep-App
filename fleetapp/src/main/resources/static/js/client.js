$('document').ready(function() {

	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(client, status){
			$('#idEdit').val(client.id);
			$('#nameEdit').val(client.name);
			$('#detailsEdit').val(client.details);
			$('#websiteEdit').val(client.website);
			$('#addressEdit').val(client.address);
			$('#ddlStateEdit').val(client.stateid);
			$('#ddlCountryEdit').val(client.countryid);
			$('#cityEdit').val(client.city);
			$('#phoneEdit').val(client.phone);
			$('#emailEdit').val(client.email);
		});
		$('#editModal').modal();
	});

	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(client, status){
			$('#idDetails').val(client.id);
            $('#nameDetails').val(client.name);
            $('#detailsDetails').val(client.details);
            $('#websiteDetails').val(client.website);
            $('#addressDetails').val(client.address);
            $('#ddlStateDetails').val(client.stateid);
            $('#ddlCountryDetails').val(client.countryid);
            $('#cityDetails').val(client.city);
            $('#phoneDetails').val(client.phone);
            $('#emailDetails').val(client.email);
		});
		$('#detailsModal').modal();
	});

	$('table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delButton').attr('href', href);
		$('#deleteModal').modal();
	});
});




