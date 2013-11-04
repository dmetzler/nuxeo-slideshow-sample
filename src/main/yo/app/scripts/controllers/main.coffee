
angular.module("nuxeoAngularSampleApp")

.controller("SlideshowCtrl", 
['$scope','$routeParams','$location','nxSearch'
($scope,$routeParams,$location,nxSearch) ->
  
  
  $scope.searchTag = $routeParams.tag
  $scope.tagToSearch = $scope.searchTag


  $scope.search = new nxSearch()
  .setQuery("SELECT * FROM Document WHERE ecm:tag = '" +  $scope.searchTag + "'")
  .setPageSize(4)
  .setBOAdapter("SlideShowElement")

  $scope.search.nextPage()


  $scope.doSearch = ()->
    $location.path("slideshow/"+$scope.tagToSearch)


])
