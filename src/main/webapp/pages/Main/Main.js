Application.$controller("MainPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         * 
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.button2Click = function($event, $isolateScope) {

    };


    $scope.jsvUpdatePatientonSuccess = function(variable, data, options) {
        debugger;
    };


    $scope.jsvUpdatePatientonError = function(variable, data, options) {
        debugger;
    };

}]);