
var kinoApp = angular.module('KinoApp',  []);

kinoApp.controller('filmprogram', function ($scope, $http) {
  $http.get('rest/filmprogram').success(function(data){
    $scope.filmprogram = data;
  });

  $scope.opprettFilm = function(){
    console.log($scope.navn, $scope.antallSeter);
    $http.put('rest/filmprogram', {"navn":$scope.navn, "ledigeSeter":$scope.antallSeter})
  };
});