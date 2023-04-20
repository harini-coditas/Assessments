<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <title>Show Customer</title>
</head>
<body>

<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
                        <th>Operations</th>
					</tr>
				</thead>
				<tbody>
                					<!--   for (Customer customer: listCustomer) {  -->
                					<c:forEach var="customer" items="${listCustomer}">

                						<tr>
                							<td><c:out value="${customer.id}" /></td>
                							<td><c:out value="${customer.name}" /></td>

                							<td><c:out value="${customer.email}" /></td>

                                            <td><a href="CustomerEditServlet?id=<c:out value='${customer.id}' />">Edit</a>
                                             &nbsp;&nbsp;&nbsp;&nbsp;
                                             <a href="CustomerDeleteServlet?id=<c:out value='${customer.id}'/>">Delete</a></td>

                						</tr>
                					</c:forEach>
                					<!-- } -->
                				</tbody>
                			</table>

<a href='ShowProduct'><button class="btn btn-primary">Back</button></a>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>