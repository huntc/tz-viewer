/*global define, angular */

'use strict';

// Declare here that angular is the US version - other locales can be easily substituted.

define('angular', ['webjars!angular-locale_en-us.js'], function () {
    return angular;
});

require(['angular', './controllers/Application', 'webjars!ui-bootstrap.js', 'webjars!angular-resource.js'],
    function (angular, app) {

        angular.module('main', ['ui', 'ngResource']).
            controller('Application', ['$scope', '$resource', app]);

        angular.bootstrap(document, ['main']);

    });
