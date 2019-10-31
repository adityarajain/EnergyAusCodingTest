'use strict'

var module = angular.module('recordLabel.controllers', []);
module.controller("RecordLabelController", [ "$scope", "RecordLabelService",
		function($scope, RecordLabelService) {

			RecordLabelService.getAllRecordLabels().then(function(value) {
				console.log("get api works");
				$scope.allRecordLabels= value.data;
			}, function(reason) {
				console.log("error occured while fetching data");
			}, function(value) {
				console.log("Invocaton of rest endpoint failed");
			});
		} ]);