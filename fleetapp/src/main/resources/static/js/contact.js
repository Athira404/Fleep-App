$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(contact, status){
			$('#txtEmailEdit').val(contact.email);
			$('#txtFirstnameEdit').val(contact.firstname);
			$('#txtIdEdit').val(contact.id);
			$('#txtLastnameEdit').val(contact.lastname);
			$('#txtPhoneEdit').val(contact.phone);
			$('#txtRemarksEdit').val(contact.remarks);
		});
		$('#editModal').modal();
	});


	$('.table #detailsButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(contact, status){
			$('#txtEmailDetails').val(contact.email);
			$('#txtFirstnameDetails').val(contact.firstname);
			$('#txtIdDetails').val(contact.id);
			$('#txtLastnameDetails').val(contact.lastname);
			$('#txtPhoneDetails').val(contact.phone);
			$('#txtRemarksDetails').val(contact.remarks);
		});
		$('#detailsModal').modal();
	});


	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});