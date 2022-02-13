$('document').ready(function() {
	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(invoice, status){
			$('#idEdit').val(invoice.id);
			$('#ddlClientEdit').val(invoice.clientId);
			$('#invoiceDateEdit').val(invoiceDate);
			$('#ddlInvoiceStatusEdit').val(invoice.invoiceStatusId);
			$('#remarksEdit').val(invoice.remarks);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(invoice, status){
			$('#idDetails').val(invoice.id);
			$('#ddlClientDetails').val(invoice.clientId);
			$('#invoiceDateDetails').val(invoiceDate);
			$('#ddlStatusDetails').val(invoice.invoiceStatusId);
			$('#remarksDetails').val(invoice.remarks);
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