var kinoApp = angular.module('KinoApp', []);

kinoApp.controller('filmprogram', function ($scope, $http) {

    updateFilmprogram();

    $scope.opprettFilm = function () {
        $http.put('rest/filmprogram', {
            "navn": $scope.navn,
            "ledigeSeter": $scope.antallSeter
        });
        updateFilmprogram();
    };

    $scope.reserverSete = function(film, reserverteSeter) {
        $http.put('rest/setereservering', {
            "forestilling": film,
            "reserverteSeter":reserverteSeter
        });
        // Vi må vente litt før vi henter data. Løses med SSE.
        setTimeout(updateFilmprogram,400);
    };

    function updateFilmprogram() {
        $http.get('rest/filmprogram').success(function (data) {
            $scope.filmprogram = data;
        });
    }


});

