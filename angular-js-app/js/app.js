
var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';
    
$scope.firme = [];
$scope.firma = {};
    
 $http.get('http://localhost:8080/firma').then(
       function successCallback(response) {

       $scope.firme = response.data;
     });
    

   $scope.deleteFirma = function(id) {
    $http.delete('http://localhost:8080/firma/' + id)
    .then(
      function successCallback(response) {
       angular.element('[data-id=' + id + ']').remove();
      },
      function errorCallback(response) {
    });
  };
    
    
$scope.addFirma = function(firma) {

    $http.post('http://localhost:8080/firma/'+firma.id+'?nume=' + firma.nume);
    $scope.firme.push(firma);
    $scope.firme = {};
  };

 $scope.setUpdateFirma = function(firma) {
  $scope.editFirma = firma;
   };


   $scope.updateFirma = function(editFirma) {
     $http.put('http://localhost:8080/firma/'+editFirma.id+'?nume=' + editFirma.nume);
       $scope.editFirma = {};
  };


}]);
