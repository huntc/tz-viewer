/*global define */

'use strict';

define(function () {

    function Application($scope, $resource) {
        var tzsResource = $resource("/tzs");

        $scope.listAllTzs = function () {
            $scope.tzs = tzsResource.query();
        }
    }

    return Application;
});
