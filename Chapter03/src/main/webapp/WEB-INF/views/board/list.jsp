<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Board List</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							Board List Page
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables">
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
										<th>수정일</th>
									</tr>
								</thead>
								
								<tbody>
								<c:forEach items="${list}" var="board">
									<tr>
										<td><c:out value="${board.bno}"/></td>
										<td><a href='/board/get?bno=
											<c:out value="${board.bno}"/>'>
											<c:out value="${board.title}"/></a>
										</td>
										<td><c:out value="${board.writer}"/></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regdate}"/></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updateDate}"/></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>

<%@ include file="../includes/footer.jsp" %>