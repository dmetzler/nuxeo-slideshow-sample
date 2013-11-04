"use strict"
angular.module("nuxeoAngularSampleApp", ['infinite-scroll'])
.value("nxUrl", "/nuxeo/api/v1" )
.config ($routeProvider) ->
  $routeProvider
  .when("/slideshow"
    templateUrl: "views/slideshow.html"
    controller: "SlideshowCtrl"
  )
  .when("/slideshow/:tag"
    templateUrl: "views/slideshow.html"
    controller: "SlideshowCtrl"
  )
  
  .otherwise redirectTo: "/slideshow/"
