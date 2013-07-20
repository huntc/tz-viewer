/*global define */

'use strict';

define(['module'], function (module) {

    function Application($scope, $resource) {
        var tzsResource = $resource(module.config().tzs);

        $scope.listAllTzs = function () {
            $scope.tzs = tzsResource.query();
        }
    }

    return Application;
});
