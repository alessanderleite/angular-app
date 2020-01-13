var app = angular.module('CustomerManagement', []);

//Controller Part
app.controller('CustomerController', function($scope, $http) {
	
	$scope.customers = [];
	$scope.customerForm = {
			id : -1,
			customerName : '',
			email : ''
	};
	
	//Load the data from server
	_refreshCustomerData()
	
	$scope.submitCustomer = function() {
		
		var method = '';
		var url = '';
		
		if ($scope.customerForm.id == -1) {
			method = 'POST';
			url = '/addCustomer';
		} else {
			method = 'PUT';
			url = '/updateCustomer';
		}
		
		$http({
			method: method,
			url : url,
			data : angular.toJson($scope.customerForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then( _success, _error );
	};
	
	//Populate form fields
    $scope.editCustomer = function(customer) {
        $scope.customerForm.customerName = customer.customerName;
        $scope.customerForm.email = customer.email;
        $scope.customerForm.id = customer.id;
    };
	
	//HTTP GET - get all customers
    function _refreshCustomerData() {
        $http({
            method : 'GET',
            url : 'http://localhost:8080/getAllCustomers'
        }).then(function successCallback(response) {
            $scope.customers = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	
    function _success(response) {
    	_refreshCustomerData();
        _clearFormData();
    }

    function _error(response) {
        console.log(response.statusText);
    }

    //Clear the form
    function _clearFormData() {
        $scope.customerForm.id = -1;
        $scope.customerForm.customerName = '';
        $scope.customerForm.email = '';
    
    };
});