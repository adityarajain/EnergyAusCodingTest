'use strict'

angular.module('recordLabel.services', []).factory('RecordLabelService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getAllRecordLabels = function() {
				return $http.get(CONSTANTS.getAllRecordLabels);
			}
			return service;
		} ]);