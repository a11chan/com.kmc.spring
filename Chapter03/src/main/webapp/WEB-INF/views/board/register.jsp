<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>
			<div class="panel-body">
				<form role="form" action="/board/register" method="post">
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name='title'>
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name='content'></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name='writer'>
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</form>
			</div>
			<%//.panel-body-end %>
		</div>
		<%//.panel-end %>
	</div>
</div>
<%//.row-end %>
<%--
input 태그나 textarea 태그의 name 속성은 BoardVO 클래스의 변수와 일치시켜준다.
게시물 등록 시 한글이 깨지는 문제가 발생하면 web.xml에 UTF-8 필터 등록을 한다.
--%>
<%@include file="../includes/footer.jsp"%>