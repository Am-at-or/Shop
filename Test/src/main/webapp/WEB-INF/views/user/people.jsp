<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />
<script type="text/javascript">
		var app = angular.module('app', ['angularUtils.directives.dirPagination']);
		app.filter('byName', function() {
			return function(input, search) {
				if (!search) return input;
				var array = [];
				for (var i = 0; i < input.length; i++) {
					if (input[i].name.toLowerCase().indexOf(search.toLowerCase()) !== -1) {
						array.push(input[i])
					}
				}
				return array;
			}
		});
		
		app.controller('mainCtrl', function($scope, $http){
			 $scope.people = [];
             $scope.currentItem = {};
             $scope.currentView = 'data';
             $scope.add = function(){
                 $scope.currentView = 'form';
             }
             $scope.cancel = function(){
                 $scope.currentView = 'data';
                 $scope.currentItem = {};
             }
             $scope.save = function(){
             	$http({
             		method:"PUT",
						url:"/people",
						data:$scope.currentItem,
						headers:{'X-CSRF-TOKEN':$("meta[name='_csrf']").attr("content")}
             	}).then(function(result) {
             		for(var i = 0; i < $scope.people.length; i++){
             			if(result.data.id==$scope.people[i].id){
             				$scope.people.splice(i, 1);
             			}
             		}
             		$scope.people.push(result.data);
					})
                 $scope.cancel();
             }
             $scope.update = function(item){
                 $scope.currentItem = item;
                 $scope.add();
             }
             $scope.delete = function(item){
             	$http({
             		method:"DELETE",
						url:"/people/"+item.id,
						headers:{'X-CSRF-TOKEN':$("meta[name='_csrf']").attr("content")}
             	}).then(function() {
             		for(var i = 0; i < $scope.people.length; i++){
             			if(item.id==$scope.people[i].id){
             				$scope.people.splice(i, 1);
             			}
             		}
             	});
             }
             $scope.refresh = function() {
					$http({
						method:"GET",
						url:"/people"
					}).then(function(result) {
						$scope.people = result.data;
					});
				}
             $scope.refresh();
             
             $scope.sort = function(keyname){
                 $scope.sortKey = keyname;
                 $scope.reverse = !$scope.reverse;
             }
         });
	</script>
<div class="container-fluid text-left" ng-app="app"
	ng-controller="mainCtrl">
	<div class="row" ng-show="currentView == 'data'">
		<div class="col-md-3">
			<form class="form-inline">
				<div class="form-group">
					<input type="text" ng-model="search" class="form-control"
						placeholder="Search">
				</div>
			</form>
		</div>
		<div class="col-md-9">
		<div class="alert alert-info row">
				<div class="col-md-4">Sort key: {{sortKey}}</div>
				<div class="col-md-4">Reverse: {{reverse}}</div>
				<div class="col-md-4">Search string : {{search}}</div>
			</div>
			<div class="row">
				<table class="table table-striped text-center">
					<tr>
						<th class="text-center" ng-click="sort('name')"
							style="cursor: pointer;">Name<span
							class="glyphicon sort-icon" ng-show="sortKey=='name'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
						<th class="text-center" ng-click="sort('age')"
							style="cursor: pointer;">Age<span
							class="glyphicon sort-icon" ng-show="sortKey=='age'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
						<th class="text-center" ng-click="sort('address')"
							style="cursor: pointer;">Address<span
							class="glyphicon sort-icon" ng-show="sortKey=='address'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
						<th class="text-center">Update</th>
						<th class="text-center">Delete</th>
					</tr>
					<tr
						dir-paginate="item in people|orderBy:sortKey:reverse|byName:search|itemsPerPage:2">
						<td>{{item.name}}</td>
						<td>{{item.age}}</td>
						<td>{{item.address}}</td>
						<td><button class="btn btn-warning" ng-click="update(item)">Update</button></td>
						<td><button class="btn btn-danger" ng-click="delete(item)">Delete</button></td>
					</tr>
				</table>
			</div>
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-primary" ng-click="add()">Add</button>
				</div>
			</div>
			<div class="row text-center">
				<dir-pagination-controls max-size="5" direction-links="true"
					boundary-links="true"> </dir-pagination-controls>
			</div>
		</div>
	</div>
	<div class="row" ng-show="currentView == 'form'">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="" class="control-label col-md-2">Name</label>
				<div class="col-md-6">
					<input ng-model="currentItem.name" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="" class="control-label col-md-2">Age</label>
				<div class="col-md-6">
					<input ng-model="currentItem.age" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="" class="control-label col-md-2">Address</label>
				<div class="col-md-6">
					<input ng-model="currentItem.address" class="form-control"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-6 col-md-offset-2">
					<button class="btn btn-success" type='submit' ng-click="save()">Create</button>
					<button class="btn btn-warning" type='submit' ng-click="cancel()">Cancel</button>
				</div>
			</div>
		</form>
	</div>
</div>