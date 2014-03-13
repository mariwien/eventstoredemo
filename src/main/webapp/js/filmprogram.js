var kinoApp = angular.module('KinoApp', []);

kinoApp.controller('filmprogram', function ($scope, $http) {

    function setupServerSideEvents ($scope) {
        $scope.lastEvent = {};

        var handleCallback = function (msg) {
            console.log("got event from server! :)");
            $scope.lastEvent = msg;
            updateFilmprogram();
        }

        var source = new EventSource('rest/events');
        source.onmessage = function(event) {
           console.log(event);
        };
        //source.addEventListener('message', handleCallback, false);
        console.log(source);
    }
    updateFilmprogram();

    $scope.opprettFilm = function () {
        $http.put('rest/filmprogram', {
            "navn": $scope.navn,
            "ledigeSeter": $scope.antallSeter
        });
    };

    $scope.reserverSete = function(film, reserverteSeter) {
        $http.put('rest/setereservering', {
            "forestilling": film,
            "reserverteSeter":reserverteSeter
        });
    };

    function updateFilmprogram() {
        $http.get('rest/filmprogram').success(function (data) {
            $scope.filmprogram = data;
        });
    }

    setupServerSideEvents($scope);
});

