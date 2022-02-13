$('document').ready(function() {
	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(invoice, status){
			$('#idEdit').val(invoice.id);
			$('#ddlClientEdit').val(invoice.clientid);
			$('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
            $('#remarksEdit').val(invoice.remarks);
            var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateEdit').val(invoice.invoiceDate);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(invoice, status){
			$('#idDetails').val(invoice.id);
			$('#ddlClientDetails').val(invoice.clientid);
			$('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);
            $('#remarksDetails').val(invoice.remarks);
            var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateDetails').val(invoiceDate);

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