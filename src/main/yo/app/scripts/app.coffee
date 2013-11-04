"use strict"
angular.module("nuxeoAngularSampleApp", ['infinite-scroll'])
.value("nxUrl", "/nuxeo/api/v1" )
.factory("nxSession", ["nxSessionFactory","nxUrl",(nxSessionFactory,nxUrl)->
  nxSessionFactory(
    apiRootPath: nxUrl
  )
])
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
