/**
 *
 */

$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(employee, status){
			$('#txtUsernameEdit').val(employee.username);
			$('#txtAddressEdit').val(employee.address);
			$('#txtCityEdit').val(employee.city);
			$('#ddlNationalityEdit').val(employee.countryid);
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(employee.email);
			$('#txtFirstnameEdit').val(employee.firstname);
			$('#ddlGenderEdit').val(employee.gender);
			$('#txtIdEdit').val(employee.id);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtLastnameEdit').val(employee.lastname);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#txtOthernameEdit').val(employee.otherName);
			$('#txtPhoneEdit').val(employee.phone);
//			$('#fupPhotoEdit').val(employee.photo);
			$('#ddlStateEdit').val(employee.stateid);
			$('#ddlTitleEdit').val(employee.title);
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(employee.jobtitleid);
		});
		$('#editModal').modal();
	});


	$('.table #detailsButton').on('click',function(event){
    		event.preventDefault();
    		var href= $(this).attr('href');
    		$.get(href, function(employee, status){
    			$('#txtUsernameDetails').val(employee.username);
    			$('#txtAddressDetails').val(employee.address);
    			$('#txtCityDetails').val(employee.city);
    			$('#ddlNationalityDetails').val(employee.countryid);
    			var dob = employee.dateOfBirth.substr(0,10);
    			$('#txtDateOfBirthDetails').val(dob);
    			$('#txtEmailDetails').val(employee.email);
    			$('#txtFirstnameDetails').val(employee.firstname);
    			$('#ddlGenderDetails').val(employee.gender);
    			$('#txtIdDetails').val(employee.id);
    			$('#txtInitialsDetails').val(employee.initials);
    			$('#txtLastnameDetails').val(employee.lastname);
    			$('#ddlMaritalStatusDetails').val(employee.maritalStatus);
    			$('#txtOthernameDetails').val(employee.otherName);
    			$('#txtPhoneDetails').val(employee.phone);
    //			$('#fupPhotoDetails').val(employee.photo);
    			$('#ddlStateDetails').val(employee.stateid);
    			$('#ddlTitleDetails').val(employee.title);
    			$('#ddlEmployeeTypeDetails').val(employee.employeetypeid);
    			var hireDate = employee.hireDate.substr(0,10);
    			$('#txtHireDateDetails').val(hireDate);
    			$('#ddlJobTitleDetails').val(employee.jobtitleid);
    		});
    		$('#detailsModal').modal();
    	});


	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDelete').attr('href', href);
		$('#deleteModal').modal();
	});

	$('.table #photoButton').on('click',function(event) {
		   event.preventDefault();
		   var href = $(this).attr('href');
		   $('#photoModal #employeePhoto').attr('src', href);
//		   im just assigning the link, its not going to navigate
		   $('#photoModal').modal();
	});

});


