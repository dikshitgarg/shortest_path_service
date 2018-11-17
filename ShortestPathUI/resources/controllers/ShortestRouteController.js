app.controller("ShortestRouteController", function($scope,$ngBootbox,$http,$window,$location,$rootScope) {
	
	 var config = { headers : {  'Content-Type': 'application/json ;charset=utf-8;'   } }
	  $scope.findroute= function(){
		  if(!($scope.shortest.number<=2) && ($scope.shortest.origin<$scope.shortest.number)){
		  
		  $http.post("http://localhost:8085/v1/shortest",$scope.shortest)
          .success(function (response){    
        	  $scope.result=response.result;
          })
          .error(function (response){
          });
		  }
		  else{
			  $ngBootbox.alert("Please check your input:<br>" +
			  		"1.Number of cities should be more than 2<br>" +
			  		"2.Origin city starts from 0 so last city should not be equal to the number of cities");

		  }
		  

      };
});

