<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Book</title>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<section class="container">
		<h3>Create Book</h3>
		<p style="color: red;">${errorString}</p>
		<form method="POST" action="${pageContext.request.contextPath}/bookCreate">
			<table class="table table-bordered">
				<tr>
					<td>Mã sách</td>
					<td><input type="text" name="bookid" value="${book.bookId}" /></td>
				</tr>
				<tr>
					<td>Tiêu đề</td>
					<td><input type="text" name="title" value="${book.title}" /></td>
				</tr>
				<tr>
					<td>Tác Giả</td>
					<td><input type="text" name="author" value="${book.author}" /></td>
				</tr>
				<tr>
					<td>Phát hành</td>
					<td><input type="text" name="release" value="${book.release}" /></td>
				</tr>
				<tr>
					<td>Giá</td>
					<td><input type="text" name="price" value="${book.price}" /></td>
				</tr>
				<tr>
					<td>Ảnh</td>
					<td><input type="text" name="picture" value="${book.picture}" /></td>
				</tr>
				<tr>
					<td>PublisherId</td>
					<td><input type="text" name="publisherId" value="${book.publisherId}" /></td>
				</tr>
				<tr>
					<td>CategoryId</td>
					<td><input type="text" name="categoryId" value="${book.categoryId}" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="Ghi lại" class="btn btn-success" />
						<a href="bookList" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>