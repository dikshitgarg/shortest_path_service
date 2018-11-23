app.controller("ShortestRouteController", function($scope,$ngBootbox,$http,$window,$location,$rootScope,NgTableParams) {
	
	$scope.demo="Input:\n\n" +
			"Enter number of cities\n" +
			"5\n" +
			"Enter distance between cities\n" +
			"0 12 10 19 8\n" +
			"12 0 3 7 2\n" +
			"10 3 0 6 20\n" +
			"19 7 6 0 4\n" +
			"8 2 20 4 0\n" +
			"Enter the origin city: (Starts from 0)\n" +
			"0\n\n" +
			"Output:\n" +
			"Route: [0, 2, 1, 3, 4, 0]\n" +
			"Distance: 32.0" 
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
      
      
      $scope.save= function(){
    	  $scope.shortest.result=$scope.result;
		  
		  $http.post("http://localhost:8085/v1/save",$scope.shortest)
          .success(function (response){    
        	  $ngBootbox.alert("Saved");
          })
          .error(function (response){
          });
      };
      
      $scope.getData= function(){
		  $http.get("http://localhost:8085/v1/values")
          .success(function (response){    
        	  $scope.data = response;
        	  console.log($scope.previousData);
        	  $scope.tableParams = new NgTableParams({}, {counts: [], dataset: $scope.data});
          })
          .error(function (response){
          });
		  
		  

      };
});

