var sipApp = angular.module("incidentModule", ['ngMaterial']);

sipApp.controller("incidentCtrl", function($scope, $http) {
	
	
	$scope.proceed = function(form){
		if($scope.type.localeCompare("animal") == 0){
			$scope.selectedValue = true;
		}
	}
	
	$scope.postMe = function() {
		debugger;
		$http.post('localhost:8080/_ah/api/incident/v1/create', $scope.animal).success(
				function(response) {
					alert("done");
				}).error(function(error) {
					alert("An error occured during post request");
		});
		
	}
})