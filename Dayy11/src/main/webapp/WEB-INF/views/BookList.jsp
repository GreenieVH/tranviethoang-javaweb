<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<style>
	img{
		width:100px;
		height:100px;
	}

</style>
<body>

	<section class="container">
		<h3>Book List</h3>
		<a href="bookCreate" class="btn btn-primary">Create Book</a>
		<p style="color: red;">${errorString}</p>
		
		<table class="table table-bordered">
			<thead style="background: #f1f1f1;">
				<tr>
					<th>Mã sách</th>
					<th>Tiêu đề</th>
					<th>Tác Giả</th>
					<th>Phát hành</th>
					<th>Giá</th>
					<th>Ảnh</th>
					<th>PublisherId</th>
					<th>CategoryId</th>
					<th>Tuỳ chọn</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.bookId}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.release}</td>
						<td>${book.price}</td>
						<td>${book.picture}</td>
						<td>${book.publisherId}</td>
						<td>${book.categoryId}</td>
						<td>
							<a href="bookEdit?bookid=${book.bookId}" class="btn btn-success">Edit</a>
							<a href="bookDelete?bookid=${book.bookId}" class="btn btn-success">Delete</a>
						</td>				
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>

</body>
</html>