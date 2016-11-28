'use strict';

var beerApp = angular.module('Team43App', ['ngRoute']);

beerApp.config(function($routeProvider, $locationProvider) {
  $routeProvider

  .when('/home', {
    templateUrl: 'templates/map.html',
    controller: 'MapController',
    resolve: {
      // I will cause a 1 second delay
      delay: function($q, $timeout) {
        var delay = $q.defer();
        $timeout(delay.resolve, 1000);
        return delay.promise;
      }
 	}
  })
	.when('/feed', {
	    templateUrl: 'templates/feed.html',
	    controller: 'FeedController',
	    resolve: {
	      // I will cause a 1 second delay
	      delay: function($q, $timeout) {
	        var delay = $q.defer();
	        $timeout(delay.resolve, 1000);
	        return delay.promise;
	      }
	 	}
	  })
  .otherwise({
    redirectTo: '/home'
  });

 }).factory('MapService', function($http, $q) {
	var baseURL = "/api/";

	return{
		getMocks: function(){
			var deferred = $q.defer();
			$http.get(baseURL + 'map/')
			.success(function(data, status, headers, config) {
				deferred.resolve(data);
			})
			.error(function() {
				deferred.reject("Failed to get Maps");
			});
			return deferred.promise;
		},
	};
}).factory('FeedService', function($http, $q) {
	var baseURL = "/api/";

	return{
		getMocks: function(){
			var deferred = $q.defer();
			$http.get(baseURL + 'feed/')
			.success(function(data, status, headers, config) {
				deferred.resolve(data);
			})
			.error(function() {
				deferred.reject("Failed to get Feeds");
			});
			return deferred.promise;
		},
	};
}).controller('MapController', function($log, $scope, $route, $routeParams, $location, MapService) {

	$scope.getMocks = function(){
		MapService.getMocks()
		.then(function(response) {
			$scope.map = response;
			$log.info('Map successfully retrieved to controller.');
		}).catch(function(error) {
			$log.error('Map not successfully retrieved to controller.');
		});
	}

	$scope.mocks=$scope.getMocks();

}).controller('FeedController', function($log, $scope, $route, $routeParams, $location, FeedService) {

	$scope.getMocks = function(){
		FeedService.getMocks()
		.then(function(response) {
			$scope.feeds = response;
			$log.info('Feeds successfully retrieved to controller.');
		}).catch(function(error) {
			$log.error('Feeds not successfully retrieved to controller.');
		});
	}

	$scope.feeds=$scope.getMocks();
});


