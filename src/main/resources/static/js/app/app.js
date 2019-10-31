'use strict'

var recordLabelApp = angular.module('recordLabel', [ 'ui.bootstrap', 'recordLabel.controllers',
		'recordLabel.services']);
recordLabelApp.constant("CONSTANTS", {
	getAllRecordLabels : "/recordlabel/getAllRecordLabels"
});