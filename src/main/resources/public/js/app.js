'use strict';

var team3App = angular.module('Team43App', ['ngRoute']);

team3App.config(function($routeProvider, $locationProvider) {
  $routeProvider

    .when('/home', {
    templateUrl: 'templates/map.html',
    controller: 'MapController'
    })
    .when('/feed', {
        templateUrl: 'templates/feed.html',
        controller: 'FeedController'
      })
      .when('/form', {
        templateUrl: 'templates/form.html',
        controller: 'FeedController'
      })
      .when('/more-info/:feedbackId', {
        templateUrl: 'templates/moreInfo.html',
        controller: 'MoreInfoController'
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
			$http.get(baseURL + 'form/')
			.success(function(data, status, headers, config) {
				deferred.resolve(data);
			})
			.error(function() {
				deferred.reject("Failed to get Feeds");
			});
			return deferred.promise;
		},
	};
}).factory('MoreInfoService', function($http, $q, $location) {
  	var baseURL = "/api/";

  	return{
  		getMoreInfoData: function(feedbackId){
  			var deferred = $q.defer();
  			$http.get(baseURL + 'tweet/'+feedbackId)
  			.success(function(data, status, headers, config) {
  				deferred.resolve(data);
  			})
  			.error(function() {
  				deferred.reject("Failed to get Form Data");
  			});
  			return deferred.promise;
  		},
  	};
}).controller('MapController', function($log, $scope, $route, $routeParams, $location, MapService) {

//	$scope.getMocks = function(){
//		MapService.getMapData()
//		.then(function(response) {
//			$scope.mapData = response;
//			$log.info('Map successfully retrieved to controller.');
//		}).catch(function(error) {
//			$log.error('Map not successfully retrieved to controller.');
//		});
//	}

	$scope.mapData={"data":"test"};

}).controller('FeedController', function($log, $scope, $route, $routeParams, $location, FeedService) {

	$scope.getFeedData = function(){
		FeedService.getFeedData()
		.then(function(response) {
			$scope.feedData = response;
			$log.info('Feeds successfully retrieved to controller.');
		}).catch(function(error) {
			$log.error('Feeds not successfully retrieved to controller.');
		});
	}

	$scope.feedData=$scope.getFeedData();
}).controller('MoreInfoController', function($log, $scope, $route, $routeParams, $location, MoreInfoService) {

	$scope.feedbackId = $routeParams.feedbackId;
	
  	$scope.getMoreInfoData = function(){
  		MoreInfoService.getMoreInfoData(feedbackId)
  		.then(function(response) {
  			$scope.moreInfoData = response;
  			$log.info('Forms successfully retrieved to controller.');
  		}).catch(function(error) {
  			$log.error('Forms not successfully retrieved to controller.');
  		});
  	}
	
  	$scope.moreInfoData=$scope.getMoreInfoData
  });


