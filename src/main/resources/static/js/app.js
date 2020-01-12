'use strict'

var app = angular.module("CustomerManagement", []);
 
    //Controller Part
app.controller("CustomerController", function($scope, $http) {
       
        $scope.customers = [];
        $scope.customerForm = {
            id : -1,
            customerName : "",
        email : ""
        };

        $scope.submitCustomer = function() {
 
	        var method = "";
	        var url = "";
	        if ($scope.customerForm.id == -1) {
	            //Id is absent in form data, it is create new customer operation
	            method = "POST";
	            url = '/addCustomer';
	        } else {
	            //Id is present in form data, it is edit customer operation
	            method = "PUT";
	            url = '/addCustomer';
	            }
	 
	            $http({
	                method : method,
	                url : url,
	                data : angular.toJson($scope.customerForm),
	                headers : {
	                    'Content-Type' : 'application/json'
	                }
	            }).then( _success, _error );
        };
 
        function _success(response) {
            _clearFormData()
        }
 
        function _error(response) {
            console.log(response.statusText);
        }
 
        //Clear the form
	    function _clearFormData() {
	        $scope.customerForm.id = -1;
	        $scope.customerForm.customerName = "";
	        $scope.customerForm.email = "";
	    
	    };
});