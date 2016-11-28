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
		getMapData: function(){
			var deferred = $q.defer();
			$http.get(baseURL + 'map/')
			.success(function(data, status, headers, config) {
				deferred.resolve(data);
			})
			.error(function() {
				deferred.reject("Failed to get Map Data");
			});
			return deferred.promise;
		},
	};
}).factory('FeedService', function($http, $q) {
	var baseURL = "/api/";

	return{
		getFeedData: function(){
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
		MapService.getMapData()
		.then(function(response) {
			$scope.mapData = response;
			$log.info('Map successfully retrieved to controller.');
		}).catch(function(error) {
			$log.error('Map not successfully retrieved to controller.');
		});
	}

	$scope.mapData=$scope.getMapData();

}).controller('FeedController', function($log, $scope, $route, $routeParams, $location, FeedService) {

	$scope.getMocks = function(){
		FeedService.getFeedData()
		.then(function(response) {
			$scope.feedData = response;
			$log.info('Feeds successfully retrieved to controller.');
		}).catch(function(error) {
			$log.error('Feeds not successfully retrieved to controller.');
		});
	}

	$scope.feedData=$scope.getFeedData();
});


