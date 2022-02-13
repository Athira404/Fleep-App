$('document').ready(function() {
	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicle, status){

			var acquisitionDate = vehicle.acquisitionDate.substr(0,10);
			$('#txtAcquisitionDateEdit').val(acquisitionDate);

			$('#txtDescriptionEdit').val(vehicle.description);
			$('#ddlEmployeeEdit').val(vehicle.employeeid);
			$('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#txtIdEdit').val(vehicle.id);
			$('#ddlLocationEdit').val(vehicle.locationid);
			$('#txtNameEdit').val(vehicle.name);
			$('#txtNetWeightEdit').val(vehicle.netWeight);
			$('#txtPowerEdit').val(vehicle.power);

			var registrationDate = vehicle.registrationDate.substr(0,10);
			$('#txtRegistrationDateEdit').val(registrationDate);

			$('#txtRemarksEdit').val(vehicle.remarks);
			$('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
			$('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
			$('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);
			$('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
		});
		$('#editModal').modal();
	});


	$('.table #detailsButton').on('click',function(event){
    		event.preventDefault();
    		var href= $(this).attr('href');
    		$.get(href, function(vehicle, status){

    			var acquisitionDate = vehicle.acquisitionDate.substr(0,10);
    			$('#txtAcquisitionDateDetails').val(acquisitionDate);

    			$('#txtDescriptionDetails').val(vehicle.description);
    			$('#ddlEmployeeDetails').val(vehicle.employeeid);
    			$('#txtFuelCapacityDetails').val(vehicle.fuelCapacity);
    			$('#txtIdDetails').val(vehicle.id);
    			$('#ddlLocationDetails').val(vehicle.locationid);
    			$('#txtNameDetails').val(vehicle.name);
    			$('#txtNetWeightDetails').val(vehicle.netWeight);
    			$('#txtPowerDetails').val(vehicle.power);

    			var registrationDate = vehicle.registrationDate.substr(0,10);
    			$('#txtRegistrationDateDetails').val(registrationDate);

    			$('#txtRemarksDetails').val(vehicle.remarks);
    			$('#ddlVehicleMakeDetails').val(vehicle.vehiclemakeid);
    			$('#ddlVehicleModelDetails').val(vehicle.vehiclemodelid);
    			$('#txtVehicleNumberDetails').val(vehicle.vehicleNumber);
    			$('#ddlVehicleStatusDetails').val(vehicle.vehiclestatusid);
    			$('#ddlVehicleTypeDetails').val(vehicle.vehicletypeid);
    		});
    		$('#editModal').modal();
    	});



	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});

	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #vehiclePhoto').attr('src', href);
		$('#photoModal').modal();
	});
});